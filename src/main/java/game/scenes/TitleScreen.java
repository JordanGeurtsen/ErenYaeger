package game.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import game.RoundExecutor;
import game.Screen;
import game.entities.buttons.QuitButton;
import game.BonkTheTowerTD;
import game.entities.buttons.SceneSwitchButton;
import game.entities.enemies.Enemy;
import game.entities.targeting.Arrow;
import game.entities.towers.Archer;
import game.entities.towers.Tower;

import java.util.ArrayList;

import static game.Screen.MAP_CHOOSER;

public class TitleScreen extends DynamicScene implements TileMapContainer {
    private BonkTheTowerTD bonkTheTowerTD;
    private int newScene = 1;
    public ArrayList<Enemy> enemyList = new ArrayList<>();
    public ArrayList<Tower> towers = new ArrayList<>();
    public ArrayList<Arrow> arrows = new ArrayList<>();


    public TitleScreen(BonkTheTowerTD bonkTheTowerTD) {
        this.bonkTheTowerTD = bonkTheTowerTD;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/bonk_the_tower_titlescreen.jpg");
    }

    @Override
    public void setupEntities() {
        var startButton = new SceneSwitchButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 2), this.bonkTheTowerTD, newScene, "Play Game");
        startButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(startButton);

        var bonkTheTowerQuit = new QuitButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 1.5), this.bonkTheTowerTD);
        bonkTheTowerQuit.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(bonkTheTowerQuit);

        var enemyTest = new Enemy("sprites/derpy_coot.png", new Coordinate2D(200, 500));
        enemyTest.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        enemyList.add(enemyTest);
        Archer archer = new Archer("sprites/mama_coot.png", new Coordinate2D(800, 200), this);
        archer.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        towers.add(archer);
        Arrow arrow = new Arrow(new Coordinate2D(800, 20), enemyTest);
        arrows.add(arrow);
        var re = new RoundExecutor(2);
        for(Enemy e : enemyList){
            addEntity(e);
        }
        for(Tower t : towers){
            addEntity(t);
        }
        for (Arrow a : arrows){
            addEntity(a);
        }
    }


    @Override
    public void setupTileMaps() {

    }
}
