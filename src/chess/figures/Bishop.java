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
        if(Math.abs(this.getX() - x) == Math.abs(this.getY() - y)) {

            if(game.getFigure(x, y) != null && game.getFigure(x, y).isWhite == this.isWhite())
                return false;

            int tmpX;
            int tmpY;

            if(this.getX() > x && this.getY() > y) {
                tmpX = this.getX() - 1;
                tmpY = this.getY() - 1;
                while(tmpX > x) {
                    if(game.getFigure(tmpX, tmpY) != null)
                        return false;
                    tmpX--;
                    tmpY--;
                }
            }

            if(this.getX() < x && this.getY() < y) {
                tmpX = this.getX() + 1;
                tmpY = this.getY() + 1;
                while(tmpX < x) {
                    if(game.getFigure(tmpX, tmpY) != null)
                        return false;
                    tmpX++;
                    tmpY++;
                }

            }

            if(this.getX() > x && this.getY() < y) {
                tmpX = this.getX() - 1;
                tmpY = this.getY() + 1;
                while(tmpX > x) {
                    if(game.getFigure(tmpX, tmpY) != null)
                        return false;
                    tmpX--;
                    tmpY++;
                }
            }

            if(this.getX() < x && this.getY() > y) {
                tmpX = this.getX() + 1;
                tmpY = this.getY() - 1;
                while(tmpX < x) {
                    if(game.getFigure(tmpX, tmpY) != null)
                        return false;
                    tmpX++;
                    tmpY--;
                }
            }
            return true;
        }
        return false;
    }

}
