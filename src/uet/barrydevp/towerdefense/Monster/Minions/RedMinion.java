package uet.barrydevp.towerdefense.Monster.Minions;import javafx.geometry.Point2D;import uet.barrydevp.towerdefense.Game.GameManager;import uet.barrydevp.towerdefense.Game.GameSpriteManager;import uet.barrydevp.towerdefense.Monster.BaseMonster;import uet.barrydevp.towerdefense.Monster.MonsterName;import uet.barrydevp.towerdefense.Sprite;import java.util.ArrayList;public class RedMinion extends BaseMonster {    @Override    public boolean init() {        setMonsterName(MonsterName.RedMinion);        return true;    }    public static RedMinion createMonster(ArrayList<Point2D> pointsArray){        RedMinion monster = new RedMinion();//        System.out.println(pointsArray.get(0));        if(monster.init()) {            monster.setBaseSprite(new Sprite(                    GameManager.getInstance().getGameFieldPane(),                    GameSpriteManager.getInstance().redMinionImage,                    new Point2D(pointsArray.get(0).getX(), pointsArray.get(0).getY()), 0)            );            monster.setPointsArray(pointsArray);            monster.setMaxHp(75);            monster.setCurHp(75);            monster.setMoney(20);            monster.setRunSpeed(250);            monster.setArmor(10);            monster.setForce(2);            monster.runNextPoint(0);        }        return monster;    }}