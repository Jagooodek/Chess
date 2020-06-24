package chess.figures;

import chess.Game;
import chess.Move;

import java.util.ArrayList;

public class Pawn extends Figure {

    public Pawn(int x, int y, String folderPath, boolean isWhite, Game game) {
        super(x, y, folderPath, isWhite, game);
    }

    @Override
    public String getPath() {
        if(this.isWhite()) {
            return "w_pawn.png";
        }   else {
            return "b_pawn.png";
        }
    }


    @Override
    public ArrayList<Move> getPossibleMoves() {

        int x = this.getX();
        int y = this.getY();
        ArrayList<Move> arrayList = new ArrayList<>();
        Move move;

        move = new Move(x,y,x,this.isWhite()?y+1:y-1);
        if(this.isPossibleMove(move)) {
            arrayList.add(move);
            move = new Move(x,y,x,this.isWhite()?y+2:y-2);
            if(!this.hasMoved() && isPossibleMove(move))
                arrayList.add(move);
        }

        move = new Move(x,y,this.isWhite()?x+1:x-1,this.isWhite()?y+1:y-1);
        if(isPossibleCapture(move))
            arrayList.add(move);

        move = new Move(x,y,this.isWhite()?x+1:x-1,this.isWhite()?y+1:y-1);
        if(isPossibleCapture(move))
            arrayList.add(move);

        return arrayList;


    }

}
