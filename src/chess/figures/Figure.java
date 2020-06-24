package chess.figures;

import java.awt.*;
import java.util.ArrayList;

import chess.Game;
import chess.Move;
import chess.Tile;

public abstract class Figure {

    private int x;
    private int y;

    private boolean isWhite;
    private boolean moved;

    private String folderPath;
    private Image image;



    private Game game;

    public Figure(int x, int y, String folderPath, boolean isWhite, Game game) {
        this.game = game;
        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
        this.folderPath = folderPath;
        this.moved = false;
        loadImage();
    }

    public boolean hasMoved() {
        return this.moved;
    }

    public void move() {
        this.moved = true;
    }

    protected boolean isPossibleCapture(Move move) {
        if(this.game.getFigure(move.getX2(), move.getY2()) == null)
            return false;
        if(this.game.getFigure(move.getX2(), move.getY2()).isWhite != this.isWhite)
            return true;
        return false;
    }

    protected boolean isPossibleMove(Move move) {
        if(game.getFigure(move.getX2(), move.getY2()) == null)
            return true;
        return false;
    }

    public abstract String getPath();

    public abstract ArrayList<Move> getPossibleMoves();

    private void loadImage() {
        image = Toolkit.getDefaultToolkit().getImage(folderPath + "/" + getPath());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Game getGame() {
        return game;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public boolean isWhite() {
        return this.isWhite;
    }

}
