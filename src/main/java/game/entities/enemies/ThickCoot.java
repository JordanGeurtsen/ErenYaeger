package game.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;

public class ThickCoot extends Enemy {
    private int health = 2;
    private double speed;
    private Direction direction = Direction.LEFT;
    private double walkedDistance = 0.0;
    private Coordinate2D initialLocation;

    public ThickCoot(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
        this.initialLocation = initialLocation;
        setMotion(getMovementSpeed(), direction);
    }

    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(double newHealth) {
        this.health += newHealth;
    }

    public double getMovementSpeed() {
        return speed;
    }

    @Override
    public void setMovementSpeed(MovementSpeed movementSpeed) {
        switch (movementSpeed){
            case SLOW :
                speed = 0.6;
                direction = Direction.UP;
                setMotion(speed, direction);
                System.out.println("SLOOOWW");
                break;
            case NORMAL:
                speed = 1.2;
                direction = Direction.LEFT;
                System.out.println("NOORRMAAAAL");
                setMotion(speed, direction);
        }
    }
}
