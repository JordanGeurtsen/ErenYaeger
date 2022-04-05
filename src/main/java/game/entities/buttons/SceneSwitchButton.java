package game.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import game.BonkTheTowerTD;
import game.Screenum;

public class SceneSwitchButton extends TextButton {
    private final BonkTheTowerTD bonkTheTowerTD;
    private final int goToScene;

    public SceneSwitchButton(Coordinate2D initialLocation, BonkTheTowerTD bonkTheTowerTD, Screenum newScene, String buttonText) {
        super(initialLocation, buttonText);
        this.bonkTheTowerTD = bonkTheTowerTD;
        goToScene = newScene.getId();
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void onButtonClick() {
        bonkTheTowerTD.setActiveScene(goToScene);
    }
}