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
        if(Math.abs(this.getX() - x ) <= 1 && Math.abs(this.getY() - y) <= 1) {
            if(game.getFigure(x,y) != null && game.getFigure(x, y).isWhite == this.isWhite())
                return false;
            return true;
        }
        return false;
    }


    @Override
    public boolean isKing() {
        return true;
    }
}
