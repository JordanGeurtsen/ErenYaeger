package game.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import game.Screen;
import game.entities.buttons.QuitButton;
import game.BonkTheTowerTD;
import game.entities.buttons.SceneSwitchButton;

import static game.Screen.MAP_CHOOSER;

public class TitleScreen extends StaticScene implements TileMapContainer {
    private BonkTheTowerTD bonkTheTowerTD;
    private int newScene = 1;


    public TitleScreen(BonkTheTowerTD bonkTheTowerTD) {
        this.bonkTheTowerTD = bonkTheTowerTD;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/bonk_the_tower_titlescreen.jpg");
    }

    @Override
    public void setupEntities() {
        var startButton = new SceneSwitchButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 2), this.bonkTheTowerTD, newScene, "Play Game");
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
