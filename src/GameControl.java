import java.awt.*;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class GameControl {
    static LinkedList<Coordinate> snakecoordinate = new LinkedList<>();
    static Coordinate foodcoordinate = new Coordinate(3,3);
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
        snakeinitlength = 3;

        for (int i=0; i<snakeinitlength; i++) {
            snakecoordinate.add(new Coordinate(snakeheadcol +i, snakeheadrow));
            GUI.square[snakecoordinate.get(i).getX()][snakecoordinate.get(i).getY()].setBackground(Color.white);
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
        checkIfFoodIsEaten();
        checkForSnakeCollision();
    }

    public static void moveSnakeRight() {
        if (snakeheadcol+1==20)
            snakeheadcol=0;
        else
            snakeheadcol++;
        snakecoordinate.addLast(new Coordinate(snakeheadcol, snakeheadrow));
        GUI.square[snakecoordinate.getLast().getX()][snakecoordinate.getLast().getY()].setBackground(Color.white);
        GUI.square[snakecoordinate.getFirst().getX()][snakecoordinate.getFirst().getY()].setBackground(Color.black);
        snakecoordinate.removeFirst();
        GUI.f.setVisible(true);
    }

    public static void moveSnakeLeft() {
        if (snakeheadcol-1==-1)
            snakeheadcol=19;
        else
            snakeheadcol--;
        snakecoordinate.addLast(new Coordinate(snakeheadcol, snakeheadrow));
        GUI.square[snakecoordinate.getLast().getX()][snakecoordinate.getLast().getY()].setBackground(Color.white);
        GUI.square[snakecoordinate.getFirst().getX()][snakecoordinate.getFirst().getY()].setBackground(Color.black);
        snakecoordinate.removeFirst();
        GUI.f.setVisible(true);
    }

    public static void moveSnakeDown() {
        if (snakeheadrow+1==20)
            snakeheadrow=0;
        else
            snakeheadrow++;
        snakecoordinate.addLast(new Coordinate(snakeheadcol, snakeheadrow));
        GUI.square[snakecoordinate.getLast().getX()][snakecoordinate.getLast().getY()].setBackground(Color.white);
        GUI.square[snakecoordinate.getFirst().getX()][snakecoordinate.getFirst().getY()].setBackground(Color.black);
        snakecoordinate.removeFirst();
        GUI.f.setVisible(true);
    }

    public static void moveSnakeUp() {
        if (snakeheadrow-1==-1)
            snakeheadrow=19;
        else
            snakeheadrow--;
        snakecoordinate.addLast(new Coordinate(snakeheadcol, snakeheadrow));
        GUI.square[snakecoordinate.getLast().getX()][snakecoordinate.getLast().getY()].setBackground(Color.white);
        GUI.square[snakecoordinate.getFirst().getX()][snakecoordinate.getFirst().getY()].setBackground(Color.black);
        snakecoordinate.removeFirst();
        GUI.f.setVisible(true);
    }

    public static void extendSnake() {
        GameControl.snakecoordinate.addLast(new Coordinate(GameControl.snakeheadcol, GameControl.snakeheadrow));
    }

    public static void placeFood() {
        foodcoordinate.setY(ThreadLocalRandom.current().nextInt(0, 19 + 1));
        foodcoordinate.setX(ThreadLocalRandom.current().nextInt(0, 19 + 1));
        GUI.square[foodcoordinate.getX()][foodcoordinate.getY()].setBackground(Color.yellow);
    }

    public static void checkIfFoodIsEaten() {
        if (snakecoordinate.getLast().getX() == foodcoordinate.getX() && snakecoordinate.getLast().getY() == foodcoordinate.getY()) {
            extendSnake();
            placeFood();
            MoveSnakeTimer.makeTimerFaster();

        }
    }

    public static void checkForSnakeCollision() {
        for (int i = 0; i<snakecoordinate.size(); i++)
            if (snakecoordinate.getLast().getY() == snakecoordinate.get(0).getY() && snakecoordinate.getLast().getX() == snakecoordinate.get(0).getX()){
                MoveSnakeTimer.timer.cancel();
                GUI.square[snakecoordinate.getLast().getX()][snakecoordinate.getLast().getY()].setBackground(Color.red);
            }

    }

}







