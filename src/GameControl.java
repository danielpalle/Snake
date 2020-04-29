import java.awt.*;
import java.util.LinkedList;

public class GameControl {
    static LinkedList<Coordinate> queue = new LinkedList<>();
    static int snakeheadrow;
    static int snakeheadcol;
    static int snakeinitlength;
    public static String movesnakedirection = "right";
    public static String lastmoveddirection;

    public static void buildGUI() {
        GUI.createGameWindow();
        GUI.createGameGrid();
    }

    public static void createSnake()  {
        snakeheadcol = 8;
        snakeheadrow = 10;
        snakeinitlength = 7;

        for (int i=0; i<snakeinitlength; i++) {
            queue.add(new Coordinate(snakeheadcol +i, snakeheadrow));
            GUI.square[queue.get(i).getX()][queue.get(i).getY()].setBackground(Color.white);
        }
        snakeheadcol+=(snakeinitlength-1);
    }

    public static void moveSnake() {
        if (movesnakedirection == "right") {
            if (lastmoveddirection == "left")
                moveSnakeLeft();
            else {
                moveSnakeRight();
                lastmoveddirection = "right";
            }
        }
        else if (movesnakedirection == "down") {
            if (lastmoveddirection == "up")
                moveSnakeUp();
            else {
                moveSnakeDown();
                lastmoveddirection = "down";
            }
        }
        else if (movesnakedirection == "up") {
            if (lastmoveddirection == "down")
                moveSnakeDown();
            else {
                moveSnakeUp();
                lastmoveddirection = "up";
            }
        }
        else if (movesnakedirection == "left") {
            if (lastmoveddirection == "right")
                moveSnakeRight();
            else {
                moveSnakeLeft();
                lastmoveddirection = "left";
            }
        }
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

    public static void moveSnakeLeft() {
        if (snakeheadcol-1==-1)
            snakeheadcol=19;
        else
            snakeheadcol--;
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

    public static void moveSnakeUp() {
        if (snakeheadrow-1==-1)
            snakeheadrow=19;
        else
            snakeheadrow--;
        queue.addLast(new Coordinate(snakeheadcol, snakeheadrow));
        GUI.square[queue.getLast().getX()][queue.getLast().getY()].setBackground(Color.white);
        GUI.square[queue.getFirst().getX()][queue.getFirst().getY()].setBackground(Color.black);
        queue.removeFirst();
        GUI.f.setVisible(true);
    }
}







