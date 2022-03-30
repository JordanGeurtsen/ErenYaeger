package game.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;

public class BabyCoot extends Enemy{
    private int health = 2;
    private double speed;
    private double walkedDistance = 0.0;
    private Coordinate2D initialLocation;

    public BabyCoot(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
        this.initialLocation = initialLocation;
        setMotion(getMovementSpeed(), Direction.LEFT);
    }

    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(double newHealth) {
        this.health += newHealth;
    }

    public double getMovementSpeed(){return speed;}

    @Override
    public void setMovementSpeed(MovementSpeed movementSpeed) {
        switch (movementSpeed){
            case SLOW :
                speed = 0.5;
                break;
            case NORMAL:
                speed = 1.0;
        }
    }

}
