package game.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import game.scenes.GameScreen;

public class FastCoot extends Enemy{
    private int health = 50;
    private int damage = 2;
    private double walkedDistance = 0.0;
    private double speed = 2.5;
    private Direction direction = Direction.DOWN;
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
    public int getDamage() {
        return damage;
    }

    @Override
    public void setMovementSpeed(MovementSpeed movementSpeed) {
        switch (movementSpeed){
            case SLOW :
                speed = 1.3;
                setSpeed(speed);
                break;
            case NORMAL:
                speed = 2.0;
                setSpeed(speed);
        }
    }
}
