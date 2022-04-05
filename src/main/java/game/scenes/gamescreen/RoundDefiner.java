package game.scenes.gamescreen;

import com.github.hanyaeger.api.Coordinate2D;
import game.Round;
import game.entities.enemies.*;
import java.util.ArrayList;

public class RoundDefiner {
    private final GameScreen gameScreen;
    private final Coordinate2D startCoordinates = new Coordinate2D(112, 0);

    public RoundDefiner(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public void setEnemies(Round round) {
        ArrayList<Enemy> newEnemies = new ArrayList<>();
        switch (round) {
            case ONE -> {
                newEnemies.clear();
                for (int i = 0; i < 2; i++) {
                    newEnemies.add(new DerpyCoot("sprites/enemies/derpy_coot.png", startCoordinates, gameScreen));
                }
                for (int i = 0; i < 6; i++) {
                    newEnemies.add(new BabyCoot("sprites/enemies/baby_coot.png", startCoordinates, gameScreen));
                }
            }
            case TWO -> {
                newEnemies.clear();
                for (int i = 0; i < 3; i++) {
                    newEnemies.add(new DerpyCoot("sprites/enemies/derpy_coot.png", startCoordinates, gameScreen));
                }
                for (int i = 0; i < 2; i++) {
                    newEnemies.add(new MamaCoot("sprites/enemies/mama_coot.png", startCoordinates, gameScreen));
                }
                for (int i = 0; i < 6; i++) {
                    newEnemies.add(new BabyCoot("sprites/enemies/baby_coot.png", startCoordinates, gameScreen));
                }
            }
            case THREE -> {
                newEnemies.clear();
                newEnemies.add(new ThickCoot("sprites/enemies/thick_coot.png", startCoordinates, gameScreen));
                for (int i = 0; i < 3; i++) {
                    newEnemies.add(new FastCoot("sprites/enemies/fast_coot.png", startCoordinates, gameScreen));
                }
                for (int i = 0; i < 6; i++) {
                    newEnemies.add(new MamaCoot("sprites/enemies/mama_coot.png", startCoordinates, gameScreen));
                }
                for (int i = 0; i < 10; i++) {
                    newEnemies.add(new BabyCoot("sprites/enemies/baby_coot.png", startCoordinates, gameScreen));
                }
            }
            case FOUR -> {
                newEnemies.clear();
                for (int i = 0; i < 3; i++) {
                    newEnemies.add(new FastCoot("sprites/enemies/fast_coot.png", startCoordinates, gameScreen));
                }
                for (int i = 0; i < 3; i++) {
                    newEnemies.add(new ThickCoot("sprites/enemies/thick_coot.png", startCoordinates, gameScreen));
                }
                for (int i = 0; i < 3; i++) {
                    newEnemies.add(new MamaCoot("sprites/enemies/mama_coot.png", startCoordinates, gameScreen));
                }
                for (int i = 0; i < 3; i++) {
                    newEnemies.add(new FastCoot("sprites/enemies/fast_coot.png", startCoordinates, gameScreen));
                }
                for (int i = 0; i < 2; i++) {
                    newEnemies.add(new MamaCoot("sprites/enemies/mama_coot.png", startCoordinates, gameScreen));
                }
                for (int i = 0; i < 10; i++) {
                    newEnemies.add(new BabyCoot("sprites/enemies/baby_coot.png", startCoordinates, gameScreen));
                }
            }
            case FIVE -> {
                newEnemies.clear();
                for (int i = 0; i < 5; i++) {
                    newEnemies.add(new ThickCoot("sprites/enemies/thick_coot.png", startCoordinates, gameScreen));
                }
                for (int i = 0; i < 3; i++) {
                    newEnemies.add(new MamaCoot("sprites/enemies/mama_coot.png", startCoordinates, gameScreen));
                }
                for (int i = 0; i < 8; i++) {
                    newEnemies.add(new BabyCoot("sprites/enemies/baby_coot.png", startCoordinates, gameScreen));
                }
                for (int i = 0; i < 5; i++) {
                    newEnemies.add(new FastCoot("sprites/enemies/fast_coot.png", startCoordinates, gameScreen));
                }
                for (int i = 0; i < 5; i++) {
                    newEnemies.add(new DerpyCoot("sprites/enemies/derpy_coot.png", startCoordinates, gameScreen));
                }
                for (int i = 0; i < 4; i++) {
                    newEnemies.add(new MamaCoot("sprites/enemies/mama_coot.png", startCoordinates, gameScreen));
                }
                for (int i = 0; i < 7; i++) {
                    newEnemies.add(new BabyCoot("sprites/enemies/baby_coot.png", startCoordinates, gameScreen));
                }
            }
            default -> System.out.println("ERROR: problem with filling newEnemies. Check the round!");
        }
        gameScreen.enemyList = newEnemies;
    }
}
