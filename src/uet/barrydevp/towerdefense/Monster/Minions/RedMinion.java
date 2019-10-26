package uet.barrydevp.towerdefense.Monster.Minions;import javafx.geometry.Point2D;import uet.barrydevp.towerdefense.Game.GameManager;import uet.barrydevp.towerdefense.Game.GameSpriteManager;import uet.barrydevp.towerdefense.HealthBar;import uet.barrydevp.towerdefense.Monster.BaseMonster;import uet.barrydevp.towerdefense.Monster.MonsterName;import uet.barrydevp.towerdefense.Sprite.BaseSprite;import uet.barrydevp.towerdefense.Sprite.MonsterSprite;import java.util.ArrayList;public class RedMinion extends BaseMonster {    @Override    public boolean init() {        setMonsterName(MonsterName.RedMinion);        return true;    }    public static RedMinion createMonster(ArrayList<Point2D> pointsArray){        RedMinion monster = new RedMinion();//        System.out.println(pointsArray.get(0));        if(monster.init()) {            monster.setBaseSprite(new MonsterSprite(                    GameSpriteManager.getInstance().redMinionImage,                    null,                    new Point2D(pointsArray.get(0).getX(), pointsArray.get(0).getY()), 0)            );            monster.setHpBar(new HealthBar(20, 5, monster.getBaseSprite()));            monster.setPointsArray(pointsArray);            monster.setMaxHp(75);            monster.setCurHp(75);            monster.setHpPercentage(1);            monster.setMoney(20);            monster.setRunSpeed(200);            monster.setArmor(10);            monster.setForce(2);            monster.addToLayer();            monster.runNextPoint(0);        }        return monster;    }}