import chess.figures.Figure;
import chess.figures.Knight;

import javax.swing.*;

public class Try {
    public static void main(String[] args) {
        JOptionPane jOptionPane = new JOptionPane();
        jOptionPane.setVisible(true);
        String [] possibilities = {"Knight", "Bishop", "Queen", "Rook"};
        JFrame frame = new JFrame();
        frame.setVisible(true);

        String s = (String)JOptionPane.showInputDialog(frame, "Choose figure to replace your pawn.", "Pawn promotion",  JOptionPane.QUESTION_MESSAGE, null,  possibilities, "Knight");
    }
}
