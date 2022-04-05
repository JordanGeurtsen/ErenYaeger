package game.entities.counter;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Counter extends DynamicTextEntity {
    double counterData;

    public Counter(Coordinate2D initialLocation, int counterData, String text) {
        super(initialLocation, text + "" + counterData);
        this.counterData = counterData;
        setFont(Font.font("Roboto", FontWeight.BOLD, 25));
    }

    public void setCounterText(String text, int points){
        setText(text + points);
    }
}
