package chess.figures;

import chess.Game;

public class Bishop extends Figure {

    public Bishop(int x, int y, String path, boolean isWhite) {
        super(x, y, path, isWhite);
    }

    @Override
    public String getPath() {
        if(this.isWhite) {
            return "w_bishop.png";
        }   else {
            return "b_bishop.png";
        }
    }

    @Override
    public boolean canMove(int x, int y, Game game) {
        return true;
    }

}
