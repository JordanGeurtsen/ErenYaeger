package game.entities.tilemap;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.TileMap;
import game.entities.buttons.compositebutton.buyButton;
import game.entities.tilemap.shop.shopFiller;

public class ShopTileMap extends TileMap {
    private String[] archerDetails = {"sprites/archer_logo.png", "Archer", "Price: 100", "Damage: 30", "Range: 75"};
    private String[] hitmanDetails = {"sprites/hitman_logo.png", "Hitman", "Price: 200", "Damage: 45", "Range: 1000"};
    private String[] freezerDetails = {"sprites/freezer_logo.png", "Freezer", "Price: 75", "Damage: 30", "Range: 40"};

    private int[][] shopMap = {
            {1},        //later naar 2 veranderen (de counters)
            {1},
            {3},
            {1},
            {4},
            {1},
            {5},
            {1},
            {6}
    };

    public ShopTileMap (){
        super(new Coordinate2D(1038,0), new Size(200, 675));
    }

    @Override
    public void setupEntities() {
        addEntity(1, shopFiller.class, "sprites/shop_filler.png");
//        addEntity(2, gameCounter.class);
        addEntity(3, buyButton.class, "sprites/archer_logo.png");
        addEntity(4, buyButton.class, "sprites/hitman_logo.png");
        addEntity(5, buyButton.class, "sprites/freezer_logo.png");
    }

    @Override
    public int[][] defineMap() {
        return shopMap;
    }
}
