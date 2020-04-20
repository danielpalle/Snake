import java.util.TimerTask;

public class Timertask {
    static java.util.Timer timer = new java.util.Timer();

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
