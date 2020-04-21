package chess;

import chess.figures.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Game {

    private JFrame gameFrame;
    private ArrayList<Tile> tiles;
    private ArrayList<Figure> figures;

    private boolean isSelected;
    private Figure selectedFigure;
    private boolean isWhiteTurn;

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        init();
    }

    private void init() {
        isWhiteTurn = true;
        isSelected = false;

        initGameFrame();
        initFigures();
        initTiles();
    }

    private void initGameFrame() {
        gameFrame = new JFrame("Chess");
        gameFrame.setDefaultCloseOperation(3);
        gameFrame.setVisible(true);
        GridLayout gridLayout = new GridLayout(8,8,0,0);
        gameFrame.setLayout(gridLayout);
        gameFrame.setSize(1024,1024);
        gameFrame.setResizable(false);
    }

    private void initFigures() {
        figures = new ArrayList<Figure>();


        for (int i = 0; i < 8; i++) {
            figures.add(new Pawn(i + 1, 7, "resources", false));
            figures.add(new Pawn(i + 1, 2, "resources", true));
        }

        figures.add(new Rook(1, 1, "resources", true));
        figures.add(new Rook(8, 1, "resources", true));
        figures.add(new Rook(8, 8, "resources", false));
        figures.add(new Rook(1, 8, "resources", false));

        figures.add(new Knight(2, 1, "resources", true));
        figures.add(new Knight(7, 1, "resources", true));
        figures.add(new Knight(2, 8, "resources", false));
        figures.add(new Knight(7, 8, "resources", false));

        figures.add(new Bishop(3, 1, "resources", true));
        figures.add(new Bishop(6, 1, "resources", true));
        figures.add(new Bishop(3, 8, "resources", false));
        figures.add(new Bishop(6, 8, "resources", false));

        figures.add(new Queen(4,1, "resources", true));
        figures.add(new Queen(4,8, "resources", false));

        figures.add(new King(5,1, "resources", true));
        figures.add(new King(5,8, "resources", false));

    }

    private void initTiles() {

        tiles = new ArrayList<Tile>();

        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j ++) {
                Tile tile = new Tile(j + 1, i + 1, 128, i % 2 == j % 2 ? "resources/brown1.png" : "resources/brown2.png");
                tiles.add(tile);
                tile.addMouseListener(new TileListener(tile));
                gameFrame.add(tile);
            }
        }

        addFiguresToTiles();

    }

    private void addFiguresToTiles () {
        for(Tile tile : tiles) {
            tile.setFigure(null);
            tile.setFigure(getFigure(tile.getTileX(), tile.getTileY()));
        }
        gameFrame.repaint();
    }


    public Figure getFigure(int x, int y) {
        for (Figure figure : figures) {
            if(figure.getX() == x && figure.getY() == y) {
                return figure;
            }
        }
        return null;
    }

    public Figure getFigure(Tile tile) {
        return getFigure(tile.getTileX(), tile.getTileY());
    }

    public Tile getTile(int x, int y) {
        for (Tile tile : tiles) {
            if(tile.getTileX() == x && tile.getTileY() == y) {
                return tile;
            }
        }
        return null;
    }

    public Tile getTile(Figure figure) {
        return getTile(figure.getX(), figure.getY());
    }

    private void print() {
        for (int j = 8; j > 0; j--) {
            for (int i = 1; i <= 8; i++) {
                if(getFigure(i,j) == null) {
                    System.out.print("null  ");
                } else if(getFigure(i,j).isWhite()) {
                    System.out.print("white ");
                } else {
                    System.out.print("black ");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    private void select(Tile tile) {
        
        Figure figure = tile.getFigure();
        if(figure != null) {
            if(isWhiteTurn == figure.isWhite()) {
                selectedFigure = figure;
                isSelected = true;
                tile.setSelected(true);
            }
        }
    }

    private void action(Tile tile) {

        getTile(selectedFigure).setSelected(false);
        isSelected = false;

        if(selectedFigure.canMove(tile, this)) {

            if(tile.getFigure() != null)
                figures.remove(tile.getFigure());

            selectedFigure.setX(tile.getTileX());
            selectedFigure.setY(tile.getTileY());
            isWhiteTurn = !isWhiteTurn;
            isSelected = false;
            addFiguresToTiles();

        }


    }

    class TileListener extends MouseAdapter {

        private Tile tile;

        TileListener(Tile tile) {
            this.tile = tile;
        }


        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

            if(!isSelected) {
                select(tile);
            }   else {
                action(tile);
            }

            gameFrame.repaint();
        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {
        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }
}

