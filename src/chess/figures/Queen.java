package chess.figures;

import chess.Game;

import javax.swing.table.TableRowSorter;

public class Queen extends Figure {

    public Queen(int x, int y, String path, boolean isWhite) {
        super(x, y, path, isWhite);
    }

    @Override
    public String getPath() {
        if(this.isWhite) {
            return "w_queen.png";
        }   else {
            return "b_queen.png";
        }
    }

    @Override
    public boolean canMove(int x, int y, Game game) {
        return true;
    }


}
