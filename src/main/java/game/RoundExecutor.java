package game;

import com.github.hanyaeger.api.Coordinate2D;
import game.entities.enemies.*;

import java.util.ArrayList;

public class RoundExecutor {
    private int round;
    private ArrayList<Enemy> newEnemies;
    private Coordinate2D startCoordinates = new Coordinate2D(100,0);

    public RoundExecutor(int round) {
        this.round = round;
    }

    public ArrayList<Enemy> getEnemies(int round){
        newEnemies = new ArrayList<>();
        switch (round){
            case 1:
                for(int i = 0; i < 6; i++) {
                    newEnemies.add(new BabyCoot("sprites/enemies/baby_coot.png", startCoordinates));
                }
                for(int j = 0; j < 3; j++){
                    newEnemies.add(new DerpyCoot("sprites/enemies/derpy_coot.png", startCoordinates));
                }
                break;
            case 2:
                for(int i = 0; i < 4; i++) {
                    newEnemies.add(new MamaCoot("sprites/enemies/mama_coot.png", startCoordinates));
                }
                for(int j = 0; j < 3; j++){
                    newEnemies.add(new DerpyCoot("sprites/enemies/derpy_coot.png", startCoordinates));
                }
                break;
            case 3:
                for(int i = 0; i < 6; i++) {
                    newEnemies.add(new MamaCoot("sprites/enemies/mama_coot.png", startCoordinates));
                }
                for(int j = 0; j < 2; j++){
                    newEnemies.add(new FastCoot("sprites/enemies/fast_coot.png", startCoordinates));
                }
                newEnemies.add(new ThickCoot("sprites/enemies/thick_coot.png", startCoordinates));
                break;
            case 4:
                for(int i = 0; i < 4; i++) {
                    newEnemies.add(new BabyCoot("sprites/enemies/baby_coot.png", startCoordinates));
                }
                for(int i = 0; i < 5; i++) {
                    newEnemies.add(new MamaCoot("sprites/enemies/mama_coot.png", startCoordinates));
                }
                for(int j = 0; j < 3; j++){
                    newEnemies.add(new FastCoot("sprites/enemies/fast_coot.png", startCoordinates));
                }
                for(int j = 0; j < 3; j++){
                    newEnemies.add(new ThickCoot("sprites/enemies/thick_coot.png", startCoordinates));
                }
                break;
            case 5:
                for(int i = 0; i < 4; i++) {
                    newEnemies.add(new BabyCoot("sprites/enemies/baby_coot.png", startCoordinates));
                }
                for(int i = 0; i < 7; i++) {
                    newEnemies.add(new MamaCoot("sprites/enemies/mama_coot.png", startCoordinates));
                }
                for(int j = 0; j < 5; j++){
                    newEnemies.add(new DerpyCoot("sprites/enemies/derpy_coot.png", startCoordinates));
                }
                for(int j = 0; j < 5; j++){
                    newEnemies.add(new FastCoot("sprites/enemies/fast_coot.png", startCoordinates));
                }
                for(int j = 0; j < 4; j++){
                    newEnemies.add(new ThickCoot("sprites/enemies/thick_coot.png", startCoordinates));
                }
                break;
            default:
                System.out.println("ERROR: problem with filling newEnemies. Check the round!");
                break;
        }
        return newEnemies;
    }
}
