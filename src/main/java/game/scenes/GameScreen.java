package game.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import game.entities.towers.Archer;
import game.entities.towers.Tower;

import java.util.ArrayList;
import game.BonkTheTowerTD;

public class GameScreen extends DynamicScene {
    ArrayList<Tower> towers = new ArrayList<Tower>();

    private BonkTheTowerTD bonkTheTowerTD;

    public GameScreen(BonkTheTowerTD bonkTheTowerTD) {
    this.bonkTheTowerTD = bonkTheTowerTD;
    }

    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        var archer = new Archer("sprites/mama_coot.png", new Coordinate2D(100, 100));
        addEntity(archer);
        towers.add(archer);

        for(Tower t : towers){
            if(t.isInRange(t.getTowerRange(), enemyList)){
                var weapon = t.attackForm();

            }
        }
    }
}
