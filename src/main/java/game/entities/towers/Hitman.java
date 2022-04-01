package game.entities.towers;

import com.github.hanyaeger.api.Coordinate2D;
import game.entities.targeting.ProjectileSpawner;
import game.scenes.GameScreen;

public class Hitman extends Tower {
    private Coordinate2D initialLocation;
    private static double price = 15.0;
    private static double rangeRadius = 1250;
    private static double damage = 10;
    private ProjectileSpawner spawner;

    public Hitman(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, gameScreen);
        this.initialLocation = initialLocation;
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

    }
}
