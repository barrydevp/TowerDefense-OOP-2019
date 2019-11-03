package uet.barrydevp.towerdefense.Sprite;import javafx.geometry.Point2D;import javafx.scene.image.Image;import javafx.scene.image.ImageView;import javafx.scene.input.MouseEvent;import javafx.scene.layout.Pane;import uet.barrydevp.towerdefense.Game.GameManager;import uet.barrydevp.towerdefense.Game.GameSpriteManager;import uet.barrydevp.towerdefense.Tower.*;import java.util.ArrayList;public class RootTower extends Pane {    private ImageView rootTower;    private ArrayList<ImageView> listTower;    private Point2D centerLocation;    private BaseTower curTower;    private boolean isVisible;    public RootTower(Point2D centerLocation) {        this.centerLocation = centerLocation;        this.isVisible = false;        this.listTower = new ArrayList<>();        init();        rootTower = new ImageView(GameSpriteManager.getInstance().rootTowerImage);        rootTower.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {            System.out.println(rootTower.getFitWidth());//            System.out.println(e);//            if(listTower != null) {//                isVisible = !isVisible;//                for(int i = 0; i < listTower.size(); i++) {//                    listTower.get(i).setVisible(isVisible);//                }//            }            changeVisibleListTower();        });        Point2D tmp = centerLocation.subtract(GameSpriteManager.getInstance().rootTowerImage.getWidth() / 2, GameSpriteManager.getInstance().rootTowerImage.getHeight() / 2);//        relocate(tmp.getX(), tmp.getY());        setTranslateX(tmp.getX());        setTranslateY(tmp.getY());        getChildren().add(rootTower);    }    public void init() {        GameSpriteManager instanceSprite = GameSpriteManager.getInstance();        ImageView singleCanonView = createChooseTower(instanceSprite.singleCanonImage, new Point2D(-20, -40));        singleCanonView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {            BaseTower tower = SingleCanon.creatTower(centerLocation);            buildTower(tower);        });        listTower.add(singleCanonView);        ImageView singleMissileView = createChooseTower(instanceSprite.singleMissileImage, new Point2D(40, -40));        singleMissileView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {            BaseTower tower = SingleMissile.creatTower(centerLocation);            buildTower(tower);        });        listTower.add(singleMissileView);        ImageView miniGunGreenView = createChooseTower(instanceSprite.miniGunGreenImage, new Point2D(-20, -80));        miniGunGreenView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {            BaseTower tower = MiniGunGreen.creatTower(centerLocation);            buildTower(tower);        });        listTower.add(miniGunGreenView);        ImageView minGunBlueView = createChooseTower(instanceSprite.miniGunBlueImage, new Point2D(40, -80));        minGunBlueView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {            BaseTower tower = MiniGunBlue.creatTower(centerLocation);            buildTower(tower);        });        listTower.add(minGunBlueView);        ImageView singleFlyGunView = createChooseTower(instanceSprite.singleFlyGunImage, new Point2D(-20, -120));        singleFlyGunView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {            BaseTower tower = SingleFlyGun.creatTower(centerLocation);            buildTower(tower);        });        listTower.add(singleFlyGunView);    }    public ImageView createChooseTower(Image image, Point2D pos) {        ImageView towerView = new ImageView(image);        towerView.setFitHeight(42);        towerView.setFitWidth(42);        towerView.setVisible(false);        towerView.relocate(pos.getX(), pos.getY());        getChildren().add(towerView);        return towerView;    }    public void buildTower(BaseTower tower) {        GameManager instance = GameManager.getInstance();        System.out.println(instance.getMoney());        System.out.println(tower.getBuildMoney());        int tmpMoney = instance.getMoney() - tower.getBuildMoney();        if(tmpMoney >= 0) {            instance.setMoney(tmpMoney);//            GameManager.getInstance().getTowerArray().add(tower);            instance.getTowerArray().add(tower);            curTower = tower;//            getChildren().removeAll(listTower);            changeVisibleListTower();        } else {            tower.removeTower();            System.out.println("Haven't enought gold to build this Tower!");        }    }    public void changeVisibleListTower() {        if(listTower != null) {            isVisible = !isVisible;            for(int i = 0; i < listTower.size(); i++) {                listTower.get(i).setVisible(isVisible);            }        }    }    public void reload() {        Point2D tmp = centerLocation.subtract(GameSpriteManager.getInstance().rootTowerImage.getWidth() / 2, GameSpriteManager.getInstance().rootTowerImage.getHeight() / 2);//        relocate(tmp.getX(), tmp.getY());        setTranslateX(tmp.getX());        setTranslateY(tmp.getY());    }}