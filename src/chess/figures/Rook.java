package chess.figures;

import chess.Game;

public class Rook extends Figure {

    public Rook(int x, int y, String path, boolean isWhite) {
        super(x, y, path, isWhite);
    }

    @Override
    public String getPath() {
        if(this.isWhite) {
            return "w_rook.png";
        }   else {
            return "b_rook.png";
        }
    }

    @Override
    public boolean canMove(int x, int y, Game game) {
        return true;
    }


}
