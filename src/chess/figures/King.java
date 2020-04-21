package chess.figures;

import chess.Game;

public class King extends Figure {

    public King(int x, int y, String path, boolean isWhite) {
        super(x, y, path, isWhite);
    }

    @Override
    public String getPath() {
        if(this.isWhite) {
            return "w_king.png";
        }   else {
            return "b_king.png";
        }
    }

    @Override
    public boolean canMove(int x, int y, Game game) {
        return true;
    }


    @Override
    public boolean isKing() {
        return true;
    }
}
