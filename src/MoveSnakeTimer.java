public class MoveSnakeTimer {
    static java.util.Timer timer = new java.util.Timer();
    public static int timerperiod = 300;

    public static void startGame() {
        java.util.TimerTask task = new java.util.TimerTask() {
            @Override
            public void run() {
                GameControl.moveSnake();
            }
        };
        timer.schedule(task, timerperiod, timerperiod);
    }

    public static void makeTimerFaster() {
        timer.cancel();
        if (timerperiod > 85)
            timerperiod *= 0.9;
        timer = new java.util.Timer();
        startGame();
    }
}
