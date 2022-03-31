package game.entities.towers;


import com.github.hanyaeger.api.Coordinate2D;
import game.scenes.GameScreen;

public class Freezer extends Tower{
    private double price = 200.0;
    private double rangeRadius = 150;
    private double damage = 20;
    private Coordinate2D initialLocation;

    public Freezer(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, gameScreen);
        this.initialLocation = initialLocation;
    }

    @Override
    public double getTowerDamage() {
        return damage;
    }

    @Override
    public double getTowerRange() {return rangeRadius; }

    @Override
    public double getTowerPrice() {
        return price;}

    @Override
    public Coordinate2D getInitialLocation() {
        return initialLocation;
    }

    @Override
    public void setupSpawner() {

    }
}
