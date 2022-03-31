package game.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;

public class FastCoot extends Enemy{
    private int health = 2;
    private double walkedDistance = 0.0;
    private double speed = 2.5;
    private Direction direction = Direction.LEFT;
    private Coordinate2D initialLocation;

    public FastCoot(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
        this.initialLocation = initialLocation;
//        this.speed = speed;
        setMotion(getMovementSpeed(), direction);

    }

    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(double newHealth) {
        health += newHealth;}

    public double getMovementSpeed(){return speed;}

    @Override
    public void setMovementSpeed(MovementSpeed movementSpeed) {
        switch (movementSpeed){
            case SLOW :
                speed = 1.3;
                direction = Direction.UP;
                setMotion(speed, direction);
                System.out.println("SLOOOWW");
                break;
            case NORMAL:
                speed = 2.0;
                direction = Direction.LEFT;
                System.out.println("NOORRMAAAAL");
                setMotion(speed, direction);
        }
    }
}
