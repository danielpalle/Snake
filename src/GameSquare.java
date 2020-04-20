import javax.swing.*;
import java.awt.*;

class GameSquare extends JPanel {
    public int row, col;
    public GameSquare(int i, int j) {
        row = i;
        col = j;
        setPreferredSize(new Dimension(20,20));
    }
}