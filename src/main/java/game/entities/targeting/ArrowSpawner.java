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
    private ArrayList<Enemy> enemyList;
    private GameScreen gameScreen;
    private int shootAngle;
    private boolean needToShoot;
    private Enemy target;
    private Coordinate2D coordinate2D;

    public ArrowSpawner(long intervalInMs, Coordinate2D coordinate2D, GameScreen gameScreen) {
        super(intervalInMs, coordinate2D, gameScreen);
        this.enemyList = enemyList;
        this.gameScreen = gameScreen;
        this.coordinate2D = coordinate2D;
    }

    @Override
    protected void spawnEntities() {
        if (needToShoot) {
            spawn(new Arrow(coordinate2D, shootAngle, gameScreen, enemyList));
            needToShoot = !needToShoot;
        }
    }
    public void setNeedToShoot(boolean shootNeed) {
        needToShoot = shootNeed;
    }
    }
