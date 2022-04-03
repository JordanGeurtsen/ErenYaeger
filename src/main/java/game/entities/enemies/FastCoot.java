package game.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import game.scenes.GameScreen;

public class FastCoot extends Enemy{
    private int health = 50;
    private double walkedDistance = 0.0;
    private double speed = 2.5;
    private Direction direction = Direction.LEFT;
    private Coordinate2D initialLocation;

    public FastCoot(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, gameScreen);
        this.initialLocation = initialLocation;
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
                break;
            case NORMAL:
                speed = 2.0;
                direction = Direction.LEFT;
                setMotion(speed, direction);
        }
    }
}
