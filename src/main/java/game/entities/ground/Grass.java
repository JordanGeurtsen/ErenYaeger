package game.entities.ground;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Grass extends SpriteEntity {
    protected Grass(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }
}
