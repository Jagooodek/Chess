package chess.figures;

import chess.Game;
import chess.Move;

import java.util.ArrayList;

public class King extends Figure {


    public King(int x, int y, String folderPath, boolean isWhite, Game game) {
        super(x, y, folderPath, isWhite, game);
    }

    @Override
    public String getPath() {
        if(this.isWhite()) {
            return "w_king.png";
        }   else {
            return "b_king.png";
        }
    }

    @Override
    public ArrayList<Move> getPossibleMoves() {
        ArrayList<Move> arrayList = new ArrayList<>();

        for (int i = this.getX() - 1; i <= this.getX() + 1; i++) {
            for (int j = this.getY() - 1; j <= this.getY() + 1 ; j++) {
                Move move = new Move(this.getX(), this.getY(), i, j);
                if(this.isPossibleCapture(move) || this.isPossibleMove(move))
                    arrayList.add(move);
            }
        }

        if(getGame().getFigure(getX()+1,getY()) == null && getGame().getFigure(getX()+2,getY()) == null) {
            if(!hasMoved() && !getGame().getFigure(getX()+3, getY()).hasMoved()) {
                arrayList.add(new Move(getX(),getY(),getX()+3,getY(), true));
            }
        }

        if(getGame().getFigure(getX()+1,getY()) == null && getGame().getFigure(getX()+2,getY()) == null && getGame().getFigure(getX()+3,getY()) == null) {
            if(!hasMoved() && !getGame().getFigure(getX()+4, getY()).hasMoved()) {
                arrayList.add(new Move(getX(),getY(),getX()+4,getY(), true));
            }
        }



        return arrayList;
    }





}
