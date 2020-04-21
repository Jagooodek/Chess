import javax.swing.*;
import java.awt.*;

public class Try2 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setBounds(300,300,100,100);
        jFrame.setDefaultCloseOperation(3);

        jFrame.getContentPane().add(new JPanel() {
            Image img1 = Toolkit.getDefaultToolkit().getImage("E:\\InteliJJ Idea\\snake\\src\\resources\\apple.png");
            Image img2 = Toolkit.getDefaultToolkit().getImage("E:\\InteliJJ Idea\\chees\\Program-Your-Own-Chess\\ChessGUI\\images\\board.png");

            @Override
            protected void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                this.setPreferredSize(new Dimension(1000,1000));
                graphics.drawImage(img2, 0, 0,this);
                graphics.drawImage(img1, 0, 0, this);
            }
        });
        jFrame.pack();
    }
}
