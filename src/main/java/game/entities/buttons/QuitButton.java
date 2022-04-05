package game.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import game.BonkTheTowerTD;

public class QuitButton extends TextButton {
    private BonkTheTowerTD bonkTheTowerTD;

    public QuitButton(Coordinate2D initialLocation, BonkTheTowerTD bonkTheTowerTD) {
        super(initialLocation, "Quit Game");
        this.bonkTheTowerTD = bonkTheTowerTD;
    }

    @Override
    public void onButtonClick() {
        bonkTheTowerTD.quit();
    }
}
