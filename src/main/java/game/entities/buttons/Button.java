package game.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public abstract class Button extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    public Button(Coordinate2D initialLocation, String buttonText) {
        super(initialLocation, buttonText);
    }
    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D){
    }

    @Override
    public void onMouseEntered(){

    }

    @Override
    public void onMouseExited(){

    }
}
