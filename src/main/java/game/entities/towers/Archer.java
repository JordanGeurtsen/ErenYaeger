package game.entities.towers;

import com.github.hanyaeger.api.Coordinate2D;
import game.entities.enemies.Enemy;
import game.entities.targeting.ArrowSpawner;
import game.entities.targeting.ProjectileSpawner;
import game.scenes.gamescreen.GameScreen;

public class Archer extends Tower {
    private static final int price = 200;
    private static final double rangeRadius = 225;
    private static final double damage = 5;
    private final GameScreen gameScreen;
    private final Coordinate2D initialLocation;
    private final ArrowSpawner spawner;

    public Archer(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, gameScreen);
        this.initialLocation = initialLocation;
        this.gameScreen = gameScreen;
        int intervalInMs = 850;
        spawner = new ArrowSpawner(intervalInMs, getInitialLocation(), this, gameScreen);
    }

    public static int getTowerPrice() {return price;}

    @Override
    public double getTowerDamage() {return damage;}

    @Override
    public double getTowerRange() {return rangeRadius;}

    @Override
    public Coordinate2D getInitialLocation() {return initialLocation;}

    @Override
    public ProjectileSpawner getProjectileSpawner() {return spawner;}

    @Override
    public void explicitUpdate(long timestamp) {
        if (gameScreen.spawnedEnemyList.size() > 0) {
            for (Tower t : gameScreen.towers) {
                for (Enemy e: gameScreen.spawnedEnemyList) {
                    if (isInRange(getTowerRange(), e)) {
                        Enemy target = t.getTarget(gameScreen.spawnedEnemyList);
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