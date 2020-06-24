package chess.figures;

import chess.Game;
import chess.Move;

import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.HashSet;

public class Queen extends Figure {

    public Queen(int x, int y, boolean isWhite, Game game) {
        super(x, y, isWhite, game);
    }

    @Override
    public ArrayList<Move> getPossibleMoves() {
        Rook rook = new Rook(getX(), getY(), isWhite(), getGame());
        Bishop bishop = new Bishop(getX(), getY(), isWhite(), getGame());
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
