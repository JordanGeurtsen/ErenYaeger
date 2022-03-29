package game.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public abstract class TextButton extends TextEntity implements Button {

    public TextButton(Coordinate2D initialLocation, String text) {
        super(initialLocation, text);
        setFill(Color.PAPAYAWHIP);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        if(button == MouseButton.PRIMARY) {
            onButtonClick();
        }
    }

    public abstract void onButtonClick();

    @Override
    public void onMouseEntered() {
        setBrightness(0.8);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setBrightness(0);
        setCursor(Cursor.DEFAULT);
    }
}