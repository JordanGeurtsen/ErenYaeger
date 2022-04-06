package game.entities.targeting;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import game.entities.enemies.Enemy;
import game.entities.enemies.MamaCoot;
import game.entities.towers.Archer;
import game.entities.towers.Hitman;
import game.entities.towers.Tower;
import game.scenes.gamescreen.GameScreen;

import static game.scenes.gamescreen.GameScreen.points;

public abstract class Projectile extends DynamicSpriteEntity implements Collided, SceneBorderCrossingWatcher {
    private final GameScreen gameScreen;
    private final Tower shootingTower;

    public Projectile(String resource, Coordinate2D initialLocation, GameScreen gameScreen, Tower shootingTower, Size size) {
        super(resource, initialLocation, size);
        this.shootingTower = shootingTower;
        this.gameScreen = gameScreen;
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        remove();
    }

    @Override
    public void onCollision(Collider collidingObject) {
        if (collidingObject instanceof Enemy) {
            if (shootingTower instanceof Archer || shootingTower instanceof Hitman) {
                ((Enemy) collidingObject).setHealth(-shootingTower.getTowerDamage());
            }
                if (((Enemy) collidingObject).getHealth() <= 0) {
                    if (collidingObject instanceof MamaCoot){
                        ((MamaCoot) collidingObject).getBabyCootSpawner().remove();
                    }
                    gameScreen.spawnedEnemyList.remove((Enemy) collidingObject);
                    gameScreen.enemyList.remove((Enemy) collidingObject);
                    int coinReward = 20;
                    gameScreen.coins += coinReward;
                    gameScreen.coinCounter.updateCounter("Coins: ", coinReward);
                    int pointReward = 25;
                    points += pointReward;
                    gameScreen.pointCounter.updateCounter("Points: ", pointReward);
                    ((Enemy) collidingObject).remove();
                }
                remove();
            }
//        }
    }
}
