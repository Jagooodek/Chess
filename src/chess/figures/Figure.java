package chess.figures;

import java.awt.*;
import chess.Game;
public abstract class Figure {

    private int x;
    private int y;
    private String folderPath;
    private Image image;
    boolean isWhite;

    public Figure(int x, int y, String folderPath, boolean isWhite) {

        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
        this.folderPath = folderPath;
        loadImage();
    }

    public abstract String getPath();

    public abstract boolean canMove(int x, int y, Game game);

    private void loadImage() {
        System.out.println();
        image = Toolkit.getDefaultToolkit().getImage(folderPath + "/" + getPath());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public boolean isKing() {
        return false;
    }
}
