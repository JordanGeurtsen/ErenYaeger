package game.scenes;


import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;

import game.RoundExecutor;
import game.entities.buttons.QuitButton;
import game.entities.buttons.SceneSwitchButton;
import game.entities.buttons.compositebutton.buyButton;
import game.entities.counter.Counter;
import game.entities.enemies.Enemy;
import game.entities.targeting.Arrow;
import game.entities.targeting.ProjectileSpawner;
import game.entities.tilemap.LevelTileMap;
import game.entities.towers.Archer;
import game.entities.towers.Freezer;
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
        setBackgroundAudio("audio/relaxing_bg_music_2.mp3");

    }

    @Override
    public void setupEntities() {
        var coinCounter = new Counter(new Coordinate2D(1055, 30), coins, "Coins");
        addEntity(coinCounter);

        var pointCounter = new Counter(new Coordinate2D(1055, 60), points, "Points");
        addEntity(pointCounter);

        var liveCounter = new Counter(new Coordinate2D(1055, 90), lives, "Lives");
        addEntity(liveCounter);

        var archerBuy = new buyButton(new Coordinate2D(1050, 175), "sprites/towers/archer_logo.png");
        addEntity(archerBuy);

        var hitmanBuy = new buyButton(new Coordinate2D(1050, 300), "sprites/towers/hitman_logo.png");
        addEntity(hitmanBuy);

        var freezerBuy = new buyButton(new Coordinate2D(1050, 425), "sprites/towers/freezer_logo.png");
        addEntity(freezerBuy);

        var enemyTest1 = new Enemy("sprites/enemies/derpy_coot.png", new Coordinate2D(500, 500), this);
        enemyList.add(enemyTest1);

//        var enemyTest2 = new Enemy("sprites/enemies/derpy_coot.png", new Coordinate2D(800, 100), this);
//        enemyList.add(enemyTest2);
//
//        var enemyTest3 = new Enemy("sprites/enemies/derpy_coot.png", new Coordinate2D(150, 450), this);
//        enemyList.add(enemyTest3);

//        var archer = new Archer("sprites/enemies/mama_coot.png", new Coordinate2D(717, 187), this);
//        towers.add(archer);

        var freezer = new Freezer("sprites/enemies/thick_coot.png", new Coordinate2D(187.5, 412.5), this);
        towers.add(freezer);

        enemyList.forEach(this::addEntity);
        towers.forEach(this::addEntity);
    }

    @Override
    public void setupEntitySpawners() {
        for (Tower t : towers) {
            addEntitySpawner(new ProjectileSpawner((long) 1000.00, towers, enemyList, this));
        }
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new LevelTileMap());
    }

    public void checkAliveEnemies(ArrayList<Enemy> enemyList) {
        for (Enemy e : enemyList) {
            if (e.getHealth() == 0) {
                e.remove();
            }
        }
    }
}