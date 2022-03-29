package game.entities.towers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import game.entities.enemies.Enemy;
import game.scenes.GameScreen;

import java.util.ArrayList;

public abstract class Tower extends SpriteEntity {
    protected GameScreen gameScreen;
    private Coordinate2D initialLocation;
    private Enemy target;
    private int maxHealth = 0;
    private boolean inRange;


    public Tower(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, new Size(250));
        this.gameScreen = gameScreen;
        this.initialLocation = initialLocation;
    }

    public boolean isInRange(int rangeRadius, ArrayList<Enemy> enemyList) {
        inRange = false;
        for (Enemy e : enemyList) {
            if (distanceTo(e) < rangeRadius) {
                inRange = true;
            }
        }
        return inRange;
    }

    public Enemy getTarget(int rangeRadius, ArrayList<Enemy> enemyList) {
        target = new Enemy("sprites/enemies/derpy_coot.png", new Coordinate2D(100, 100));
        maxHealth = 0;
        for (Enemy e : enemyList) {
            if (distanceTo(e) < rangeRadius) {
                if (e.getHealth() > maxHealth) {
                    maxHealth = e.getHealth();
                    target = e;
                }
            }
        }
        return target;
    }



    abstract public int getTowerDamage();

    abstract public int getTowerRange();

    abstract public double getTowerPrice();

    abstract public Coordinate2D getInitialLocation();

    }
