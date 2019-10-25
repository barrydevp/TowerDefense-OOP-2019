package uet.barrydevp.towerdefense.Tower;import javafx.geometry.Point2D;import uet.barrydevp.towerdefense.Bullet.BaseBullet;import uet.barrydevp.towerdefense.Bullet.YellowBullet;import uet.barrydevp.towerdefense.Game.GameManager;import uet.barrydevp.towerdefense.Game.GameSpriteManager;import uet.barrydevp.towerdefense.Monster.BaseMonster;import uet.barrydevp.towerdefense.Sprite;public class SingleCanon extends BaseTower {    @Override    public boolean init() {        setTowerName(TowerName.SingleCanon);        return true;    }    public static SingleCanon creatTower(Point2D location) {        SingleCanon tower = new SingleCanon();        if(tower.init()) {            tower.setBaseSprite(                    new Sprite(                            GameManager.getInstance().getMonsterAndTowerLayer(),                            GameSpriteManager.getInstance().singleCanonImage,                            location, 90)            );            tower.setBuildMoney(100);            tower.setUpdateMoney(100);            tower.setForce(100);            tower.setLevel(1);            tower.setScope(200);            tower.setNextScope(250);            tower.setRate(1);        }        return tower;    }    public BaseBullet createBullet(BaseMonster targetMonster, Point2D center) {        YellowBullet bullet = YellowBullet.createBullet(targetMonster, center);        return bullet;    }}