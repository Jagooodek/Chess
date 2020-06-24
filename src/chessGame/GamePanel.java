package chessGame;

import chess.Game;
import chess.Move;;
import chess.figures.Pawn;
import chess.figures.Square;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GamePanel{

    private ArrayList<Tile> tiles;
    private Game game;
    private Tile selectedTile;
    private Boolean whiteTurn;
    private JFrame gameFrame;

    public static void main(String[] args) {
        GamePanel gamePanel = new GamePanel();

        JFrame tmp = new JFrame();
        tmp.setVisible(true);
        JButton jButton = new JButton("Undo last move");
        jButton.addActionListener(actionEvent -> gamePanel.undoLastMove());
        tmp.setBounds(1200,500,500,500);
        tmp.add(jButton);
        tmp.pack();
        tmp.setDefaultCloseOperation(3);
    }

    GamePanel() {
        super();
        initGameFrame();
        initTiles();
        game = new Game();
        refresh();
    }

    private void initGameFrame() {
        gameFrame = new JFrame("Chess");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                Tile tile = new Tile(new Square(j + 1, i + 1), 128, i % 2 ==j % 2);
                tiles.add(tile);
                tile.addMouseListener(new TileListener(tile));
                gameFrame.add(tile);
            }
        }
        selectedTile = null;
    }

    private Tile getTile(Square square) {
        for(Tile tile:tiles) {
            if(square.equals(tile.getSquare()))
                return tile;
        }
        return null;
    }

    private void refresh() {
        for(Tile tile: tiles) {
            tile.setFigure(game.getFigure(tile.getSquare()));
            tile.repaint();
        }
        whiteTurn = game.isWhiteTurn();
        if(game.getStatus() != 0) {
            String string = "";
            switch (game.getStatus()) {
                case Game.WHITE_WON:
                    string = "White won";
                    break;
                case Game.BLACK_WON:
                    string = "Black won";
                    break;
                case Game.DRAW:
                    string = "Draw";
                    break;
                default:
                    string = "??";
                    break;

            }
            JOptionPane.showMessageDialog(gameFrame,string);
        }

    }

    private void select(Tile tile) {
         if(selectedTile == null && tile.getFigure() != null && this.whiteTurn == tile.getFigure().isWhite()) {

             selectedTile = tile;
             tile.setSelected(true);
             ArrayList<Move> moves = tile.getFigure().getLegalMoves();
             for(Move move:moves) {
                 getTile(move.getSquare2()).setMove(move);
             }
         } else {
             if(selectedTile == tile) {
                 selectedTile.setSelected(false);
                 selectedTile = null;
                 for(Tile t: tiles)
                     t.setMove(null);
             } else {
                 if(tile.getMove() != null){
                     if((tile.getMove().getSquare2().getY() == 8 || tile.getMove().getSquare2().getY() == 1) && game.getFigure(selectedTile.getSquare()) instanceof Pawn) {
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

    public void undoLastMove() {
        game.undoLastMove();
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

