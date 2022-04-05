package game.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import game.scenes.GameScreen;

public class ThickCoot extends Enemy {
    private double speed = 0.5;
    private int health = 150;
    private int damage = 4;
    private Coordinate2D initialLocation;

    public ThickCoot(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, gameScreen);
        this.initialLocation = initialLocation;
        setSpeed(speed);
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
            case SLOW :
                speed = 0.3;
                setSpeed(speed);
                break;
            case NORMAL:
                speed = 0.5;
                setSpeed(speed);
                break;
            default:
                System.out.println("ERROR: movementSpeed is incorrect");
                break;
        }
    }
}
