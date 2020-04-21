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
        if(game.getFigure(x, y) != null && game.getFigure(x, y).isWhite() == this.isWhite())
            return false;
        if(this.getX() == x) {
            int tmpY = this.getY();
            if(tmpY > y) {
                tmpY --;
                while(tmpY > y) {
                    if(game.getFigure(x, tmpY) != null)
                        return false;
                    tmpY --;
                }
                return true;
            }
            if(tmpY < y) {
                tmpY ++;
                while(tmpY <  y) {
                    if(game.getFigure(x, tmpY) != null)
                        return false;
                    tmpY ++;
                }
                return true;
            }
        }

        if(this.getY() == y) {
            int tmpX = this.getX();
            if(tmpX > x) {
                tmpX --;
                while(tmpX > x) {
                    if(game.getFigure(tmpX, y) != null)
                        return false;
                    tmpX --;
                }
                return true;
            }
            if(tmpX < x) {
                tmpX ++;
                while(tmpX<  x) {
                    if(game.getFigure(tmpX, y) != null)
                        return false;
                    tmpX++;
                }
                return true;
            }
        }

        if(Math.abs(this.getX() - x) == Math.abs(this.getY() - y)) {

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
