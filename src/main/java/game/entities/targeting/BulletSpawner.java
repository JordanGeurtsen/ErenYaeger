package game.entities.targeting;

import com.github.hanyaeger.api.Coordinate2D;
import game.entities.enemies.Enemy;
import game.entities.towers.Tower;
import game.scenes.GameScreen;

public class BulletSpawner extends ProjectileSpawner{
    private final GameScreen gameScreen;
    private final Coordinate2D coordinate2D;
    private double shootAngle;
    private boolean needToShoot;
    private final Tower shootingTower;

    public BulletSpawner (long intervalInMs, Coordinate2D coordinate2D, Tower shootingTower, GameScreen gameScreen){
        super(intervalInMs);
        this.coordinate2D = coordinate2D;
        this.gameScreen = gameScreen;
        this.shootingTower = shootingTower;
    }

    @Override
    protected void spawnEntities() {
        if (gameScreen.enemyList.size() > 0) {
            for(Enemy e: gameScreen.enemyList) {
                if (shootingTower.isInRange(shootingTower.getTowerRange(), e)) {
                    if (needToShoot) {
                        spawn(new Bullet(coordinate2D, shootAngle, gameScreen, shootingTower));
                        needToShoot = !needToShoot;
                    }
                }
            }
        }
    }

    @Override
    public void setShootAngle(double shootAngle) {this.shootAngle = shootAngle;}

    public void setNeedToShoot(boolean shootNeed) {this.needToShoot = shootNeed;}

    public void shoot(double shootAngle) {
        setShootAngle(shootAngle);
        setNeedToShoot(true);
    }
}
