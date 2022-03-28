package game.entities.towers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import game.entities.enemies.Enemy;

import java.util.ArrayList;

public abstract class Tower extends SpriteEntity {
    protected ArrayList<Enemy> targets = new ArrayList<>();

    public abstract void shoot();

    public Tower(String resource, Coordinate2D initialLocation){
        super(resource, initialLocation);
    }

    public boolean isInRange(int rangeRadius, ArrayList<Enemy> enemyList){
       boolean inRange = false;
        for (Enemy e : enemyList){
            if(distanceTo(e) < rangeRadius){
                inRange = true;
                targets.add(e);
            }
        }
        return inRange;
    }

    abstract public int getTowerDamage();
    abstract public int getTowerRange();
    abstract public double getTowerPrice();

}
