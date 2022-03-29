package game.scenes;


import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;

import game.RoundExecutor;
import game.entities.buttons.QuitButton;
import game.entities.buttons.SceneSwitchButton;
import game.entities.enemies.Enemy;
import game.entities.targeting.Arrow;
import game.entities.targeting.ProjectileSpawner;
import game.entities.tilemap.LevelTileMap;
import game.entities.towers.Archer;
import game.entities.towers.Tower;

import game.BonkTheTowerTD;

import java.util.ArrayList;

public class GameScreen extends DynamicScene implements TileMapContainer, EntitySpawnerContainer {

    private BonkTheTowerTD bonkTheTowerTD;
    public ArrayList<Enemy> enemyList = new ArrayList<>();
    public ArrayList<Tower> towers = new ArrayList<>();
   // public ArrayList<Arrow> arrows = new ArrayList<>();

    private ProjectileSpawner projectileSpawner;

    public GameScreen(BonkTheTowerTD bonkTheTowerTD) {
        this.bonkTheTowerTD = bonkTheTowerTD;
        this.projectileSpawner = new ProjectileSpawner((long)5000.00, towers, enemyList);
    }

    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        var enemyTest1 = new Enemy("sprites/enemies/derpy_coot.png", new Coordinate2D(200, 500));
        enemyTest1.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        enemyList.add(enemyTest1);

        var enemyTest2 = new Enemy("sprites/enemies/derpy_coot.png", new Coordinate2D(70, 100));
        enemyTest2.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        enemyList.add(enemyTest2);

        var enemyTest3 = new Enemy("sprites/enemies/derpy_coot.png", new Coordinate2D(300, 250));
        enemyTest3.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        enemyList.add(enemyTest3);

        Archer archer = new Archer("sprites/enemies/mama_coot.png", new Coordinate2D(800, 200), this);
        archer.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        towers.add(archer);
//        Arrow arrow = new Arrow(archer.getAnchorLocation(), enemyTest);
//        arrows.add(arrow);
        var re = new RoundExecutor(2);
        enemyList.forEach(this::addEntity);
        towers.forEach(this::addEntity);
    }

    @Override
    public void setupEntitySpawners() {
//        addEntitySpawner(projectileSpawner);
//
//        ArrayList<ProjectileSpawner> projectileSpawns = new ArrayList<ProjectileSpawner>();
//        projectileSpawns.add(new ProjectileSpawner((long)5000.00, towers, enemyList));
//        projectileSpawns.forEach((this::addEntitySpawner));

        for(Tower t : towers) {
            addEntitySpawner(new ProjectileSpawner((long)500.00, towers, enemyList));
        }
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new LevelTileMap());
    }

}
