package chess;

import chess.figures.*;


import java.util.ArrayList;

public class Game {

    private ArrayList<Figure> figures;
    private boolean whiteTurn;
    private boolean end;

    public Game() {
        init();
    }

    private void init() {
        whiteTurn = true;
        end = false;
        initFigures();
    }

    private void initFigures() {
        figures = new ArrayList<Figure>();


        for (int i = 0; i < 8; i++) {
            figures.add(new Pawn(i + 1, 7, false, this));
            figures.add(new Pawn(i + 1, 2, true, this));
        }

        figures.add(new Rook(1, 1, true, this));
        figures.add(new Rook(8, 1, true, this));
        figures.add(new Rook(8, 8, false, this));
        figures.add(new Rook(1, 8, false, this));

        figures.add(new Knight(2, 1, true, this));
        figures.add(new Knight(7, 1, true, this));
        figures.add(new Knight(2, 8, false, this));
        figures.add(new Knight(7, 8, false, this));

        figures.add(new Bishop(3, 1, true, this));
        figures.add(new Bishop(6, 1, true, this));
        figures.add(new Bishop(3, 8, false, this));
        figures.add(new Bishop(6, 8, false, this));

        figures.add(new Queen(4,1, true, this));
        figures.add(new Queen(4,8, false, this));

        figures.add(new King(5,1, true, this));
        figures.add(new King(5,8, false, this));

    }

    public Figure getFigure(int x, int y) {
        for (Figure figure : figures) {
            if(figure.getX() == x && figure.getY() == y) {
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

    public boolean isEnd() {
        return end;
    }

    public void doMove(Move move) {

        Figure figure = getFigure(move.getX2(), move.getY2());
        if(figure != null) {
            figures.remove(figure);
            if(figure instanceof King)
                end = true;
        }


        figure = getFigure(move.getX1(), move.getY1());
        figure.setX(move.getX2());
        figure.setY(move.getY2());
        figure.move();

        if(move.isCastle()) {
            doMove(move.getCastleMove());
        }

        whiteTurn = !whiteTurn;
    }

}

