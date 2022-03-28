package game.scenes;


import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;

import game.BonkTheTowerTD;

public class GameScreen extends DynamicScene implements TileMapContainer {

    private BonkTheTowerTD bonkTheTowerTD;

    public GameScreen(BonkTheTowerTD bonkTheTowerTD) {
    this.bonkTheTowerTD = bonkTheTowerTD;
    }

    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
    }

    @Override
    public void setupTileMaps() {

    }
}
