package game.entities.towers;

import com.github.hanyaeger.api.Coordinate2D;
import game.entities.enemies.Enemy;
import game.entities.targeting.ArrowSpawner;
import game.scenes.GameScreen;

public class Archer extends Tower {
    private double price = 100.0;
    private double rangeRadius = 600.0;
    private double damage = 10;
    private Coordinate2D initialLocation;
    private ArrowSpawner arrowSpawner;
    private GameScreen gameScreen;
    private Enemy target;

    public Archer(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, gameScreen);
        this.initialLocation = initialLocation;
        this.gameScreen = gameScreen;
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
    public void setupSpawner() {
        arrowSpawner = new ArrowSpawner(500, getInitialLocation(), this, gameScreen);
    }

    @Override
    public ArrowSpawner getSpawner(){
        return arrowSpawner;
    }

    @Override
    public void explicitUpdate(long timestamp) {
        if (timestamp % 1000 == 0) {
            if (gameScreen.enemyList.size() > 0) {
                for (Tower t : gameScreen.towers) {
                    if (t.isInRange(getTowerRange(), gameScreen.enemyList)) {
                        target = getTarget(getTowerRange(), gameScreen.enemyList);
                        arrowSpawner.setShootAngle((int) angleTo(target));
                        arrowSpawner.setNeedToShoot(true);
                    }
                }
            }
        }
    }
}