package game.entities.towers;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import game.entities.enemies.Enemy;
import game.entities.targeting.ProjectileSpawner;
import game.scenes.gamescreen.GameScreen;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Tower extends DynamicSpriteEntity implements UpdateExposer {
    protected GameScreen gameScreen;
    private Enemy target;
    private double shootAngle;

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
        return distanceTo(e) < rangeRadius;
    }

    public Enemy getTarget(ArrayList<Enemy> spawnedEnemyList) {
        double furthestWalked = 0;
        ArrayList<Enemy> enemiesInRange = new ArrayList<>();
        for (Enemy e : spawnedEnemyList) {
            if (isInRange(getTowerRange(), e)) {
                if(!Objects.equals(e.getAnchorLocation(), new Coordinate2D(112.0, 0.0))) {
                    enemiesInRange.add(e);
                    for (Enemy r : enemiesInRange) {
                        if (!isInRange(getTowerRange(), r)) {
                            enemiesInRange.remove(r);
                        } else if (r.getMapProgress() > furthestWalked) {
                            furthestWalked = r.getMapProgress();
                            target = r;
                            setShootAngle(angleTo(target));
                            if (r.getHealth() <= 0 || !isInRange(getTowerRange(), r)) {
                                furthestWalked = 0;
                            }
                        }
                    }
                }
            }
        }
        return target;
    }
}
