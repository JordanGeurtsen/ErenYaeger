package game.entities.buttons.compositebutton;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import game.entities.buttons.Button;
import game.scenes.GameScreen;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class PauseButton extends CompositeEntity implements Button {
    private GameScreen gameScreen;
    private String resource;
    private Hitbox background;
    private TextEntity pauseText;
    private TextEntity replayText;
    private TextEntity quitText;



    public PauseButton(Coordinate2D initialLocation, String resource, GameScreen gameScreen) {
        super(initialLocation);
        this.resource = resource;
        this.gameScreen = gameScreen;
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        if(button == MouseButton.PRIMARY) {
            onButtonClick();
        }
    }

    public void onButtonClick() {
        if(!gameScreen.screenPaused) {
            background = new Hitbox(new Coordinate2D(0, 0), new Size(1238, 675));
            background.setFill(Color.BLACK);
            background.setOpacity(0.7);
            addEntity(background);
            gameScreen.screenPaused = !gameScreen.screenPaused;
            pauseText.setOpacity(1.0);
            replayText.setOpacity(1.0);
            gameScreen.pause();
        } else{
            background.remove();
            gameScreen.screenPaused = !gameScreen.screenPaused;
            pauseText.setOpacity(0.0);
            replayText.setOpacity(0.0);
            gameScreen.resume();
        }
    }

    @Override
    protected void setupEntities() {
        var image = new Sprite(
                new Coordinate2D(7, 7),
                resource, new Size(51)
        );
        addEntity(image);

        background = new Hitbox(
                new Coordinate2D(getSceneHeight() / 2 - 200, getSceneWidth() / 2 - 200),
                new Size(300, 300)
        );
        background = new Hitbox(
            new Coordinate2D(0, 0), new Size(1238, 675)
        );
        if(gameScreen.screenPaused) {
            background.setFill(Color.BLACK);
            background.setOpacity(0.8);
            addEntity(background);
        }

        var hitbox = new Hitbox(
                new Coordinate2D(0, 0), new Size(75, 75)
        );

        addEntity(hitbox);

        pauseText = new TextEntity(
                new Coordinate2D(1238 / 2, 675 / 5 * 2 ),
                "PAUSE"
        );
        addEntity(pauseText);

        replayText = new TextEntity(
                new Coordinate2D(1238 / 3, 675 / 5 * 3 ),
                "REPLAY"
        );
        addEntity(replayText);

        pauseText.setOpacity(0.0);
        replayText.setOpacity(0.0);
    }

    @Override
    public void onMouseEntered() {
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setCursor(Cursor.DEFAULT);
    }

}
