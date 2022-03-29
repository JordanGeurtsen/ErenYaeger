package game.entities.targeting;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import game.entities.enemies.Enemy;
import game.entities.targeting.Targeting;

public class Arrow extends Targeting implements Collider{
    private double movementSpeed = 2.5;
    private int damage = 0;

    public Arrow(Coordinate2D initialLocation, Enemy target) {
        super("sprites/enemies/baby_coot.png", initialLocation);
        //setMotion(movementSpeed, angleTo(target.getCoordinate2D()) - 90);
        setMotion(movementSpeed, 315 - (angleTo(target.getCoordinate2D()))); // 270 + (90/2) = 315, werkt niet voor e2
    }
}
