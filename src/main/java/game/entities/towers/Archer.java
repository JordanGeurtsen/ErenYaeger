package game.entities.towers;

import com.github.hanyaeger.api.Coordinate2D;
import game.entities.enemies.Enemy;
import game.entities.targeting.ArrowSpawner;
import game.entities.targeting.ProjectileSpawner;
import game.scenes.GameScreen;

public class Archer extends Tower {
    private double price = 100.0;
    private double rangeRadius = 300.0;
    private double damage = 10;
    private Coordinate2D initialLocation;
    private ArrowSpawner spawner;
    private GameScreen gameScreen;
    private Enemy target;

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

    @Override
    public double getTowerPrice() {
        return price;
    }

    @Override
    public Coordinate2D getInitialLocation() {
        return initialLocation;
    }

    @Override
    public ProjectileSpawner getSpawner() {
        return spawner;
    }

    @Override
    public void explicitUpdate(long timestamp) {
            if (gameScreen.enemyList.size() > 0) {
                for (Tower t : gameScreen.towers) {
                    if (t.isInRange(t.getTowerRange(), gameScreen.enemyList)) {
                        target = t.getTarget(getTowerRange(), gameScreen.enemyList);
                        System.out.println(target);
                        spawner.setShootAngle((int) angleTo(target));
                        spawner.setNeedToShoot(true);
//                        t.inRange = false;
                    }
            }
        }
    }
}