package game.entities.towers;

import com.github.hanyaeger.api.Coordinate2D;
import game.entities.enemies.Enemy;
import game.entities.targeting.Arrow;
import game.scenes.GameScreen;
import game.scenes.TitleScreen;

import java.util.ArrayList;

public class Archer extends Tower {
    private double price = 100.0;
    private double rangeRadius = 99999999;
    private int cooldown = 2;
    private double damage = 30;
    private int maxHealth = 0;
    public Arrow arrow;

    private Coordinate2D initialLocation;
    private String resource;

    public Archer(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, gameScreen);
        this.resource = resource;
        this.initialLocation = initialLocation;
    }

    @Override
    public double getTowerDamage() {
        return damage;
    }

    @Override
    public double getTowerRange() {
        return rangeRadius;
    }

    @Override
    public double getTowerPrice() {
        return price;
    }

    @Override
    public Coordinate2D getInitialLocation() {
        return initialLocation;
    }

    public Arrow getArrow(){return arrow;}
}