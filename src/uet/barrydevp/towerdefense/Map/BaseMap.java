package uet.barrydevp.towerdefense.Map;import javafx.geometry.Point2D;import javafx.scene.image.ImageView;import javafx.scene.layout.Pane;import uet.barrydevp.towerdefense.Game.GameManager;import uet.barrydevp.towerdefense.Entity.Monster.BaseMonster;import uet.barrydevp.towerdefense.Entity.Monster.Bosses.GreenPlane;import uet.barrydevp.towerdefense.Entity.Monster.Bosses.GreenTank;import uet.barrydevp.towerdefense.Entity.Monster.Bosses.SilverPlane;import uet.barrydevp.towerdefense.Entity.Monster.Bosses.WhiteTank;import uet.barrydevp.towerdefense.Entity.Monster.Minions.BrowMinion;import uet.barrydevp.towerdefense.Entity.Monster.Minions.GreenMinion;import uet.barrydevp.towerdefense.Entity.Monster.Minions.RedMinion;import uet.barrydevp.towerdefense.Entity.Monster.Minions.SilverMinion;import uet.barrydevp.towerdefense.Entity.Monster.MonsterName;import uet.barrydevp.towerdefense.Sprite.RootTower;import java.util.ArrayList;public abstract class BaseMap {    public static final double DURATION_WAVE = 5;    public static final double DURATION_TURN = 0.75;    private int level;    private ImageView mapSprite;    protected Pane layer;    private int difficulty;    private boolean isEnd;    private boolean isStart;    private int wave;    private int maxWave;    private int turn;    private double elapsedTimeWave;    private double elapsedTimeTurn;    public ArrayList<Point2D> pointsArray;    public ArrayList<Point2D> locationRootArray;    public ArrayList<ArrayList<MonsterName>> waveArray;    public BaseMap() {        GameManager.getInstance().eraseAll();        isEnd = false;        isStart = false;        wave = 0;        maxWave = 0;        turn = 0;        elapsedTimeWave = 0;        elapsedTimeTurn = 0;        pointsArray = new ArrayList<>();        waveArray = new ArrayList<>();        locationRootArray = new ArrayList<>();        layer = GameManager.getInstance().getBackgroundLayer();    }    public int getLevel() {        return level;    }    public void setLevel(int level) {        this.level = level;    }    public int getWave() {        return wave;    }    public void setWave(int wave) {        this.wave = wave;    }    public int getDifficulty() {        return difficulty;    }    public void setDifficulty(int difficulty) {        this.difficulty = difficulty;    }    public double getElapsedTimeTurn() {        return elapsedTimeTurn;    }    public void setElapsedTimeTurn(double elapsedTimeTurn) {        this.elapsedTimeTurn = elapsedTimeTurn;    }    public double getElapsedTimeWave() {        return elapsedTimeWave;    }    public void setElapsedTimeWave(double elapsedTimeWave) {        this.elapsedTimeWave = elapsedTimeWave;    }    public int getMaxWave() {        return maxWave;    }    public void setMaxWave(int maxWave) {        this.maxWave = maxWave;    }    public int getTurn() {        return turn;    }    public void setTurn(int turn) {        this.turn = turn;    }    public ImageView getMapSprite() {        return mapSprite;    }    public void setMapSprite(ImageView mapSprite) {        this.mapSprite = mapSprite;    }    public boolean isEnd() {        return isEnd;    }    public void setEnd(boolean end) {        isEnd = end;    }    public boolean isStart() {        return isStart;    }    public void setStart(boolean start) {        isStart = start;    }    public abstract void addPointsArray();    public abstract void addWave();    public abstract void addlocationRoot();    public void spawnMonster(double elapsedTime) {//        System.out.println(waveArray);        if(isStart && !isEnd) {            if(waveArray != null && waveArray.size() > 0 && wave < maxWave) {                if(turn == -1) {                    if(elapsedTimeWave > DURATION_WAVE) {                        turn = 0;                        elapsedTimeWave = 0;                    } else {                        elapsedTimeWave += elapsedTime;                    }                }                if(turn > -1) {                    if(elapsedTimeTurn > DURATION_TURN) {                        BaseMonster monster = null;                        System.out.println("wave:" + wave);                        System.out.println("turn: " + turn);                        switch (waveArray.get(wave).get(turn)) {                            case GreenMinion:                                monster = GreenMinion.createMonster(pointsArray);                                break;                            case SilverMinion:                                monster = SilverMinion.createMonster(pointsArray);                                break;                            case RedMinion:                                monster = RedMinion.createMonster(pointsArray);                                break;                            case BrowMinion:                                monster = BrowMinion.createMonster(pointsArray);                                break;                            case GreenPlane:                                monster = GreenPlane.createMonster(pointsArray);                                break;                            case SilverPlane:                                monster = SilverPlane.createMonster(pointsArray);                                break;                            case GreenTank:                                monster = GreenTank.createMonster(pointsArray);                                break;                            case WhiteTank:                                monster = WhiteTank.createMonster(pointsArray);                                break;                        }                        if(monster != null){                            GameManager.getInstance().getMonsterArray().add(monster);                        }                        if(++turn >= waveArray.get(wave).size()) {                            turn = -1;                            ++wave;//                            if(++wave >= maxWave) {//                                --wave;//                                isStart = false;//                            }                        }                        elapsedTimeTurn = 0;                    } else {                        elapsedTimeTurn += elapsedTime;                    }                }            } else {                if(wave >= maxWave) {//                    System.out.println("GO THIS 2");                    if(GameManager.getInstance().getMonsterArray().size() == 0){                        isEnd = true;                        isStart = false;                    }                }            }        }    }    public void addTile() {        GameManager instance = GameManager.getInstance();        Pane towerLayer = instance.getTowerLayer();        for(int i = 0; i < locationRootArray.size(); ++i) {            RootTower rootTower = new RootTower(locationRootArray.get(i));            towerLayer.getChildren().add(rootTower);            instance.getRootTowerArray().add(rootTower);        }    }    public void addToLayer() {        if(layer != null && mapSprite != null)            layer.getChildren().add(mapSprite);    }    public void removeFromLayer() {        if(layer != null && mapSprite != null){            layer.getChildren().remove(mapSprite);        }    }}