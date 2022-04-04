package game.entities.towers;

import com.github.hanyaeger.api.Coordinate2D;
import game.entities.enemies.Enemy;
import game.entities.targeting.BulletSpawner;
import game.entities.targeting.ProjectileSpawner;
import game.scenes.GameScreen;

public class Hitman extends Tower {
    private Coordinate2D initialLocation;
    private static int price = 250;
    private static double rangeRadius = 1250;
    private static double damage = 40;
    private BulletSpawner spawner;
    private GameScreen gameScreen;
    private Enemy target;

    public Hitman(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, gameScreen);
        this.initialLocation = initialLocation;
        this.gameScreen = gameScreen;
        this.spawner = new BulletSpawner(2500, getInitialLocation(), this, gameScreen);

    }

    @Override
    public double getTowerDamage() {
        return damage;
    }

    @Override
    public double getTowerRange() {
        return rangeRadius;
    }

    @Override
    public Coordinate2D getInitialLocation() {
        return initialLocation;
    }

    @Override
    public ProjectileSpawner getProjectileSpawner() {
        return spawner;
    }

    public static int getTowerPrice() {
        return price;
    }


    @Override
    public void explicitUpdate(long timestamp) {
        if (gameScreen.spawnedEnemyList.size() > 0) {
            for (Tower t : gameScreen.towers) {
                for (Enemy e : gameScreen.spawnedEnemyList) {
                    if (isInRange(getTowerRange(), e)) {
                        target = t.getTarget(gameScreen.spawnedEnemyList);
                        if (target != null) {
                            spawner.shoot(getShootAngle());
                        } else {
                            spawner.setNeedToShoot(true);
                        }
                    }
                }
            }
        }
    }
}
