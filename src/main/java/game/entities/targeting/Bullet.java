package game.entities.targeting;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import game.entities.towers.Tower;
import game.scenes.gamescreen.GameScreen;

public class Bullet extends Projectile {
    public Bullet(Coordinate2D initialLocation, double shootAngle, GameScreen gameScreen, Tower shootingTower) {
        super("sprites/bullet.png", initialLocation, gameScreen, shootingTower, new Size(20));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setRotate(shootAngle - 90);
        int movementSpeed = 20;
        setMotion(movementSpeed, shootAngle);
    }
}