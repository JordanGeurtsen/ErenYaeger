package game.entities.targeting;

import com.github.hanyaeger.api.Coordinate2D;
import game.entities.enemies.Enemy;
import game.entities.towers.Tower;
import game.scenes.GameScreen;

import java.util.ArrayList;
import java.util.Random;

public class ArrowSpawner extends ProjectileSpawner {
    private GameScreen gameScreen;
    private double shootAngle;
    private boolean needToShoot;
    private Coordinate2D coordinate2D;
    private Tower shootingTower;

    public ArrowSpawner(long intervalInMs, Coordinate2D coordinate2D, Tower shootingTower, GameScreen gameScreen) {
        super(intervalInMs, coordinate2D, gameScreen);
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

