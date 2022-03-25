package game.scenes.maps;

import com.github.hanyaeger.api.scenes.StaticScene;
import game.BonkTheTowerTD;

public class MapOne extends StaticScene {
    private BonkTheTowerTD bonkTheTowerTD;

    public MapOne (BonkTheTowerTD bonkTheTowerTD){
        this.bonkTheTowerTD = bonkTheTowerTD;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/maps/map_1_with_shop.jpg");
    }

    @Override
    public void setupEntities() {
    }

}
