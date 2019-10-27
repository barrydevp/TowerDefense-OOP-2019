package uet.barrydevp.towerdefense.Sprite;import javafx.geometry.Point2D;import javafx.scene.image.Image;import javafx.scene.image.ImageView;import javafx.scene.input.MouseEvent;import javafx.scene.layout.Pane;import uet.barrydevp.towerdefense.Game.GameManager;import uet.barrydevp.towerdefense.Game.GameSpriteManager;import uet.barrydevp.towerdefense.Tower.*;import java.util.ArrayList;public class RootTower extends Pane {    private ImageView rootTower;    private ArrayList<ImageView> listTower;    private Point2D centerLocation;    private BaseTower curTower;    private boolean isVisible;    public RootTower(Point2D centerLocation) {        this.centerLocation = centerLocation;        this.isVisible = false;        this.listTower = new ArrayList<>();        init();        rootTower = new ImageView(GameSpriteManager.getInstance().rootTowerImage);        rootTower.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {            System.out.println(rootTower.getFitWidth());//            System.out.println(e);            if(listTower != null) {                isVisible = !isVisible;                for(int i = 0; i < listTower.size(); i++) {                    listTower.get(i).setVisible(isVisible);                }            }        });        Point2D tmp = centerLocation.subtract(GameSpriteManager.getInstance().rootTowerImage.getWidth() / 2, GameSpriteManager.getInstance().rootTowerImage.getHeight() / 2);//        relocate(tmp.getX(), tmp.getY());        setTranslateX(tmp.getX());        setTranslateY(tmp.getY());        getChildren().add(rootTower);    }    public void init() {        GameSpriteManager instance = GameSpriteManager.getInstance();        ImageView singleCanonView = createTower(instance.singleCanonImage, new Point2D(-20, -40));        singleCanonView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {            BaseTower tower = SingleCanon.creatTower(centerLocation);            GameManager.getInstance().getTowerArray().add(tower);            curTower = tower;            getChildren().removeAll(listTower);        });        listTower.add(singleCanonView);        ImageView singleMissileView = createTower(instance.singleMissileImage, new Point2D(40, -40));        singleMissileView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {            BaseTower tower = SingleMissile.creatTower(centerLocation);            GameManager.getInstance().getTowerArray().add(tower);            curTower = tower;            getChildren().removeAll(listTower);        });        listTower.add(singleMissileView);        ImageView miniGunGreenView = createTower(instance.miniGunGreenImage, new Point2D(-20, -80));        miniGunGreenView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {            BaseTower tower = MiniGunGreen.creatTower(centerLocation);            GameManager.getInstance().getTowerArray().add(tower);            curTower = tower;            getChildren().removeAll(listTower);        });        listTower.add(miniGunGreenView);        ImageView minGunWhiteView = createTower(instance.miniGunWhiteImage, new Point2D(40, -80));        minGunWhiteView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {            BaseTower tower = MiniGunWhite.creatTower(centerLocation);            GameManager.getInstance().getTowerArray().add(tower);            curTower = tower;            getChildren().removeAll(listTower);        });        listTower.add(minGunWhiteView);    }    public ImageView createTower(Image image, Point2D pos) {        ImageView towerView = new ImageView(image);        towerView.setFitHeight(42);        towerView.setFitWidth(42);        towerView.setVisible(false);        towerView.relocate(pos.getX(), pos.getY());        getChildren().add(towerView);        return towerView;    }}