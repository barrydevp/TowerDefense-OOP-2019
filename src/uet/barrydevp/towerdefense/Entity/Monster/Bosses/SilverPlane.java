package uet.barrydevp.towerdefense.Entity.Monster.Bosses;import javafx.geometry.Point2D;import uet.barrydevp.towerdefense.Game.GameSpriteManager;import uet.barrydevp.towerdefense.Sprite.HealthBarSprite;import uet.barrydevp.towerdefense.Entity.Monster.BaseMonster;import uet.barrydevp.towerdefense.Entity.Monster.MonsterName;import uet.barrydevp.towerdefense.Sprite.BaseSprite;import uet.barrydevp.towerdefense.Sprite.EffectSprite;import uet.barrydevp.towerdefense.Sprite.MonsterSprite;import java.util.ArrayList;import java.util.HashMap;public class SilverPlane extends BaseMonster {    @Override    public boolean init() {        setMonsterName(MonsterName.SilverPlane);        return true;    }    public static SilverPlane createMonster(ArrayList<Point2D> pointsArray){        SilverPlane monster = new SilverPlane();//        System.out.println(pointsArray.get(0));        if(monster.init()) {            HashMap<String, BaseSprite> children = new HashMap<>();            children.put(EXPLOSION_EFFECT ,new EffectSprite(GameSpriteManager.getInstance().explosion1Image, new Point2D(pointsArray.get(0).getX(), pointsArray.get(0).getY()), 0));            monster.setBaseSprite(new MonsterSprite(                    GameSpriteManager.getInstance().silverPlaneImage,                    children,                    new Point2D(pointsArray.get(0).getX(), pointsArray.get(0).getY()), 0)            );            monster.setHpBar(new HealthBarSprite(20, 5, monster.getBaseSprite()));            monster.setPointsArray(pointsArray);            monster.setMaxHp(4000);//            monster.setCurHp(4000);            monster.setMoney(800);            monster.setRunSpeed(50);            monster.setArmor(30);            monster.setForce(20);            monster.addToLayer();            monster.runNextPoint(0);        }        return monster;    }}