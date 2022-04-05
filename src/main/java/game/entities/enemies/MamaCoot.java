package game.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import game.scenes.GameScreen;

public class MamaCoot extends Enemy {
    private double speed = 0.9;
    private int health = 80;
    private int damage = 4;
    private BabyCootSpawner babyCootSpawner;

    public MamaCoot(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, gameScreen);
        babyCootSpawner = new BabyCootSpawner(5000, getAnchorLocation(), gameScreen, this);
        setSpeed(getMovementSpeed());
    }

    @Override
    public BabyCootSpawner getBabyCootSpawner() {return babyCootSpawner;}

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
                speed = 0.6;
                setSpeed(speed);
                break;
            case NORMAL:
                speed = 0.9;
                setSpeed(speed);
                break;
            default:
                System.out.println("ERROR: movementSpeed is incorrect");
                break;
        }
    }
}
