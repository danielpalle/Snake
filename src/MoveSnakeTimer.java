public class MoveSnakeTimer {
    static java.util.Timer timer = new java.util.Timer();
    static int timerperiod = 300;

    public static void startGame() {
        java.util.TimerTask task = new java.util.TimerTask() {
            @Override
            public void run() {
                GameControl.moveSnake();
                GameControl.checkForSnakeCollision();
                GameControl.makeSnakeFasterIfItEats();
            }
        };
        timer.schedule(task, timerperiod, timerperiod);
    }

    public static void makeTimerFaster() {
        timer.cancel();
        if (timerperiod > 100)
            timerperiod *= 0.9;
        timer = new java.util.Timer();
        startGame();
    }
}
