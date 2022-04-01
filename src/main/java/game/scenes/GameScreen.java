package game.scenes;


import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;

import game.entities.buttons.compositebutton.buyButton;
import game.entities.counter.Counter;
import game.entities.enemies.DerpyCoot;
import game.entities.enemies.Enemy;
import game.entities.enemies.FastCoot;
import game.entities.enemies.MamaCoot;
import game.entities.targeting.Arrow;
import game.entities.tilemap.LevelTileMap;
import game.entities.towers.Archer;
import game.entities.towers.Freezer;
import game.entities.towers.Hitman;
import game.entities.towers.Tower;

import game.BonkTheTowerTD;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class GameScreen extends DynamicScene implements TileMapContainer, EntitySpawnerContainer {

    private BonkTheTowerTD bonkTheTowerTD;
    public ArrayList<Enemy> enemyList = new ArrayList<>();
    public ArrayList<Tower> towers = new ArrayList<>();
    public double coins = 100.0;
    public double points = 0.0;
    public double lives = 20.0;

    public GameScreen(BonkTheTowerTD bonkTheTowerTD) {
        this.bonkTheTowerTD = bonkTheTowerTD;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.PAPAYAWHIP);
        setBackgroundAudioVolume(0.1);
//        setBackgroundAudio("audio/relaxing_bg_music_2.mp3");

    }

    @Override
    public void setupEntities() {
        var coinCounter = new Counter(new Coordinate2D(1055, 30), coins, "Coins");
        addEntity(coinCounter);

        var pointCounter = new Counter(new Coordinate2D(1055, 60), points, "Points");
        addEntity(pointCounter);

        var liveCounter = new Counter(new Coordinate2D(1055, 90), lives, "Lives");
        addEntity(liveCounter);

        var archerBuy = new buyButton(new Coordinate2D(1050, 175), "sprites/towers/archer_logo.png",
                "Archer", 100, 5, 250);
        addEntity(archerBuy);

        var hitmanBuy = new buyButton(new Coordinate2D(1050, 300), "sprites/towers/hitman_logo.png",
                "Hitman", 250, 40, 1250);
        addEntity(hitmanBuy);

        var freezerBuy = new buyButton(new Coordinate2D(1050, 425), "sprites/towers/freezer_logo.png",
                "Freezer", 200, 0, 150);
        addEntity(freezerBuy);

        var enemyTest1 = new FastCoot("sprites/enemies/fast_coot.png", new Coordinate2D(1237, 187), this);
        enemyList.add(enemyTest1);

        var enemyTest3 = new FastCoot("sprites/enemies/fast_coot.png", new Coordinate2D(1237, 300), this);
        enemyList.add(enemyTest3);

        var enemyTest2 = new DerpyCoot("sprites/enemies/derpy_coot.png", new Coordinate2D(1200, 350), this);
        enemyList.add(enemyTest2);
//
        var enemyTest4 = new FastCoot("sprites/enemies/fast_coot.png", new Coordinate2D(1200, 562.5), this);
        enemyList.add(enemyTest4);
//
//        var enemyTest4 = new MamaCoot("sprites/enemies/mama_coot.png", new Coordinate2D(50, 50), this);
//        enemyList.add(enemyTest4);

        var archer = new Archer("sprites/towers/archer_tower.png", new Coordinate2D(617.5, 187), this);
        towers.add(archer);

        var archer2 = new Archer("sprites/towers/archer_tower.png", new Coordinate2D(617.5, 562.5), this);
        towers.add(archer2);

//        var freezer = new Freezer("sprites/towers/freezer_tower.png", new Coordinate2D(187.5, 412.5), this);
//        towers.add(freezer);

//
//        var hitman = new Hitman("sprites/towers/hitman_tower.png", new Coordinate2D(187.5, 412.5), this);
//        towers.add(hitman);

        enemyList.forEach(this::addEntity);
        towers.forEach(this::addEntity);
    }

    @Override
    public void setupEntitySpawners() {
        for (Tower t : towers) {
            addEntitySpawner(t.getSpawner());
        }
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new LevelTileMap());
    }
//
//    public void checkAliveEnemies() {
//        for (int i = enemyList.size() - 1; i > 0; i--) {
//            if (enemyList.get(i).getHealth() <= 0) {
//                enemyList.remove(i);
//                enemyList.get(i).remove();
//                points += 5;
//                coins += 10;
//            }
//        }
//    }

    public void enemyPastBorder(boolean pastBorder, Enemy e){
        if(pastBorder) {
            enemyList.remove(e);
            e.remove();
        }
    }

}