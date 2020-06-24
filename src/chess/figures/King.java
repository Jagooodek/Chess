package chess.figures;

import chess.Game;
import chess.Move;

import java.util.ArrayList;

public class King extends Figure {

    public King(int x, int y, boolean isWhite, Game game) {
        super(x, y, isWhite, game);
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

        ArrayList<Square> squaresBetween = new ArrayList<>();

        squaresBetween.add(new Square(getX()+1, getY()));
        squaresBetween.add(new Square(getX()+2, getY()));

        if(getGame().getFigure(getX()+1,getY()) == null && getGame().getFigure(getX()+2,getY()) == null) {
            if(!hasMoved() && !getGame().getFigure(getX()+3, getY()).hasMoved()) {
                arrayList.add(new Move(getX(),getY(),getX()+2,getY(), new Move(getX()+3, getY(),getX()+1, getY())));
            }
        }

        if(getGame().getFigure(getX()-1,getY()) == null && getGame().getFigure(getX()-2,getY()) == null && getGame().getFigure(getX()-3,getY()) == null) {
            if(!hasMoved() && !getGame().getFigure(getX()-4, getY()).hasMoved()) {
                arrayList.add(new Move(getX(),getY(),getX()-2,getY(), new Move(getX()-4, getY(), getX() - 1, getY())));
            }
        }



        return arrayList;
    }

    @Override
    public String toString() {
        return (isWhite()?"w":"b") + "_king";
    }

}
