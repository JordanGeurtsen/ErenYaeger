package game.entities.towers;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import game.entities.enemies.Enemy;
import game.entities.targeting.ArrowSpawner;
import game.entities.targeting.ProjectileSpawner;
import game.scenes.GameScreen;

import java.util.ArrayList;

public abstract class Tower extends DynamicSpriteEntity implements UpdateExposer {
    protected GameScreen gameScreen;
    private Coordinate2D initialLocation;
    private Enemy target;
    private double maxHealth = 0.0;
    private boolean inRange;
    public double closestDistance;
    private ProjectileSpawner spawner;

    public Tower(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, new Size(75));
        this.gameScreen = gameScreen;
        this.initialLocation = initialLocation;

        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    public boolean isInRange(double rangeRadius, ArrayList<Enemy> enemyList) {
        if (enemyList.size() > 0) {
            for (Enemy e : enemyList) {
                if (distanceTo(e) <= rangeRadius) {
                    inRange = true;
                    System.out.println(e + "inrange fucker");
                } else {
                    inRange = false;
                }
            }
        }
        return inRange;
    }

    public boolean isMutipleInRange(double rangeRadius, Enemy e) {
        inRange = false;
        if (distanceTo(e) < rangeRadius) {
            inRange = true;
        }
        return inRange;
    }

    public Enemy getTarget(double rangeRadius, ArrayList<Enemy> enemyList) {
        maxHealth = 0;
        closestDistance = rangeRadius;
        if (enemyList.size() >= 1) {
            for (Enemy e : enemyList) {
                if (isInRange(getTowerRange(), enemyList)) {
                    if (e.getHealth() > maxHealth && distanceTo(e) < closestDistance) {
                        maxHealth = e.getHealth();
                        closestDistance = distanceTo(e);
                        target = e;
                        if (e.getHealth() <= 0) {
                            closestDistance = rangeRadius;
                        }
                    }
                }
            }
        }
        return target;
    }

    public ArrayList<Enemy> getEveryTarget(ArrayList<Enemy> enemyList, Tower t) {
        ArrayList<Enemy> everyTarget = new ArrayList<>();
        if (enemyList.size() >= 1){
            for (Enemy e : enemyList) {
                if (isMutipleInRange(t.getTowerRange(), e)) {
                    everyTarget.add(e);
                }
            }
        }
        return everyTarget;
    }

    public abstract double getTowerDamage();

    public abstract double getTowerRange();

    public abstract double getTowerPrice();

    abstract public Coordinate2D getInitialLocation();

    public abstract ProjectileSpawner getSpawner();

}
