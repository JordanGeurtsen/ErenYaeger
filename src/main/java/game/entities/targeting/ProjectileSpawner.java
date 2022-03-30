package game.entities.targeting;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.entities.EntitySpawner;
import game.entities.enemies.Enemy;
import game.entities.enemies.MovementSpeed;
import game.entities.towers.*;
import game.scenes.GameScreen;

import java.util.ArrayList;

public class ProjectileSpawner extends EntitySpawner {
    private ArrayList<Tower> towers;
    private ArrayList<Enemy> enemyList;
    private GameScreen gameScreen;

    public ProjectileSpawner(long intervalInMs, ArrayList<Tower> towers, ArrayList<Enemy> enemyList, GameScreen gameScreen) { // intervalInMs = speed
        super(intervalInMs);
        this.towers = towers;
        this.enemyList = enemyList;
        this.gameScreen = gameScreen;
    }

    @Override
    protected void spawnEntities() {
        Enemy target;
        ArrayList<Enemy> everyTargetInRange = new ArrayList<>();
        if (enemyList.size() > 0) {
            for (Enemy e: enemyList) {
                e.setMovementSpeed(MovementSpeed.NORMAL);
            }
            if (towers.size() > 0) {
                for (Tower t : towers) {
                    if (t.isInRange(t.getTowerRange(), enemyList)) {
                        target = t.getTarget(t.getTowerRange(), enemyList);
                        everyTargetInRange = t.getEveryTarget(t.getTowerRange(), enemyList);
                        int shootAngle = (int) t.angleTo(target);
                        if (t instanceof Archer) {
                            Arrow arrow = new Arrow(t.getInitialLocation(), shootAngle, gameScreen, t, enemyList);
                            arrow.setAnchorPoint(AnchorPoint.CENTER_CENTER);
                            spawn(arrow);
                        } else if (t instanceof Hitman) {
                            Arrow arrow = new Arrow(t.getInitialLocation(), shootAngle, gameScreen, t, enemyList);
                            arrow.setAnchorPoint(AnchorPoint.CENTER_CENTER);
                            spawn(arrow);
                        } else if (t instanceof Freezer) {
                            Ice ice = new Ice(t.getInitialLocation(), gameScreen, t, enemyList);
                            spawn(ice);
                        }
                    } else {
                        System.out.println("No enemies in range");
                    }
                }
            }
        }
    }
}