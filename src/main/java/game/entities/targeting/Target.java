package game.entities.targeting;

import com.github.hanyaeger.api.Coordinate2D;
import game.entities.enemies.Enemy;
import game.entities.enemies.MovementSpeed;
import game.scenes.GameScreen;

public class Target extends Enemy {
    public Target (Enemy target, String resource, Coordinate2D initialLocation, GameScreen gameScreen){
        super(resource, initialLocation, gameScreen);

    }

    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public void setHealth(double newHealth) {

    }

    @Override
    public double getMovementSpeed() {
        return 0;
    }

    @Override
    public void setMovementSpeed(MovementSpeed movementSpeed) {

    }
}
