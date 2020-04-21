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
    private ArrayList<Figure> Figures;

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
        gameFrame = new JFrame();
        gameFrame.setDefaultCloseOperation(3);
        gameFrame.setVisible(true);
        GridLayout gridLayout = new GridLayout(8,8,0,0);
        gameFrame.setLayout(gridLayout);
        gameFrame.setSize(1024,1024);
        gameFrame.setResizable(false);
    }

    private void initFigures() {
        Figures = new ArrayList<Figure>();


        for (int i = 0; i < 8; i++) {
            Figures.add(new Pawn(i + 1, 7, "resources", false));
            Figures.add(new Pawn(i + 1, 2, "resources", true));
        }

        Figures.add(new Rook(1, 1, "resources", true));
        Figures.add(new Rook(8, 1, "resources", true));
        Figures.add(new Rook(8, 8, "resources", false));
        Figures.add(new Rook(1, 8, "resources", false));

        Figures.add(new Knight(2, 1, "resources", true));
        Figures.add(new Knight(7, 1, "resources", true));
        Figures.add(new Knight(2, 8, "resources", false));
        Figures.add(new Knight(7, 8, "resources", false));

        Figures.add(new Bishop(3, 1, "resources", true));
        Figures.add(new Bishop(6, 1, "resources", true));
        Figures.add(new Bishop(3, 8, "resources", false));
        Figures.add(new Bishop(6, 8, "resources", false));

        Figures.add(new Queen(4,1, "resources", true));
        Figures.add(new Queen(4,8, "resources", false));

        Figures.add(new King(5,1, "resources", true));
        Figures.add(new King(5,8, "resources", false));

    }

    private void initTiles() {

        tiles = new ArrayList<>();

        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j ++) {
                Tile tile = new Tile(j + 1, i + 1, 128, i%2 == j%2 ? "resources/brown2.png" : "resources/brown1.png");
                tiles.add(tile);
                gameFrame.add(tile);
            }
        }


        for(Tile tile : tiles) {

            tile.setFigure(getFigure(tile.getTileX(), tile.getTileY()));
            tile.addMouseListener(new TileListener(tile));
        }
    }

    public Figure getFigure(int x, int y) {
        for (Figure figure : Figures) {
            if(figure.getX() == x && figure.getY() == y) {
                return figure;
            }
        }
        return null;
    }

    public Tile getTile(int x, int y) {
        for (Tile tile : tiles) {
            if(tile.getTileX() == x && tile.getTileY() == y) {
                return tile;
            }
        }
        return null;
    }

    private void select(Figure figure, Tile tile) {
        if(figure != null) {
            if(isWhiteTurn == figure.isWhite()) {
                selectedFigure = figure;
                isSelected = true;
                tile.setSelected(true);
            }
        }
    }

    private void action(Tile tile) {

        if(selectedFigure == tile.getFigure()) {
            isSelected = false;
            tile.setSelected(false);
            tile.repaint();
            return;
        }
        if(selectedFigure.canMove(tile.getTileX(), tile.getTileY(), this)) {
            getTile(selectedFigure.getX(), selectedFigure.getY()).setSelected(false);
            getTile(selectedFigure.getX(), selectedFigure.getY()).setFigure(null);
            getTile(selectedFigure.getX(), selectedFigure.getY()).repaint();
            tile.setFigure(selectedFigure);
            isSelected = false;
            isWhiteTurn = !isWhiteTurn;

        }
        isSelected = false;

    }

    class TileListener extends MouseAdapter {

        private Tile tile;

        TileListener(Tile tile) {
            this.tile = tile;
        }


        @Override
        public void mouseReleased(MouseEvent mouseEvent) {
            if(!isSelected) {
                select(tile.getFigure(), tile);
            }   else {
                action(tile);
            }

            tile.repaint();
        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }
}

