package chess.figures;

import chess.Game;
import chess.Move;

import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.HashSet;

public class Queen extends Figure {

    public Queen(Square square, boolean isWhite, Game game) {
        super(square, isWhite, game);
    }

    @Override
    public ArrayList<Move> getPossibleMoves() {
        Rook rook = new Rook(this.getSquare(), isWhite(), getGame());
        Bishop bishop = new Bishop(this.getSquare(), isWhite(), getGame());
        HashSet<Move> hashSet = new HashSet<Move>();
        hashSet.addAll(rook.getPossibleMoves());
        hashSet.addAll(bishop.getPossibleMoves());
        ArrayList<Move> arrayList = new ArrayList<Move>();
        arrayList.addAll(hashSet);
        return arrayList;
    }

    @Override
    public String toString() {
        return (isWhite()?"w":"b") + "_queen";
    }

}
