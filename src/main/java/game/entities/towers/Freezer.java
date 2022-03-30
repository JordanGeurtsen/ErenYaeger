package game.entities.towers;


import com.github.hanyaeger.api.Coordinate2D;
import game.entities.enemies.Enemy;
import game.scenes.GameScreen;
import game.scenes.TitleScreen;

import java.util.ArrayList;

public class Freezer extends Tower{
    private double price = 200.0;
    private int rangeRadius = 250;
    private int cooldown = 3;
    private int damage = 20;

    public Freezer(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, gameScreen);
    }

    public void freezeEnemies(ArrayList<Enemy> enemyList){
        for (Enemy e : enemyList) {
            if (isInRange(getTowerRange(), enemyList)) {
               e.setMovementSpeed(1.0);
            } else {
                e.resetMovementSpeed();
            }
        }
    }

    @Override
    public double getTowerDamage() {
        return damage;
    }

    @Override
    public double getTowerRange() {return rangeRadius; }

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
