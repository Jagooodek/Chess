package chessGame;

import chess.Game;
import chess.Move;
import chess.figures.Figure;
import chess.figures.Knight;
import chess.figures.Pawn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class chessPanel {

    private JFrame gameFrame;
    private ArrayList<Tile> tiles;
    private Game game;
    private Tile selectedTile;
    private Boolean whiteTurn;

    chessPanel() {
        initGameFrame();
        initTiles();
        game = new Game();
        refresh();
    }

    public static void main(String[] args) {
        new chessPanel();
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

    private void initTiles() {

        tiles = new ArrayList<>();

        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j ++) {
                Tile tile = new Tile(j + 1, i + 1, 128, i % 2 ==j % 2);
                tiles.add(tile);
                tile.addMouseListener(new TileListener(tile));
                gameFrame.add(tile);
            }
        }
        selectedTile = null;
    }

    private Tile getTile(int x, int y) {
        for(Tile tile:tiles) {
            if(tile.getTileX() == x && tile.getTileY() == y)
                return tile;
        }
        return null;
    }

    private void refresh() {
        for(Tile tile: tiles) {
            tile.setFigure(game.getFigure(tile.getTileX(), tile.getTileY()));
            tile.repaint();
        }
        whiteTurn = game.isWhiteTurn();
        if(game.isEnd())
            gameFrame.removeAll();
    }

    private void select(Tile tile) {
         if(selectedTile == null && tile.getFigure() != null && this.whiteTurn == tile.getFigure().isWhite()) {

             selectedTile = tile;
             tile.setSelected(true);
             ArrayList<Move> moves = tile.getFigure().getPossibleMoves();
             for(Move move:moves) {
                 getTile(move.getX2(), move.getY2()).setMove(move);
             }
         } else {
             if(selectedTile == tile) {
                 selectedTile.setSelected(false);
                 selectedTile = null;
                 for(Tile t: tiles)
                     t.setMove(null);
             } else {
                 if(tile.getMove() != null){
                     if((tile.getMove().getY2() == 8 || tile.getMove().getY2() == 1) && game.getFigure(tile.getMove().getX1(), tile.getMove().getY1()) instanceof Pawn) {
                         String [] possibilities = {"Knight", "Bishop", "Queen", "Rook"};
                         String s = (String)JOptionPane.showInputDialog(gameFrame, "Choose figure to replace your pawn.", "Pawn promotion",  JOptionPane.QUESTION_MESSAGE, null,  possibilities, "Knight");
                         tile.getMove().setPromotionFigure(s);
                     }
                     game.doMove(tile.getMove());
                     selectedTile.setSelected(false);
                     selectedTile = null;
                     for(Tile t: tiles)
                         t.setMove(null);
                 }
             }
         }
         refresh();
    }

    class TileListener extends MouseAdapter {

        private Tile tile;

        TileListener(Tile tile) {
            this.tile = tile;
        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {
            select(tile);
        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {
        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }
}

