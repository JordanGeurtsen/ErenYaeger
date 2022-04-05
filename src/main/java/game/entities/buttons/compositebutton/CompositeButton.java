package game.entities.buttons.compositebutton;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;
import game.entities.buttons.Button;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;

public abstract class CompositeButton extends CompositeEntity implements Button {
    public CompositeButton(Coordinate2D initialLocation) {
        super(initialLocation);
        setAnchorPoint(AnchorPoint.TOP_LEFT);
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        if(button == MouseButton.PRIMARY) {
            onButtonClick();
        }
    }

    @Override
    public void onMouseEntered() {
        setBrightness(0.5);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setBrightness(0);
        setCursor(Cursor.DEFAULT);
    }

    public abstract void onButtonClick();
}
