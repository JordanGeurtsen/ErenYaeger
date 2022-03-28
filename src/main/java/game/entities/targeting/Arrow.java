package game.entities.targeting;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import game.entities.enemies.Enemy;

public class Arrow extends Targeting implements Collider{
    private int movementSpeed = 2;
    private int damage = 0;

    public Arrow(Coordinate2D initialLocation, Enemy target) {
        super("sprites/enemies/baby_coot.png", initialLocation);
        setMotion(movementSpeed, angleTo(target) - 90);
    }
}
