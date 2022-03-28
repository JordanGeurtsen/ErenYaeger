package game.entities.targeting;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Targeting extends DynamicSpriteEntity {
    protected Targeting(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }
}
