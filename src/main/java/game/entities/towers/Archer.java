package game.entities.towers;

import com.github.hanyaeger.api.Coordinate2D;
import game.entities.enemies.Enemy;
import game.entities.targeting.Arrow;
import game.scenes.TitleScreen;

public class Archer extends Tower {
    private double price = 100.0;
    private double rangeRadius = 99999999;
    private int cooldown = 2;
    private double damage = 30; // arrow does damage, so idk if it fits here?
    private int maxHealth = 0;
    private Enemy target;

    private Coordinate2D initialLocation;
    private String resource;

    public Archer(String resource, Coordinate2D initialLocation, TitleScreen titleScreen) {
        super(resource, initialLocation, titleScreen);
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
    public void shoot() {
        for (Enemy e : targets) {
            if (e.getHealth() > maxHealth) {
                maxHealth = e.getHealth();
                target = e;
                System.out.println(target);
            }
        }
       // if(getTimers().equals(5000)) {

            Arrow arrow = new Arrow(initialLocation, target);

       // }
    }

}