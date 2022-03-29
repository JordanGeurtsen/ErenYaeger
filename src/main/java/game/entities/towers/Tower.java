package game.entities.towers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import game.entities.enemies.Enemy;
import game.scenes.TitleScreen;

import java.util.ArrayList;

public abstract class Tower extends SpriteEntity {
    protected ArrayList<Enemy> targets = new ArrayList<>();
    protected TitleScreen titleScreen;

    public abstract void shoot();

    public Tower(String resource, Coordinate2D initialLocation, TitleScreen titleScreen) {
        super(resource, initialLocation, new Size(250));
        this.titleScreen = titleScreen;
    }

    public boolean isInRange(int rangeRadius, ArrayList<Enemy> enemyList) {
        boolean inRange = false;
        for (Enemy e : enemyList) {
            if (distanceTo(e) < rangeRadius) {
                inRange = true;
                targets.add(e);
            }
        }
        return inRange;
    }

    public double[] getTowerInfo(){
        double [] towerInfo = new double[3];

        towerInfo[0] = getTowerDamage();
        towerInfo[1] = getTowerPrice();
        towerInfo[2] = getTowerRange();

        return towerInfo;
    }

    abstract public double getTowerDamage();

    abstract public double getTowerRange();

    abstract public double getTowerPrice();

    public void towerTest() {
            if (isInRange((int) getTowerRange(), titleScreen.enemyList)) {
                shoot();
            }
        }
    }
