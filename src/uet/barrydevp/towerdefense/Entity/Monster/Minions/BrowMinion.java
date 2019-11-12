package uet.barrydevp.towerdefense.Entity.Monster.Minions;import javafx.geometry.Point2D;import uet.barrydevp.towerdefense.Game.GameSpriteManager;import uet.barrydevp.towerdefense.Sprite.HealthBarSprite;import uet.barrydevp.towerdefense.Entity.Monster.BaseMonster;import uet.barrydevp.towerdefense.Entity.Monster.MonsterName;import uet.barrydevp.towerdefense.Sprite.BaseSprite;import uet.barrydevp.towerdefense.Sprite.EffectSprite;import uet.barrydevp.towerdefense.Sprite.MonsterSprite;import java.util.ArrayList;import java.util.HashMap;public class BrowMinion extends BaseMonster {    @Override    public boolean init() {        setMonsterName(MonsterName.BrowMinion);        return true;    }    public static BrowMinion createMonster(ArrayList<Point2D> pointsArray){        BrowMinion monster = new BrowMinion();//        System.out.println(pointsArray.get(0));        if(monster.init()) {            HashMap<String, BaseSprite> children = new HashMap<>();            children.put(EXPLOSION_EFFECT ,new EffectSprite(GameSpriteManager.getInstance().explosion3Image, new Point2D(pointsArray.get(0).getX(), pointsArray.get(0).getY()), 0));            monster.setBaseSprite(new MonsterSprite(                    GameSpriteManager.getInstance().browMinionImage,                    children,                    new Point2D(pointsArray.get(0).getX(), pointsArray.get(0).getY()), 0)            );            monster.setHpBar(new HealthBarSprite(20, 5, monster.getBaseSprite()));            monster.setPointsArray(pointsArray);            monster.setMaxHp(320);//            monster.setCurHp(320);            monster.setMoney(150);            monster.setRunSpeed(30);            monster.setArmor(4);            monster.setForce(2);            monster.addToLayer();            monster.runNextPoint(0);        }        return monster;    }}