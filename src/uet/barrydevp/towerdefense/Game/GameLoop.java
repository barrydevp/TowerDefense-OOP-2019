package uet.barrydevp.towerdefense.Game;import javafx.animation.AnimationTimer;public class GameLoop extends AnimationTimer {    private long lastTime = 0;    private long curTime = 0;    @Override    public void handle(long now) {        lastTime = curTime;        curTime = now;        long elapsedTime = curTime - lastTime;    }}