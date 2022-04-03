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
        setBackgroundImage("backgrounds/base_background.jpg");
    }

    @Override
    public void setupEntities() {
        var menuButton = new SceneSwitchButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 2.0), this.bonkTheTowerTD, Screenum.TITLE, "Main menu");
        menuButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(menuButton);

        var againButton = new SceneSwitchButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 1.7), this.bonkTheTowerTD, Screenum.GAME, "Play Again");
        againButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(againButton);

        var bonkTheTowerQuit = new QuitButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 1.5), this.bonkTheTowerTD);
        bonkTheTowerQuit.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(bonkTheTowerQuit);
    }

    @Override
    public void setupTileMaps() {

    }
}
