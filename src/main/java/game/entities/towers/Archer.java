package game.entities.towers;

import com.github.hanyaeger.api.Coordinate2D;
import game.entities.enemies.Enemy;
import game.entities.targeting.projectile.Arrow;

import java.util.ArrayList;


public class Archer extends Tower {
    private double price = 100.0;
    private int rangeRadius = 100;
    private int cooldown = 2;
    private int damage = 30;
    private ArrayList<Enemy> targets = new ArrayList<>();
    private Coordinate2D initialLocation;
    private String resource;

    public Archer(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
        this.resource = resource;
        this.initialLocation = initialLocation;
    }

    @Override
    public int getTowerDamage() {
        return damage;
    }

    @Override
    public int getTowerRange() {
        return rangeRadius;
    }

    @Override
    public double getTowerPrice() {
        return 100.0;
    }

    @Override
    public void shoot() {
            for(Enemy e : enemyList){
                if(distanceTo(e) < rangeRadius){
                    targets.add(e);
                }
            }
            maxHealth = 0;
            for(Enemy e : targets){
                if(e.getHealth() > maxHealth){
                    maxHealth = e.getHealth();
                }
            }
           var arrow = new Arrow(initialLocation, target);
        }
    }


}
