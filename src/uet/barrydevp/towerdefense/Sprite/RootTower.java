package uet.barrydevp.towerdefense.Sprite;import javafx.geometry.Point2D;import javafx.scene.effect.DropShadow;import javafx.scene.image.Image;import javafx.scene.image.ImageView;import javafx.scene.input.MouseEvent;import javafx.scene.layout.Pane;import uet.barrydevp.towerdefense.Game.GameManager;import uet.barrydevp.towerdefense.Game.GameMenu;import uet.barrydevp.towerdefense.Game.GameSpriteManager;import uet.barrydevp.towerdefense.Entity.Tower.*;import java.util.ArrayList;import static javafx.scene.paint.Color.rgb;public class RootTower extends Pane {    private DropShadow dropShadowNonHover;    private DropShadow dropShadowHover;    private ImageView rootTower;    private ArrayList<ImageView> listTower;    private Point2D centerLocation;    private BaseTower curTower;    private boolean isVisible;    public RootTower(Point2D centerLocation) {        dropShadowNonHover = new DropShadow();        dropShadowNonHover.setRadius(5.0);        dropShadowNonHover.setColor(rgb(81, 109, 81));        dropShadowHover = new DropShadow();        dropShadowHover.setRadius(8.0);        dropShadowHover.setColor(rgb(30, 63, 45));        this.centerLocation = centerLocation;        this.isVisible = false;        this.listTower = new ArrayList<>();        init();        rootTower = new ImageView(GameSpriteManager.getInstance().rootTowerImage);        rootTower.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {            changeVisibleListTower();        });        Point2D tmp = centerLocation.subtract(GameSpriteManager.getInstance().rootTowerImage.getWidth() / 2, GameSpriteManager.getInstance().rootTowerImage.getHeight() / 2);//        relocate(tmp.getX(), tmp.getY());        setTranslateX(tmp.getX());        setTranslateY(tmp.getY());        getChildren().add(rootTower);    }    public void init() {        GameSpriteManager instanceSprite = GameSpriteManager.getInstance();        ImageView singleCanonView = createChooseTower(TowerName.SingleCanon, new Point2D(-30, -60));        singleCanonView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {            BaseTower tower = SingleCanon.creatTower(centerLocation);            buildTower(tower);        });        listTower.add(singleCanonView);        ImageView singleMissileView = createChooseTower(TowerName.SingleMissile, new Point2D(50, -30));        singleMissileView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {            BaseTower tower = SingleMissile.creatTower(centerLocation);            buildTower(tower);        });        listTower.add(singleMissileView);        ImageView miniGunGreenView = createChooseTower(TowerName.MiniGunGreen, new Point2D(10, -30) );        miniGunGreenView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {            BaseTower tower = MiniGunGreen.creatTower(centerLocation);            buildTower(tower);        });        listTower.add(miniGunGreenView);        ImageView minGunBlueView = createChooseTower(TowerName.MiniGunBlue, new Point2D(-30, -30));        minGunBlueView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {            BaseTower tower = MiniGunBlue.creatTower(centerLocation);            buildTower(tower);        });        listTower.add(minGunBlueView);        ImageView singleFlyGunView = createChooseTower(TowerName.SingleFlyGun, new Point2D(10, -60));        singleFlyGunView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {            BaseTower tower = SingleFlyGun.creatTower(centerLocation);            buildTower(tower);        });        listTower.add(singleFlyGunView);    }    public ImageView createChooseTower(TowerName towerName, Point2D pos) {        ArrayList<Image> images = GameSpriteManager.getInstance().getListTowerImage(towerName);        ImageView towerView = new ImageView(images.get(0));        towerView.setFitHeight(42);        towerView.setFitWidth(42);        towerView.setVisible(false);        towerView.relocate(pos.getX(), pos.getY());        towerView.setEffect(dropShadowNonHover);        getChildren().add(towerView);        ImageView tableInfoTower = GameMenu.getInstance().getTableInfoTower();        towerView.addEventFilter(MouseEvent.MOUSE_ENTERED_TARGET, e -> {            towerView.setEffect(dropShadowHover);            tableInfoTower.setImage(images.get(1));            tableInfoTower.setVisible(true);        });        towerView.addEventFilter(MouseEvent.MOUSE_EXITED_TARGET, e -> {            towerView.setEffect(dropShadowNonHover);            tableInfoTower.setVisible(false);        });        return towerView;    }    public void buildTower(BaseTower tower) {        GameManager instance = GameManager.getInstance();        System.out.println(instance.getMoney());        System.out.println(tower.getBuildMoney());        int tmpMoney = instance.getMoney() - tower.getBuildMoney();        if(tmpMoney >= 0) {            instance.setMoney(tmpMoney);//            GameManager.getInstance().getTowerArray().add(tower);            instance.getTowerArray().add(tower);            curTower = tower;//            getChildren().removeAll(listTower);            changeVisibleListTower();            GameMenu.getInstance().updateMessage("-" + tower.getBuildMoney() + "$");        } else {            tower.removeTower();            System.out.println("Haven't enought gold to build this Tower!");            GameMenu.getInstance().updateMessage("Haven't enought gold to build this Tower!");        }    }    public void changeVisibleListTower() {        if(listTower != null) {            isVisible = !isVisible;            for(int i = 0; i < listTower.size(); i++) {                listTower.get(i).setVisible(isVisible);            }        }    }    public void reload() {        Point2D tmp = centerLocation.subtract(GameSpriteManager.getInstance().rootTowerImage.getWidth() / 2, GameSpriteManager.getInstance().rootTowerImage.getHeight() / 2);//        relocate(tmp.getX(), tmp.getY());        setTranslateX(tmp.getX());        setTranslateY(tmp.getY());    }}