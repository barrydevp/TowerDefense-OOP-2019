package uet.barrydevp.towerdefense.Map;import javafx.geometry.Point2D;import javafx.scene.image.ImageView;import uet.barrydevp.towerdefense.Game.GameManager;import uet.barrydevp.towerdefense.Game.GameSpriteManager;import uet.barrydevp.towerdefense.Monster.MonsterName;import java.util.ArrayList;public class Maplvl11 extends BaseMap {    public static Maplvl11 createMap() {        Maplvl11 map = new Maplvl11();        map.setMapSprite(new ImageView(GameSpriteManager.getInstance().Maplvl1Image));        map.addToLayer();        map.setLevel(1);        map.setMaxWave(10);        map.setDifficulty(1);        map.addPointsArray();        map.addWave();        map.addlocationRoot();        map.addTile();        GameManager instance = GameManager.getInstance();        instance.setLife(10);        instance.setLevel(1);        instance.setMoney(500);        return map;    }    @Override    public void addPointsArray() {        ArrayList<Point2D> pointsArray = new ArrayList<>();        pointsArray.add(new Point2D(1028, 60));        pointsArray.add(new Point2D(510, 60));        pointsArray.add(new Point2D(510, 440));        pointsArray.add(new Point2D(0, 440));        this.pointsArray = pointsArray;    }    @Override    public void addWave() {        int[] turn = new int[getMaxWave()];        turn[0] = 3;        turn[1] = 5;        turn[2] = 6;        turn[3] = 7;        turn[4] = 1;        turn[5] = 4;        turn[6] = 5;        turn[7] = 8;        turn[8] = 5;        turn[9] = 1;        MonsterName[] monsterNames = new MonsterName[getMaxWave()];        monsterNames[0] = MonsterName.GreenMinion;        monsterNames[1] = MonsterName.BrowMinion;        monsterNames[2] = MonsterName.SilverMinion;        monsterNames[3] = MonsterName.GreenMinion;        monsterNames[4] = MonsterName.GreenPlane;        monsterNames[5] = MonsterName.RedMinion;        monsterNames[6] = MonsterName.BrowMinion;        monsterNames[7] = MonsterName.SilverMinion;        monsterNames[8] = MonsterName.GreenMinion;        monsterNames[9] = MonsterName.GreenTank;        for(int i = 0; i < getMaxWave(); ++i) {            this.waveArray.add(new ArrayList<>());            for(int j = 0; j < turn[i]; ++j) {                this.waveArray.get(i).add(monsterNames[i]);            }        }    }    @Override    public void addlocationRoot() {        locationRootArray.add(new Point2D(980, 130));        locationRootArray.add(new Point2D(820, 130));        locationRootArray.add(new Point2D(700, 130));        locationRootArray.add(new Point2D(590, 130));        locationRootArray.add(new Point2D(440, 30));        locationRootArray.add(new Point2D(445, 130));        locationRootArray.add(new Point2D(445, 220));        locationRootArray.add(new Point2D(580, 320));        locationRootArray.add(new Point2D(445, 380));        locationRootArray.add(new Point2D(580, 480));        locationRootArray.add(new Point2D(250, 380));        locationRootArray.add(new Point2D(380, 520));        locationRootArray.add(new Point2D(145, 520));        locationRootArray.add(new Point2D(20, 380));    }}