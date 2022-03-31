package game.entities.targeting;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import game.entities.enemies.Enemy;
import game.scenes.GameScreen;

import java.util.ArrayList;

public abstract class ProjectileSpawner extends EntitySpawner {
    private boolean needToSpawn = false;
    private GameScreen gameScreen;

    public ProjectileSpawner(long intervalInMs, Coordinate2D coordinate2D, GameScreen gameScreen) { // intervalInMs = speed
        super(intervalInMs);
        this.gameScreen = gameScreen;
    }

    @Override
    protected void spawnEntities() {

    }

}