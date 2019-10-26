package uet.barrydevp.towerdefense;import javafx.scene.layout.Pane;import javafx.scene.paint.Color;import javafx.scene.shape.Rectangle;import javafx.scene.shape.StrokeType;import uet.barrydevp.towerdefense.Sprite.BaseSprite;public class HealthBar extends Pane {    final double offset = 10;    Rectangle outerHealthRect;    Rectangle innerHealthRect;    private BaseSprite owner;    private double width;    private double height;    public HealthBar(){};    public HealthBar(double width, double height, BaseSprite owner) {        this.owner = owner;        this.width = width;        this.height = height;        outerHealthRect = new Rectangle( 0, 0, width, height);        outerHealthRect.setStroke(Color.BLACK);        outerHealthRect.setStrokeWidth(2);        outerHealthRect.setStrokeType( StrokeType.OUTSIDE);        outerHealthRect.setFill(Color.RED);        innerHealthRect = new Rectangle( 0, 0, width, height);        innerHealthRect.setStrokeType( StrokeType.OUTSIDE);        innerHealthRect.setFill(Color.LIMEGREEN);        getChildren().addAll( outerHealthRect, innerHealthRect);    }    public void setValue( double hpPercentage) {        innerHealthRect.setWidth( outerHealthRect.getWidth() * hpPercentage);    }    public void update(double hpPercentage) {        setValue(hpPercentage);//        System.out.println(owner.getCenterLocation());//        relocate( 100, 100);        relocate(owner.getCenterLocation().getX() - this.width / 2, owner.getCenterLocation().getY() /*- this.height / 2*/ - owner.getHeight() / 2 + offset);//        setRotate(owner.getR());    }}