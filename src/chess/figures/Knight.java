package chess.figures;

import chess.Game;
import chess.Move;

import java.util.ArrayList;

public class Knight extends Figure {

    public Knight(Square square, boolean isWhite, Game game) {
        super(square, isWhite, game);
    }

    @Override
    public ArrayList<Move> getPossibleMoves() {
        ArrayList<Move> arrayList = new ArrayList<Move>();

        arrayList.add(new Move(this.getSquare(), new Square(this.getSquare(),2,1)));
        arrayList.add(new Move(this.getSquare(), new Square(this.getSquare(),2,-1)));
        arrayList.add(new Move(this.getSquare(), new Square(this.getSquare(),-2,1)));
        arrayList.add(new Move(this.getSquare(), new Square(this.getSquare(),-2,1)));
        arrayList.add(new Move(this.getSquare(), new Square(this.getSquare(),1,2)));
        arrayList.add(new Move(this.getSquare(), new Square(this.getSquare(),1,-2)));
        arrayList.add(new Move(this.getSquare(), new Square(this.getSquare(),-1,2)));
        arrayList.add(new Move(this.getSquare(), new Square(this.getSquare(),-1,-2)));


        ArrayList<Move> answer = new ArrayList<Move>();
        for (Move move : arrayList) {
            if(isLegalCapture(move) || isLegalMove(move)) {
                answer.add(move);
            }
        }
        return answer;
    }

    @Override
    public String toString() {
        return (isWhite()?"w":"b") + "_knight";
    }
}



