package game.entities.towers;

import com.github.hanyaeger.api.Coordinate2D;
import game.scenes.GameScreen;
import game.scenes.TitleScreen;

public class Hitman extends Tower {
    double price = 150.0;
    int rangeRadius = 10000;
    int cooldown = 5;
    int damage = 300; // of random zodat het niet altijd instant kill is

    protected Hitman(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, gameScreen);
    }

    @Override
    public int getTowerDamage() {
        return 0;
    }

    @Override
    public int getTowerRange() {
        return 0;
    }

    @Override
    public double getTowerPrice() {
        return 0;
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
