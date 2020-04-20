import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class GameControl {
    static GameSquare[][] square = new GameSquare[20][20];
    static JFrame f = new JFrame();
    static JPanel upperborder = new JPanel();
    static JPanel gamearea = new JPanel();
    static JPanel lowerborder = new JPanel();
    static LinkedList<Coordinate> queue = new LinkedList<>();
    static int snakeheadrow;
    static int snakeheadcol;
    public static String movesnakedirection = "right";

    public static void startGame() {
        GameControl.createGameWindow();
        GameControl.createGameGrid();
        GameControl.createSnake();
    }

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
        for (int i = 0; i< square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                square[i][j] = new GameSquare(i, j);
                gamearea.add(square[i][j]);
                square[i][j].setBackground(Color.black);
            }
        }
        f.setVisible(true);
    }

    public static void createSnake()  {
        snakeheadcol = 8;
        snakeheadrow = 10;
        for (int i=0; i<3; i++) {
            queue.add(new Coordinate(snakeheadcol +i, snakeheadrow));
            square[queue.get(i).getX()][queue.get(i).getY()].setBackground(Color.white);
        }
        snakeheadcol+=2;
    }

    public static void moveSnake() {
        if (movesnakedirection == "right")
            moveSnakeRight();
        else if (movesnakedirection == "down")
            moveSnakeDown();
    }

    public static void moveSnakeRight() {
        if (snakeheadcol+1==20)
            snakeheadcol=0;
        else
            snakeheadcol++;
        queue.addLast(new Coordinate(snakeheadcol, snakeheadrow));
        square[queue.getLast().getX()][queue.getLast().getY()].setBackground(Color.white);
        square[queue.getFirst().getX()][queue.getFirst().getY()].setBackground(Color.black);
        queue.removeFirst();
        f.setVisible(true);
    }

    public static void moveSnakeDown() {
        if (snakeheadrow+1==20)
            snakeheadrow=0;
        else
            snakeheadrow++;
        queue.addLast(new Coordinate(snakeheadcol, snakeheadrow));
        square[queue.getLast().getX()][queue.getLast().getY()].setBackground(Color.white);
        square[queue.getFirst().getX()][queue.getFirst().getY()].setBackground(Color.black);
        queue.removeFirst();
        f.setVisible(true);
    }
}

class GameSquare extends JPanel {
    public int row, col;
    public GameSquare(int i, int j) {
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



