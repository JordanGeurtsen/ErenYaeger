package game.entities.towers;


import com.github.hanyaeger.api.Coordinate2D;
import game.entities.enemies.Enemy;
import game.entities.enemies.MovementSpeed;
import game.entities.targeting.ProjectileSpawner;
import game.scenes.GameScreen;

public class Freezer extends Tower{
    private static int price = 300;
    private static double rangeRadius = 117.5;
    private static double damage = 20;
    private GameScreen gameScreen;
    private Coordinate2D initialLocation;

    public Freezer(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, gameScreen);
        this.initialLocation = initialLocation;
        this.gameScreen = gameScreen;
    }

    public static int getTowerPrice() {return price;}

    @Override
    public double getTowerDamage() {return damage;}

    @Override
    public double getTowerRange() {return rangeRadius;}

    @Override
    public Coordinate2D getInitialLocation() {return initialLocation;}

    @Override
    public ProjectileSpawner getProjectileSpawner() {
        return null;
    }

    @Override
    public void explicitUpdate(long timestamp) {
        for (Enemy e: gameScreen.spawnedEnemyList) {
            if(isInRange(getTowerRange(), e)){
                e.setMovementSpeed(MovementSpeed.SLOW);
            } else {
                e.setMovementSpeed(MovementSpeed.NORMAL);
            }
        }
    }
}
