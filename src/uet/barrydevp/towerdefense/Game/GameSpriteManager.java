package uet.barrydevp.towerdefense.Game;import javafx.scene.image.Image;import uet.barrydevp.towerdefense.Entity.Tower.TowerName;import java.util.ArrayList;public class GameSpriteManager {    private static GameSpriteManager instance;    public Image buttonPlayGame;    public Image buttonContinute;    public Image buttonStartGame;    public Image buttonNextWave;    public Image buttonPauseGame;    public Image imageTitle;    public Image buttonLevel1;    public Image buttonLevel2;    public Image buttonLevel3;    public Image infoSingleCanonImage;    public Image infoSingleFlyGunImage;    public Image infoSingleMissileImage;    public Image infoMiniGunWhiteImage;    public Image infoMiniGunUltraWhiteImage;    public Image infoMiniGunRedImage;    public Image infoMiniGunUltraRedImage;    public Image infoMiniGunGreenImage;    public Image infoMiniGunBlueImage;    public Image infoDoubleMissileImage;    public Image infoDoubleFlyGunImage;    public Image infoDoubleCanonImage;    public Image infoTripleCanonImage;    public Image buttonMainMenu;    public Image buttonPlayAgain;    public Image buttonSelectLevel;    public Image effectMainMenu;    public Image effectGameVictory;    public Image effectGameOver1;    public Image effectGameOver2;    public Image effectGameOver3;    public Image effectGameOver4;    public Image effectGameOver5;    public Image effectGameOver6;    public Image effectGameOver7;    public Image effectGameOver8;    public Image effectGameOver9;    public Image effectGameOver10;    public Image upgradeImage;    public Image sellImage;    public Image moneyImage;    public Image heartImage;    public Image Maplvl1Image;    public Image Maplvl2Image;    public Image Maplvl3Image;    public Image greenMinionImage;    public Image greenBrowMinionImage;    public Image greenBlackMinionImage;    public Image ultraGreenMinionImage;    public Image whiteMinionImage;    public Image blueMinionImage;    public Image ultraBlueMinionImage;    public Image redMinionImage;    public Image redBrowMinionImage;    public Image ultraRedMinionImage;    public Image silverMinionImage;    public Image browMinionImage;    public Image ultraBrowMinionImage;    public Image greenPlaneImage;    public Image bluePlaneImage;    public Image silverPlaneImage;    public Image greenTankImage;    public Image whiteTankImage;    public Image rocketImage;    public Image bigRocketImage;    public Image yellowBulletImage;    public Image browBulletImage;    public Image silverBulletImage;    public Image ultraWhiteBulletImage;    public Image greenBulletImage;    public Image blueBulletImage;    public Image redBulletImage;    public Image ultraRedBulletImage;    public Image yellowSilverBulletImage;    public Image yellowBrowBulletImage;    public Image rootTowerImage;    public Image singleCanonImage;    public Image doubleCanonImage;    public Image tripleCanonImage;    public Image miniGunGreenImage;    public Image miniGunRedImage;    public Image miniGunUltraRedImage;    public Image miniGunWhiteImage;    public Image miniGunUltraWhiteImage;    public Image miniGunBlueImage;    public Image singleMissileImage;    public Image doubleMissileImage;    public Image singleFlyGunImage;    public Image doubleFlyGunImage;    public Image explosion1Image;    public Image explosion2Image;    public Image explosion3Image;    public Image fireEffect1Image;    public Image fireEffect2Image;    public Image fireEffect3Image;    public Image fireEffect4Image;    public Image fireSingleMissileEffectImage;    private GameSpriteManager(){}    public void createGameSpriteManager() {        // button  (Image Menu)        buttonPlayGame = new Image(getClass().getResource("/buttons/play.png").toExternalForm());        buttonContinute = new Image(getClass().getResource("/buttons/continue.png").toExternalForm());        buttonStartGame = new Image(getClass().getResource("/buttons/start.png").toExternalForm());        buttonNextWave = new Image(getClass().getResource("/buttons/next-wave.png").toExternalForm());        buttonPauseGame = new Image(getClass().getResource("/buttons/pause.png").toExternalForm());        imageTitle = new Image(getClass().getResource("/buttons/DefineButton2_15/1.png").toExternalForm());        buttonLevel1 = new Image(getClass().getResource("/buttons/level1.png").toExternalForm());        buttonLevel2 = new Image(getClass().getResource("/buttons/level2.png").toExternalForm());        buttonLevel3 = new Image(getClass().getResource("/buttons/level3.png").toExternalForm());        buttonMainMenu = new Image(getClass().getResource("/buttons/main-menu.png").toExternalForm());        buttonPlayAgain = new Image(getClass().getResource("/buttons/play-again.png").toExternalForm());        buttonSelectLevel = new Image(getClass().getResource("/buttons/select-level.png").toExternalForm());        // info        infoTripleCanonImage = new Image(getClass().getResource("/buttons/TripleCanon.png").toExternalForm());        infoDoubleCanonImage = new Image(getClass().getResource("/buttons/DoubleCanon.png").toExternalForm());        infoDoubleFlyGunImage = new Image(getClass().getResource("/buttons/DoubleFlyGun.png").toExternalForm());        infoDoubleMissileImage = new Image(getClass().getResource("/buttons/DoubleMissile.png").toExternalForm());        infoMiniGunBlueImage = new Image(getClass().getResource("/buttons/MiniGunBlue.png").toExternalForm());        infoMiniGunGreenImage = new Image(getClass().getResource("/buttons/MiniGunGreen.png").toExternalForm());        infoMiniGunRedImage = new Image(getClass().getResource("/buttons/MiniGunRed.png").toExternalForm());        infoMiniGunUltraRedImage = new Image(getClass().getResource("/buttons/MiniGunUltraRed.png").toExternalForm());        infoMiniGunUltraWhiteImage = new Image(getClass().getResource("/buttons/MiniGunUltraWhite.png").toExternalForm());        infoMiniGunWhiteImage = new Image(getClass().getResource("/buttons/MiniGunWhite.png").toExternalForm());        infoSingleCanonImage = new Image(getClass().getResource("/buttons/SingleCanon.png").toExternalForm());        infoSingleFlyGunImage = new Image(getClass().getResource("/buttons/SingleFlyGun.png").toExternalForm());        infoSingleMissileImage = new Image(getClass().getResource("/buttons/SingleMissile.png").toExternalForm());        // effect Menu        effectMainMenu = new Image(getClass().getResource("/effects/gameStartMainMenu.png").toExternalForm());        effectGameVictory = new Image(getClass().getResource("/effects/gameVictory.png").toExternalForm());        effectGameOver1 = new Image(getClass().getResource("/effects/gameOver1.png").toExternalForm());        effectGameOver2 = new Image(getClass().getResource("/effects/gameOver2.png").toExternalForm());        effectGameOver3 = new Image(getClass().getResource("/effects/gameOver3.png").toExternalForm());        effectGameOver4 = new Image(getClass().getResource("/effects/gameOver4.png").toExternalForm());        effectGameOver5 = new Image(getClass().getResource("/effects/gameOver5.png").toExternalForm());        effectGameOver6 = new Image(getClass().getResource("/effects/gameOver6.png").toExternalForm());        effectGameOver7 = new Image(getClass().getResource("/effects/gameOver7.png").toExternalForm());        effectGameOver8 = new Image(getClass().getResource("/effects/gameOver7.png").toExternalForm());        effectGameOver9 = new Image(getClass().getResource("/effects/gameOver7.png").toExternalForm());        effectGameOver10 = new Image(getClass().getResource("/effects/gameOver7.png").toExternalForm());        // icon        upgradeImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile289.png").toExternalForm());        sellImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile287.png").toExternalForm());        heartImage =  new Image(getClass().getResource("/buttons/icon-heart.png").toExternalForm());        moneyImage =  new Image(getClass().getResource("/buttons/icon-money.png").toExternalForm());        // icon        upgradeImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile289.png").toExternalForm());        sellImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile287.png").toExternalForm());        // map        Maplvl1Image = new Image(getClass().getResource("/Map/bkg1.jpg").toExternalForm());        Maplvl2Image = new Image(getClass().getResource("/Map/bkg2.jpg").toExternalForm());        Maplvl3Image = new Image(getClass().getResource("/Map/bkg3.jpg").toExternalForm());        // monster        greenMinionImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile245.png").toExternalForm());        greenBrowMinionImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile241.png").toExternalForm());        greenBlackMinionImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile240.png").toExternalForm());        ultraGreenMinionImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile239.png").toExternalForm());        blueMinionImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile244.png").toExternalForm());        ultraBlueMinionImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile238.png").toExternalForm());        whiteMinionImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile243.png").toExternalForm());        redMinionImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile246.png").toExternalForm());        redBrowMinionImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile235.png").toExternalForm());        ultraRedMinionImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile236.png").toExternalForm());        silverMinionImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile248.png").toExternalForm());        browMinionImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile247.png").toExternalForm());        ultraBrowMinionImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile237.png").toExternalForm());        greenPlaneImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile270.png").toExternalForm());        bluePlaneImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile242.png").toExternalForm());        silverPlaneImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile271.png").toExternalForm());        greenTankImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile268.png").toExternalForm());        whiteTankImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile269.png").toExternalForm());        // bullet        rocketImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile251.png").toExternalForm());        bigRocketImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile252.png").toExternalForm());        yellowBulletImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile272.png").toExternalForm());        yellowSilverBulletImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile273.png").toExternalForm());        yellowBrowBulletImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile279.png").toExternalForm());        browBulletImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile274.png").toExternalForm());        silverBulletImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile275.png").toExternalForm());        greenBulletImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile277.png").toExternalForm());        blueBulletImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile276.png").toExternalForm());        redBulletImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile278.png").toExternalForm());        ultraRedBulletImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile281.png").toExternalForm());        ultraWhiteBulletImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile280.png").toExternalForm());        // tower        rootTowerImage = new  Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile181.png").toExternalForm());        singleCanonImage = new  Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile249.png").toExternalForm());        doubleCanonImage = new  Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile250.png").toExternalForm());        tripleCanonImage = new  Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile253.png").toExternalForm());        miniGunGreenImage = new  Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile291.png").toExternalForm());        miniGunRedImage = new  Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile294.png").toExternalForm());        miniGunUltraRedImage = new  Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile255.png").toExternalForm());        miniGunBlueImage = new  Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile292.png").toExternalForm());        miniGunWhiteImage = new  Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile293.png").toExternalForm());        miniGunUltraWhiteImage = new  Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile254.png").toExternalForm());        singleMissileImage = new  Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile206.png").toExternalForm());        doubleMissileImage = new  Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile205.png").toExternalForm());        singleFlyGunImage = new  Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile203.png").toExternalForm());        doubleFlyGunImage = new  Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile204.png").toExternalForm());        // explosion        explosion1Image = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile019.png").toExternalForm());        explosion2Image = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile020.png").toExternalForm());        explosion3Image = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile021.png").toExternalForm());        // effect fire        fireEffect1Image = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile295.png").toExternalForm());        fireEffect2Image = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile296.png").toExternalForm());        fireEffect3Image = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile297.png").toExternalForm());        fireEffect4Image = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile298.png").toExternalForm());        fireSingleMissileEffectImage = new Image(getClass().getResource("/PNG/Defaultsize/towerDefense_tile229.png").toExternalForm());    }    public static GameSpriteManager getInstance(){        if(instance == null){            instance = new GameSpriteManager();            instance.createGameSpriteManager();        }        return instance;    }    public ArrayList<Image> getListTowerImage(TowerName name) {        ArrayList<Image> images = new ArrayList<>();        switch (name) {            case SingleCanon:                images.add(singleCanonImage);                images.add(infoSingleCanonImage);                images.add(infoDoubleCanonImage);                break;            case SingleFlyGun:                images.add(singleFlyGunImage);                images.add(infoSingleFlyGunImage);                images.add(infoDoubleFlyGunImage);                break;            case SingleMissile:                images.add(singleMissileImage);                images.add(infoSingleMissileImage);                images.add(infoDoubleMissileImage);                break;            case DoubleCanon:                images.add(doubleCanonImage);                images.add(infoDoubleCanonImage);                images.add(infoTripleCanonImage);                break;            case TripleCanon:                images.add(tripleCanonImage);                images.add(infoTripleCanonImage);                images.add(infoTripleCanonImage);                break;            case DoubleFlyGun:                images.add(doubleFlyGunImage);                images.add(infoDoubleFlyGunImage);                images.add(infoDoubleFlyGunImage);                break;            case DoubleMissile:                images.add(doubleMissileImage);                images.add(infoDoubleMissileImage);                images.add(infoDoubleMissileImage);                break;            case MiniGunRed:                images.add(miniGunRedImage);                images.add(infoMiniGunRedImage);                images.add(infoMiniGunUltraRedImage);                break;            case MiniGunBlue:                images.add(miniGunBlueImage);                images.add(infoMiniGunBlueImage);                images.add(infoMiniGunWhiteImage);                break;            case MiniGunGreen:                images.add(miniGunGreenImage);                images.add(infoMiniGunGreenImage);                images.add(infoMiniGunRedImage);                break;            case MiniGunWhite:                images.add(miniGunWhiteImage);                images.add(infoMiniGunWhiteImage);                images.add(infoMiniGunUltraWhiteImage);                break;            case MiniGunUltraRed:                images.add(miniGunUltraRedImage);                images.add(infoMiniGunUltraRedImage);                images.add(infoMiniGunUltraRedImage);                break;            case MiniGunUltraWhite:                images.add(miniGunUltraWhiteImage);                images.add(infoMiniGunUltraWhiteImage);                images.add(infoMiniGunUltraWhiteImage);                break;        }        return images;    }}