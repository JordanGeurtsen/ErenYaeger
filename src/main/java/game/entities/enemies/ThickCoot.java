package game.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import game.scenes.gamescreen.GameScreen;

public class ThickCoot extends Enemy {
    private double speed = 0.5;
    private int health = 150;

    public ThickCoot(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, gameScreen);
        setSpeed(speed);
    }

    @Override
    public double getMovementSpeed() {return speed;}

    public int getHealth() {return health;}

    @Override
    public void setHealth(double newHealth) {this.health += newHealth;}

    @Override
    public int getDamage() {
        return 4;}

    @Override
    public void setMovementSpeed(MovementSpeed movementSpeed) {
        switch (movementSpeed) {
            case SLOW -> {
                speed = 0.3;
                setSpeed(speed);
            }
            case NORMAL -> {
                speed = 0.5;
                setSpeed(speed);
            }
            default -> System.out.println("ERROR: movementSpeed is incorrect");
        }
    }
}
