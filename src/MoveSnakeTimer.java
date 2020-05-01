public class MoveSnakeTimer {
    java.util.Timer timer = new java.util.Timer();
    int timerperiod = 300;
    GameControl gamecontrol1;

    public MoveSnakeTimer(GameControl k) {
        gamecontrol1 = k;
    }

    public void taskMoveSnake() {
        java.util.TimerTask task = new java.util.TimerTask() {
            @Override
            public void run() {
                gamecontrol1.moveSnake();
                gamecontrol1.checkForSnakeCollision();
                gamecontrol1.makeSnakeFasterIfItEats();
            }
        };
        timer.schedule(task, timerperiod, timerperiod);
    }

    public void makeTimerFaster() {
        timer.cancel();
        if (timerperiod > 100)
            timerperiod *= 0.9;
        timer = new java.util.Timer();
        taskMoveSnake();
    }
}
