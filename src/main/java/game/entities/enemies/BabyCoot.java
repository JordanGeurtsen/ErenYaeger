package game.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import game.scenes.gamescreen.GameScreen;

public class BabyCoot extends Enemy{
    private double speed = 1.6;
    private int health = 10;

    public BabyCoot(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, gameScreen);
        setSpeed(getMovementSpeed());
    }

    @Override
    public double getMovementSpeed() {return speed;}

    public int getHealth() {return health;}

    @Override
    public void setHealth(double newHealth) {this.health += newHealth;}

    @Override
    public int getDamage() {
        return 1;}

    @Override
    public void setMovementSpeed(MovementSpeed movementSpeed) {
        switch (movementSpeed) {
            case SLOW -> {
                speed = 1.1;
                setSpeed(speed);
            }
            case NORMAL -> {
                speed = 1.6;
                setSpeed(speed);
            }
            default -> System.out.println("ERROR: movementSpeed is incorrect");
        }
    }
}
