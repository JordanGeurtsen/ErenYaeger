package game.entities.tilemap;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.TileMap;
import game.BonkTheTowerTD;
import game.Screen;
import game.entities.buttons.ImageButton;
import game.entities.buttons.SceneSwitchButton;

public class LevelChooseTileMap extends TileMap {
    private BonkTheTowerTD bonkTheTowerTD;
    private String resource;

    public LevelChooseTileMap (BonkTheTowerTD bonkTheTowerTD, String resource){
        this.bonkTheTowerTD = bonkTheTowerTD;
        this.resource = resource;
    }

    @Override
    public void setupEntities() {
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(1, new ImageButton(resource,  , bonkTheTowerTD));
        addEntity(2, new SceneSwitchButton( ,bonkTheTowerTD , Screen.GAME, "Play Game"));
    }

    @Override
    public int[][] defineMap() {
        int[][] chooseMap = {
                {1},
                {2}
        };
        return chooseMap;
    }
}
