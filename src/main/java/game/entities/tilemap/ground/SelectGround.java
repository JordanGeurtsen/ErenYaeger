package game.entities.tilemap.ground;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class SelectGround extends SpriteEntity {
    public SelectGround(Coordinate2D initialLocation, Size size, String resource) {
        super(resource, initialLocation, size);
    }
}
