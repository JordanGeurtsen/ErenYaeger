package game.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;


public class Enemy extends DynamicSpriteEntity implements Collided {
    int health = 20;
    int movementSpeed, hitPoints;
    Coordinate2D coordinate2D;

    public Enemy(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation, new Size(150));
        this.coordinate2D = initialLocation;
    }

    @Override
    public void onCollision(Collider collider) {
    }

    public int getHealth() {
        return health;
    }
    public int getMovementSpeed() {
        return movementSpeed;
    }
    public int getHitPoints() {
        return hitPoints;
    }
    public Coordinate2D getCoordinate2D() { return coordinate2D; }
}
