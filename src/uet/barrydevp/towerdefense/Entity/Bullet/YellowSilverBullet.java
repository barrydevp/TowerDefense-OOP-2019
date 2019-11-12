package uet.barrydevp.towerdefense.Entity.Bullet;import javafx.geometry.Point2D;import uet.barrydevp.towerdefense.Game.GameSpriteManager;import uet.barrydevp.towerdefense.Entity.Monster.BaseMonster;import uet.barrydevp.towerdefense.Sprite.BulletSprite;public class YellowSilverBullet extends BaseBullet {    @Override    public boolean init() {        setBulletName(BulletName.YellowSilverBullet);        return true;    }    public static YellowSilverBullet createBullet(BaseMonster targetMonster, Point2D startPoint) {        YellowSilverBullet bullet = new YellowSilverBullet();        if(bullet.init()) {            bullet.setBaseSprite(new BulletSprite(                    GameSpriteManager.getInstance().yellowSilverBulletImage,                    null,                    startPoint, 0)            );            bullet.setTargetMonster(targetMonster);            bullet.setMoveSpeed(250);            bullet.setAcceleration(50);            bullet.setMaxForce(14);            bullet.setScope(4);            bullet.addToLayer();        }        return bullet;    }    @Override    public void fire() {        double monsterHp = targetMonster.getCurHp() + targetMonster.getArmor() - getMaxForce();        if(Double.compare(monsterHp, 0) <= 0){            targetMonster.setCurHp(0);            targetMonster.death();        } else {            targetMonster.setCurHp(monsterHp);            targetMonster.getHurt();        }//        targetMonster.setHpPercentage(monsterHp * 1.0 / targetMonster.getMaxHp());        removeBullet();    }}