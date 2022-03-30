package game.entities.enemies;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import game.scenes.GameScreen;


public class Enemy extends DynamicSpriteEntity implements Collided, Collider {
    int health = 2;
    double movementSpeed = 1.5;
    double walkedDistance = 0.0;
    Coordinate2D initialLocation;

    public Enemy(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, new Size(75));
        this.initialLocation = initialLocation;

        setAnchorLocation(new Coordinate2D(107.5, 37.5));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setMotion(movementSpeed, Direction.DOWN);
    }

    @Override
    public void onCollision(Collider collider) {
        health--;
    }

    public int getHealth() {
        return health;
    }

    public double getMovementSpeed() {
        return movementSpeed;
    }

    public Coordinate2D getInitialLocation() {
        return initialLocation;
    }

    public void slowMovementSpeed() {this.movementSpeed = 1.0;}
    public void resetMovementSpeed() {this.movementSpeed = 1.5;}

}