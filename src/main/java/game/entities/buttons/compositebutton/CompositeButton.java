package game.entities.buttons.compositebutton;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import game.entities.buttons.Button;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;

public abstract class CompositeButton extends CompositeEntity implements Button {
    String details;

    public CompositeButton(Coordinate2D initialLocation, Size size, String details) {
        super(initialLocation);
        this.details = details;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    protected void setupEntities() {
        var image = new Sprite(
                new Coordinate2D(0, 0),
                details
        );
        addEntity(image);

        var titleText = new TextEntity(
                new Coordinate2D(10, 0),
                "Price= koet"
        );
        addEntity(titleText);

        var priceText = new TextEntity(
                new Coordinate2D(10, 25),
                "Price= koet"
        );

        addEntity(priceText);

        var damageText = new TextEntity(
                new Coordinate2D(10, 15),
                "Price= koet"
        );
        addEntity(damageText);

        var rangeText = new TextEntity(
                new Coordinate2D(10, 35),
                "Price= koet"
        );
        addEntity(rangeText);
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        if(button == MouseButton.PRIMARY) {
            onButtonClick();
        }
    }

    public abstract void onButtonClick();

    @Override
    public void onMouseEntered() {
        setBrightness(0.8);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setBrightness(0);
        setCursor(Cursor.DEFAULT);
    }
}
