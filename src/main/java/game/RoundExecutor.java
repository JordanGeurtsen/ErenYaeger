package game;

import com.github.hanyaeger.api.Coordinate2D;
import game.entities.enemies.Enemy;
import game.entities.targeting.projectile.Projectile;
import game.entities.towers.Archer;
import game.entities.towers.Tower;

import java.util.ArrayList;

public class RoundExecutor {
    private int round;
    public ArrayList<Enemy> enemyList = new ArrayList<Enemy>();

    public ArrayList<Tower> towers = new ArrayList<Tower>();

    public RoundExecutor(int round) {
        this.round = round;
    }

        public void towerTest(){

        Archer archer = new Archer("sprites/mama_coot.png", new Coordinate2D(100, 100));
        towers.add(archer);

        for(
        Tower t :towers) {
            if (t.isInRange(t.getTowerRange(), enemyList)) {
                t.shoot();
            }
        }
    }

}
