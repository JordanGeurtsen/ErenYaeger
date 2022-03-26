package game.scenes;

import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import game.BonkTheTowerTD;
import game.entities.tilemap.LevelChooserTileMap;

public class MapSelector extends StaticScene implements TileMapContainer {
    private BonkTheTowerTD bonkTheTowerTD;
    private LevelChooserTileMap mapOne = new LevelChooserTileMap(bonkTheTowerTD, "backgrounds/maps/map_one.jpg", );
    private LevelChooserTileMap mapTwo = new LevelChooserTileMap(bonkTheTowerTD, "backgrounds/maps/map_two.jpg");
    private LevelChooserTileMap mapThree = new LevelChooserTileMap(bonkTheTowerTD, "backgrounds/maps/map_three.jpg");

    public MapSelector(BonkTheTowerTD bonkTheTowerTD) {
        this.bonkTheTowerTD = bonkTheTowerTD;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/base_background.jpg");
    }

    @Override
    public void setupEntities() {
//        var map1 = new SceneSwitchButton(
//                new Coordinate2D(getWidth() / bonkTheTowerTD.buttonWidthLeft, getHeight() / bonkTheTowerTD.buttonHeightBelowCenter), this.bonkTheTowerTD, 2, "Map 1");
//        map1.setAnchorPoint(AnchorPoint.CENTER_RIGHT);
//        addEntity(map1);
//
//        var map2 = new SceneSwitchButton(
//                new Coordinate2D(getWidth() / bonkTheTowerTD.buttonWidthCenter, getHeight() / bonkTheTowerTD.buttonHeightBelowCenter), this.bonkTheTowerTD, 3, "Map 2");
//        map2.setAnchorPoint(AnchorPoint.CENTER_CENTER);
//        addEntity(map2);
//
//        var map3 = new SceneSwitchButton(
//                new Coordinate2D(getWidth() / bonkTheTowerTD.buttonWidthRight, getHeight() / bonkTheTowerTD.buttonHeightBelowCenter), this.bonkTheTowerTD, 4, "Map 3");
//        map3.setAnchorPoint(AnchorPoint.CENTER_LEFT);
//        addEntity(map3);
    }

    @Override
    public void setupTileMaps() {
        addTileMap(mapOne);
        addTileMap(mapTwo);
        addTileMap(mapThree);
    }
}
