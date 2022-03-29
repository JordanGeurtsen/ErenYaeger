package game.entities.buttons.compositebutton;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import game.entities.buttons.compositebutton.CompositeButton;

public class buyButton extends CompositeButton {
    private String resource;

    public buyButton(Coordinate2D initialLocation, String resource) {
        super(initialLocation, resource);
        this.resource = resource;
    }

    @Override
    protected void setupEntities() {
        var image = new Sprite(
                new Coordinate2D(5, 0),
                resource
        );
        addEntity(image);

        var background = new Hitbox(
                new Coordinate2D(0, 0),
                new Size(188, 75)
        );
        addEntity(background);

        var titleText = new TextEntity(
                new Coordinate2D(90, 0),
                "Archer Tower"
        );
        addEntity(titleText);

        var priceText = new TextEntity(
                new Coordinate2D(90, 15),
                "Price =        100 C"
        );

        addEntity(priceText);

        var damageText = new TextEntity(
                new Coordinate2D(90, 25),
                "Damage =   30 HP"
        );
        addEntity(damageText);

        var rangeText = new TextEntity(
                new Coordinate2D(90, 35),
                "Range =       45 Px"
        );
        addEntity(rangeText);
    }

    @Override
    public void onButtonClick() {

    }
}
