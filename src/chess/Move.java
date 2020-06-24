package chess;

import chess.figures.Figure;
import chess.figures.Square;

public class Move {
    private Square square1;
    private Square square2;
    private boolean castle;
    private Move castleMove;
    private String promotionFigure;
    private Figure capturedFigure;

    public boolean isCastle() {
        return castle;
    }

    public Move getCastleMove() {
        return castleMove;
    }

    public Move(Square square1, Square square2) {
        this.square1 = square1;
        this.square2 = square2;
        this.castle = false;
        promotionFigure = null;
    }

    public Move(Square square1, Square square2, Move castleMove) {
        this.square1 = square1;
        this.square2 = square2;
        this.castle = castleMove != null;
        if(castle) {
            this.castleMove = castleMove;
        }
        promotionFigure = null;
        capturedFigure = null;
    }

    public boolean isPossible() {
        if(square1.isLegal() && square2.isLegal())
            return true;
        return false;
    }

    public Square getSquare1() {
        return square1;
    }

    public Square getSquare2() {
        return square2;
    }

    public void setPromotionFigure(String promotionFigure) {
        this.promotionFigure = promotionFigure;
    }

    public String getPromotionFigure() {
        return promotionFigure;
    }

    public Figure getCapturedFigure() {
        return capturedFigure;
    }

    public void setCapturedFigure(Figure capturedFigure) {
        this.capturedFigure = capturedFigure;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Move))
            return false;
        Move move = (Move)o;
        if(square1.equals(move.square1) && square2.equals(move.square2))
            return true;
        return false;
    }

    @Override
    public String toString() {
        String s = square1 + " " + square2;
        return s;
    }

}
