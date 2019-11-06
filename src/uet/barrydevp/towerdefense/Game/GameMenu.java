package uet.barrydevp.towerdefense.Game;import javafx.event.EventHandler;import javafx.scene.Node;import javafx.scene.Scene;import javafx.scene.effect.DropShadow;import javafx.scene.image.ImageView;import javafx.scene.input.MouseEvent;import javafx.scene.layout.Pane;import javafx.scene.paint.Color;import javafx.scene.text.Font;import javafx.scene.text.FontWeight;import javafx.scene.text.Text;import javafx.scene.text.TextBoundsType;import javafx.stage.Stage;import uet.barrydevp.towerdefense.Map.MapName;import uet.barrydevp.towerdefense.Settings;import static javafx.scene.paint.Color.rgb;public class GameMenu {    public static GameMenu instance;    private Stage primaryStage;    private GameLoop gameLoop;    private Scene scene;    private Pane gameMainMenuPane;    private Pane gameMenuLevelPane;    private Pane gameMenuInfoPane;    private Pane gameOverPane;    private Pane gameVictoryGame;    private ImageView tableInfoTower;    private Text lifeText = new Text();    private Text moneyText = new Text();    private int life = 0;    private int money = 0;    private EventHandler<MouseEvent> handlerStartMenuLevel = new EventHandler<MouseEvent>() {        @Override        public void handle(MouseEvent e) {            startMenuLevelGame();            primaryStage.setTitle("MainMenu/Game");            primaryStage.setScene(scene);            primaryStage.show();        }    };    private EventHandler<MouseEvent> handlerContinuteGame = new EventHandler<MouseEvent>() {        @Override        public void handle(MouseEvent e) {            gameLoop.start();            GameManager.getInstance().getMap().setStart(true);            scene = GameScene.getInstance().getSceneInGame();            primaryStage.setTitle("Continute/Game");            primaryStage.setScene(scene);            primaryStage.show();        }    };    private EventHandler<MouseEvent> handlerChooseLevel1 = new EventHandler<MouseEvent>() {        @Override        public void handle(MouseEvent e) {            GameManager.getInstance().eraseAll();            GameManager.getInstance().newGame(MapName.MapLvl11);            startInGame();            gameLoop = new GameLoop(primaryStage);            primaryStage.setTitle("DefenseTowerLevel11/Game");            primaryStage.setScene(scene);            primaryStage.show();        }    };    private EventHandler<MouseEvent> handlerChooseLevel2 = new EventHandler<MouseEvent>() {        @Override        public void handle(MouseEvent e) {            GameManager.getInstance().eraseAll();            GameManager.getInstance().newGame(MapName.MapLvl21);            startInGame();            gameLoop = new GameLoop(primaryStage);            primaryStage.setTitle("DefenseTowerLevel21/Game");            primaryStage.setScene(scene);            primaryStage.show();        }    };    private EventHandler<MouseEvent> handlerChooseLevel3 = new EventHandler<MouseEvent>() {        @Override        public void handle(MouseEvent e) {            GameManager.getInstance().eraseAll();            GameManager.getInstance().newGame(MapName.MapLvl31);            startInGame();            gameLoop = new GameLoop(primaryStage);            primaryStage.setTitle("DefenseTowerLevel31/Game");            primaryStage.setScene(scene);            primaryStage.show();        }    };    private EventHandler<MouseEvent> handlerStartGame = new EventHandler<MouseEvent>() {        @Override        public void handle(MouseEvent e) {            GameManager.getInstance().getBulletLayer().getChildren().clear();            gameLoop.start();        }    };    private EventHandler<MouseEvent> handlerPauseGame = new EventHandler<MouseEvent>() {        @Override        public void handle(MouseEvent e) {            GameManager.getInstance().getBulletLayer().getChildren().clear();            gameLoop.stop();        }    };    private EventHandler<MouseEvent> handlerBackMainMenu = new EventHandler<MouseEvent>() {        @Override        public void handle(MouseEvent e) {            gameLoop.stop();            GameManager.getInstance().getMap().setStart(false);            createMainMenuLayer(true);            startMainMenuGame();            primaryStage.setTitle("MainMenu/Game");            primaryStage.setScene(scene);            primaryStage.show();        }    };    public static GameMenu getInstance() {        if (instance == null) {            instance = new GameMenu();            instance.CreateGameMenu();        }        return instance;    }    private void CreateGameMenu() {        createMainMenuLayer(false);        createMenuLevelLayer();        createMenuInfoLayer();        createScoreGame();        createTableInfoIconTower();        createGameOverLayer();        createGameVictoryLayer();    }    public ImageView getTableInfoTower() {        return tableInfoTower;    }    public Stage getPrimaryStage() {        return primaryStage;    }    public void setPrimaryStage(Stage primaryStage) {        this.primaryStage = primaryStage;    }    public Scene getScene() {        return scene;    }    public Pane getMainMenuPane() {        return gameMainMenuPane;    }    public Pane getMenuLevelPane() {        return gameMenuLevelPane;    }    public Pane getMenuInfoPane() {        return gameMenuInfoPane;    }    public Pane getGameOverPane() {        return gameOverPane;    }    public Pane getGameVictoryGame() {        return gameVictoryGame;    }    public void startMainMenuGame() {        GameScene instanceGameScene = GameScene.getInstance();        instanceGameScene.createSceneMainMenuGame();        scene = instanceGameScene.getSceneMainMenuGame();    }    public void startMenuLevelGame() {        GameScene instanceGameScene = GameScene.getInstance();        instanceGameScene.createSceneMenuLevelGame();        scene = instanceGameScene.getSceneMenuLevelGame();    }    public void startInGame() {        GameManager instanceGameManager = GameManager.getInstance();        GameSpriteManager instanceSprite = GameSpriteManager.getInstance();        GameScene instanceGameScene = GameScene.getInstance();        instanceGameManager.getMap().setStart(true);        instanceGameScene.createSceenInGame();        scene = instanceGameScene.getSceneInGame();        System.out.println(instanceGameManager.getLife());    }    public void updateGameOver() {        // System.out.println("---- Game Over ----");        GameManager.getInstance().eraseAll();        gameLoop.stop();        GameScene.getInstance().createSceneGameOver();        scene = GameScene.getInstance().getSceneGameOver();        primaryStage.setTitle("GameOver - PlayAgain/Game");        primaryStage.setScene(scene);        primaryStage.show();    }    public void updateGameVictory() {        // System.out.println("---- Game Victory ----");        GameManager.getInstance().eraseAll();        gameLoop.stop();        GameScene.getInstance().createSceneGameVictory();        scene = GameScene.getInstance().getSceneGameVictory();        primaryStage.setTitle("GameVictory - PlayAgain/Game");        primaryStage.setScene(scene);        primaryStage.show();    }    private void createMainMenuLayer(boolean isPaused) {        gameMainMenuPane = new Pane();        gameMainMenuPane.setPrefSize(Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);        gameMainMenuPane.setStyle("-fx-background-color: rgb(68,255,204);");        GameSpriteManager instanceSprite = GameSpriteManager.getInstance();        ImageView playGame = new ImageView(instanceSprite.buttonPlayGame);        playGame.relocate(Settings.SCENE_WIDTH / 2 - instanceSprite.buttonPlayGame.getWidth() / 2, 350);        setButtonEffect(playGame);        playGame.addEventFilter(MouseEvent.MOUSE_CLICKED, handlerStartMenuLevel);        ImageView continuteGame = new ImageView(instanceSprite.buttonContinute);        continuteGame.relocate(Settings.SCENE_WIDTH / 2 - instanceSprite.buttonContinute.getWidth() / 2, 250);        setButtonEffect(continuteGame);        continuteGame.addEventFilter(MouseEvent.MOUSE_CLICKED, handlerContinuteGame);        ImageView selectLevelGame = new ImageView(instanceSprite.buttonSelectLevel);        selectLevelGame.relocate(Settings.SCENE_WIDTH / 2 - instanceSprite.buttonSelectLevel.getWidth() / 2, 350);        setButtonEffect(selectLevelGame);        selectLevelGame.addEventFilter(MouseEvent.MOUSE_CLICKED, handlerStartMenuLevel);        // add pane        if (!isPaused) {            gameMainMenuPane.getChildren().add(playGame);            gameMainMenuPane.getChildren().removeAll(continuteGame, selectLevelGame);        } else {            gameMainMenuPane.getChildren().addAll(continuteGame, selectLevelGame);            gameMainMenuPane.getChildren().remove(playGame);        }    }    public void updateLife() {        life = GameManager.getInstance().getLife();        lifeText.setText("Life:  " + life);    }    public void updateMoney() {        money = GameManager.getInstance().getMoney();        moneyText.setText("Money: " + money + " $");    }    private void createMenuLevelLayer() {        gameMenuLevelPane = new Pane();        gameMenuLevelPane.setPrefSize(Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);        gameMenuLevelPane.setStyle("-fx-background-color: rgb(68,255,204);");        GameSpriteManager instanceSprite = GameSpriteManager.getInstance();        ImageView titleGame = new ImageView(instanceSprite.imageTitle);        ImageView buttonMapLvl1 = new ImageView(instanceSprite.buttonLevel1);        ImageView buttonMapLvl2 = new ImageView(instanceSprite.buttonLevel2);        ImageView buttonMapLvl3 = new ImageView(instanceSprite.buttonLevel3);        titleGame.relocate(Settings.SCENE_WIDTH / 2 - instanceSprite.imageTitle.getWidth() / 2, 100);        buttonMapLvl1.relocate(0.25 * Settings.SCENE_WIDTH - instanceSprite.buttonLevel1.getWidth() / 2, 400);        buttonMapLvl2.relocate(Settings.SCENE_WIDTH / 2 - instanceSprite.buttonLevel2.getWidth() / 2, 400);        buttonMapLvl3.relocate(0.75 * Settings.SCENE_WIDTH - instanceSprite.buttonLevel3.getWidth() / 2, 400);        setButtonEffect(buttonMapLvl1);        setButtonEffect(buttonMapLvl2);        setButtonEffect(buttonMapLvl3);        buttonMapLvl1.addEventFilter(MouseEvent.MOUSE_CLICKED, handlerChooseLevel1);        buttonMapLvl2.addEventFilter(MouseEvent.MOUSE_CLICKED, handlerChooseLevel2);        buttonMapLvl3.addEventFilter(MouseEvent.MOUSE_CLICKED, handlerChooseLevel3);        // add pane        gameMenuLevelPane.getChildren().addAll(titleGame, buttonMapLvl1, buttonMapLvl2, buttonMapLvl3);    }    private void createMenuInfoLayer() {        gameMenuInfoPane = new Pane();        gameMenuInfoPane.setPrefSize(Settings.SCENE_WIDTH * 0.2, Settings.SCENE_HEIGHT);        gameMenuInfoPane.setMaxSize(Settings.SCENE_WIDTH * 0.2, Settings.SCENE_HEIGHT);        gameMenuInfoPane.setStyle("-fx-background-color: rgb(68,255,204);" + "-fx-border-width: 3px;");        double widthPane = gameMenuInfoPane.getMaxWidth();        double heightPane = gameMenuInfoPane.getMaxHeight();        GameSpriteManager instanceSprite = GameSpriteManager.getInstance();        ImageView backMainMenu = new ImageView(instanceSprite.buttonMainMenu);        ImageView startGame = new ImageView(instanceSprite.buttonStartGame);        ImageView pauseGame = new ImageView(instanceSprite.buttonPauseGame);        backMainMenu.relocate(widthPane * 0.5 - instanceSprite.buttonMainMenu.getWidth() / 2, 600.0);        startGame.relocate(widthPane * 0.5 - instanceSprite.buttonStartGame.getWidth() / 2, 460.0);        pauseGame.relocate(widthPane * 0.5 - instanceSprite.buttonPauseGame.getWidth() / 2, 530.0);        setButtonEffect(backMainMenu);        setButtonEffect(startGame);        setButtonEffect(pauseGame);        backMainMenu.addEventFilter(MouseEvent.MOUSE_CLICKED, handlerBackMainMenu);        startGame.addEventFilter(MouseEvent.MOUSE_CLICKED, handlerStartGame);        pauseGame.addEventFilter(MouseEvent.MOUSE_CLICKED, handlerPauseGame);        // add pane        gameMenuInfoPane.getChildren().addAll(backMainMenu, startGame, pauseGame);    }    private void createGameOverLayer() {        gameOverPane = new Pane();        gameOverPane.setPrefSize(Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);        gameOverPane.setStyle("-fx-background-color: rgb(69,198,172);");        GameSpriteManager instanceSprite = GameSpriteManager.getInstance();        ImageView playAgain = new ImageView(instanceSprite.buttonPlayAgain);        playAgain.relocate(Settings.SCENE_WIDTH / 2 - instanceSprite.buttonPlayAgain.getWidth() / 2, 300);        setButtonEffect(playAgain);        playAgain.addEventFilter(MouseEvent.MOUSE_CLICKED, handlerStartMenuLevel);        // add pane        gameOverPane.getChildren().add(playAgain);    }    private void createGameVictoryLayer() {        gameVictoryGame = new Pane();        gameVictoryGame.setPrefSize(Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);        gameVictoryGame.setStyle("-fx-background-color: rgb(198,96,69);");        GameSpriteManager instanceSprite = GameSpriteManager.getInstance();        ImageView selectLevel = new ImageView(instanceSprite.buttonSelectLevel);        selectLevel.relocate(Settings.SCENE_WIDTH / 2 - instanceSprite.buttonSelectLevel.getWidth() / 2, 300);        setButtonEffect(selectLevel);        selectLevel.addEventFilter(MouseEvent.MOUSE_CLICKED, handlerStartMenuLevel);        // add pane        gameVictoryGame.getChildren().add(selectLevel);    }    private void createScoreGame() {        lifeText = new Text();        moneyText = new Text();        life = 0;        money = 0;        // Score        lifeText.setText("Life: " + life);        lifeText.setFont(Font.font(null, FontWeight.BOLD, 20));        lifeText.setStroke(Color.BLACK);        lifeText.setFill(Color.RED);        lifeText.relocate(30.0, 300.0);        lifeText.setBoundsType(TextBoundsType.VISUAL);        // Money        moneyText.setText("Money: " + money + " $");        moneyText.setFont(Font.font(null, FontWeight.BOLD, 20));        moneyText.setStroke(Color.BLACK);        moneyText.setFill(Color.RED);        moneyText.relocate(30.0, 350.0);        moneyText.setBoundsType(TextBoundsType.VISUAL);        gameMenuInfoPane.getChildren().add(lifeText);        gameMenuInfoPane.getChildren().add(moneyText);    }    private DropShadow effectShadowDefault() {        DropShadow dropShadow = new DropShadow();        dropShadow.setRadius(5.0);        dropShadow.setOffsetX(5.0);        dropShadow.setOffsetY(5.0);        dropShadow.setColor(rgb(112, 113, 110));        return dropShadow;    }    private void setButtonEffect(Node node) {        DropShadow rollOverColor = new DropShadow();        rollOverColor.setColor(Color.RED);        DropShadow clickColor = new DropShadow();        clickColor.setColor(Color.GREENYELLOW);        // Effect default        node.setEffect(effectShadowDefault());        // Effect mouse hover        node.addEventHandler(MouseEvent.MOUSE_ENTERED,                (event) -> node.setEffect(rollOverColor));        // Effect mouse hover end        node.addEventHandler(MouseEvent.MOUSE_EXITED, (event) -> node.setEffect(effectShadowDefault()));        // Effect on click        node.addEventHandler(MouseEvent.MOUSE_PRESSED,                (event) -> node.setEffect(clickColor));        // Effect on click end        node.addEventHandler(MouseEvent.MOUSE_RELEASED,                (event) -> node.setEffect(effectShadowDefault()));    }    private void createTableInfoIconTower() {        tableInfoTower = new ImageView();        gameMenuInfoPane.getChildren().add(tableInfoTower);        double posX = gameMenuInfoPane.getMaxWidth() * 0.5 - 195 * 0.5;        tableInfoTower.relocate(posX, 20);        tableInfoTower.setEffect(effectShadowDefault());    }}