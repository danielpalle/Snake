import javax.swing.*;
import java.awt.*;

class Square extends JPanel {
    int row, col;

    public Square(int i, int j) {
        row = i;
        col = j;
        setPreferredSize(new Dimension(20,20));
    }
}