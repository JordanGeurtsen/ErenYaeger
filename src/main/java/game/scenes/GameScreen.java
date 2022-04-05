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
import game.*;
import game.entities.buttons.NextRoundButton;
import game.entities.buttons.BuyButton;
import game.entities.counter.Counter;
import game.entities.enemies.*;
import game.entities.tilemap.LevelTileMap;
import game.entities.towers.Archer;
import game.entities.towers.Freezer;
import game.entities.towers.Hitman;
import game.entities.towers.Tower;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

import java.nio.channels.FileChannel;
import java.util.ArrayList;

import static game.scenes.FinalScreen.setFinalMessage;

public class GameScreen extends DynamicScene implements TileMapContainer, EntitySpawnerContainer, UpdateExposer, MouseButtonReleasedListener {
    private BonkTheTowerTD bonkTheTowerTD;
    public LevelTileMap levelTileMap = new LevelTileMap();
    private RoundExecutor roundExecutor = new RoundExecutor(this);
    public ArrayList<Enemy> enemyList = new ArrayList<>();
    public ArrayList<Enemy> spawnedEnemyList = new ArrayList<>();
    public ArrayList<Tower> towers = new ArrayList<>();
    public Round currentRound = Round.ZERO;
    public Counter coinCounter;
    public Counter pointCounter;
    public Counter liveCounter;
    public Counter roundCounter;
    public static int coins;
    public static int points;
    public static int lives;
    private final int blockSize = 75;
    private final int gameFieldSize = 1050;
    private int blockNrWidth;
    private int blockNrHeight;
    private double xCoordinateTower;
    private double yCoordinateTower;
    private int towerPrice;
    private Coordinate2D newTowerCoordinates;
    private int enemyListNr = 8;
    private int enemySpawnTimer = 40;
    private int enemySpawnInterval = 100;
    public boolean nextRound = false;

    public GameScreen(BonkTheTowerTD bonkTheTowerTD) {
        this.bonkTheTowerTD = bonkTheTowerTD;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.PAPAYAWHIP);
        setBackgroundAudioVolume(0.3);
        setBackgroundAudio("audio/relaxing_bg_music_2.mp3");
    }

    @Override
    public void setupEntities() {
        if(BuyButton.currentTowerSelected == "") {
            resetStartingVariables();

            roundCounter = new Counter(new Coordinate2D(1055, 5),  currentRound.getId() , "Round: ");
            addEntity(roundCounter);

            coinCounter = new Counter(new Coordinate2D(1055, 35), coins, "Coins: ");
            addEntity(coinCounter);

            pointCounter = new Counter(new Coordinate2D(1055, 65), points, "Points: ");
            addEntity(pointCounter);

            liveCounter = new Counter(new Coordinate2D(1055, 95), lives, "Lives: ");
            addEntity(liveCounter);

            var archerBuy = new BuyButton(new Coordinate2D(1050, 175), "sprites/towers/archer_logo.png",
                    "Archer", 200, 5, 225, this);
            addEntity(archerBuy);

            var hitmanBuy = new BuyButton(new Coordinate2D(1050, 300), "sprites/towers/hitman_logo.png",
                    "Hitman", 500, 40, 1250, this);
            addEntity(hitmanBuy);

            var freezerBuy = new BuyButton(new Coordinate2D(1050, 425), "sprites/towers/freezer_logo.png",
                    "Freezer", 300, 0, 118, this);
            addEntity(freezerBuy);

            roundExecutor.setEnemies(currentRound);
            enemyListNr = enemyList.size() -1;

            var nextRoundButton = new NextRoundButton(new Coordinate2D(1140, 600), this);
            addEntity(nextRoundButton);
            }
        towers.forEach(this::addEntity);
    }

    @Override
    public void setupEntitySpawners() {
        for (Enemy e: enemyList) {
            if (e instanceof MamaCoot) {
                addEntitySpawner( e.getBabyCootSpawner());
            }
        }
        for (Tower t : towers) {
            if (t instanceof Archer || t instanceof Hitman) {
                addEntitySpawner(t.getProjectileSpawner());
            }
        }
    }

    @Override
    public void setupTileMaps() {addTileMap(levelTileMap);}

    public void enemyPastBorder(Enemy e, int damage) {
        enemyList.remove(e);
        spawnedEnemyList.remove(e);
        e.remove();
        liveCounter.updateCounter("Lives: ", -damage);
    }

    @Override
    public void explicitUpdate(long l) {
        changingTileMap();
        enemiesPath();
        spawnEnemy();

        if(nextRound) {
            roundExecutor.setEnemies(currentRound);
            enemyListNr = enemyList.size() - 1;
            nextRound = false;
        }

        if(currentRound == Round.FIVE && enemyList.size() - 1 == 0){
            gameOver();
        }

        if (lives <= 0){
            gameOver();
        }
    }

    public void spawnEnemy(){
        if(enemySpawnTimer > enemySpawnInterval) {
            enemySpawnTimer = 0;
            if (enemyListNr > 0) {
                addEntity(enemyList.get(enemyListNr));
                spawnedEnemyList.add(enemyList.get(enemyListNr));
                enemyListNr--;
            }
        } else {
            enemySpawnTimer++;
        }
        for (Enemy e: enemyList) {
            if (e instanceof MamaCoot) {
                e.getBabyCootSpawner().setNeedToSpawn(false);
            }
        }
        for (Enemy e: spawnedEnemyList) {
            if (e instanceof MamaCoot) {
                e.getBabyCootSpawner().setNeedToSpawn(true);
            }
        }
    }

    public void changingTileMap(){
        if (!BuyButton.tileMapChanged) {
            if (BuyButton.isTowerSelected) {
                levelTileMap.changeTileMap(1, 4);
            } else {
                levelTileMap.changeTileMap(4, 1);
                BuyButton.currentTowerSelected = "";
                setBackgroundColor(Color.PAPAYAWHIP);
            }
            initTileMaps();
            BuyButton.tileMapChanged = true;
        }
        enemiesPath();
    }

    public void resetStartingVariables(){
        points = 0;
        lives = 20;
        coins = 200;
        currentRound = Round.ONE;
        towers.clear();
        enemyList.clear();
        spawnedEnemyList.clear();
        levelTileMap.changeTileMap(3, 1);
        levelTileMap.changeTileMap(4, 1);
    }

    public void gameOver(){
        setFinalMessage("Game Over!!");
        bonkTheTowerTD.setActiveScene(Screenum.FINAL.getId());
    }

    public boolean enoughMoney(String towerName) {
        if (towerName == "Archer") {
            towerPrice = Archer.getTowerPrice();
        } else if (towerName == "Hitman") {
            towerPrice = Hitman.getTowerPrice();
        } else {
            towerPrice = Freezer.getTowerPrice();
        }
        if(coins >= towerPrice ) {
            System.out.println(towerPrice);
            System.out.println(coins);
            return true;
        } else {
            return false;
        }

    }

    public void addNewTower(String towerSelectedName){
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
    }

    public void resetVariablesPlacingTower(int blockNrWidth, int blockNrHeight){
        levelTileMap.changeTile(blockNrWidth, blockNrHeight , 3);
        levelTileMap.changeTileMap(4, 1);
        initTileMaps();

        BuyButton.currentTowerSelected = "";
        BuyButton.isTowerSelected = false;
        BuyButton.tileMapChanged = true;
    }

    public void placeTower(Coordinate2D mouseCoordinates) {
        if (BuyButton.isTowerSelected) {
            if (mouseCoordinates.getX() < gameFieldSize) {
                blockNrWidth = (int) Math.floor(mouseCoordinates.getX() / blockSize);
                xCoordinateTower = blockNrWidth * blockSize + (blockSize / 2);
                blockNrHeight = (int)Math.floor(mouseCoordinates.getY() / blockSize);
                yCoordinateTower = blockNrHeight * blockSize + (blockSize / 2);
                newTowerCoordinates = new Coordinate2D(xCoordinateTower, yCoordinateTower);
                String towerSelectedName = BuyButton.currentTowerSelected;

                if (levelTileMap.freeSpace(blockNrWidth, blockNrHeight)) {
                    if (enoughMoney(towerSelectedName)) {
                        setBackgroundColor(Color.PAPAYAWHIP);
                        addNewTower(towerSelectedName);

                        coinCounter.updateCounter("Coins: ", -towerPrice);

                        setupEntities();
                        setupEntitySpawners();

                        resetVariablesPlacingTower(blockNrWidth, blockNrHeight);
                    } else {
                        setBackgroundColor(Color.DARKRED);
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

    public void enemiesPath() {
        for (Enemy e : spawnedEnemyList) {
            Coordinate2D coordinates =  e.getAnchorLocation();
            PathStep pathStep = e.getPathStep();

            switch(pathStep) {
                case ZERO:
                    e.setDirection(Direction.DOWN);
                    if (coordinates.getY() > pathLimit(2)) {
                        e.setPathStep(PathStep.ONE);
                    }
                    break;
                case ONE:
                    e.setDirection(Direction.RIGHT);
                    if(coordinates.getX() > pathLimit(11)) {
                        e.setPathStep(PathStep.TWO);
                    }
                    break;
                case TWO:
                    e.setDirection(Direction.DOWN);
                    if(coordinates.getY() > pathLimit(5)) {
                        e.setPathStep(PathStep.THREE);
                    }
                    break;
                case THREE:
                    e.setDirection(Direction.LEFT);
                    if(coordinates.getX() < pathLimit(7)) {
                        e.setPathStep(PathStep.FOUR);
                    }
                    break;
                case FOUR:
                    e.setDirection(Direction.UP);
                    if(coordinates.getY() < pathLimit(4)) {
                        e.setPathStep(PathStep.FIVE);
                    }
                    break;
                case FIVE:
                    e.setDirection(Direction.LEFT);
                    if(coordinates.getX() < pathLimit(4)) {
                        e.setPathStep(PathStep.SIX);
                    }
                    break;
                case SIX:
                    e.setDirection(Direction.DOWN);
                    if(coordinates.getY() > pathLimit(5)) {
                        e.setPathStep(PathStep.SEVEN);
                    }
                    break;
                case SEVEN:
                    e.setDirection(Direction.LEFT);
                    if(coordinates.getX() < pathLimit(2)) {
                        e.setPathStep(PathStep.EIGHT);
                    }
                    break;
                case EIGHT:
                    e.setDirection(Direction.DOWN);
                    if(coordinates.getY() > pathLimit(8)) {
                        e.setPathStep(PathStep.NINE);
                    }
                    break;
                case NINE:
                    e.setDirection(Direction.RIGHT);
                    if(coordinates.getX() > pathLimit(6)) {

                        e.setPathStep(PathStep.TEN);
                    }
                    break;
                case TEN:
                    e.setDirection(Direction.UP);
                    if(coordinates.getY() < pathLimit(7)) {
                        e.setPathStep(PathStep.ELEVEN);
                    }
                    break;
                case ELEVEN:
                    e.setDirection(Direction.RIGHT);
                    if(coordinates.getX() > pathLimit(13)) {
                        e.setDirection(Direction.DOWN);
                    }
                    break;
                case TWELVE:
                    if (coordinates.getY() > pathLimit(0)) {
                        e.setPathStep(PathStep.ZERO);
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