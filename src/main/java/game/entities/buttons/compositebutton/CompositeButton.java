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
        setAnchorPoint(AnchorPoint.CENTER_LEFT);
    }

    @Override
    protected void setupEntities() {
        var image = new Sprite(
                new Coordinate2D(0, 0),
                details
        );
        addEntity(image);

        var titleText = new TextEntity(
                new Coordinate2D(85, 0),
                "Archer Tower"
        );
        addEntity(titleText);

        var priceText = new TextEntity(
                new Coordinate2D(85, 25),
                "Price= 100 G"
        );

        addEntity(priceText);

        var damageText = new TextEntity(
                new Coordinate2D(85, 15),
                "Damage= 30 HP"
        );
        addEntity(damageText);

        var rangeText = new TextEntity(
                new Coordinate2D(85, 35),
                "Range= 45"
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
