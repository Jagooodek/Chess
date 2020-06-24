package chess.figures;

import chess.Game;
import chess.Move;

import java.util.ArrayList;

public class King extends Figure {

    public King(Square square, boolean isWhite, Game game) {
        super(square, isWhite, game);
    }

    private boolean isRightCastlePossible() {
        Figure rook = this.getGame().getFigure(new Square(this.getSquare(),3,0));
        if(!(rook instanceof Rook) && rook.hasMoved())
            return false;

        Square squareBetween1 = new Square(this.getSquare(),1,0);
        Square squareBetween2 = new Square(this.getSquare(),2,0);
        if(this.getGame().getFigure(squareBetween1) != null && this.getGame().getFigure(squareBetween2) != null)
            return false;
        if(getGame().getPossibleCaptureSquares(!isWhite()).contains(squareBetween1) || getGame().getPossibleCaptureSquares(!isWhite()).contains(squareBetween2))
            return false;

        return true;

    }

    private boolean isLeftCastlePossible() {
        Figure rook = this.getGame().getFigure(new Square(this.getSquare(),-4,0));
        if(!(rook instanceof Rook) && rook.hasMoved())
            return false;

        Square squareBetween1 = new Square(this.getSquare(),-1,0);
        Square squareBetween2 = new Square(this.getSquare(),-2,0);
        Square squareBetween3 = new Square(this.getSquare(),-3,0);
        if(this.getGame().getFigure(squareBetween1) != null && this.getGame().getFigure(squareBetween2) != null && this.getGame().getFigure(squareBetween3) != null)
            return false;

        if(getGame().getPossibleCaptureSquares(!isWhite()).contains(squareBetween1) || getGame().getPossibleCaptureSquares(!isWhite()).contains(squareBetween2) || getGame().getPossibleCaptureSquares(!isWhite()).contains(squareBetween3))
            return false;

        return true;
    }

    @Override
    public ArrayList<Move> getPossibleCaptures() {
        ArrayList<Move> arrayList = new ArrayList<>();

        int x = this.getSquare().getX();
        int y = this.getSquare().getY();

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1 ; j++) {
                Move move = new Move(this.getSquare(), new Square(i,j));
                if(this.isLegalCapture(move) || this.isLegalMove(move))
                    arrayList.add(move);
            }
        }

        return arrayList;
    }

    @Override
    public ArrayList<Move> getPossibleMoves() {
        ArrayList<Move> arrayList = new ArrayList<>();
        arrayList.addAll(getPossibleCaptures());
        if(!this.hasMoved()) {
            if(isRightCastlePossible()) {
                Move rookMove = new Move(new Square(this.getSquare(),3,0), new Square(this.getSquare(),1,0));
                Move move = new Move(this.getSquare(), new Square(this.getSquare(), 2, 0), rookMove);
                arrayList.add(move);
            }

            if(isLeftCastlePossible()) {
                Move rookMove = new Move(new Square(this.getSquare(),-4,0), new Square(this.getSquare(),-1,0));
                Move move = new Move(this.getSquare(), new Square(this.getSquare(), -2, 0), rookMove);
                arrayList.add(move);
            }
        }


        return arrayList;
    }

    @Override
    public String toString() {
        return (isWhite()?"w":"b") + "_king";
    }

}
