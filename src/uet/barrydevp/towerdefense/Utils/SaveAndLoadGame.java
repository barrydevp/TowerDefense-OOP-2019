package uet.barrydevp.towerdefense.Utils;import uet.barrydevp.towerdefense.Game.GameManager;import uet.barrydevp.towerdefense.Map.MapName;import java.io.*;public class SaveAndLoadGame {    public static void saveGame() throws IOException {//        GameManager.getInstance().newGame(MapName.MapLvl21);        GameObjectSerializable gameObject = new GameObjectSerializable(GameManager.getInstance());        System.out.println("Go here 0");        FileOutputStream fileOut = new FileOutputStream("test.save");        System.out.println("Go here 1");        ObjectOutputStream out = new ObjectOutputStream(fileOut);        System.out.println("Go here 2");        out.writeObject(gameObject);        System.out.println("Go here 3");        out.close();    }    public static void loadGame() throws FileNotFoundException, IOException, ClassNotFoundException {        GameObjectSerializable gameObject = null;        FileInputStream fileIn = new FileInputStream("test.save");        ObjectInputStream in = new ObjectInputStream(fileIn);        gameObject = (GameObjectSerializable) in.readObject();        in.close();        fileIn.close();//        System.out.println("money:" + gameObject.getMoney());//        if(gameObject.getListTower() != null) {//            for(int i = 0; i < gameObject.getListTower().size(); i++) {//                System.out.println(gameObject.getListTower().get(i).getCenterLocation());//            }//        }////        System.out.println("Point2D:" + gameObject.getListTower());        gameObject.loadInstanceFromObject();    }    public static void main(String[] args) {        try {            SaveAndLoadGame.saveGame();        } catch(Exception e) {            System.out.println(e);        }    }}