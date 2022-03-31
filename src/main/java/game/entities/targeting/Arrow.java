package game.entities.targeting;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import game.entities.enemies.Enemy;
import game.entities.towers.Tower;
import game.scenes.GameScreen;

import java.util.ArrayList;

public class Arrow extends Projectile implements Collided, SceneBorderCrossingWatcher {

    public Arrow(Coordinate2D initialLocation, int shootAngle, GameScreen gameScreen, Tower shootingTower, ArrayList<Enemy> enemyList) {
        super("sprites/arrow.png", initialLocation, gameScreen, shootingTower, enemyList);
        int movementSpeed = 25;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setRotate(shootAngle - 90);
        setMotion(movementSpeed, shootAngle);

    }
}