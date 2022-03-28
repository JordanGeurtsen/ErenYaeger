package game.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import game.BonkTheTowerTD;
import game.Screen;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SceneSwitchButton extends Button {
    private BonkTheTowerTD bonkTheTowerTD;
    private int newScene;

    public SceneSwitchButton(Coordinate2D initialLocation, BonkTheTowerTD bonkTheTowerTD, int newScene, String buttonText) {
        super(initialLocation, buttonText);
        setFill(Color.PAPAYAWHIP);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        this.bonkTheTowerTD = bonkTheTowerTD;
        this.newScene = newScene;
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D){
        bonkTheTowerTD.setActiveScene(newScene);
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
