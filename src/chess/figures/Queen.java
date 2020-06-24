package chess.figures;

import chess.Game;
import chess.Move;

import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.HashSet;

public class Queen extends Figure {

    public Queen(int x, int y, String folderPath, boolean isWhite, Game game) {
        super(x, y, folderPath, isWhite, game);
    }

    @Override
    public String getPath() {
        if(this.isWhite()) {
            return "w_queen.png";
        }   else {
            return "b_queen.png";
        }
    }

    @Override
    public ArrayList<Move> getPossibleMoves() {
        Rook rook = new Rook(getX(), getY(), "resources", isWhite(), getGame());
        Bishop bishop = new Bishop(getX(), getY(), "resources", isWhite(), getGame());
        HashSet<Move> hashSet = new HashSet<Move>();
        hashSet.addAll(rook.getPossibleMoves());
        hashSet.addAll(bishop.getPossibleMoves());
        ArrayList<Move> arrayList = new ArrayList<Move>();
        arrayList.addAll(hashSet);
        return arrayList;
    }


}
