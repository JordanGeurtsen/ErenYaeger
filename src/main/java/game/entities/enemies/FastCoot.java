package game.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import game.scenes.GameScreen;

public class FastCoot extends Enemy{
    private double speed = 2.5;
    private int health = 40;
    private int damage = 2;
    private Coordinate2D initialLocation;

    public FastCoot(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, gameScreen);
        this.initialLocation = initialLocation;
        setSpeed(getMovementSpeed());
    }
    public double getMovementSpeed(){return speed;}

    public int getHealth(){return health;}

    @Override
    public void setHealth(double newHealth) {health += newHealth;}

    @Override
    public int getDamage() {return damage;}

    @Override
    public void setMovementSpeed(MovementSpeed movementSpeed) {
        switch (movementSpeed) {
            case SLOW:
                speed = 1.4;
                setSpeed(speed);
                break;
            case NORMAL:
                speed = 2.5;
                setSpeed(speed);
                break;
            default:
                System.out.println("ERROR: movementSpeed is incorrect");
                break;
        }
    }
}
