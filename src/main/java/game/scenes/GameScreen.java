package game.scenes;


import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;

import game.entities.buttons.buyButton;
import game.entities.tilemap.LevelTileMap;
import game.entities.tilemap.ShopTileMap;
import game.entities.towers.Archer;
import game.entities.towers.Tower;

import game.BonkTheTowerTD;

public class GameScreen extends DynamicScene implements TileMapContainer {

    public GameScreen(BonkTheTowerTD bonkTheTowerTD) {
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/relaxing_bg_music_2.mp3");
        setBackgroundAudioVolume(0.1);
    }

    @Override
    public void setupEntities() {
        var archerBuy = new buyButton(new Coordinate2D(1038, 75), new Size(75, 75), "sprites/towers/archer_logo.png");
        addEntity(archerBuy);
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new LevelTileMap());
//        addTileMap(new ShopTileMap());
    }
}
