import javax.swing.*;
import java.awt.*;

public class GameControl {
    static GameSquare[][] r = new GameSquare[20][20];
    static JFrame f = new JFrame();
    static JPanel upperborder = new JPanel();
    static JPanel gamearea = new JPanel();
    static JPanel lowerborder = new JPanel();

    public static void createGameWindow() {
        f.setPreferredSize(new Dimension(400, 600));
        f.setLayout(new BorderLayout());
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        upperborder.setPreferredSize(new Dimension(400, 100));
        upperborder.setBackground(Color.lightGray);
        f.add("North", upperborder);

        lowerborder.setPreferredSize(new Dimension(400, 100));
        lowerborder.setBackground(Color.lightGray);
        f.add("South", lowerborder);

        gamearea.setPreferredSize(new Dimension(400, 400));
        gamearea.setBackground(Color.black);
        f.add("Center", gamearea);
        gamearea.setLayout(new GridLayout(20,20));

        f.pack();
        f.setVisible(true);
    }

    public static void createGameGrid() {
        for (int i=0; i<r.length; i++) {
            for (int j = 0; j < r[i].length; j++) {
                r[i][j] = new GameSquare(i, j);
                gamearea.add(r[i][j]);
                r[i][j].setBackground(Color.black);
            }
        }
        r[0][0].setBackground(Color.yellow); // Can be removed whenever.
        r[1][0].setBackground(Color.green);
        r[0][1].setBackground(Color.red);
        r[1][1].setBackground(Color.blue);

        f.setVisible(true);
    }

    public static void CreateSnake() {
        Coordinate c1 = new Coordinate(10, 10);
        Coordinate c2 = new Coordinate(10, 11);
        Coordinate c3 = new Coordinate(10, 12);

        r[c1.getX()][c1.getY()].setBackground(Color.white);
        r[c2.getX()][c2.getY()].setBackground(Color.white);
        r[c3.getX()][c3.getY()].setBackground(Color.white);
    }

}

class GameSquare extends JPanel {
    public int rad, kol;
    public GameSquare(int i, int j) {
        rad = i;
        kol = j;
        setPreferredSize(new Dimension(20,20));
    }
}

class Coordinate {
    private int x, y;
    public Coordinate(int i, int j) {
        x = j;
        y = i;
    }
    public Integer getX() {
        return x;
    }
    public Integer getY() {
        return y;
    }
}



