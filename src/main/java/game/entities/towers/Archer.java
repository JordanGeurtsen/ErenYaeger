package game.entities.towers;

import com.github.hanyaeger.api.Coordinate2D;
import game.entities.enemies.Enemy;
import game.entities.targeting.ArrowSpawner;
import game.entities.targeting.ProjectileSpawner;
import game.scenes.GameScreen;

import java.util.ArrayList;

public class Archer extends Tower {
    private static int price = 100;
    private static double rangeRadius = 225;
    private static double damage = 10;
    private Coordinate2D initialLocation;
    private ArrowSpawner spawner;
    private GameScreen gameScreen;
    private Enemy target;
    private ArrayList<Enemy> enemiesInRange = new ArrayList<>();

    public Archer(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, gameScreen);
        this.initialLocation = initialLocation;
        this.gameScreen = gameScreen;
        spawner = new ArrowSpawner(500, getInitialLocation(), this, gameScreen);
    }

    @Override
    public double getTowerDamage() {
        return damage;
    }

    @Override
    public double getTowerRange() {
        return rangeRadius;
    }

//    @Override
    public static int getTowerPrice() {
        return price;
    }

    @Override
    public Coordinate2D getInitialLocation() {
        return initialLocation;
    }

    @Override
    public ProjectileSpawner getProjectileSpawner() {
        return spawner;
    }

    @Override
    public void explicitUpdate(long timestamp) {
        if (gameScreen.enemyList.size() > 0) {
            for (Tower t : gameScreen.towers) {
                    target = t.getTarget(gameScreen.enemyList);
                System.out.println(target + "" + target.getInitialLocation());
                    if (target != null) {
                        spawner.shoot(getShootAngle());
                    } else {
                        spawner.setNeedToShoot(false);
                    }
            }
        }
    }
}