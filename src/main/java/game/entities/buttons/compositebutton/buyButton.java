package game.entities.buttons.compositebutton;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import game.entities.buttons.compositebutton.CompositeButton;

public class buyButton extends CompositeButton {
    private String resource;
    private String towerName;
    private String price;
    private String damage;
    private String range;

    public buyButton(Coordinate2D initialLocation, String resource, String towerName, int price, int damage, int range) {
        super(initialLocation, resource);
        this.resource = resource;
        this.towerName = towerName;
        this.price = "Price =          " + price;
        this.damage = "Damage =     " + damage;
        this.range = "Range =        " + range;
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
               // "Archer Tower"
                towerName
        );
        addEntity(titleText);

        var priceText = new TextEntity(
                new Coordinate2D(90, 15),
               // "Price =        100 C"
               price
        );

        addEntity(priceText);

        var damageText = new TextEntity(
                new Coordinate2D(90, 25),
                //"Damage =   30 HP"
                damage
        );
        addEntity(damageText);

        var rangeText = new TextEntity(
                new Coordinate2D(90, 35),
                //"Range =       45 Px"
                range
        );
        addEntity(rangeText);
    }

    @Override
    public void onButtonClick() {
    }
}
