package game.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.EntitySpawner;
import game.PathStep;
import game.scenes.GameScreen;
import javafx.animation.ParallelTransition;

public class BabyCootSpawner extends EntitySpawner {
    private Coordinate2D initialLocation;
    private GameScreen gameScreen;
    private Enemy mamaCoot;
    private boolean needToSpawn = false;

    protected BabyCootSpawner(long intervalInMs, Coordinate2D initialLocation, GameScreen gameScreen, Enemy mamaCoot) {
        super(intervalInMs);
        this.initialLocation = initialLocation;
        this.gameScreen = gameScreen;
        this.mamaCoot = mamaCoot;
    }

    @Override
    protected void spawnEntities() {
        if (needToSpawn) {
            initialLocation = mamaCoot.getAnchorLocation();
            BabyCoot newBabyCoot = new BabyCoot("sprites/enemies/baby_coot.png", initialLocation, gameScreen);
            newBabyCoot.setPathStep(mamaCoot.getPathStep());
            newBabyCoot.setMapProgress(mamaCoot.getMapProgress());
            spawn(newBabyCoot);
            gameScreen.enemyList.add(newBabyCoot);
            gameScreen.spawnedEnemyList.add(newBabyCoot);
        }
    }

    public void setNeedToSpawn(boolean state){
        this.needToSpawn = state;
    }
}
