package game.entities.targeting;

import com.github.hanyaeger.api.Coordinate2D;
import game.entities.enemies.Enemy;
import game.entities.towers.Tower;
import game.scenes.gamescreen.GameScreen;

public class ArrowSpawner extends ProjectileSpawner {
    private final GameScreen gameScreen;
    private final Coordinate2D coordinate2D;
    private double shootAngle;
    private boolean needToShoot;
    private final Tower shootingTower;

    public ArrowSpawner(long intervalInMs, Coordinate2D coordinate2D, Tower shootingTower, GameScreen gameScreen) {
        super(intervalInMs);
        this.gameScreen = gameScreen;
        this.shootingTower = shootingTower;
        this.coordinate2D = coordinate2D;
    }

    @Override
    protected void spawnEntities() {
        if (gameScreen.enemyList.size() > 0) {
            for(Enemy e: gameScreen.enemyList) {
                if (shootingTower.isInRange(shootingTower.getTowerRange(), e)) {
                    if (needToShoot) {
                        spawn(new Arrow(coordinate2D, shootAngle, gameScreen, shootingTower));
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

