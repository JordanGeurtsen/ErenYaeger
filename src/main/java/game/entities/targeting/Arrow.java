package game.entities.targeting;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import game.entities.enemies.Enemy;
import game.entities.targeting.Targeting;

public class Arrow extends Targeting implements Collider{
    private int movementSpeed = 2;
    private int damage = 0;

    public Arrow(Coordinate2D initialLocation, Enemy target) {
        super("sprites/baby_coot.png", initialLocation);
        setMotion(movementSpeed, angleTo(target) - 90);
    }
}
