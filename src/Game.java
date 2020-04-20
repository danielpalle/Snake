import java.util.Timer;
import java.util.TimerTask;

public class Game {
    static Timer timer = new Timer();

    public static void main(String[] args) {
        GameControl.startGame();
        MyTimer();
    }

    public static void MyTimer() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                GameControl.moveSnake();
            }
        };
        timer.schedule(task, 0, 250);
    }
}
