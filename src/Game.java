
public class Game {
    public static void main(String[] args) throws InterruptedException {
        GameControl.createGameWindow();
        GameControl.createGameGrid();
        GameControl.createSnake();
        //GameControl.moveSnakeRight();
        GameControl.moveSnakeDown();
    }
}
