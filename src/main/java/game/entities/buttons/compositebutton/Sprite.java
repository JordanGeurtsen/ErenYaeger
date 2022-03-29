package game.entities.buttons.compositebutton;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Sprite extends SpriteEntity {
    protected Sprite(Coordinate2D initialLocation, String resource) {
        super(resource, initialLocation);
    }
}
