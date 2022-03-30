package game.entities.targeting;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.entities.EntitySpawner;
import game.entities.enemies.Enemy;
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
        if (enemyList.size() >= 1) {
            if (towers.size() > 0) {
                for (Tower t : towers) {
                    if (t.isInRange(t.getTowerRange(), enemyList)) {
                        target = t.getTarget(t.getTowerRange(), enemyList);
                        int shootAngle = (int) t.angleTo(target);
                        System.out.println(target.getInitialLocation() + " " + target);
                        if (t instanceof Archer) {
                            Arrow arrow = new Arrow(t.getInitialLocation(), shootAngle, gameScreen, enemyList);
                            arrow.setAnchorPoint(AnchorPoint.CENTER_CENTER);
                            spawn(arrow);
                        } else if (t instanceof Hitman) {
                            Arrow arrow = new Arrow(t.getInitialLocation(), shootAngle, gameScreen, enemyList);
                            arrow.setAnchorPoint(AnchorPoint.CENTER_CENTER);
                            spawn(arrow);
                        } else if (t instanceof Freezer) {
                            Arrow arrow = new Arrow(t.getInitialLocation(), shootAngle, gameScreen, enemyList);
                            arrow.setAnchorPoint(AnchorPoint.CENTER_CENTER);
                            spawn(arrow);
                        }
                    } else {
                        System.out.println("No enemies in range");
                    }
                }
            }
        }
    }
}