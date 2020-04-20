import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class GameControl {
    static gamesquare[][] r = new gamesquare[20][20];
    static JFrame f = new JFrame();
    static JPanel upperborder = new JPanel();
    static JPanel gamearea = new JPanel();
    static JPanel lowerborder = new JPanel();
    static LinkedList<Coordinate> queue = new LinkedList<>();
    static int snakeheadrow;
    static int snakeheadcol;

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
                r[i][j] = new gamesquare(i, j);
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

    public static void createSnake() throws InterruptedException {
        snakeheadcol = 3;
        snakeheadrow = 10;
        for (int i=0; i<3; i++) {
            queue.add(new Coordinate(snakeheadcol +i, snakeheadrow));
            r[queue.get(i).getX()][queue.get(i).getY()].setBackground(Color.white);
            Thread.sleep(500);
        }
        snakeheadcol+=2;
    }

    public static void moveSnakeRight() throws InterruptedException {
        boolean MoveRight = true;
        while (MoveRight) {

            for (int i=0; i<queue.size(); i++) {
                snakeheadcol++;
                queue.addLast(new Coordinate(snakeheadcol, snakeheadrow));
                r[queue.getLast().getX()][queue.getLast().getY()].setBackground(Color.white);
                System.out.println(queue.getFirst().getY());
                r[queue.getFirst().getX()][queue.getFirst().getY()].setBackground(Color.black);
                queue.removeFirst();
                Thread.sleep(500);


            }

            f.setVisible(true);
        }
    }
}

class gamesquare extends JPanel {
    public int row, col;
    public gamesquare(int i, int j) {
        row = i;
        col = j;
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



