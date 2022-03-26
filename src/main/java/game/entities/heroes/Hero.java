package game.entities.heroes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public abstract class Hero extends SpriteEntity {
    protected Hero(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }
}
