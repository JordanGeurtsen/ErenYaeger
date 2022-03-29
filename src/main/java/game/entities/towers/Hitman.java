package game.entities.towers;

import com.github.hanyaeger.api.Coordinate2D;
import game.scenes.GameScreen;
import game.scenes.TitleScreen;

public class Hitman extends Tower {
    private double price = 150.0;
    private int rangeRadius = 10000;
    private int cooldown = 5;
    private int damage = 300;

    protected Hitman(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, gameScreen);
    }

    @Override
    public int getTowerDamage() {
        return damage;
    }

    @Override
    public int getTowerRange() {
        return rangeRadius;
    }

    @Override
    public double getTowerPrice() {
        return price;
    }

//    @Override
//    public void shoot() {
//
//    }
    @Override
    public Coordinate2D getInitialLocation() {
        return new Coordinate2D(0,0);
    }

}
