package game.entities.targeting;

import com.github.hanyaeger.api.Coordinate2D;
import game.entities.enemies.Enemy;
import game.entities.towers.Tower;
import game.scenes.GameScreen;


public class BulletSpawner extends ProjectileSpawner{
    private GameScreen gameScreen;
    private Coordinate2D coordinate2D;
    private double shootAngle;
    private Tower shootingTower;
    private boolean needToShoot;

    public BulletSpawner (long intervalInMs, Coordinate2D coordinate2D, Tower shootingTower, GameScreen gameScreen){
        super(intervalInMs, coordinate2D, gameScreen);
        this.coordinate2D = coordinate2D;
        this.gameScreen = gameScreen;
        this.shootingTower = shootingTower;
//        this.shootAngle = shootAngle;
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
    public void setShootAngle(double shootAngle) {
        this.shootAngle = shootAngle;
    }

    public void setNeedToShoot(boolean shootNeed) {
        this.needToShoot = shootNeed;
    }

    public void shoot(double shootAngle) {
        setShootAngle(shootAngle);
        setNeedToShoot(true);
    }
}
