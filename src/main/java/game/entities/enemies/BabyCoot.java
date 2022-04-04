package game.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import game.scenes.GameScreen;

public class BabyCoot extends Enemy{
    private int health = 10;
    private int damage = 19;
    private double speed = 1.0;
    private Direction direction = Direction.DOWN;
    private double walkedDistance = 0.0;
    private Coordinate2D initialLocation;

    public BabyCoot(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, gameScreen);
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

    public double getMovementSpeed(){return speed;}

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void setMovementSpeed(MovementSpeed movementSpeed) {
        switch (movementSpeed){
            case SLOW :
                speed = 0.5;
                setSpeed(speed);
                break;
            case NORMAL:
                speed = 1.0;
                setSpeed(speed);
        }
    }
}
