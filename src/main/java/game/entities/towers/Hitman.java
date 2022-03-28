package game.entities.towers;

import com.github.hanyaeger.api.Coordinate2D;

public class Hitman extends Tower {
    double price = 150.0;
    int rangeRadius = 10000;
    int cooldown = 5;
    int damage = 300; // of random zodat het niet altijd instant kill is

    protected Hitman(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
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

    @Override
    public void attackForm() {

    }

}
