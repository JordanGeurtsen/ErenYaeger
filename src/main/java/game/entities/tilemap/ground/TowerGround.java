package game.entities.tilemap.ground;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class TowerGround extends SpriteEntity {
    public TowerGround(Coordinate2D initialLocation, Size size, String resource) {
        super(resource, initialLocation, size);
    }
}
