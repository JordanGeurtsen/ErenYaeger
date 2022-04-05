package game.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import game.Round;
import game.scenes.GameScreen;
import javafx.scene.paint.Color;

public class NextRoundButton extends TextButton {
    private final Round newRound;
    private final GameScreen gameScreen;

    public NextRoundButton(Coordinate2D initialLocation, GameScreen gameScreen) {
            super(initialLocation, "Next round");
            this.newRound = Round.ONE;
            this.gameScreen = gameScreen;
            setFill(Color.GREEN);
    }

    @Override
    public void onButtonClick() {
            if (gameScreen.enemyList.size() -1 == 0) {
                setFill(Color.GREEN);
                if (newRound.getId() < 4) {
                    newRound.setNextID();
                    gameScreen.currentRound = Round.values()[newRound.getId()];
                    gameScreen.nextRound = true;
                    GameScreen.points += 100;
                } else {
                    gameScreen.gameOver();
                }
            }
    }
}
