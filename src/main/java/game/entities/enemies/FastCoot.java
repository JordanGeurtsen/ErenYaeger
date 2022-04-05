package game.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import game.scenes.gamescreen.GameScreen;

public class FastCoot extends Enemy{
    private double speed = 2.5;
    private int health = 40;

    public FastCoot(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, gameScreen);
        setSpeed(getMovementSpeed());
    }

    @Override
    public double getMovementSpeed(){return speed;}

    public int getHealth(){return health;}

    @Override
    public void setHealth(double newHealth) {health += newHealth;}

    @Override
    public int getDamage() {
        return 2;}

    @Override
    public void setMovementSpeed(MovementSpeed movementSpeed) {
        switch (movementSpeed) {
            case SLOW -> {
                speed = 1.4;
                setSpeed(speed);
            }
            case NORMAL -> {
                speed = 2.5;
                setSpeed(speed);
            }
            default -> System.out.println("ERROR: movementSpeed is incorrect");
        }
    }
}
