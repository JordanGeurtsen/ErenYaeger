package game.entities.buttons.compositebutton;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import game.BonkTheTowerTD;
import game.Round;
import game.Screenum;
import game.entities.buttons.TextButton;
import game.scenes.GameScreen;
import javafx.scene.paint.Color;

public class NextRoundButton extends TextButton {
    private Round newRound;
    private GameScreen gameScreen;

    public NextRoundButton(Coordinate2D initialLocation, GameScreen gameScreen) {
            super(initialLocation, "Next round");
            this.newRound = Round.ONE;
            this.gameScreen = gameScreen;
            setFill(Color.GREEN);
    }

    @Override
    public void onButtonClick() {
            if (gameScreen.enemyList.size() -1 == 0) {
                if (newRound.getId() < 4) {
                    newRound.setNextID();
                    gameScreen.currentRound = newRound.values()[newRound.getId()];
                    gameScreen.nextRound = true;
                    gameScreen.points += 100;
                } else {
                    gameScreen.gameOver();
                }
            }
//        }
    }
}
