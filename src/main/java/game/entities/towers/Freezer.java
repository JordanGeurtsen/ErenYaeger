package game.entities.towers;


import com.github.hanyaeger.api.Coordinate2D;
import game.scenes.GameScreen;
import game.scenes.TitleScreen;

public class Freezer extends Tower{
    private double price = 200.0;
    private int rangeRadius = 250;
    private int cooldown = 3;
    private int damage = 20;

    public Freezer(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, gameScreen);
    }

    @Override
    public int getTowerDamage() {
        return damage;
    }

    @Override
    public int getTowerRange() {return rangeRadius; }

    @Override
    public double getTowerPrice() {
        return price;
    }

    @Override
    public Coordinate2D getInitialLocation() {
        return new Coordinate2D(0,0);
    }

//    @Override
//    public void shoot() {
//
//    }
}
