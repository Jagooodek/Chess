package chess.figures;

import chess.Game;
import chess.Move;

import java.util.ArrayList;

public class Bishop extends Figure {

    public Bishop(Square square, boolean isWhite, Game game) {
        super(square, isWhite, game);
    }

    @Override
    public ArrayList<Move> getPossibleMoves() {
        ArrayList<Move> arrayList = new ArrayList<Move>();

        Move move;
        int x = this.getSquare().getX();
        int y = this.getSquare().getY();

        while(x-- >= 1 && y-- >= 1) {
            move = new Move(this.getSquare(), new Square(x,y));
            if(isLegalMove(move)) {
                arrayList.add(move);
            } else {
                if(isLegalCapture(move))
                    arrayList.add(move);
                break;
            }
        }

        x = this.getSquare().getX();
        y = this.getSquare().getY();
        while(x-- >= 1 && y++ <= 8) {
            move = new Move(this.getSquare(), new Square(x,y));
            if(isLegalMove(move)) {
                arrayList.add(move);
            } else {
                if(isLegalCapture(move))
                    arrayList.add(move);
                break;
            }
        }

        x = this.getSquare().getX();
        y = this.getSquare().getY();
        while(x++ <= 8 && y++ <= 8) {
            move = new Move(this.getSquare(), new Square(x,y));
            if(isLegalMove(move)) {
                arrayList.add(move);
            } else {
                if(isLegalCapture(move))
                    arrayList.add(move);
                break;
            }
        }

        x = this.getSquare().getX();
        y = this.getSquare().getY();
        while(x++ <= 8 && y-- >= 1) {
            move = new Move(this.getSquare(), new Square(x,y));
            if(isLegalMove(move)) {
                arrayList.add(move);
            } else {
                if(isLegalCapture(move))
                    arrayList.add(move);
                break;
            }
        }


        return arrayList;
    }


    @Override
    public String toString() {
        return (isWhite()?"w":"b") + "_bishop";
    }
}
