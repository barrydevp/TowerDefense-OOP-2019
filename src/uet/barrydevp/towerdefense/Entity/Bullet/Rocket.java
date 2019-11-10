package uet.barrydevp.towerdefense.Entity.Bullet;import javafx.geometry.Point2D;import uet.barrydevp.towerdefense.Game.GameManager;import uet.barrydevp.towerdefense.Game.GameSpriteManager;import uet.barrydevp.towerdefense.Entity.Monster.BaseMonster;import uet.barrydevp.towerdefense.Sprite.BulletSprite;import java.util.ArrayList;public class Rocket extends BaseBullet {    @Override    public boolean init() {        setBulletName(BulletName.Rocket);        return true;    }    public static Rocket createBullet(BaseMonster targetMonster, Point2D startPoint) {        Rocket bullet = new Rocket();        if(bullet.init()) {            bullet.setBaseSprite(new BulletSprite(                    GameSpriteManager.getInstance().rocketImage,                    null,                    startPoint, 90)            );            bullet.setTargetMonster(targetMonster);            bullet.setMoveSpeed(200);            bullet.setAcceleration(50);            bullet.setMaxForce(300);            bullet.setScope(80);            bullet.addToLayer();        }        return bullet;    }    @Override    public void fire() {        ArrayList<BaseMonster> monsterArray = GameManager.getInstance().getMonsterArray();        for(int i = 0; i < monsterArray.size(); ++i) {            BaseMonster monster = monsterArray.get(i);            double tmpDistance = getBaseSprite().getCenterLocation().distance(monsterArray.get(i).getBaseSprite().getCenterLocation());            if(tmpDistance < getScope()) {                double monsterHp = monster.getCurHp() + monster.getArmor() - getMaxForce();                if(Double.compare(monsterHp, 0) <= 0){                    monster.setCurHp(0);                    monster.death();                } else {                    monster.setCurHp(monsterHp);                    monster.getHurt();                }//                monster.setHpPercentage(monsterHp * 1.0 / monster.getMaxHp());            }        }        removeBullet();    }}