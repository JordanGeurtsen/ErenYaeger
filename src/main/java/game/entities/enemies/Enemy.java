package game.entities.enemies;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;


public class Enemy extends DynamicSpriteEntity implements Collider, SceneBorderCrossingWatcher {
    double health = 2;
    double movementSpeed = 1.5;
    double walkedDistance = 0.0;
    Coordinate2D initialLocation;

    public Enemy(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation, new Size(75));
        this.initialLocation = initialLocation;
        setAnchorLocation(new Coordinate2D(107.5, 37.5));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setMotion(movementSpeed, Direction.DOWN);
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double newHealth){
        this.health += newHealth;
    }

    public double getMovementSpeed() {
        return movementSpeed;
    }

    public Coordinate2D getInitialLocation() {
        return initialLocation;
    }

    public void setMovementSpeed(double movementSpeed) {this.movementSpeed = movementSpeed;}
    public void resetMovementSpeed() {this.movementSpeed = 1.5;}

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        switch (border) {
            case TOP, LEFT, RIGHT, BOTTOM -> remove();
        }
    }
}