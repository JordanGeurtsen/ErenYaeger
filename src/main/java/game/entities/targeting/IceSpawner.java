package game.entities.targeting;

import com.github.hanyaeger.api.Coordinate2D;
import game.entities.enemies.Enemy;
import game.entities.enemies.MovementSpeed;
import game.entities.towers.Freezer;
import game.entities.towers.Tower;
import game.scenes.GameScreen;

import java.util.ArrayList;

public class IceSpawner extends ProjectileSpawner {
    private ArrayList<Tower> tower;
    private ArrayList<Enemy> enemyList;
    private ArrayList<Enemy> everyTargetInRange = new ArrayList<>();
    private GameScreen gameScreen;
    private boolean needToSpawn = false;
    private Coordinate2D coordinate2D;

    public IceSpawner(long intervalInMs, Coordinate2D coordinate2D, ArrayList<Enemy> enemyList, GameScreen gameScreen) {
        super(intervalInMs, coordinate2D, gameScreen);
        this.coordinate2D = coordinate2D;
        this.enemyList = enemyList;
        this.gameScreen = gameScreen;
    }


    @Override
    protected void spawnEntities() {
        if (needToSpawn) {
            if (enemyList.size() > 0) {
                for (Enemy e : enemyList) {
                    e.setMovementSpeed(MovementSpeed.NORMAL);
                }
                if (gameScreen.towers.size() > 0) {
                    for (Tower t : gameScreen.towers) {
                        if (t instanceof Freezer) {
                            for(Enemy e : enemyList) {
                                if (t.isMutipleInRange(t.getTowerRange(), e)) {
                                    everyTargetInRange = t.getEveryTarget(enemyList, t);
                                }
                            }
                        }
                    }
                }
            }
        for (Enemy e : everyTargetInRange) {
            e.setMovementSpeed(MovementSpeed.SLOW);
        }
            everyTargetInRange.clear();

            needToSpawn = false;
        } else if (!needToSpawn) {
            everyTargetInRange.clear();
            if (enemyList.size() > 0) {
                for (Tower t : gameScreen.towers) {
                    for(Enemy e : enemyList){
                    if (t.isMutipleInRange(t.getTowerRange(), e)) {
                        needToSpawn = true;
                    } else {
                            e.setMovementSpeed(MovementSpeed.NORMAL);
                    }
                    }
                }
            }
        }
    }
}
