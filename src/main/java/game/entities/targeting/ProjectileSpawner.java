package game.entities.targeting;

import com.github.hanyaeger.api.entities.EntitySpawner;
import game.entities.enemies.Enemy;
import game.entities.towers.Archer;
import game.entities.towers.Tower;

import java.util.ArrayList;

public class ProjectileSpawner extends EntitySpawner  {
    private ArrayList<Tower> towers;
    private ArrayList<Enemy> enemyList;
    private Enemy target;

    public ProjectileSpawner(long intervalInMs, ArrayList<Tower> towers, ArrayList<Enemy> enemyList) { // intervalInMs = speed
        super(intervalInMs);
        this.towers = towers;
        this.enemyList = enemyList;
    }

    @Override
    protected void spawnEntities() {
        for (Tower t : towers) {
            if (t.isInRange(t.getTowerRange(), enemyList)) {
                target = t.getTarget(t.getTowerRange(), enemyList);
                if (t instanceof Archer) {
                    spawn(new Arrow(((Archer)t).getInitialLocation(), target));
                }

            }
        }
    }

}