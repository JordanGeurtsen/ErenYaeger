package game.entities.targeting;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import game.entities.towers.Tower;
import game.scenes.gamescreen.GameScreen;

public class Arrow extends Projectile {
    public Arrow(Coordinate2D initialLocation, double shootAngle, GameScreen gameScreen, Tower shootingTower) {
        super("sprites/arrow.png", initialLocation, gameScreen, shootingTower, new Size(60));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setRotate(shootAngle - 90);
        int movementSpeed = 25;
        setMotion(movementSpeed, shootAngle);
    }
}