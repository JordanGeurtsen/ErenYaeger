package game.entities.targeting.projectile;

import com.github.hanyaeger.api.Coordinate2D;
import game.entities.targeting.Targeting;

public class Bullet extends Targeting {
    protected Bullet(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }
}
