package game.entities.targeting;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import game.entities.enemies.Enemy;
import game.entities.enemies.MovementSpeed;
import game.entities.towers.Archer;
import game.entities.towers.Freezer;
import game.entities.towers.Hitman;
import game.entities.towers.Tower;
import game.scenes.GameScreen;

import java.util.ArrayList;

public class ArrowSpawner extends ProjectileSpawner {
    private GameScreen gameScreen;
    private int shootAngle;
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
        if(gameScreen.enemyList.size() > 0) {
            if (needToShoot) {
//                System.out.println(gameScreen.enemyList);
//                System.out.println(gameScreen.enemyList.size());
                spawn(new Arrow(coordinate2D, shootAngle, gameScreen, shootingTower));
//                System.out.println(gameScreen.enemyList);
                needToShoot = !needToShoot;
            }
        }
    }

    public void setShootAngle(int shootAngle) {
        this.shootAngle = shootAngle;
    }

    public void setNeedToShoot(boolean shootNeed) {
        this.needToShoot = shootNeed;
    }
    }

