package game.entities.towers;

import com.github.hanyaeger.api.Coordinate2D;
import game.entities.targeting.ArrowSpawner;
import game.scenes.GameScreen;

public class Archer extends Tower {
    private double price = 100.0;
    private double rangeRadius = 9000.00;
    private double damage = 10;
    private Coordinate2D initialLocation;
    private ArrowSpawner arrowSpawner;

    public Archer(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
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
    public void setupSpawner() {
        arrowSpawner = new ArrowSpawner(500, getInitialLocation(),gameScreen);

    }
}