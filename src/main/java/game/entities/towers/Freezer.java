package game.entities.towers;


import com.github.hanyaeger.api.Coordinate2D;
import game.entities.targeting.ArrowSpawner;
import game.entities.targeting.IceSpawner;
import game.entities.targeting.ProjectileSpawner;
import game.scenes.GameScreen;

public class Freezer extends Tower{
    private static double price = 200.0;
    private static double rangeRadius = 150;
    private static double damage = 20;
    private Coordinate2D initialLocation;
    private IceSpawner spawner;
    private GameScreen gameScreen;

    public Freezer(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, gameScreen);
        this.initialLocation = initialLocation;
        this.gameScreen = gameScreen;
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
    public ProjectileSpawner getSpawner() {
        spawner = new IceSpawner(500, getInitialLocation(), gameScreen.enemyList, this, gameScreen);
        return spawner;
    }

    @Override
    public void explicitUpdate(long timestamp) {

    }
}
