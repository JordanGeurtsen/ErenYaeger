package game.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import game.BonkTheTowerTD;
import game.Screenum;
import game.entities.buttons.QuitButton;
import game.entities.buttons.SceneSwitchButton;
import javafx.scene.paint.Color;

public class FinalScreen extends DynamicScene implements TileMapContainer {
    BonkTheTowerTD bonkTheTowerTD;

    public FinalScreen(BonkTheTowerTD bonkTheTowerTD) {
        this.bonkTheTowerTD = bonkTheTowerTD;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.PAPAYAWHIP);
    }

    @Override
    public void setupEntities() {
        Screenum newScene = Screenum.GAME;
        var startButton = new SceneSwitchButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 1.8), this.bonkTheTowerTD, Screenum.GAME, "Play Again");
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
