package game.entities.towers;

import com.github.hanyaeger.api.Coordinate2D;

public class Archer extends Tower {
    double price = 100.0;
    int rangeRadius = 100;
    int cooldown;
    int damage;

    @Override
    public void attackForm() {
    }

    protected Archer(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }
}
