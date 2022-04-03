package game.entities.towers;

import com.github.hanyaeger.api.Coordinate2D;
import game.entities.targeting.ArrowSpawner;
import game.entities.targeting.ProjectileSpawner;
import game.scenes.GameScreen;

public class Hitman extends Tower {
    private Coordinate2D initialLocation;
    private static double price = 250.0;
    private static double rangeRadius = 1250;
    private static double damage = 10;
    private ProjectileSpawner spawner;
    private GameScreen gameScreen;

    public Hitman(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, gameScreen);
        this.initialLocation = initialLocation;
        this.gameScreen = gameScreen;
        this.spawner = new ArrowSpawner(500, getInitialLocation(), this, gameScreen);
        //hierboven aanpassen naar bullet, maar voor nu zo anders krijg je foutmeldingen

    }

    @Override
    public double getTowerDamage() {
        return damage;
    }

    @Override
    public double getTowerRange() {
        return rangeRadius;
    }

//    @Override
    public static double getTowerPrice() {
        return price;
    }

    @Override
    public Coordinate2D getInitialLocation() {
        return initialLocation;
    }

    @Override
    public ProjectileSpawner getSpawner() {
        return spawner;
    }

    @Override
    public void explicitUpdate(long timestamp) {

    }
}
