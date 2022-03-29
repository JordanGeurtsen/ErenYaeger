package game.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import game.BonkTheTowerTD;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Optional;

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
