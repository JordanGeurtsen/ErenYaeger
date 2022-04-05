package game.entities.targeting;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import game.scenes.GameScreen;

public abstract class ProjectileSpawner extends EntitySpawner {
    private GameScreen gameScreen;
    protected double shootAngle;

    public ProjectileSpawner(long intervalInMs, Coordinate2D coordinate2D, GameScreen gameScreen) {
        super(intervalInMs);
        this.gameScreen = gameScreen;
    }

    public abstract void setShootAngle(double shootAngle);
}