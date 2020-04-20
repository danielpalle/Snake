public class MoveSnakeTimer {
    static java.util.Timer timer = new java.util.Timer();

    public static void MyTimer() {
        java.util.TimerTask task = new java.util.TimerTask() {
            @Override
            public void run() {
                GameControl.moveSnake();
            }
        };
        timer.schedule(task, 0, 250);
    }
}
