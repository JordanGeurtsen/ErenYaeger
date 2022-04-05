package game.entities.targeting;

import com.github.hanyaeger.api.entities.EntitySpawner;

public abstract class ProjectileSpawner extends EntitySpawner {
    protected double shootAngle;

    public ProjectileSpawner(long intervalInMs) {
        super(intervalInMs);
    }

    public abstract void setShootAngle(double shootAngle);
}