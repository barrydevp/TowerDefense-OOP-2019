package uet.barrydevp.towerdefense.Bullet;import javafx.geometry.Point2D;import uet.barrydevp.towerdefense.Game.GameManager;import uet.barrydevp.towerdefense.Game.GameSpriteManager;import uet.barrydevp.towerdefense.Monster.BaseMonster;import uet.barrydevp.towerdefense.Sprite.BaseSprite;import uet.barrydevp.towerdefense.Sprite.BulletSprite;public class Rocket extends BaseBullet {    @Override    public boolean init() {        setBulletName(BulletName.Rocket);        return true;    }    public static Rocket createBullet(BaseMonster targetMonster, Point2D startPoint) {        Rocket bullet = new Rocket();        if(bullet.init()) {            bullet.setBaseSprite(new BulletSprite(                    GameSpriteManager.getInstance().rocketImage,                    null,                    startPoint, 90)            );            bullet.setTargetMonster(targetMonster);            bullet.setMoveSpeed(200);            bullet.setAcceleration(50);            bullet.setMaxForce(300);            bullet.setScope(4);            bullet.addToLayer();        }        return bullet;    }    @Override    public void fire() {        BaseMonster targetMonster = getTargetMonster();        double distance = getBaseSprite().getCenterLocation().distance(targetMonster.getBaseSprite().getCenterLocation());        if(distance < getScope()) {            int monsterHp = targetMonster.getCurHp() - getMaxForce();            if(monsterHp <= 0){                targetMonster.setCurHp(0);                targetMonster.death();            } else {                targetMonster.setCurHp(monsterHp);                targetMonster.getHurt();            }            targetMonster.setHpPercentage(monsterHp * 1.0 / targetMonster.getMaxHp());            removeBullet();        }    }}