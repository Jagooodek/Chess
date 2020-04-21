package chess.figures;

import chess.Game;

public class Knight extends Figure {

    public Knight(int x, int y, String path, boolean isWhite) {
        super(x, y, path, isWhite);
    }

    @Override
    public String getPath() {
        if(this.isWhite) {
            return "w_knight.png";
        }   else {
            return "b_knight.png";
        }
    }

    @Override
    public boolean canMove(int x, int y, Game game) {
        return true;
    }


}
