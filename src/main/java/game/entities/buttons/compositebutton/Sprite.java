package game.entities.buttons.compositebutton;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Sprite extends SpriteEntity {
    public Sprite(Coordinate2D initialLocation, String resource, Size size) {
        super(resource, initialLocation, size);
    }
}
