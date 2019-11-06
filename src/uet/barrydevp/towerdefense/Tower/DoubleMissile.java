package uet.barrydevp.towerdefense.Tower;import javafx.geometry.Point2D;import uet.barrydevp.towerdefense.Bullet.BaseBullet;import uet.barrydevp.towerdefense.Bullet.Rocket;import uet.barrydevp.towerdefense.Game.GameManager;import uet.barrydevp.towerdefense.Game.GameSpriteManager;import uet.barrydevp.towerdefense.Monster.BaseMonster;import uet.barrydevp.towerdefense.Sprite.BaseSprite;import uet.barrydevp.towerdefense.Sprite.TowerSprite;public class DoubleMissile extends BaseTower {    @Override    public boolean init() {        setTowerName(TowerName.DoubleMissile);        return true;    }    public static DoubleMissile creatTower(Point2D location) {        DoubleMissile tower = new DoubleMissile();        if(tower.init()) {            tower.setBaseSprite(                    new TowerSprite(                            TowerName.DoubleMissile,                            null,                            location, 90,                            tower)            );            tower.setBuildMoney(250);            tower.setUpdateMoney(200);            tower.setForce(500);            tower.setLevel(1);            tower.setScope(150);            tower.setNextScope(250);            tower.setRate(1.5);            tower.addToLayer();        }        return tower;    }    @Override    public void upgradeTower() {//        BaseTower tower = DoubleCanon.creatTower(baseSprite.getCenterLocation());//        buildTower(tower);    }    public void createBullet(BaseMonster targetMonster, Point2D center) {        Rocket bullet1 = Rocket.createBullet(targetMonster, center.add(0, 10));        Rocket bullet2 = Rocket.createBullet(targetMonster, center.add(0, -10));        GameManager.getInstance().getBulletArray().add(bullet1);        GameManager.getInstance().getBulletArray().add(bullet2);    }}