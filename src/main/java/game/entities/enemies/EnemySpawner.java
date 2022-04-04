package game.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.entities.EntitySpawner;
import game.Round;
import game.RoundExecutor;
import game.scenes.GameScreen;

public class EnemySpawner extends Timer {  //extends EntitySpawner {
    private GameScreen gameScreen;
    private long intervalInMS;
    private boolean spawnEnemyOnce = true;
    public int enemyListNr;

    public EnemySpawner(long intervalInMs, GameScreen gameScreen) {
//        super(intervalInMs, gameScreen, round);
        super(intervalInMs);
        this.intervalInMS = intervalInMs;
        this.gameScreen = gameScreen;
        this.enemyListNr  = 8;  //gameScreen.enemyList.toArray().length +1;
    }


//    @Override
//    protected void spawnEntities() {
//        if(spawnEnemyOnce){
//        for (int i = 0; i < 5; i++) {
//            for (Enemy e : gameScreen.enemyList) {
//                spawn(e);
//            }
//            spawnEnemyOnce = false;
//        }


//    }
//    private int fun = 1;

    @Override
    public void onAnimationUpdate(long l) {
//        System.out.println(enemyListNr);
////        System.out.println(fun + "   " + l);
////        if (l > fun) {
//
//                gameScreen.zooi = true;
//                //spawn(gameScreen.enemyList.get(enemyListBack));
////            enemyListNr--;
//                System.out.println("YAYAYY");
//            }
////            fun += 3000;
////        }
    }
}