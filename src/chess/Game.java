package chess;

import chess.figures.*;


import java.util.ArrayList;

public class Game {

    public static final int GAME_CONTINUES = 0;
    public static final int WHITE_WON = 1;
    public static final int BLACK_WON = 2;
    public static final int DRAW = 3;

    private ArrayList<Move> moves;
    private ArrayList<Figure> figures;
    private boolean whiteTurn;
    private Figure whiteKing;
    private Figure blackKing;
    private int status;

    public Game() {
        init();
    }

    private void init() {
        whiteTurn = true;
        moves = new ArrayList<>();
        status = this.GAME_CONTINUES;
        initFigures();
    }

    private void initFigures() {
        figures = new ArrayList<Figure>();


        for (int i = 0; i < 8; i++) {
            figures.add(new Pawn(new Square(i + 1, 7), false, this));
            figures.add(new Pawn(new Square(i + 1, 2), true, this));
        }

        figures.add(new Rook(new Square(1, 1), true, this));
        figures.add(new Rook(new Square(8, 1), true, this));
        figures.add(new Rook(new Square(8, 8), false, this));
        figures.add(new Rook(new Square(1, 8), false, this));

        figures.add(new Knight(new Square(2, 1), true, this));
        figures.add(new Knight(new Square(7, 1), true, this));
        figures.add(new Knight(new Square(2, 8), false, this));
        figures.add(new Knight(new Square(7, 8), false, this));

        figures.add(new Bishop(new Square(3, 1), true, this));
        figures.add(new Bishop(new Square(6, 1), true, this));
        figures.add(new Bishop(new Square(3, 8), false, this));
        figures.add(new Bishop(new Square(6, 8), false, this));

        figures.add(new Queen(new Square(4,1), true, this));
        figures.add(new Queen(new Square(4,8), false, this));

        whiteKing = new King(new Square(5,1), true, this);
        blackKing = new King(new Square(5,8), false, this);

        figures.add(whiteKing);
        figures.add(blackKing);

    }

    public Figure getFigure(Square square) {
        for (Figure figure : figures) {
            if(figure.getSquare().equals(square)) {
                return figure;
            }
        }
        return null;
    }

    public ArrayList<Figure> getFigures() {
        return figures;
    }

    public boolean isWhiteTurn() {
        return whiteTurn;
    }

    public void doMove(Move move) {

        moves.add(move);
        Figure figure = getFigure(move.getSquare2());
        if(figure != null) {
            move.setCapturedFigure(figure);
            figures.remove(figure);
        }

        figure = getFigure(move.getSquare1());
        figure.setSquare(move.getSquare2());
        figure.move();
        if(move.getPromotionFigure() != null) {
            Figure promotionFigure = figure;
            switch (move.getPromotionFigure()) {
                case "Bishop":
                    promotionFigure = new Bishop(figure.getSquare(), figure.isWhite(), figure.getGame());
                    break;
                case "Knight":
                    promotionFigure = new Knight(figure.getSquare(), figure.isWhite(), figure.getGame());
                    break;
                case "Queen":
                    promotionFigure = new Queen(figure.getSquare(), figure.isWhite(), figure.getGame());
                    break;
                case "Rook":
                    promotionFigure = new Rook(figure.getSquare(), figure.isWhite(), figure.getGame());
                    break;
            }
            figures.remove(figure);
            figures.add(promotionFigure);
        }

        if(move.isCastle())
            doMove(move.getCastleMove());
        else
            whiteTurn = !whiteTurn;

        if(getLegalMoves(whiteTurn).size() == 0) {
            if(isChecked(whiteTurn))
                status = whiteTurn?BLACK_WON:WHITE_WON;
            else
                status = DRAW;
        }
    }

    public void undoLastMove() {
        if(moves.size() > 0) {
            Move move = moves.get(moves.size() - 1);
            moves.remove(move);
            getFigure(move.getSquare2()).undoMove();
            getFigure(move.getSquare2()).setSquare(move.getSquare1());
            if(move.getCapturedFigure() != null)
                figures.add(move.getCapturedFigure());
            whiteTurn = !whiteTurn;
        }

    }

    public boolean isChecked(boolean white) {
        if(getPossibleCaptureSquares(!white).contains((white?whiteKing:blackKing).getSquare()))
            return true;
        return false;
    }

    public ArrayList<Square> getPossibleCaptureSquares(boolean white) {
        ArrayList<Square> arrayList = new ArrayList<>();
        for(Figure figure:figures) {
            if(figure.isWhite() == white) {
                for(Move move: figure.getPossibleCaptures()) {
                    arrayList.add(move.getSquare2());
                }
            }
        }
        return arrayList;
    }

    public ArrayList<Move> getLegalMoves(boolean white) {
        ArrayList<Move> arrayList = new ArrayList<>();
        for(Figure figure:figures) {
            if(figure.isWhite() == white)
                arrayList.addAll(figure.getPossibleMoves());
        }
        return arrayList;
    }

    public ArrayList<Move> getMoves() {
        return moves;
    }

    public int getStatus() {
        return status;
    }
}

