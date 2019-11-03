package uet.barrydevp.towerdefense.Monster.Bosses;import javafx.geometry.Point2D;import uet.barrydevp.towerdefense.Game.GameSpriteManager;import uet.barrydevp.towerdefense.HealthBar;import uet.barrydevp.towerdefense.Monster.BaseMonster;import uet.barrydevp.towerdefense.Monster.MonsterName;import uet.barrydevp.towerdefense.Sprite.BaseSprite;import uet.barrydevp.towerdefense.Sprite.EffectSprite;import uet.barrydevp.towerdefense.Sprite.MonsterSprite;import java.util.ArrayList;import java.util.HashMap;public class GreenTank extends BaseMonster {    @Override    public boolean init() {        setMonsterName(MonsterName.GreenTank);        return true;    }    public static GreenTank createMonster(ArrayList<Point2D> pointsArray){        GreenTank monster = new GreenTank();//        System.out.println(pointsArray.get(0));        if(monster.init()) {            HashMap<String, BaseSprite> children = new HashMap<>();            children.put(EXPLOSION_EFFECT ,new EffectSprite(GameSpriteManager.getInstance().explosion1Image, new Point2D(pointsArray.get(0).getX(), pointsArray.get(0).getY()), 0));            monster.setBaseSprite(new MonsterSprite(                    GameSpriteManager.getInstance().greenTankImage,                    children,                    new Point2D(pointsArray.get(0).getX(), pointsArray.get(0).getY()), 0)            );            monster.setHpBar(new HealthBar(20, 5, monster.getBaseSprite()));            monster.setPointsArray(pointsArray);            monster.setMaxHp(5000);//            monster.setCurHp(5000);            monster.setMoney(500);            monster.setRunSpeed(50);            monster.setArmor(50);            monster.setForce(20);            monster.addToLayer();            monster.runNextPoint(0);        }        return monster;    }}