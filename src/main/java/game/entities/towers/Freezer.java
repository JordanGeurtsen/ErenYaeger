package game.entities.towers;


import com.github.hanyaeger.api.Coordinate2D;

public class Freezer extends Tower{
    double price = 200.0;
    int rangeRadius = 250;
    int cooldown = 3;
    int damage = 20;

    public Freezer(String resource, Coordinate2D initialLocation) {
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
    public void shoot() {

    }
}
