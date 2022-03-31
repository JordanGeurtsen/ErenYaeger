package game.entities.towers;

import com.github.hanyaeger.api.Coordinate2D;
import game.scenes.GameScreen;

public class Hitman extends Tower {
    private Coordinate2D initialLocation;
    private double price = 15.0;
    private double rangeRadius = 1000.0;
    private double damage = 10;

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
    public void setupSpawner() {

    }

}
