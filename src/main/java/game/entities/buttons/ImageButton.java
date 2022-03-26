package game.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import game.BonkTheTowerTD;
import javafx.scene.input.MouseButton;

public class ImageButton extends SpriteEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private BonkTheTowerTD bonkTheTowerTD;
    private int newScene;

    public ImageButton(String resource, Coordinate2D initialLocation, BonkTheTowerTD bonkTheTowerTD, int newScene) {
        super(resource, initialLocation);
        this.bonkTheTowerTD = bonkTheTowerTD;
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        bonkTheTowerTD.setActiveScene(newScene);
    }

    @Override
    public void onMouseEntered() {
        //
    }

    @Override
    public void onMouseExited() {
        //
    }
}
