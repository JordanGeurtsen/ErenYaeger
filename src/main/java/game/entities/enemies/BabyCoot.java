package game.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import game.scenes.GameScreen;

public class BabyCoot extends Enemy{
    private int health = 2;
    private int damage = 1;
    private double speed;
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
                speed = 0.6;
                setMotion(speed, direction);
                break;
            case NORMAL:
                speed = 1.0;
                setMotion(speed, direction);
        }
    }
}
