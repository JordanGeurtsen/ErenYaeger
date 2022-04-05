package game.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import game.entities.buttons.compositebutton.CompositeButton;
import game.entities.buttons.compositebutton.Hitbox;
import game.entities.buttons.compositebutton.Sprite;

import java.util.Objects;

public class BuyButton extends CompositeButton {
    private final String resource;
    private final String towerName;
    private final String price;
    private final String damage;
    private final String range;

    public static boolean isTowerSelected = false;
    public static boolean tileMapChanged = false;
    public static String currentTowerSelected = "";

    public BuyButton(Coordinate2D initialLocation, String resource, String towerName, int price, int damage, int range) {
        super(initialLocation);
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
                resource, new Size(75)
        );
        addEntity(image);

        var background = new Hitbox(
                new Coordinate2D(0, 0),
                new Size(188, 75)
        );
        addEntity(background);

        var titleText = new TextEntity(
                new Coordinate2D(90, 0),
                towerName
        );
        addEntity(titleText);

        var priceText = new TextEntity(
                new Coordinate2D(90, 15),
                price
        );

        addEntity(priceText);

        var damageText = new TextEntity(
                new Coordinate2D(90, 25),
                damage
        );
        addEntity(damageText);

        var rangeText = new TextEntity(
                new Coordinate2D(90, 35),
                range
        );
        addEntity(rangeText);
    }

    @Override
    public void onButtonClick() {
        if(Objects.equals(currentTowerSelected, getBuyButtonTower())){
            isTowerSelected = false;
        } else {
            isTowerSelected = true;
            currentTowerSelected = getBuyButtonTower();
        }
        tileMapChanged = false;
    }

    public String getBuyButtonTower(){return towerName;}
}