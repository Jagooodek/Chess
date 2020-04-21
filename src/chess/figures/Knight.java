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
        if(game.getFigure(x, y) != null && game.getFigure(x, y).isWhite() == this.isWhite())
            return false;
        if(Math.abs(this.getX() - x) == 2 && Math.abs(this.getY() - y) == 1)
            return true;
        if(Math.abs(this.getX() - x) == 1 && Math.abs(this.getY() - y) == 2)
            return true;
        return false;
    }


}
