package chess.figures;

public class Square {
    private int x;
    private int y;

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Square(Square square, int xChange, int yChange) {
        this.x = square.getX() + xChange;
        this.y = square.getY() + yChange;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isLegal() {
        if(x >= 1 && x <=8 && y >= 1 && y <=8)
            return true;
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Square) {
            Square square = (Square)o;
            if(square.getX() == this.x && square.getY() == this.y)
                return true;
            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        String s = x + "x" + y;
        return s;
    }
}
