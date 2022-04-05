package game.entities.targeting;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import game.entities.towers.Tower;
import game.scenes.GameScreen;

public class Bullet extends Projectile implements Collided, SceneBorderCrossingWatcher {
    private int movementSpeed = 20;

    public Bullet(Coordinate2D initialLocation, double shootAngle, GameScreen gameScreen, Tower shootingTower) {
        super("sprites/bullet.png", initialLocation, gameScreen, shootingTower, new Size(20));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setRotate(shootAngle - 90);
        setMotion(movementSpeed, shootAngle);
    }
}