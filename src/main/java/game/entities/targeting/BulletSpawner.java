package game.entities.targeting;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import game.entities.enemies.Enemy;
import game.entities.enemies.MovementSpeed;
import game.entities.towers.Hitman;
import game.entities.towers.Tower;
import game.scenes.GameScreen;

import java.util.ArrayList;

public class BulletSpawner extends ProjectileSpawner{
    private ArrayList<Tower> towers;
//    private ArrayList<Enemy> enemyList;
    private GameScreen gameScreen;
    private boolean needToSpawn = false;
    private Enemy target;
    private Coordinate2D coordinate2D;
    private double shootAngle;
    private Tower shootingTower;

    public BulletSpawner (long intervalInMs, Coordinate2D coordinate2D, int shootAngle, Tower shootingTower, GameScreen gameScreen) {
        super(intervalInMs, coordinate2D, gameScreen);
        this.coordinate2D = coordinate2D;
        this.gameScreen = gameScreen;
        this.shootingTower = shootingTower;
        this.shootAngle = shootAngle;
    }

    @Override
    protected void spawnEntities() {
        if (needToSpawn) {
            if (gameScreen.enemyList.size() > 0) {
                for (Enemy e : gameScreen.enemyList) {
                    e.setMovementSpeed(MovementSpeed.NORMAL);
                }
                if (towers.size() > 0) {
                    for (Tower t : towers) {
                        for (Enemy e : gameScreen.enemyList) {
                            if (t.isInRange(t.getTowerRange(), e)) {
//                                target = t.getTarget(t.getTowerRange(), e);
//                                if (t instanceof Hitman) {
//                                    Arrow arrow = new Arrow(t.getInitialLocation(), shootAngle, gameScreen, shootingTower);
//                                    arrow.setAnchorPoint(AnchorPoint.CENTER_CENTER);
//                                    spawn(arrow);
//                                }
                            }
                        }
                    }
                }
                needToSpawn = false;
            } else if (!needToSpawn) {
                for (Tower t : towers) {
                    for (Enemy e : gameScreen.enemyList) {
                        if (t.isInRange(t.getTowerRange(), e)) {
                            needToSpawn = true;
                        }
                    }
                }
            }
        }
    }

    @Override
    public void setShootAngle(double shootAngle) {
        this.shootAngle = shootAngle;
        System.out.println("set");
    }
}
