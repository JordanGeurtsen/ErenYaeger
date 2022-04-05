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
import game.entities.enemies.MovementSpeed;
import game.entities.towers.Archer;
import game.entities.towers.Freezer;
import game.entities.towers.Hitman;
import game.entities.towers.Tower;
import game.scenes.GameScreen;

import static game.scenes.GameScreen.coins;
import static game.scenes.GameScreen.points;

public class Projectile extends DynamicSpriteEntity implements Collided, SceneBorderCrossingWatcher {
    private GameScreen gameScreen;
    private Tower shootingTower;
    private int coinReward = 20;
    private int pointReward = 25;

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
            if (shootingTower instanceof Archer) {
                ((Enemy) collidingObject).setHealth(-shootingTower.getTowerDamage());
            } else if (shootingTower instanceof Hitman) {
                ((Enemy) collidingObject).setHealth(-shootingTower.getTowerDamage());
            }

                if (((Enemy) collidingObject).getHealth() <= 0) {
                    if (collidingObject instanceof MamaCoot){
                        ((Enemy)collidingObject).getBabyCootSpawner().remove();
                    }
                    gameScreen.spawnedEnemyList.remove((Enemy) collidingObject);
                    gameScreen.enemyList.remove((Enemy) collidingObject);
                    gameScreen.coinCounter.setCounterText("Coins: ", coinReward);
                    gameScreen.pointCounter.setCounterText("Points: ", pointReward);
                    ((Enemy) collidingObject).remove();
                }
                remove();
            }
//        }
    }
}
