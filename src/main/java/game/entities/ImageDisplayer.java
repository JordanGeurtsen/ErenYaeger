package game.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import game.BonkTheTowerTD;
import javafx.scene.input.MouseButton;

public class ImageDisplayer extends SpriteEntity {
    private BonkTheTowerTD bonkTheTowerTD;
    private int newScene;

    public ImageDisplayer(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }
}
