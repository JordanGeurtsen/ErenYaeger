package game.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import game.BonkTheTowerTD;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SceneSwitchButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private BonkTheTowerTD bonkTheTowerTD;
    private String buttonText;
    private int switchToScene;

    public SceneSwitchButton(Coordinate2D initialLocation, BonkTheTowerTD bonkTheTowerTD, int switchToScene, String buttonText) {
        super(initialLocation, buttonText);
        setFill(Color.PAPAYAWHIP);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        this.bonkTheTowerTD = bonkTheTowerTD;
        this.switchToScene = switchToScene;
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D){
        bonkTheTowerTD.setActiveScene(switchToScene);
    }

    @Override
    public void onMouseEntered(){
        setFill(Color.CORNFLOWERBLUE);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited(){
        setFill(Color.PAPAYAWHIP);
        setCursor(Cursor.DEFAULT);
    }
}
