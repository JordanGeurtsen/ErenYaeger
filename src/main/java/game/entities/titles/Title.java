package game.entities.titles;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Title extends TextEntity {
    public Title(Coordinate2D initialLocation, String text) {
        super(initialLocation, text);
        setFill(Color.PAPAYAWHIP);
        setFont(Font.font("Roboto", FontWeight.BOLD, 50));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
}
