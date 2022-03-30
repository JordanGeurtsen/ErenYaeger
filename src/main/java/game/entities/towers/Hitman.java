package game.entities.towers;

import com.github.hanyaeger.api.Coordinate2D;
import game.scenes.GameScreen;

public class Hitman extends Tower {
    private double price = 150.0;
    private int rangeRadius = 10000;
    private int cooldown = 5;
    private int damage = 300;
    private Coordinate2D initialLocation;

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

}
