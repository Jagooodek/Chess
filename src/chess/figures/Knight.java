package chess.figures;

import chess.Game;
import chess.Move;

import java.util.ArrayList;

public class Knight extends Figure {


    public Knight(int x, int y, String folderPath, boolean isWhite, Game game) {
        super(x, y, folderPath, isWhite, game);
    }

    @Override
    public String getPath() {
        if(this.isWhite()) {
            return "w_knight.png";
        }   else {
            return "b_knight.png";
        }
    }

    @Override
    public ArrayList<Move> getPossibleMoves() {
        ArrayList<Move> arrayList = new ArrayList<Move>();

        arrayList.add(new Move(this.getX(), this.getY(), this.getX() + 2, this.getY() + 1));
        arrayList.add(new Move(this.getX(), this.getY(), this.getX() + 2, this.getY() - 1));
        arrayList.add(new Move(this.getX(), this.getY(), this.getX() + 1, this.getY() + 2));
        arrayList.add(new Move(this.getX(), this.getY(), this.getX() + 1, this.getY() - 2));
        arrayList.add(new Move(this.getX(), this.getY(), this.getX() - 2, this.getY() + 1));
        arrayList.add(new Move(this.getX(), this.getY(), this.getX() - 2, this.getY() - 1));
        arrayList.add(new Move(this.getX(), this.getY(), this.getX() - 1, this.getY() + 2));
        arrayList.add(new Move(this.getX(), this.getY(), this.getX() - 1, this.getY() + 2));

        ArrayList<Move> answer = new ArrayList<Move>();
        for (Move move : arrayList) {
            if(isPossibleCapture(move) || isPossibleMove(move)) {
                answer.add(move);
            }
        }
        return answer;
    }


}



