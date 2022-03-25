package game.entities.tilemap.ground;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Path extends SpriteEntity {
    protected Path(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }
}
