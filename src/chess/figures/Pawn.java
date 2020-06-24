package chess.figures;

import chess.Game;
import chess.Move;

import java.util.ArrayList;

public class Pawn extends Figure {

    public Pawn(Square square, boolean isWhite, Game game) {
        super(square, isWhite, game);
    }

    @Override
    public ArrayList<Move> getPossibleMoves() {


        ArrayList<Move> arrayList = new ArrayList<>();
        Move move;

        move = new Move(this.getSquare(),new Square(this.getSquare(), 0, (this.isWhite()?1:-1)));
        if(this.isLegalMove(move)) {
            arrayList.add(move);
            move = new Move(this.getSquare(),new Square(this.getSquare(), 0, (this.isWhite()?2:-2)));
            if(!this.hasMoved() && isLegalMove(move))
                arrayList.add(move);
        }

        for(Move m:getPossibleCaptures()) {
            if(this.isLegalCapture(m))
                arrayList.add(m);
        }
        return arrayList;
    }

    @Override
    public String toString() {
        return (isWhite()?"w":"b") + "_pawn";
    }

    @Override
    public ArrayList<Move> getPossibleCaptures() {

        ArrayList<Move> arrayList = new ArrayList<>();

        Move move;
        move = new Move(this.getSquare(), new Square(this.getSquare(), (isWhite()?1:-1), (isWhite()?1:-1)));
        if(move.isPossible())
            arrayList.add(move);

        move = new Move(this.getSquare(), new Square(this.getSquare(), (isWhite()?-1:1), (isWhite()?1:-1)));
        if(move.isPossible())
            arrayList.add(move);
        return arrayList;
    }
}
