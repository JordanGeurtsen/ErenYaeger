package game.entities.targeting;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import game.entities.towers.Tower;
import game.scenes.GameScreen;

public class Arrow extends Projectile implements Collided, SceneBorderCrossingWatcher {

    public Arrow(Coordinate2D initialLocation, double shootAngle, GameScreen gameScreen, Tower shootingTower) {
        super("sprites/arrow.png", initialLocation, gameScreen, shootingTower);
        int movementSpeed = 25;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setRotate(shootAngle - 90);
        setMotion(movementSpeed, shootAngle);

    }
}