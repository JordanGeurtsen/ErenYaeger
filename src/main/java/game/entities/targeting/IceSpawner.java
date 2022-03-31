package game.entities.targeting;

import com.github.hanyaeger.api.Coordinate2D;
import game.entities.enemies.Enemy;
import game.entities.enemies.MovementSpeed;
import game.entities.towers.Freezer;
import game.entities.towers.Tower;
import game.scenes.GameScreen;

import java.util.ArrayList;

public class IceSpawner extends ProjectileSpawner {
//    private ArrayList<Tower> tower;
    private ArrayList<Enemy> enemyList;
    private ArrayList<Enemy> everyTargetInRange = new ArrayList<>();
    private GameScreen gameScreen;
    private boolean needToSpawn = false;
    private Coordinate2D coordinate2D;
    private Tower shootingTower;

    public IceSpawner(long intervalInMs, Coordinate2D coordinate2D, ArrayList<Enemy> enemyList, Tower shootingTower, GameScreen gameScreen) {
        super(intervalInMs, coordinate2D, gameScreen);
        this.coordinate2D = coordinate2D;
        this.enemyList = enemyList;
        this.gameScreen = gameScreen;
        this.shootingTower = shootingTower;
    }


    @Override
    protected void spawnEntities() {
        for (Enemy e : enemyList) {
            e.setMovementSpeed(MovementSpeed.NORMAL);
        }
        if (needToSpawn) {
            if (enemyList.size() > 0) {
                            for(Enemy e : enemyList) {
                                if (shootingTower.isMutipleInRange(shootingTower.getTowerRange(), e)) {
                                    everyTargetInRange = shootingTower.getEveryTarget(enemyList, shootingTower);
                                }
                            }
                        }
                    }
        for (Enemy e : everyTargetInRange) {
            e.setMovementSpeed(MovementSpeed.SLOW);
        }
            everyTargetInRange.clear();
            needToSpawn = !needToSpawn;
    }

    @Override
    public void setShootAngle(int shootAngle) {

    }
//
//    @Override
//    protected void spawnEntities() {
//        if (needToShoot) {
//            spawn(new Arrow(coordinate2D, shootAngle, gameScreen, shootingTower, enemyList));
//            needToShoot = !needToShoot;
//        }
//    }
//
//    public void setShootAngle(int shootAngle) {
//        this.shootAngle = shootAngle;
//    }
//
//    public void setNeedToShoot(boolean shootNeed) {
//        this.needToShoot = shootNeed;
//    }
}
