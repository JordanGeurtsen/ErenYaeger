package game.entities.tilemap;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.scenes.TileMap;
import game.BonkTheTowerTD;
import game.Screen;
import game.entities.ImageDisplayer;
import game.entities.buttons.SceneSwitchButton;

public class LevelChooserTileMap extends TileMap {
    private BonkTheTowerTD bonkTheTowerTD;
    private String resource;

    public LevelChooserTileMap (BonkTheTowerTD bonkTheTowerTD, String resource){
        this.bonkTheTowerTD = bonkTheTowerTD;
        this.resource = resource;
    }

    @Override
    public void setupEntities() {
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(1, new ImageDisplayer(resource,  , bonkTheTowerTD));
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
