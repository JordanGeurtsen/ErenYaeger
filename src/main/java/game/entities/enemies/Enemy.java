package game.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

import java.util.ArrayList;

public class Enemy extends DynamicSpriteEntity implements Collided {
    int health = 20;
    int movementSpeed, hitPoints;
    ArrayList<Enemy> enemyList = new ArrayList<Enemy>();

    protected Enemy(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
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
}
