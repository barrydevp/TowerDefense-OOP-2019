package uet.barrydevp.towerdefense.Entity.Tower;import javafx.geometry.Point2D;import uet.barrydevp.towerdefense.Entity.Bullet.YellowBrowBullet;import uet.barrydevp.towerdefense.Entity.Bullet.YellowSilverBullet;import uet.barrydevp.towerdefense.Entity.Monster.BaseMonster;import uet.barrydevp.towerdefense.Game.GameManager;import uet.barrydevp.towerdefense.Game.GameSpriteManager;import uet.barrydevp.towerdefense.Sprite.BaseSprite;import uet.barrydevp.towerdefense.Sprite.EffectSprite;import uet.barrydevp.towerdefense.Sprite.TowerSprite;import java.util.HashMap;public class TripleCanon extends BaseTower {    @Override    public boolean init() {        setTowerName(TowerName.DoubleCanon);        return true;    }    public static TripleCanon creatTower(Point2D location) {        TripleCanon tower = new TripleCanon();        if(tower.init()) {            HashMap<String, BaseSprite> children = new HashMap<>();            children.put(FIRE_EFFECT ,new EffectSprite(GameSpriteManager.getInstance().fireEffect4Image, location, 90));//            ((EffectSprite)children.get(FIRE_EFFECT)).addChildEffect(GameSpriteManager.getInstance().fireEffect1Image, new Point2D(6, 0), 0);            tower.setBuildMoney(250);            tower.setUpdateMoney(0);            tower.setBaseSprite(                    new TowerSprite(                            TowerName.TripleCanon,                            children,                            location, 90,                            tower)            );            tower.setForce(20);            tower.setLevel(3);            tower.setScope(170);            tower.setNextScope(170);            tower.setRate(0.6);            tower.addToLayer();        }        return tower;    }    @Override    public void upgradeTower() {//        BaseTower tower = DoubleCanon.creatTower(baseSprite.getCenterLocation());//        buildTower(tower);    }    public void createBullet(BaseMonster targetMonster, Point2D center) {        YellowBrowBullet bullet1 = YellowBrowBullet.createBullet(targetMonster, center.add(10, 0));        YellowBrowBullet bullet2 = YellowBrowBullet.createBullet(targetMonster, center.add(-10, 0));        GameManager.getInstance().getBulletArray().add(bullet1);        GameManager.getInstance().getBulletArray().add(bullet2);    }}