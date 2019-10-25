package uet.barrydevp.towerdefense.Tower;import javafx.geometry.Point2D;import uet.barrydevp.towerdefense.Bullet.BaseBullet;import uet.barrydevp.towerdefense.Bullet.Rocket;import uet.barrydevp.towerdefense.Game.GameManager;import uet.barrydevp.towerdefense.Game.GameSpriteManager;import uet.barrydevp.towerdefense.Monster.BaseMonster;import uet.barrydevp.towerdefense.Sprite;public class DoubleMissile extends BaseTower {    @Override    public boolean init() {        setTowerName(TowerName.DoubleMissile);        return true;    }    public static DoubleMissile creatTower(Point2D location) {        DoubleMissile tower = new DoubleMissile();        if(tower.init()) {            tower.setBaseSprite(                    new Sprite(                            GameManager.getInstance().getMonsterAndTowerLayer(),                            GameSpriteManager.getInstance().doubleMissileImage,                            location, 90)            );            tower.setBuildMoney(250);            tower.setUpdateMoney(200);            tower.setForce(500);            tower.setLevel(1);            tower.setScope(150);            tower.setNextScope(250);            tower.setRate(1.5);        }        return tower;    }    public BaseBullet createBullet(BaseMonster targetMonster, Point2D center) {        Rocket bullet = Rocket.createBullet(targetMonster, center);        return bullet;    }}