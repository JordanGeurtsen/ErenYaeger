package game.entities.targeting;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import game.entities.enemies.Enemy;
import game.entities.targeting.Targeting;

public class Arrow extends Targeting implements Collider{
    private double movementSpeed = 25;

    public Arrow(Coordinate2D initialLocation, Enemy target) {
        super("sprites/enemies/baby_coot.png", initialLocation);
        setMotion(movementSpeed, angleTo(target.getCoordinate2D()) -90);


    }
}
