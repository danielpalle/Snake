import java.awt.*;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class GameControl {
    LinkedList<Coordinate> snakecoordinate = new LinkedList<>();
    Coordinate foodcoordinate = new Coordinate(3,3);
    int snakeheadrow;
    int snakeheadcol;
    int snakeinitlength;
    String movesnakedirection = "right";
    String lastmoveddirection;
    GUI gui1;
    MoveSnakeTimer movesnaketimer1;

    public void startGame() {
        movesnaketimer1 = new MoveSnakeTimer(this);
        movesnaketimer1.taskMoveSnake();
    }

    public void buildGUI () {
        gui1 = new GUI(this);
        gui1.createGameWindow();
    }

    public void createSnake () {
        snakeheadcol = 3;
        snakeheadrow = 10;
        snakeinitlength = 15;

        for (int i = 0; i < snakeinitlength; i++) {
            snakecoordinate.add(new Coordinate(snakeheadcol + i, snakeheadrow));
            gui1.square[snakecoordinate.get(i).getX()][snakecoordinate.get(i).getY()].setBackground(Color.white);
        }
        snakeheadcol += (snakeinitlength - 1);
    }

    public void moveSnake () {
        if (movesnakedirection == "right") {
            if (lastmoveddirection == "left")
                moveSnakeLeft();
            else {
                moveSnakeRight();
                lastmoveddirection = "right";
            }
        } else if (movesnakedirection == "down") {
            if (lastmoveddirection == "up")
                moveSnakeUp();
            else {
                moveSnakeDown();
                lastmoveddirection = "down";
            }
        } else if (movesnakedirection == "up") {
            if (lastmoveddirection == "down")
                moveSnakeDown();
            else {
                moveSnakeUp();
                lastmoveddirection = "up";
            }
        } else if (movesnakedirection == "left") {
            if (lastmoveddirection == "right")
                moveSnakeRight();
            else {
                moveSnakeLeft();
                lastmoveddirection = "left";
            }
        }
    }

    public void moveSnakeRight () {
        if (snakeheadcol + 1 == 20)
            snakeheadcol = 0;
        else
            snakeheadcol++;
        if (nextSquareHasFood()) {
            extendSnake();
        }
        else {
            snakecoordinate.addLast(new Coordinate(snakeheadcol, snakeheadrow));
            gui1.square[snakecoordinate.getFirst().getX()][snakecoordinate.getFirst().getY()].setBackground(Color.black);
            gui1.square[snakecoordinate.getLast().getX()][snakecoordinate.getLast().getY()].setBackground(Color.white);
            snakecoordinate.removeFirst();
            gui1.f.setVisible(true);
        }
    }

    public void moveSnakeLeft () {
        if (snakeheadcol - 1 == -1)
            snakeheadcol = 19;
        else
            snakeheadcol--;
        if (nextSquareHasFood()) {
            extendSnake();
        }
        else {
            snakecoordinate.addLast(new Coordinate(snakeheadcol, snakeheadrow));
            gui1.square[snakecoordinate.getFirst().getX()][snakecoordinate.getFirst().getY()].setBackground(Color.black);
            gui1.square[snakecoordinate.getLast().getX()][snakecoordinate.getLast().getY()].setBackground(Color.white);
            snakecoordinate.removeFirst();
            gui1.f.setVisible(true);
        }
    }

    public void moveSnakeDown () {
        if (snakeheadrow + 1 == 20)
            snakeheadrow = 0;
        else
            snakeheadrow++;
        if (nextSquareHasFood()) {
            extendSnake();
        }
        else {
            snakecoordinate.addLast(new Coordinate(snakeheadcol, snakeheadrow));
            gui1.square[snakecoordinate.getFirst().getX()][snakecoordinate.getFirst().getY()].setBackground(Color.black);
            gui1.square[snakecoordinate.getLast().getX()][snakecoordinate.getLast().getY()].setBackground(Color.white);
            snakecoordinate.removeFirst();
            gui1.f.setVisible(true);
        }
    }

    public void moveSnakeUp () {
        if (snakeheadrow - 1 == -1)
            snakeheadrow = 19;
        else
            snakeheadrow--;
        if (nextSquareHasFood()) {
            extendSnake();
        }
        else {
            snakecoordinate.addLast(new Coordinate(snakeheadcol, snakeheadrow));
            gui1.square[snakecoordinate.getFirst().getX()][snakecoordinate.getFirst().getY()].setBackground(Color.black);
            gui1.square[snakecoordinate.getLast().getX()][snakecoordinate.getLast().getY()].setBackground(Color.white);
            snakecoordinate.removeFirst();
            gui1.f.setVisible(true);
        }
    }

    public String getMoveSnakeDirection () {
        return movesnakedirection;
    }

    public void setMoveSnakeDirection(String a) {
        movesnakedirection=a;
    }

    public void extendSnake () {
        snakecoordinate.addLast(new Coordinate(snakeheadcol, snakeheadrow));
        gui1.square[snakecoordinate.getLast().getX()][snakecoordinate.getLast().getY()].setBackground(Color.white);
        gui1.f.setVisible(true);
    }

    public void placeFood () {
        foodcoordinate.setY(ThreadLocalRandom.current().nextInt(0, 19 + 1));
        foodcoordinate.setX(ThreadLocalRandom.current().nextInt(0, 19 + 1));

        while (foodIsPlacedOnSnake()) {
            foodcoordinate.setY(ThreadLocalRandom.current().nextInt(0, 19 + 1));
            foodcoordinate.setX(ThreadLocalRandom.current().nextInt(0, 19 + 1));
        }
        gui1.square[foodcoordinate.getX()][foodcoordinate.getY()].setBackground(Color.yellow);
    }

    public void makeSnakeFasterIfItEats () {
        if (nextSquareHasFood()) {
            placeFood();
            movesnaketimer1.makeTimerFaster();
        }
    }

    public void checkForSnakeCollision () {
        for (int i = 0; i < snakecoordinate.size() - 1; i++)
            if (snakecoordinate.getLast().getY() == snakecoordinate.get(i).getY() && snakecoordinate.getLast().getX() == snakecoordinate.get(i).getX()) {
                movesnaketimer1.timer.cancel();
                gui1.square[snakecoordinate.getLast().getX()][snakecoordinate.getLast().getY()].setBackground(Color.red);
            }
    }

    public boolean foodIsPlacedOnSnake(){
        String resultat = "false";
        for (int i = 0; i < snakecoordinate.size() - 1; i++)
            if (foodcoordinate.getY() == snakecoordinate.get(i).getY() && foodcoordinate.getX()  == snakecoordinate.get(i).getX()) {
                resultat = "true";
            }
        if (resultat == "true")
            return true;
        else
            return false;
    }

    public boolean nextSquareHasFood () {
        if (snakeheadrow == foodcoordinate.getX() && snakeheadcol == foodcoordinate.getY()) {
            return true;
        } else return false;
    }
}







