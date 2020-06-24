package chess.figures;

import chess.Game;
import chess.Move;

import java.util.ArrayList;

public class Bishop extends Figure {

    public Bishop(int x, int y, boolean isWhite, Game game) {
        super(x, y, isWhite, game);
    }

    @Override
    public ArrayList<Move> getPossibleMoves() {
        ArrayList<Move> arrayList = new ArrayList<Move>();

        Move move;
        int x = this.getX();
        int y = this.getY();

        while(x-- >= 1 && y-- >= 1) {
            move = new Move(this.getX(), this.getY(), x, y);
            if(isPossibleMove(move)) {
                arrayList.add(move);
            } else {
                if(isPossibleCapture(move))
                    arrayList.add(move);
                break;
            }
        }

        x = this.getX();
        y = this.getY();
        while(x-- >= 1 && y++ <= 8) {
            move = new Move(this.getX(), this.getY(), x, y);
            if(isPossibleMove(move)) {
                arrayList.add(move);
            } else {
                if(isPossibleCapture(move))
                    arrayList.add(move);
                break;
            }
        }

        x = this.getX();
        y = this.getY();
        while(x++ <= 8 && y++ <= 8) {
            move = new Move(this.getX(), this.getY(), x, y);
            if(isPossibleMove(move)) {
                arrayList.add(move);
            } else {
                if(isPossibleCapture(move))
                    arrayList.add(move);
                break;
            }
        }

        x = this.getX();
        y = this.getY();
        while(x++ <= 8 && y-- >= 1) {
            move = new Move(this.getX(), this.getY(), x, y);
            if(isPossibleMove(move)) {
                arrayList.add(move);
            } else {
                if(isPossibleCapture(move))
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
