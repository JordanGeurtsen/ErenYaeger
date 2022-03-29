package game.entities.towers;

import com.github.hanyaeger.api.Coordinate2D;
import game.scenes.TitleScreen;

public class Hitman extends Tower {
    private double price = 150.0;
    private double rangeRadius = 10000;
    private int cooldown = 5;
    private double damage = 300; // of random zodat het niet altijd instant kill is

    protected Hitman(String resource, Coordinate2D initialLocation, TitleScreen titleScreen) {
        super(resource, initialLocation, titleScreen);
    }

    @Override
    public double getTowerDamage() {
        return 0;
    }

    @Override
    public double getTowerRange() {
        return 0;
    }

    @Override
    public double getTowerPrice() {
        return 0;
    }

    @Override
    public void shoot() {

    }

}
