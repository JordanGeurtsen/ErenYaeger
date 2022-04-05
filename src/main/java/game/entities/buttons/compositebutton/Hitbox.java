package game.entities.buttons.compositebutton;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class Hitbox extends RectangleEntity {
    public Hitbox(Coordinate2D initialLocation, Size size) {
        super(initialLocation, size);
        setFill(Color.TRANSPARENT);
    }
}
