package game.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import game.scenes.gamescreen.GameScreen;

public class MamaCoot extends Enemy {
    private double speed = 0.9;
    private int health = 80;
    private final int spawnInterval = 5000;
    private final BabyCootSpawner babyCootSpawner;

    public MamaCoot(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, gameScreen);
        babyCootSpawner = new BabyCootSpawner(spawnInterval, getAnchorLocation(), gameScreen, this);
        setSpeed(getMovementSpeed());
    }

    public BabyCootSpawner getBabyCootSpawner() {return babyCootSpawner;}

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
                speed = 0.6;
                setSpeed(speed);
            }
            case NORMAL -> {
                speed = 0.9;
                setSpeed(speed);
            }
            default -> System.out.println("ERROR: movementSpeed is incorrect");
        }
    }
}
