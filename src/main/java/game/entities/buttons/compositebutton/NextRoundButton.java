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
//    private BonkTheTowerTD bonkTheTowerTD;
    private Round newRound;
    private GameScreen gameScreen;
//    private int goToScene;

    public NextRoundButton(Coordinate2D initialLocation, GameScreen gameScreen) {
            super(initialLocation, "Next round");
//            setAnchorPoint(AnchorPoint.CENTER_CENTER);
            this.newRound = Round.ONE;
            this.gameScreen = gameScreen;
            setFill(Color.GREEN);
//            goToScene = newRound.getId()
//            this.bonkTheTowerTD = bonkTheTowerTD;
    }

    @Override
    public void onButtonClick() {
        System.out.println(gameScreen.enemyList.size());
//        if(gameScreen.nextRound) {
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
