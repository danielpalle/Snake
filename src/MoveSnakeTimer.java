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
        timer.schedule(task, 0, timerperiod);
    }

    public static void setSchedule() {
    }
}
