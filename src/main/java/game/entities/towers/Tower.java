package game.entities.towers;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import game.entities.enemies.Enemy;
import game.entities.targeting.ProjectileSpawner;
import game.scenes.GameScreen;

import java.util.ArrayList;

public abstract class Tower extends DynamicSpriteEntity implements UpdateExposer {
    protected GameScreen gameScreen;
    private Enemy target;
    public double closestDistance;
    private double shootAngle;
    private double maxHealth;
    private ArrayList<Enemy> enemiesInRange;
    private  ArrayList<Enemy> everyTarget;

    public Tower(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, new Size(75));
        this.gameScreen = gameScreen;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    public abstract double getTowerDamage();

    public abstract double getTowerRange();

    abstract public Coordinate2D getInitialLocation();

    public abstract ProjectileSpawner getProjectileSpawner();

    public double getShootAngle(){return shootAngle;}

    public void setShootAngle(double shootAngle) {this.shootAngle = shootAngle;}

    public boolean isInRange(double rangeRadius, Enemy e) {
        boolean inRange = distanceTo(e) < rangeRadius;
        return inRange;
    }

    public Enemy getTarget(ArrayList<Enemy> spawnedEnemyList) {
        maxHealth = 0;
        closestDistance = getTowerRange();
        enemiesInRange = new ArrayList<>();
        for (Enemy e : spawnedEnemyList) {
            if (isInRange(getTowerRange(), e)) {
                if(e.getAnchorLocation() != new Coordinate2D(112.0, 0.0)) {
                    enemiesInRange.add(e);
                    if (enemiesInRange != null) {
                        for (Enemy r : enemiesInRange) {
                            if (!isInRange(getTowerRange(), r)) {
                                enemiesInRange.remove(r);
                            } else if (r.getHealth() > maxHealth && distanceTo(r) < closestDistance) {
                                maxHealth = r.getHealth();
                                closestDistance = distanceTo(r);
                                target = r;
                                setShootAngle(angleTo(target));
                                if (r.getHealth() <= 0 || !isInRange(getTowerRange(), r)) {
                                    closestDistance = getTowerRange();
                                }
                            }
                        }
                    }
                }
            }
        }
        return target;
    }

//    public void setShootAngle(double shootAngle) {
//        this.shootAngle = shootAngle;
//    }
//
//    public double getShootAngle(){
//        return shootAngle;
//    }
//
//    public abstract double getTowerDamage();
//
//    public abstract double getTowerRange();
//
//    abstract public Coordinate2D getInitialLocation();
//
//    public abstract ProjectileSpawner getProjectileSpawner();

}
