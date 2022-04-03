package game.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import game.BonkTheTowerTD;
import game.Screenum;
import game.entities.buttons.QuitButton;
import game.entities.buttons.SceneSwitchButton;
import game.entities.counter.Counter;
import game.entities.titles.Title;
import javafx.scene.paint.Color;

import static game.scenes.GameScreen.points;

public class FinalScreen extends DynamicScene{
    private BonkTheTowerTD bonkTheTowerTD;
    private static String finalMessage;

    public FinalScreen(BonkTheTowerTD bonkTheTowerTD) {
        this.bonkTheTowerTD = bonkTheTowerTD;
    }

    public static void setFinalMessage(String finalMessage) {
        FinalScreen.finalMessage = finalMessage;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/base_background.jpg");
    }

    @Override
    public void setupEntities() {
        var finalText = new Title(new Coordinate2D(getWidth() / 2.0, getHeight() / 3.5), finalMessage);
        addEntity(finalText);

        var pointsResult = new Counter(new Coordinate2D(getWidth() / 2, getHeight() / 2.7), points, "Points: ");
        pointsResult.setFill(Color.PAPAYAWHIP);
        pointsResult.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(pointsResult);

        var menuButton = new SceneSwitchButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 2.0), this.bonkTheTowerTD, Screenum.TITLE, "Main menu");
        addEntity(menuButton);

        var againButton = new SceneSwitchButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 1.7), this.bonkTheTowerTD, Screenum.GAME, "Play Again");
        addEntity(againButton);

        var bonkTheTowerQuit = new QuitButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 1.5), this.bonkTheTowerTD);
        addEntity(bonkTheTowerQuit);
    }
}
