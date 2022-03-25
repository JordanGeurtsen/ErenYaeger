package game.entities.towers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import game.entities.enemies.Enemy;

import java.util.ArrayList;

public abstract class Tower extends SpriteEntity {
    float price;
    int rangeRadius, cooldown, damage;
    String resource;
    Coordinate2D initialLocation;

    public abstract void attackForm();


    public Tower(String resource, Coordinate2D initialLocation){
        super(resource, initialLocation);
        this.resource = resource;
        this.initialLocation = initialLocation;
    }

    public boolean isInRange(int rangeRadius, ArrayList<Enemy> enemyList){
       boolean inRange = false;
        for (Enemy e : enemyList){
            if(distanceTo(e) < rangeRadius){
                inRange = true;
            }
        }
        return inRange;
    }

    public int getTowerDamage(){ return damage;}
    public int getTowerRange(){ return rangeRadius;}
    public int getTowerCooldown(){ return cooldown;}
    public float getTowerPrice(){ return price;}

}
