package game.entities.tilemap;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.scenes.TileMap;
import game.BonkTheTowerTD;
import game.Screen;
import game.entities.buttons.SceneSwitchButton;

public class LevelChooserTileMap extends TileMap {
    private BonkTheTowerTD bonkTheTowerTD;
    private String resource;
    private String levelText;

    public LevelChooserTileMap (BonkTheTowerTD bonkTheTowerTD, String resource, String levelText){
        this.bonkTheTowerTD = bonkTheTowerTD;
        this.resource = resource;
        this.levelText = levelText;
    }

    @Override
    public void setupEntities() {
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(1, ImageDisplayer.class, resource);
        addEntity(2, SceneSwitchButton.class, bonkTheTowerTD, Screen.GAME, levelText);
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
