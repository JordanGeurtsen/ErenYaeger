package game.entities.tilemap.shop;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class shopFiller extends SpriteEntity {
    public shopFiller(Coordinate2D initialLocation, Size size, String resource) {
        super(resource, initialLocation, size);
    }
}
