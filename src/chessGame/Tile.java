package chessGame;

import chess.Move;
import chess.figures.Figure;
import sun.awt.image.ToolkitImage;

import javax.swing.*;
import java.awt.*;

public class Tile extends JPanel {
    private int x;
    private int y;
    private Image image;
    private Image selectedImage;
    private Image moveImage;
    private Figure figure = null;
    private boolean selected = false;
    private boolean white;
    private Move move;

    public Tile(int x, int y, int size, Boolean white) {
        super();
        this.x = x;
        this.y = y;
        this.setSize(size, size);
        this.white = white;
        String path = "resources/brown" + (white?"1":"2") + ".png";
        loadImage(path);
    }

    private void loadImage(String path) {
        image = Toolkit.getDefaultToolkit().getImage(path);
        selectedImage = Toolkit.getDefaultToolkit().getImage("resources/selected.png");
        moveImage = Toolkit.getDefaultToolkit().getImage("resources/move" + (white?2:1) + ".png");
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
        if(figure != null) {
            figure.setX(this.x);
            figure.setY(this.y);
        }
    }

    public Figure getFigure() {
        return figure;
    }

    public int getTileX() {
        return x;
    }

    public int getTileY() {
        return y;
    }

    public void setSelected(Boolean isSelected) {
        this.selected = isSelected;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if(selected)
            graphics.drawImage(selectedImage, 0 ,0, this);
        else {
            if(move == null)
                graphics.drawImage(image, 0, 0, this);
            else
                graphics.drawImage(moveImage, 0, 0, this);
        }
        if(figure != null) {
            graphics.drawImage(getImage(figure), 0, 0, this);
        }
    }

    private Image getImage(Figure figure) {
        String path = "resources/" + figure.toString() + ".png";
        return Toolkit.getDefaultToolkit().getImage(path);
    }
}
