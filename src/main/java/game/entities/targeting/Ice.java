package game.entities.targeting;

import com.github.hanyaeger.api.Coordinate2D;
import game.entities.enemies.Enemy;
import game.entities.towers.Tower;
import game.scenes.GameScreen;

import java.util.ArrayList;

public class Ice extends Projectile {
    protected Ice(Coordinate2D initialLocation, GameScreen gameScreen, Tower shootingTower, ArrayList<Enemy> enemyList) {
        super("sprites/enemies/fast_coot.png", initialLocation, gameScreen, shootingTower,enemyList);

    }
}
