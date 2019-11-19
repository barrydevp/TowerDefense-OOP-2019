package uet.barrydevp.towerdefense.Game;import javafx.application.Platform;import javafx.scene.media.AudioClip;import javafx.scene.media.Media;import javafx.scene.media.MediaPlayer;public class GameAudio {    private static GameAudio instance;    final public String SOUND_STRACK_GAME        = "/sounds/musicStrackGame.mp3";    final public String SOUND_BUTTON_CLICK       = "/sounds/soundButtonClick.mp3";    final public String SOUND_BUILDING_TOWER     = "/sounds/soundBuildingTower.mp3";    final public String SOUND_EXPLOSION_MOSTER   = "/sounds/soundExplosionMonster.wav";    final public String SOUND_BULLET_SINGLE     = "/sounds/soundBulletSingle.mp3";    final public String SOUND_BULLET_DOUBLE     = "/sounds/soundBulletDouble.mp3";    final public String SOUND_ROCKET             = "/sounds/soundRocket.mp3";    final public String SOUND_START_GAME         = "/sounds/soundStartGame.mp3";    final public String SOUND_GAME_OVER          = "/sounds/soundGameOver.wav";    final public String SOUND_GAME_VICTORY       = "/sounds/soundGameVictory.wav";    private boolean isMusicGame;    private boolean isMotionSoundGame;    private AudioClip soundStartGame;    private AudioClip soundGameOver;    private AudioClip soundGameVictory;    private AudioClip musicStrackGame;    private AudioClip soundButtonClick;    private AudioClip soundBuidingTower;    private AudioClip soundExplosionMonster;    private AudioClip soundBulletSingle;    private AudioClip soundBulletDouble;    private AudioClip soundRocket;    private MediaPlayer soundEffect;    public static GameAudio getInstance() {        if (instance == null) {            instance = new GameAudio();            instance.createGameAudio();        }        return instance;    }    public AudioClip getMusicStrackGame() {        return musicStrackGame;    }    public AudioClip getSoundButtonClick() {        return soundButtonClick;    }    public AudioClip getSoundBuidingTower() {        return soundBuidingTower;    }    public AudioClip getSoundExplosionMonster() {        return soundExplosionMonster;    }    public AudioClip getSoundBulletSingle() {        return soundBulletSingle;    }    public AudioClip getSoundBulletDouble() {        return soundBulletDouble;    }    public AudioClip getSoundRocket() {        return soundRocket;    }    public AudioClip getSoundStartGame() {        return soundStartGame;    }    public AudioClip getSoundGameOver() {        return soundGameOver;    }    public AudioClip getSoundGameVictory() {        return soundGameVictory;    }    public boolean isMotionSoundGame() {        return isMotionSoundGame;    }    public void setMotionSoundGame(boolean motionSoundGame) {        isMotionSoundGame = motionSoundGame;    }    public boolean isMusicGame() {        return isMusicGame;    }    public void setMusicGame(boolean musicGame) {        isMusicGame = musicGame;    }    private void createGameAudio() {        // default is true        isMusicGame = true;        isMotionSoundGame = true;        createSoundStartGame();        createSoundStrackGame();        createSoundButtonClick();        createSoundBuildingTower();        createSoundExplosionMonster();        createSoundBullet();        createSoundGameVictory();        createSoundGameOver();    }    private void createSoundStartGame() {        soundStartGame = new AudioClip(getClass().getResource(SOUND_START_GAME).toExternalForm());        soundStartGame.setVolume(0.5);        soundStartGame.setCycleCount(1);    }    private void createSoundGameOver() {        soundGameOver = new AudioClip(getClass().getResource(SOUND_GAME_OVER).toExternalForm());        soundGameOver.setVolume(0.5);    }    private void createSoundGameVictory() {        soundGameVictory = new AudioClip(getClass().getResource(SOUND_GAME_VICTORY).toExternalForm());        soundGameVictory.setVolume(0.5);    }    private void createSoundStrackGame() {        musicStrackGame = new AudioClip(getClass().getResource(SOUND_STRACK_GAME).toExternalForm());        musicStrackGame.setVolume(0.5);    }    private void createSoundButtonClick() {        soundButtonClick = new AudioClip(getClass().getResource(SOUND_BUTTON_CLICK).toExternalForm());    }    private void createSoundBuildingTower() {        soundBuidingTower = new AudioClip(getClass().getResource(SOUND_BUILDING_TOWER).toExternalForm());    }    private void createSoundExplosionMonster() {        soundExplosionMonster = new AudioClip(getClass().getResource(SOUND_EXPLOSION_MOSTER).toExternalForm());        soundExplosionMonster.setVolume(0.7);    }    private void createSoundBullet() {        soundBulletSingle = new AudioClip(getClass().getResource(SOUND_BULLET_SINGLE).toExternalForm());        soundBulletDouble = new AudioClip(getClass().getResource(SOUND_BULLET_DOUBLE).toExternalForm());        soundRocket = new AudioClip(getClass().getResource(SOUND_ROCKET).toExternalForm());        soundBulletSingle.setVolume(0.7);        soundBulletDouble.setVolume(0.7);        soundRocket.setVolume(0.7);    }    // On Sound    public void onSoundStartGame() {        if (isMusicGame && !soundStartGame.isPlaying()) {            soundStartGame.play();        }    }    public void onSoundGameOver() {        if (isMusicGame && !soundGameOver.isPlaying()) {            soundGameOver.play();        }    }    public void onSoundGameVictory() {        if (isMusicGame && !soundGameVictory.isPlaying()) {            soundGameVictory.play();        }    }    public void onMusicStrackGame() {        if (isMusicGame && !musicStrackGame.isPlaying()) {            musicStrackGame.play();        }    }    public void onSoundButtonClick() {        if (isMotionSoundGame && !soundButtonClick.isPlaying()) {            soundButtonClick.play();        }    }    public void onSoundBuildingTower() {        if (isMotionSoundGame && !soundBuidingTower.isPlaying()) {            soundBuidingTower.play();        }    }    public void onSoundExplosionMonster() {        if (isMotionSoundGame && !soundExplosionMonster.isPlaying()) {            Platform.runLater(() -> soundExplosionMonster.play(0.75));        }    }    public void onSoundBulletSingle() {        if (isMotionSoundGame && !soundBulletSingle.isPlaying()) {            Platform.runLater(() -> soundBulletSingle.play(0.5));        }        // effectSoundBullet(SOUND_BULLET_SINGLE, 1.1);    }    public void onSoundBulletDouble() {        if (isMotionSoundGame && !soundBulletDouble.isPlaying()) {            Platform.runLater(() -> soundBulletDouble.play(0.5));        }        //  effectSoundBullet(SOUND_BULLET_DOUBLE, 1.2);    }    public void onSoundRocket() {        if (isMotionSoundGame && !soundRocket.isPlaying()) {            Platform.runLater(() -> soundRocket.play(0.7));        }    }    public void changeStatusMusicGame() {        isMusicGame = !isMusicGame;        if (isMusicGame && !musicStrackGame.isPlaying()) {            musicStrackGame.play();        } else {            musicStrackGame.stop();        }    }    public void changeStatusMotionSoundGame() {        isMotionSoundGame = !isMotionSoundGame;        if (!isMotionSoundGame) {            soundButtonClick.stop();            soundBuidingTower.stop();            soundExplosionMonster.stop();            soundRocket.stop();            soundBulletSingle.stop();            soundBulletDouble.stop();        }    }    private void effectSoundBullet(String soundEffectFilename, double speedSound) {        soundEffect = new MediaPlayer(new Media(getClass().getResource(soundEffectFilename).toExternalForm()));        soundEffect.setCycleCount(1);        //      soundEffect.setRate(speedSound);        soundEffect.play();        Runnable callback = () -> {            soundEffect.play();        };    }}