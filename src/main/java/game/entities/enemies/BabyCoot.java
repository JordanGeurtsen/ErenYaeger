package game.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import game.scenes.GameScreen;

public class BabyCoot extends Enemy{
    private double speed = 1.6;
    private int health = 10;
    private int damage = 1;
    private Coordinate2D initialLocation;

    public BabyCoot(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, gameScreen);
        this.initialLocation = initialLocation;
        setSpeed(getMovementSpeed());
    }

    public double getMovementSpeed() {return speed;}

    public int getHealth() {return health;}

    @Override
    public void setHealth(double newHealth) {this.health += newHealth;}

    @Override
    public int getDamage() {return damage;}

    @Override
    public void setMovementSpeed(MovementSpeed movementSpeed) {
        switch (movementSpeed) {
            case SLOW:
                speed = 1.1;
                setSpeed(speed);
                break;
            case NORMAL:
                speed = 1.6;
                setSpeed(speed);
                break;
            default:
                System.out.println("ERROR: movementSpeed is incorrect");
                break;
        }
    }
}
