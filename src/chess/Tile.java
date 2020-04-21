package chess;

import chess.figures.Figure;
import sun.awt.image.ToolkitImage;

import javax.swing.*;
import java.awt.*;

public class Tile extends JPanel {
    private int x;
    private int y;
    private Image image;
    private Image selectedImage;
    private Figure figure = null;
    private boolean isSelected = false;
    public Tile(int x, int y, int size, String path) {
        super();
        this.x = x;
        this.y = y;
        this.setSize(size, size);
        loadImage(path);
    }

    private void loadImage(String path) {
        image = Toolkit.getDefaultToolkit().getImage(path);
        selectedImage = Toolkit.getDefaultToolkit().getImage("resources/selected.png");
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
        this.isSelected = isSelected;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if(isSelected)
            graphics.drawImage(selectedImage, 0 ,0, this);
        else
            graphics.drawImage(image, 0, 0, this);
        if(figure != null) {
            graphics.drawImage(this.figure.getImage(), 0, 0, this);
        }
    }
}
