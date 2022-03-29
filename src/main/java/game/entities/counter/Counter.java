package game.entities.counter;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Counter extends TextEntity {
    public Counter(Coordinate2D initialLocation, double counterData, String text) {
        super(initialLocation, text + ": " + (int) counterData);
        setFont(Font.font("Roboto", FontWeight.BOLD, 25));
    }
}
