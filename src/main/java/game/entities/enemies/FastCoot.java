package game.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;

public class FastCoot extends Enemy{
    private int health = 2;
    private double walkedDistance = 0.0;
    private double speed = 2.5;
    private Coordinate2D initialLocation;

    public FastCoot(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
        this.initialLocation = initialLocation;
//        this.speed = speed;
        setMotion(getMovementSpeed(), Direction.LEFT);

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
                setMotion(0.1, Direction.LEFT);
                System.out.println("SLOOOWW");
                break;
            case NORMAL:
                System.out.println("NOORRMAAAAL");
                setMotion(2.1, Direction.LEFT);
        }
    }
}
