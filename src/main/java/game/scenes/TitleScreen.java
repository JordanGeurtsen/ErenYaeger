package game.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import game.RoundExecutor;
import game.Screenum;
import game.entities.buttons.QuitButton;
import game.BonkTheTowerTD;
import game.entities.buttons.SceneSwitchButton;
import game.entities.enemies.Enemy;
import game.entities.targeting.Arrow;
import game.entities.towers.Archer;
import game.entities.towers.Tower;

import java.util.ArrayList;

public class TitleScreen extends DynamicScene implements TileMapContainer {
    private final BonkTheTowerTD bonkTheTowerTD;
    public ArrayList<Enemy> enemyList = new ArrayList<>();
    public ArrayList<Tower> towers = new ArrayList<>();
    public ArrayList<Arrow> arrows = new ArrayList<>();


    public TitleScreen(BonkTheTowerTD bonkTheTowerTD) {
        this.bonkTheTowerTD = bonkTheTowerTD;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/bonk_the_tower_titlescreen.jpg");
        setBackgroundAudio("audio/relaxing_bg_music.mp3");
        setBackgroundAudioVolume(0.3);
    }

    @Override
    public void setupEntities() {
        int newScene = 1;
        var startButton = new SceneSwitchButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 1.8), this.bonkTheTowerTD, Screenum.GAME, "Play Game");
        startButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(startButton);

        var bonkTheTowerQuit = new QuitButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 1.5), this.bonkTheTowerTD);
        bonkTheTowerQuit.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(bonkTheTowerQuit);

        var enemyTest = new Enemy("sprites/enemies/derpy_coot.png", new Coordinate2D(200, 500));
        enemyTest.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        enemyList.add(enemyTest);
        Archer archer = new Archer("sprites/enemies/mama_coot.png", new Coordinate2D(800, 200), this);
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
