package game;

import com.github.hanyaeger.api.Coordinate2D;
import game.entities.enemies.*;
import game.scenes.GameScreen;

import java.util.ArrayList;

public class RoundExecutor {
    private int round;
    private GameScreen gameScreen;
    private ArrayList<Enemy> newEnemies;
    private Coordinate2D startCoordinates = new Coordinate2D(100,0);

    private BabyCoot babyCoot = new BabyCoot("sprites/enemies/baby_coot.png", startCoordinates, gameScreen);
    private MamaCoot mamaCoot = new MamaCoot("sprites/enemies/mama_coot.png", startCoordinates, gameScreen);
    private DerpyCoot derpyCoot = new DerpyCoot("sprites/enemies/derpy_coot.png", startCoordinates, gameScreen);
    private FastCoot fastCoot = new FastCoot("sprites/enemies/fast_coot.png", startCoordinates, gameScreen);
    private ThickCoot thickCoot = new ThickCoot("sprites/enemies/thick_coot.png", startCoordinates, gameScreen);

    public RoundExecutor(int round, GameScreen gameScreen) {
        this.round = round;
        this.gameScreen = gameScreen;
    }

    public ArrayList<Enemy> getEnemies(int round){
        newEnemies = new ArrayList<>();



        switch (round){
            case 1:
                for(int i = 0; i < 6; i++) {
                    newEnemies.add(babyCoot);
                }
                for(int j = 0; j < 3; j++){
                    newEnemies.add(derpyCoot);
                }
                break;
            case 2:
                for(int i = 0; i < 4; i++) {
                    newEnemies.add(mamaCoot);
                }
                for(int j = 0; j < 3; j++){
                    newEnemies.add(derpyCoot);
                }
                break;
            case 3:
                for(int i = 0; i < 6; i++) {
                    newEnemies.add(mamaCoot);
                }
                for(int j = 0; j < 2; j++){
                    newEnemies.add(fastCoot);
                }
                newEnemies.add(thickCoot);
                break;
            case 4:
                for(int i = 0; i < 4; i++) {
                    newEnemies.add(babyCoot);
                }
                for(int i = 0; i < 5; i++) {
                    newEnemies.add(mamaCoot);
                }
                for(int j = 0; j < 3; j++){
                    newEnemies.add(fastCoot);
                }
                for(int j = 0; j < 3; j++){
                    newEnemies.add(thickCoot);
                }
                break;
            case 5:
                for(int i = 0; i < 4; i++) {
                    newEnemies.add(babyCoot);
                }
                for(int i = 0; i < 7; i++) {
                    newEnemies.add(mamaCoot);
                }
                for(int j = 0; j < 5; j++){
                    newEnemies.add(derpyCoot);
                }
                for(int j = 0; j < 5; j++){
                    newEnemies.add(fastCoot);
                }
                for(int j = 0; j < 4; j++){
                    newEnemies.add(thickCoot);
                }
                break;
            default:
                System.out.println("ERROR: problem with filling newEnemies. Check the round!");
                break;
        }
        return newEnemies;
    }
}
