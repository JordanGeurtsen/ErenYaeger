package game.entities.enemies;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import game.EnemySpawner;
import game.PathStep;
import game.entities.towers.Archer;
import game.entities.towers.Freezer;
import game.entities.towers.Hitman;
import game.scenes.GameScreen;

import static game.scenes.GameScreen.coins;
import static game.scenes.GameScreen.points;


public abstract class Enemy extends DynamicSpriteEntity implements Collider, SceneBorderCrossingWatcher {
    private Coordinate2D initialLocation;
    private GameScreen gameScreen;
    private EnemySpawner enemySpawner;
    public PathStep pathStep = PathStep.ZERO;

    public Enemy(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, new Size(75));
        this.initialLocation = initialLocation;
        this.gameScreen = gameScreen;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        enemySpawner = new EnemySpawner(800, gameScreen.enemyList);
    }

    public abstract int getHealth();

    public abstract void setHealth(double newHealth);

    public abstract double getMovementSpeed();

    public abstract int getDamage();

    public Coordinate2D getInitialLocation() {
        return initialLocation;
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
            gameScreen.enemyPastBorder(this, getDamage());

    }

    public abstract void setMovementSpeed(MovementSpeed movementSpeed);

    public PathStep getPathStep(){return pathStep;}

    public void setPathStep(PathStep newPathStep){this.pathStep = newPathStep;}

    public EnemySpawner getEnemySpawner() {
        return enemySpawner;
    }
}