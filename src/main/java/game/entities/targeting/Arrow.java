package game.entities.targeting;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import game.entities.enemies.Enemy;
import game.scenes.GameScreen;

import java.util.ArrayList;

public class Arrow extends Targeting implements Collider, Collided, SceneBorderCrossingWatcher {
    private GameScreen gameScreen;
    private ArrayList<Enemy> enemyList;

    public Arrow(Coordinate2D initialLocation, int shootAngle, GameScreen gameScreen, ArrayList<Enemy> enemyList) {
        super("sprites/enemies/baby_coot.png", initialLocation);
        this.gameScreen = gameScreen;
        this.enemyList = enemyList;
        int movementSpeed = 25;
        System.out.println(initialLocation + " " + shootAngle + " ");
        setMotion(movementSpeed, shootAngle);

    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        switch (border) {
            case TOP, LEFT, RIGHT, BOTTOM -> remove();
        }
    }

    @Override
    public void onCollision(Collider collidingObject) {
        if (collidingObject instanceof Enemy) {
            remove();
            gameScreen.checkAliveEnemies(enemyList);
        }
    }
}
