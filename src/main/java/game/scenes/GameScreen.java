package game.scenes;


import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.api.userinput.MouseButtonReleasedListener;
import game.BonkTheTowerTD;
import game.PathStep;
import game.Screenum;
import game.entities.buttons.compositebutton.buyButton;
import game.entities.counter.Counter;
import game.entities.enemies.*;
import game.entities.tilemap.LevelTileMap;
import game.entities.towers.Archer;
import game.entities.towers.Freezer;
import game.entities.towers.Hitman;
import game.entities.towers.Tower;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class GameScreen extends DynamicScene implements TileMapContainer, EntitySpawnerContainer, UpdateExposer, MouseButtonReleasedListener {
    private BonkTheTowerTD bonkTheTowerTD;
    public LevelTileMap levelTileMap = new LevelTileMap();
    public ArrayList<Enemy> enemyList = new ArrayList<>();
    public ArrayList<Tower> towers = new ArrayList<>();
    public Counter coinCounter;
    public Counter pointCounter;
    public Counter liveCounter;
    public static int coins = 1000;
    public static int points = 0;
    public static int lives = 20;
    private final int blockSize = 75;
    private final int gameFieldSize = 1050;
    private int blockNrWidth;
    private int blockNrHeight;
    private double xCoordinateTower;
    private double yCoordinateTower;
    private int towerPrice;
    private Coordinate2D newTowerCoordinates;

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
        if(buyButton.currentTowerSelected == "") {
            coinCounter = new Counter(new Coordinate2D(1055, 30), coins, "Coins");
            addEntity(coinCounter);

            pointCounter = new Counter(new Coordinate2D(1055, 60), points, "Points");
            addEntity(pointCounter);

            liveCounter = new Counter(new Coordinate2D(1055, 90), lives, "Lives");
            addEntity(liveCounter);

            var archerBuy = new buyButton(new Coordinate2D(1050, 175), "sprites/towers/archer_logo.png",
                    "Archer", 100, 5, 250, this);
            addEntity(archerBuy);

            var hitmanBuy = new buyButton(new Coordinate2D(1050, 300), "sprites/towers/hitman_logo.png",
                    "Hitman", 250, 40, 1250, this);
            addEntity(hitmanBuy);

            var freezerBuy = new buyButton(new Coordinate2D(1050, 425), "sprites/towers/freezer_logo.png",
                    "Freezer", 200, 0, 150, this);
            addEntity(freezerBuy);

            var enemyTest1 = new FastCoot("sprites/enemies/fast_coot.png", new Coordinate2D(112, 0), this);
            enemyList.add(enemyTest1);

            var enemyTest3 = new FastCoot("sprites/enemies/fast_coot.png", new Coordinate2D(112, -10), this);
            enemyList.add(enemyTest3);

            var enemyTest2 = new DerpyCoot("sprites/enemies/derpy_coot.png", new Coordinate2D(112, -20), this);
            enemyList.add(enemyTest2);

            var enemyTest9 = new DerpyCoot("sprites/enemies/derpy_coot.png", new Coordinate2D(112, -20), this);
            enemyList.add(enemyTest9);

            var enemyTest4 = new FastCoot("sprites/enemies/fast_coot.png", new Coordinate2D(112, -15), this);
            enemyList.add(enemyTest4);

            var enemyTest8 = new FastCoot("sprites/enemies/fast_coot.png", new Coordinate2D(112, -15), this);
            enemyList.add(enemyTest8);

            var enemyTest5 = new MamaCoot("sprites/enemies/mama_coot.png", new Coordinate2D(112, 10), this);
            enemyList.add(enemyTest5);

            enemyList.forEach(this::addEntity);
        }
        towers.forEach(this::addEntity);
    }

    @Override
    public void setupEntitySpawners() {
        for (Tower t : towers) {
            addEntitySpawner(t.getProjectileSpawner());
        }
    }

    @Override
    public void setupTileMaps() {
        addTileMap(levelTileMap);
    }

    public void enemyPastBorder(Enemy e, int damage) {
            enemyList.remove(e);
            e.remove();
            lives -= damage;
            liveCounter.setCounterText("Lives: ", lives);
    }

    @Override
    public void explicitUpdate(long l) {
        if (!buyButton.tileMapChanged) {
            if (buyButton.isTowerSelected) {
                levelTileMap.setupSelectTileMap();
                System.out.println("hi");
            } else {
                System.out.println("Changing back!");
                levelTileMap.setupNormalTileMap();
                buyButton.currentTowerSelected = "";
                coinCounter.setCounterColor(Color.BLACK);
            }
            System.out.println(buyButton.currentTowerSelected);
            setupTileMaps();
            initTileMaps();
            buyButton.tileMapChanged = true;
        }
        enemiesPath();

        if (lives <= 0){
            bonkTheTowerTD.setActiveScene(Screenum.FINAL.getId());
        }
    }

    public boolean enoughMoney(String towerName) {
        if (towerName == "Archer") {
            towerPrice = Archer.getTowerPrice();
        } else if (towerName == "Hitman"){
            towerPrice = Hitman.getTowerPrice();
        } else { // if (towerName == "Freezer"){
            towerPrice = Freezer.getTowerPrice();
        }
        if(coins >= towerPrice) {
            return true;
        } else {
            return false;
        }

    }

    public void placeTower(Coordinate2D mouseCoordinates) {
        if (buyButton.isTowerSelected) {
            if (mouseCoordinates.getX() < gameFieldSize) {
                blockNrWidth = (int) Math.floor(mouseCoordinates.getX() / blockSize);
                xCoordinateTower = blockNrWidth * blockSize + (blockSize / 2);
                blockNrHeight = (int)Math.floor(mouseCoordinates.getY() / blockSize);
                yCoordinateTower = blockNrHeight * blockSize + (blockSize / 2);
                newTowerCoordinates = new Coordinate2D(xCoordinateTower, yCoordinateTower);
                String towerSelectedName = buyButton.currentTowerSelected;

                if (levelTileMap.freeSpace(blockNrWidth, blockNrHeight)) {
                    if (enoughMoney(towerSelectedName)) {
                        if (towerSelectedName == "Archer") {
                            Archer newTower = new Archer("sprites/towers/archer_tower.png", newTowerCoordinates, this);
                            towers.add(newTower);
                        } else if (towerSelectedName == "Hitman") {
                            Hitman newTower = new Hitman("sprites/towers/hitman_tower.png", newTowerCoordinates, this);
                            towers.add(newTower);
                        } else if (towerSelectedName == "Freezer") {
                            Freezer newTower = new Freezer("sprites/towers/freezer_tower.png", newTowerCoordinates, this);
                            towers.add(newTower);
                        } else {
                            System.out.println("ERROR: towerSelectedName is wrong");
                            towerPrice = 0;
                        }

                    coins -= towerPrice;
                    coinCounter.setCounterText("Coins: ", coins);

                        setupEntities();
                        setupEntitySpawners();


                        levelTileMap.changeTile(blockNrWidth, blockNrHeight);
                        // explicit update is supposed to do this?? idk why it doesn't
                        levelTileMap.setupNormalTileMap();
                        setupTileMaps();
                        initTileMaps();

                        buyButton.currentTowerSelected = "";
                        buyButton.isTowerSelected = false;
                        buyButton.tileMapChanged = true;
                    } else {
                        coinCounter.setCounterColor(Color.DARKRED);
                        System.out.println("You don't have enough money");
                    }
                }
            }
        }
    }

    @Override
    public void onMouseButtonReleased(MouseButton mouseButton, Coordinate2D coordinate2D) {
        placeTower(coordinate2D);
    }

    public double pathLimit(int tile){
        return  (tile - 1) * blockSize + (blockSize / 2);
    }

    public void enemiesPath(){
        for (Enemy e : enemyList) {
            Coordinate2D coordinates =  e.getAnchorLocation();
            PathStep pathStep = e.getPathStep();

            switch(pathStep) {
                case ZERO:
                    if (coordinates.getY() >  pathLimit(2)) {
                        e.setDirection(Direction.RIGHT);
                        e.setPathStep(PathStep.ONE);
                    }
                    break;
                case ONE:
                    if(coordinates.getX() > pathLimit(11)) {
                        e.setDirection(Direction.DOWN);
                        e.setPathStep(PathStep.TWO);
                    }
                    break;
                case TWO:
                    if(coordinates.getY() > pathLimit(5)) {
                        e.setDirection(Direction.LEFT);
                        e.setPathStep(PathStep.THREE);
                    }
                    break;
                case THREE:
                    if(coordinates.getX() < pathLimit(7)) {
                        e.setDirection(Direction.UP);
                        e.setPathStep(PathStep.FOUR);
                    }
                    break;
                case FOUR:
                    if(coordinates.getY() < pathLimit(4)) {
                        e.setDirection(Direction.LEFT);
                        e.setPathStep(PathStep.FIVE);
                    }
                    break;
                case FIVE:
                    if(coordinates.getX() < pathLimit(4)) {
                        e.setDirection(Direction.DOWN);
                        e.setPathStep(PathStep.SIX);
                    }
                    break;
                case SIX:
                    if(coordinates.getY() > pathLimit(5)) {
                        e.setDirection(Direction.LEFT);
                        e.setPathStep(PathStep.SEVEN);
                    }
                    break;
                case SEVEN:
                    if(coordinates.getX() < pathLimit(2)) {
                        e.setDirection(Direction.DOWN);
                        e.setPathStep(PathStep.EIGHT);
                    }
                    break;
                case EIGHT:
                    if(coordinates.getY() > pathLimit(8)) {
                        e.setDirection(Direction.RIGHT);
                        e.setPathStep(PathStep.NINE);
                    }
                    break;
                case NINE:
                    if(coordinates.getX() > pathLimit(6)) {
                        e.setDirection(Direction.UP);
                        e.setPathStep(PathStep.TEN);
                    }
                    break;
                case TEN:
                    if(coordinates.getY() < pathLimit(7)) {
                        e.setDirection(Direction.RIGHT);
                        e.setPathStep(PathStep.ELEVEN);
                    }
                    break;
                case ELEVEN:
                    if(coordinates.getX() > pathLimit(13)) {
                        e.setDirection(Direction.DOWN);
                    }
                    break;
                default:
                    e.setPathStep(PathStep.ZERO);
                    System.out.println("ERROR: pathStep is wrong");
                    break;
            }
        }
    }
}