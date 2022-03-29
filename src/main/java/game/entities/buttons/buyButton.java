package game.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import game.entities.buttons.compositebutton.CompositeButton;

public class buyButton extends CompositeButton {
    public buyButton(Coordinate2D initialLocation, Size size, String details) {
        super(initialLocation, size, details);
    }

    @Override
    public void onButtonClick() {

    }
}
