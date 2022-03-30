package game.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;


public abstract class Enemy extends DynamicSpriteEntity implements Collider, SceneBorderCrossingWatcher {
    private Coordinate2D initialLocation;
    private double speed;

    public Enemy(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation, new Size(75));
        this.initialLocation = initialLocation;
        setMovementSpeed(MovementSpeed.NORMAL);
        setMotion(speed, Direction.LEFT);

//        setAnchorLocation(new Coordinate2D(107.5, 37.5));
//        setAnchorPoint(AnchorPoint.CENTER_CENTER);
//        setMotion(movementSpeed, Direction.DOWN);
    }

    public abstract int getHealth();

    public abstract void setHealth(double newHealth);

    public abstract double getMovementSpeed();

    public Coordinate2D getInitialLocation() {
        return initialLocation;
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        switch (border) {
            case TOP, LEFT, RIGHT, BOTTOM -> remove();
        }
    }
    public abstract void setMovementSpeed(MovementSpeed movementSpeed);
}