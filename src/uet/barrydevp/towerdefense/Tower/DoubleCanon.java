package uet.barrydevp.towerdefense.Tower;import javafx.geometry.Point2D;import uet.barrydevp.towerdefense.Bullet.BaseBullet;import uet.barrydevp.towerdefense.Bullet.YellowBullet;import uet.barrydevp.towerdefense.Game.GameManager;import uet.barrydevp.towerdefense.Game.GameSpriteManager;import uet.barrydevp.towerdefense.Monster.BaseMonster;import uet.barrydevp.towerdefense.Sprite.TowerSprite;public class DoubleCanon extends BaseTower {    @Override    public boolean init() {        setTowerName(TowerName.SingleCanon);        return true;    }    public static DoubleCanon creatTower(Point2D location) {        DoubleCanon tower = new DoubleCanon();        if(tower.init()) {            tower.setBaseSprite(                    new TowerSprite(                            GameSpriteManager.getInstance().doubleCanonImage,                            null,                            location, 90,                            tower)            );            tower.setBuildMoney(100);            tower.setUpdateMoney(100);            tower.setForce(100);            tower.setLevel(1);            tower.setScope(200);            tower.setNextScope(250);            tower.setRate(1);            tower.addToLayer();        }        return tower;    }    @Override    public void upgradeTower() {//        removeTower();//        BaseTower tower = DoubleCanon.creatTower(baseSprite.getCenterLocation());//        GameManager.getInstance().getTowerArray().add(tower);    }    public void createBullet(BaseMonster targetMonster, Point2D center) {        YellowBullet bullet1 = YellowBullet.createBullet(targetMonster, center.add(0, 10));        YellowBullet bullet2 = YellowBullet.createBullet(targetMonster, center.add(0, -10));        GameManager.getInstance().getBulletArray().add(bullet1);        GameManager.getInstance().getBulletArray().add(bullet2);    }}