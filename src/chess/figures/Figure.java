package chess.figures;

import java.util.ArrayList;

import chess.Game;
import chess.Move;

public abstract class Figure {

    private int x;
    private int y;

    private boolean isWhite;
    private boolean moved;


    private Game game;

    public Figure(int x, int y, boolean isWhite, Game game) {
        this.game = game;
        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
        this.moved = false;
    }

    public boolean hasMoved() {
        return this.moved;
    }

    public void move() {
        this.moved = true;
    }

    protected boolean isPossibleCapture(Move move) {
        if(move.getX2() <= 8 && move.getX2() >= 1 && move.getY2() <= 8 && move.getY2() >= 1) {
            if(this.game.getFigure(move.getX2(), move.getY2()) == null)
                return false;
            if(this.game.getFigure(move.getX2(), move.getY2()).isWhite != this.isWhite)
                return true;
        }
        return false;
    }

    protected boolean isPossibleMove(Move move) {
        if(move.getX2() <= 8 && move.getX2() >= 1 && move.getY2() <= 8 && move.getY2() >= 1) {
            if(game.getFigure(move.getX2(), move.getY2()) == null)
                return true;
        }
        return false;
    }

    public abstract ArrayList<Move> getPossibleMoves();

    public abstract String toString();

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

    public boolean isWhite() {
        return this.isWhite;
    }

}
