package game.scenes;

import com.github.hanyaeger.api.scenes.DynamicScene;
import game.BonkTheTowerTD;

public class GameScreen extends DynamicScene {
    private BonkTheTowerTD bonkTheTowerTD;

    public GameScreen (BonkTheTowerTD bonkTheTowerTD) {
    this.bonkTheTowerTD = bonkTheTowerTD;
    }

    @Override
    public void setupScene() {
    }

    @Override
    public void setupEntities() {

    }
}
