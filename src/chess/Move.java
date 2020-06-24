package chess;

import chess.figures.Figure;

public class Move {
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private boolean castle;
    private Move castleMove;
    private String promotionFigure;


    public boolean isCastle() {
        return castle;
    }

    public Move getCastleMove() {
        return castleMove;
    }

    public Move(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.castle = false;
        promotionFigure = null;
    }

    public Move(int x1, int y1, int x2, int y2, Move castleMove) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.castle = castleMove != null;
        if(castle) {
            this.castleMove = castleMove;
        }
        promotionFigure = null;
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    public void setPromotionFigure(String promotionFigure) {
        this.promotionFigure = promotionFigure;
    }

    public String getPromotionFigure() {
        return promotionFigure;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Move))
            return false;
        Move move = (Move)o;
        if(this.x1 == move.getX1() && this.x2 == move.getX2() && this.y1 == move.getY1() && this.y2 == move.getY2())
            return true;
        return false;
    }
}
