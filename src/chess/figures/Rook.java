package chess.figures;

import chess.Game;
import chess.Move;

import java.util.ArrayList;

public class Rook extends Figure {


    public Rook(int x, int y, String folderPath, boolean isWhite, Game game) {
        super(x, y, folderPath, isWhite, game);
    }

    @Override
    public String getPath() {
        if(this.isWhite()) {
            return "w_rook.png";
        }   else {
            return "b_rook.png";
        }
    }

    @Override
    public ArrayList<Move> getPossibleMoves() {

        ArrayList<Move> arrayList = new ArrayList<Move>();
        Move move;

        int x = this.getX();
        int y = this.getY();

        while(x++ <= 8) {
            move = new Move(this.getX(), this.getY(), x, y);
            if(isPossibleMove(move)) {
                arrayList.add(move);
            } else {
                if(isPossibleCapture(move))
                    arrayList.add(move);
                break;
            }
        }

        x = getX();
        y = getY();

        while(x-- >= 1) {
            move = new Move(this.getX(), this.getY(), x, y);
            if(isPossibleMove(move)) {
                arrayList.add(move);
            } else {
                if(isPossibleCapture(move))
                    arrayList.add(move);
                break;
            }
        }

        x = getX();
        y = getY();

        while(y-- >= 1) {
            move = new Move(this.getX(), this.getY(), x, y);
            if(isPossibleMove(move)) {
                arrayList.add(move);
            } else {
                if(isPossibleCapture(move))
                    arrayList.add(move);
                break;
            }
        }

        x = getX();
        y = getY();

        while(y++ <= 8) {
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


}
