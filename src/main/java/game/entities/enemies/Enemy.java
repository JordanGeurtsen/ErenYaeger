package game.entities.enemies;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import game.PathStep;
import game.scenes.GameScreen;

public abstract class Enemy extends DynamicSpriteEntity implements Collider, SceneBorderCrossingWatcher {
    private Coordinate2D initialLocation;
    protected GameScreen gameScreen;
    private double mapProgress;
    private BabyCootSpawner babyCootSpawner;
    public PathStep pathStep = PathStep.ZERO;

    public Enemy(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, new Size(75));
        this.initialLocation = initialLocation;
        this.gameScreen = gameScreen;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setDirection(Direction.DOWN);
    }

    public abstract void setMovementSpeed(MovementSpeed movementSpeed);

    public abstract double getMovementSpeed();

    public abstract int getHealth();

    public abstract void setHealth(double newHealth);

    public abstract int getDamage();

    public Coordinate2D getInitialLocation() {return initialLocation;}

    public PathStep getPathStep() {return pathStep;}

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        gameScreen.enemyPastBorder(this, getDamage());
    }

    public void setPathStep(PathStep newPathStep){this.pathStep = newPathStep;}

    public BabyCootSpawner getBabyCootSpawner() {return babyCootSpawner;}

    public void updateWalkedDistance(double distanceWalked){
        this.mapProgress += distanceWalked;
    }

    public double getMapProgress(){
        return this.mapProgress;
    }

    public void setMapProgress(double mapProgress){
        this.mapProgress = mapProgress;
    }
}