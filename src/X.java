import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class X extends JPanel {
    Image img;
    X() {
        super();
        this.setBackground(Color.black);

    }
    @Override
    protected void paintComponent(Graphics graphics) {
        //graphics.drawImage(img,0, 0, this);
        super.paintComponent(graphics);
    }
}
