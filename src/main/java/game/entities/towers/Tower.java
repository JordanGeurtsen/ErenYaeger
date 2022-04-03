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

    public Tower(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, new Size(75));
        this.gameScreen = gameScreen;

        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    public boolean isInRange(double rangeRadius, Enemy e) {
        boolean inRange = distanceTo(e) < rangeRadius;
        return inRange;
    }

    public Enemy getTarget(ArrayList<Enemy> enemyList) {
        double maxHealth = 0;
        closestDistance = getTowerRange();
        ArrayList<Enemy> enemiesInRange = new ArrayList<>();
        for (Enemy e : enemyList) {
            if (isInRange(getTowerRange(), e)) {
                enemiesInRange.add(e);
                if(enemiesInRange != null) {
                    for (Enemy r : enemiesInRange) {
                        if (r.getHealth() > maxHealth && distanceTo(r) < closestDistance) {
                            maxHealth = r.getHealth();
                            closestDistance = distanceTo(r);
                            target = r;
                            setShootAngle(angleTo(target));
                            if (r.getHealth() <= 0 || distanceTo(r) > getTowerRange()) {
                                closestDistance = getTowerRange();
                            }
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
                if (isInRange(t.getTowerRange(), e)) {
                    everyTarget.add(e);
                }
            }
        }
        return everyTarget;
    }

    public void setShootAngle(double shootAngle) {
        this.shootAngle = shootAngle;
    }

    public double getShootAngle(){
        return shootAngle;
    }

    public abstract double getTowerDamage();

    public abstract double getTowerRange();

//    public abstract double getTowerPrice();

    abstract public Coordinate2D getInitialLocation();

    public abstract ProjectileSpawner getProjectileSpawner();

}
