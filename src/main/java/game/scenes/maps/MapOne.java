package game.scenes.maps;

import com.github.hanyaeger.api.scenes.DynamicScene;
import game.BonkTheTowerTD;

public class MapOne extends DynamicScene {
    private BonkTheTowerTD bonkTheTowerTD;

    public MapOne (BonkTheTowerTD bonkTheTowerTD){
        this.bonkTheTowerTD = bonkTheTowerTD;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/map_1_with_shop.jpg");
    }

    @Override
    public void setupEntities() {
 // bonkerdebonk
    }
}
