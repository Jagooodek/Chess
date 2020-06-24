package chess.figures;

import java.util.ArrayList;

import chess.Game;
import chess.Move;

public abstract class Figure {

    private Square square;

    private boolean isWhite;
    private int moves;

    private Game game;

    public Figure(Square square, boolean isWhite, Game game) {
        this.game = game;
        this.square = square;
        this.isWhite = isWhite;
        moves = 0;
    }

    public boolean hasMoved() {
        if(moves == 0)
            return false;
        return true;
    }

    public void move() {
        moves ++;
    }

    public void undoMove() {
        moves--;
    }
    protected boolean isLegalCapture(Move move) {
        if(move.isPossible()) {
            if(this.game.getFigure(move.getSquare2()) == null)
                return false;
            if(this.game.getFigure(move.getSquare2()).isWhite != this.isWhite)
                return true;
        }
        return false;
    }

    protected boolean isLegalMove(Move move) {
        if(move.isPossible()) {
            if(game.getFigure(move.getSquare2()) == null)
                return true;
        }
        return false;
    }

    public abstract ArrayList<Move> getPossibleMoves();

    public ArrayList<Move> getPossibleCaptures() {
        return getPossibleMoves();
    }

    public ArrayList<Move> getLegalMoves() {
        ArrayList<Move> arrayList = new ArrayList<>();
        for(Move move:getPossibleMoves()) {
            Game tmpGame = new Game();
            ArrayList<Move> moves = this.game.getMoves();
            for(int i = 0; i < moves.size(); i++) {
                tmpGame.doMove(moves.get(i));
            }
            tmpGame.doMove(move);
            if(!tmpGame.isChecked(this.isWhite()))
                arrayList.add(move);
        }
        return arrayList;
    }

    public abstract String toString();

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public Game getGame() {
        return game;
    }

    public boolean isWhite() {
        return this.isWhite;
    }

}
