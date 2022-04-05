package game.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import game.entities.buttons.compositebutton.CompositeButton;
import game.entities.buttons.compositebutton.Hitbox;
import game.entities.buttons.compositebutton.Sprite;
import game.scenes.GameScreen;

public class BuyButton extends CompositeButton {
    private String resource;
    private String towerName;
    private String price;
    private String damage;
    private String range;

    private GameScreen gameScreen;

    public static boolean isTowerSelected = false;
    public static boolean tileMapChanged = false;

    public static String currentTowerSelected = "";

    public BuyButton(Coordinate2D initialLocation, String resource, String towerName, int price, int damage, int range, GameScreen gameScreen) {
        super(initialLocation);
        this.resource = resource;
        this.gameScreen = gameScreen;
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
        if(currentTowerSelected == getBuyButtonTower()){
            this.isTowerSelected = false;
        } else {
            this.isTowerSelected = true;
            this.currentTowerSelected = getBuyButtonTower();
        }
        this.tileMapChanged = false;
    }

    public String getBuyButtonTower(){return towerName;}
}