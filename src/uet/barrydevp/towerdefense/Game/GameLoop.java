package uet.barrydevp.towerdefense.Game;import javafx.animation.AnimationTimer;import javafx.stage.Stage;public class GameLoop extends AnimationTimer {    public Stage primaryStage;    private long lastTime = 0;    private long curTime = 0;    public GameLoop(Stage primaryStage) {        this.primaryStage = primaryStage;    }    @Override    public void handle(long now) {        lastTime = curTime;        curTime = now;        long elapsedTime = curTime - lastTime;        double tmp = elapsedTime / 1000000000.0;        GameManager.getInstance().updateGame(tmp);        System.out.println("life: "+ GameManager.getInstance().getLife());    }}