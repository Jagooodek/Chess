package chess.figures;

import chess.Game;

public class Pawn extends Figure {

    public Pawn(int x, int y, String path, boolean isWhite) {
        super(x, y, path, isWhite);
    }

    @Override
    public String getPath() {
        if(this.isWhite) {
            return "w_pawn.png";
        }   else {
            return "b_pawn.png";
        }
    }

    @Override
    public boolean canMove(int x, int y, Game game) {
        if(isWhite) {
            if(this.getX() == x) {
                if(this.getY() + 1 == y) {
                    if(game.getFigure(x, y) == null) {
                        return true;
                    }
                }

                if(this.getY() == 2 && y == 4) {
                    if(game.getFigure(x, 3) == null && game.getFigure(x, y) == null) {
                        return true;
                    }
                }
            }

            if((Math.abs(this.getX() - x) == 1) && (y - this.getY() == 1)) {
                if(game.getFigure(x, y) != null) {
                    if(!game.getFigure(x, y).isWhite) {
                        return true;
                    }
                }
            }
        } else {
            if(this.getX() == x) {
                if(this.getY() - 1 == y) {
                    if(game.getFigure(x, y) == null) {
                        return true;
                    }
                }

                if(this.getY() == 7 && y == 5) {
                    if(game.getFigure(x, 6) == null && game.getFigure(x, y) == null) {
                        return true;
                    }
                }
            }

            if((Math.abs(this.getX() - x) == 1) && (y - this.getY() == -1)) {
                if(game.getFigure(x, y) != null) {
                    if(game.getFigure(x, y).isWhite) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
