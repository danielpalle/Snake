import java.awt.*;
import java.util.LinkedList;

public class GameControl {
    static LinkedList<Coordinate> queue = new LinkedList<>();
    static int snakeheadrow;
    static int snakeheadcol;
    public static String movesnakedirection = "right";

    public static void buildGUI() {
        GUI.createGameWindow();
        GUI.createGameGrid();
    }

    public static void createSnake()  {
        snakeheadcol = 8;
        snakeheadrow = 10;
        for (int i=0; i<3; i++) {
            queue.add(new Coordinate(snakeheadcol +i, snakeheadrow));
            GUI.square[queue.get(i).getX()][queue.get(i).getY()].setBackground(Color.white);
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
        GUI.square[queue.getLast().getX()][queue.getLast().getY()].setBackground(Color.white);
        GUI.square[queue.getFirst().getX()][queue.getFirst().getY()].setBackground(Color.black);
        queue.removeFirst();
        GUI.f.setVisible(true);
    }

    public static void moveSnakeDown() {
        if (snakeheadrow+1==20)
            snakeheadrow=0;
        else
            snakeheadrow++;
        queue.addLast(new Coordinate(snakeheadcol, snakeheadrow));
        GUI.square[queue.getLast().getX()][queue.getLast().getY()].setBackground(Color.white);
        GUI.square[queue.getFirst().getX()][queue.getFirst().getY()].setBackground(Color.black);
        queue.removeFirst();
        GUI.f.setVisible(true);
    }
}







