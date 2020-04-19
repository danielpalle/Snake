import javax.swing.*;
import java.awt.*;

public class GameControl {
    static Ruta[][] r = new Ruta[20][20];
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
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void createGameGrid() {
        for (int i=0; i<r.length; i++) {
            for (int j = 0; j < r[i].length; j++) {
                r[i][j] = new Ruta(i, j);
                gamearea.add(r[i][j]);
                r[i][j].setBackground(Color.black);
            }
        }
        r[0][0].setBackground(Color.yellow);
        r[1][0].setBackground(Color.green);
        r[0][1].setBackground(Color.red);
        r[1][1].setBackground(Color.blue);

        f.setVisible(true);
    }

    public static void MoveSnake() throws InterruptedException {
        for (int i=0; i<20; i++) {
            r[10][i].setBackground(Color.white);

            if ((i-3)>=0  && i<=20) {
                r[10][i-3].setBackground(Color.black);
            }
            Thread.sleep(200);
            if (i==19)
                i=-1;
            f.setVisible(true);

        }
    }

}

class Ruta extends JPanel {
    public int rad, kol;
    public Ruta(int i, int j) {
        rad = i;
        kol = j;
        setPreferredSize(new Dimension(20,20));
    }
}



