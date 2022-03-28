package game.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Enemy extends DynamicSpriteEntity implements Collided {
    protected Enemy(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }

    @Override
    public void onCollision(Collider collider) {

    }
}
