package game;

import com.github.hanyaeger.api.entities.EntitySpawner;
import game.entities.enemies.Enemy;

import java.util.ArrayList;

public class EnemySpawner extends EntitySpawner {
    private Enemy enemyToSpawn;
    private final ArrayList<Enemy> newEnemies;

    public EnemySpawner(long intervalInMs, ArrayList<Enemy> newEnemies) {
        super(intervalInMs);
        this.newEnemies = newEnemies;    }

    @Override
    protected void spawnEntities() {
            spawn(getSpawnEnemy(newEnemies));
    }

    public Enemy getSpawnEnemy(ArrayList<Enemy> newEnemies){
        for (int i = newEnemies.size(); i > 0; i--) {
            enemyToSpawn = newEnemies.get(i);
            newEnemies.remove(i);
        }
        return enemyToSpawn;
    }
}
