package game.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import game.BonkTheTowerTD;
import game.entities.buttons.QuitButton;
import game.entities.buttons.SceneSwitchButton;

public class TitleScreen extends DynamicScene implements TileMapContainer {
    private final BonkTheTowerTD bonkTheTowerTD;

    public TitleScreen(BonkTheTowerTD bonkTheTowerTD) {
        this.bonkTheTowerTD = bonkTheTowerTD;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/bonk_the_tower_titlescreen.jpg");
    }

    @Override
    public void setupEntities() {
        int newScene = 1;
        var startButton = new SceneSwitchButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 1.8), this.bonkTheTowerTD, newScene, "Play Game");
        startButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(startButton);

        var bonkTheTowerQuit = new QuitButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 1.5), this.bonkTheTowerTD);
        bonkTheTowerQuit.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(bonkTheTowerQuit);
    }

    @Override
    public void setupTileMaps() {

    }
}
