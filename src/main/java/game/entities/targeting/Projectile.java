package game.entities.targeting;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import game.entities.enemies.Enemy;
import game.entities.towers.Archer;
import game.entities.towers.Freezer;
import game.entities.towers.Tower;
import game.scenes.GameScreen;

import java.util.ArrayList;

public class Projectile extends DynamicSpriteEntity implements Collided, SceneBorderCrossingWatcher {
    private GameScreen gameScreen;
    private ArrayList<Enemy> enemyList;
    private Tower shootingTower;

    public Projectile(String resource, Coordinate2D initialLocation, GameScreen gameScreen, Tower shootingTower, ArrayList<Enemy> enemyList) {
        super(resource, initialLocation);
        this.gameScreen = gameScreen;
        this.enemyList = enemyList;
    }

    @Override
    public void onCollision(Collider collidingObject) {
            if (collidingObject instanceof Enemy) {
                remove();
                if (shootingTower instanceof Archer) {
                    ((Enemy) collidingObject).setHealth(-shootingTower.getTowerDamage());
                } else if (shootingTower instanceof Freezer) {
                    ((Enemy) collidingObject).setMovementSpeed(1.0);
                }
               for (Enemy e : enemyList) {
                    if (e.getHealth() == 0) {
                        e.remove();
                        gameScreen.points += 10;
                        gameScreen.coins += 10;
                        enemyList.remove(e);
               }
            }
        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        switch (border) {
            case TOP, LEFT, RIGHT, BOTTOM -> remove();
        }
    }
}
