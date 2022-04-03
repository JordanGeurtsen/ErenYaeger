package game.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import game.Round;
import game.RoundExecutor;
import game.scenes.GameScreen;

public class EnemySpawner extends RoundExecutor {
    private GameScreen gameScreen;

    public EnemySpawner(long intervalInMs, Round round, GameScreen gameScreen) {
        super(intervalInMs, gameScreen, round);
        this.gameScreen = gameScreen;
    }

    @Override
    protected void spawnEntities() {
        for (int i = 0; i < 1; i++) {
            for (Enemy e : gameScreen.enemyList) {
                spawn(e);
            }
        }
    }
}