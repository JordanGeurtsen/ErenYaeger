package game;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import game.entities.enemies.*;
import game.scenes.GameScreen;

import java.util.ArrayList;

public class RoundExecutor { //extends EntitySpawner {
    private GameScreen gameScreen;
    private ArrayList<Enemy> newEnemies;
    private Coordinate2D startCoordinates = new Coordinate2D(112, 0);

    public RoundExecutor(GameScreen gameScreen, Round round) {
        this.gameScreen = gameScreen;
//        spawner = new EnemySpawner(5, gameScreen);
    }

//    public EnemySpawner getEnemySpawner(Round round){
//        setEnemies(round);
//        return spawner;
//    }

    public void setEnemies(Round round){
        newEnemies = new ArrayList<>();
        switch (round){
            case ONE:
                newEnemies.clear();
                for(int j = 0; j < 3; j++){
                newEnemies.add(new DerpyCoot("sprites/enemies/derpy_coot.png", startCoordinates, gameScreen));
                }
                for (int i = 0; i < 6; i++) {
                    newEnemies.add(new BabyCoot("sprites/enemies/baby_coot.png", startCoordinates, gameScreen));
                }
                break;
            case TWO:
                newEnemies.clear();
                for(int j = 0; j < 3; j++){
                    newEnemies.add(new DerpyCoot("sprites/enemies/derpy_coot.png", startCoordinates, gameScreen));
                }
                for(int i = 0; i < 4; i++) {
                    newEnemies.add(new MamaCoot("sprites/enemies/mama_coot.png", startCoordinates, gameScreen));
                }
                break;
            case THREE:
                newEnemies.clear();
                newEnemies.add(new ThickCoot("sprites/enemies/thick_coot.png", startCoordinates, gameScreen));
                for(int j = 0; j < 2; j++){
                    newEnemies.add(new FastCoot("sprites/enemies/fast_coot.png", startCoordinates, gameScreen));
                }
                for(int i = 0; i < 6; i++) {
                    newEnemies.add(new MamaCoot("sprites/enemies/mama_coot.png", startCoordinates, gameScreen));
                }
                break;
            case FOUR:
                newEnemies.clear();
                for(int j = 0; j < 3; j++){
                    newEnemies.add(new ThickCoot("sprites/enemies/thick_coot.png", startCoordinates, gameScreen));
                }
                for(int j = 0; j < 3; j++){
                    newEnemies.add(new FastCoot("sprites/enemies/fast_coot.png", startCoordinates, gameScreen));
                }
                for(int i = 0; i < 5; i++) {
                    newEnemies.add(new MamaCoot("sprites/enemies/mama_coot.png", startCoordinates, gameScreen));
                }
                for(int i = 0; i < 4; i++) {
                    newEnemies.add(new BabyCoot("sprites/enemies/baby_coot.png", startCoordinates, gameScreen));
                }
                break;
            case FIVE:
                newEnemies.clear();
                for(int j = 0; j < 4; j++){
                    newEnemies.add(new ThickCoot("sprites/enemies/thick_coot.png", startCoordinates, gameScreen));
                }
                for(int j = 0; j < 5; j++){
                    newEnemies.add(new FastCoot("sprites/enemies/fast_coot.png", startCoordinates, gameScreen));
                }
                for(int j = 0; j < 5; j++){
                    newEnemies.add(new DerpyCoot("sprites/enemies/derpy_coot.png", startCoordinates, gameScreen));
                }
                for(int i = 0; i < 7; i++) {
                    newEnemies.add(new MamaCoot("sprites/enemies/mama_coot.png", startCoordinates, gameScreen));
                }
                for(int i = 0; i < 4; i++) {
                    newEnemies.add(new BabyCoot("sprites/enemies/baby_coot.png", startCoordinates, gameScreen));
                }
                break;
            default:
                System.out.println("ERROR: problem with filling newEnemies. Check the round!");
                break;
        }
        gameScreen.enemyList = newEnemies;
    }
}
