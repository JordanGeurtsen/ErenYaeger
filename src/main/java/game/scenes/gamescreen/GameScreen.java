package game.scenes.gamescreen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.api.userinput.MouseButtonReleasedListener;
import game.BonkTheTowerTD;
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

import java.util.ArrayList;
import java.util.Objects;

import static game.scenes.FinalScreen.setFinalMessage;

public class GameScreen extends DynamicScene implements TileMapContainer, EntitySpawnerContainer, UpdateExposer, MouseButtonReleasedListener {
    private final BonkTheTowerTD bonkTheTowerTD;
    private final LevelTileMap levelTileMap = new LevelTileMap();
    private final RoundExecutor roundExecutor = new RoundExecutor(this);
    public ArrayList<Enemy> enemyList = new ArrayList<>();
    public ArrayList<Enemy> spawnedEnemyList = new ArrayList<>();
    public ArrayList<Tower> towers = new ArrayList<>();
    public Round currentRound = Round.ZERO;
    public Counter coinCounter;
    public Counter pointCounter;
    public Counter liveCounter;
    public Counter roundCounter;
    private NextRoundButton nextRoundButton;
    public int coins;
    public static int points;
    public int lives;
    public final int blockSize = 75;
    private int towerPrice;
    private Coordinate2D newTowerCoordinates;
    private int enemyListNr = 8;
    private int enemySpawnTimer = 40;
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
        if(Objects.equals(BuyButton.currentTowerSelected, "")) {
            resetStartingVariables();

            roundCounter = new Counter(new Coordinate2D(1055, 5),  currentRound.getId(), "Round: ");
            addEntity(roundCounter);

            coinCounter = new Counter(new Coordinate2D(1055, 35), coins, "Coins: ");
            addEntity(coinCounter);

            pointCounter = new Counter(new Coordinate2D(1055, 65), points, "Points: ");
            addEntity(pointCounter);

            liveCounter = new Counter(new Coordinate2D(1055, 95), lives, "Lives: ");
            addEntity(liveCounter);

            BuyButton archerBuy = new BuyButton(new Coordinate2D(1050, 175), "sprites/towers/archer_logo.png",
                    "Archer", 200, 5, 225);
            addEntity(archerBuy);

            BuyButton hitmanBuy = new BuyButton(new Coordinate2D(1050, 300), "sprites/towers/hitman_logo.png",
                    "Hitman", 500, 40, 1250);
            addEntity(hitmanBuy);

            BuyButton freezerBuy = new BuyButton(new Coordinate2D(1050, 425), "sprites/towers/freezer_logo.png",
                    "Freezer", 300, 0, 118);
            addEntity(freezerBuy);

            roundExecutor.setEnemies(currentRound);
            enemyListNr = enemyList.size() -1;

            nextRoundButton = new NextRoundButton(new Coordinate2D(1140, 600), this);
            addEntity(nextRoundButton);
            }
        towers.forEach(this::addEntity);
    }

    @Override
    public void setupEntitySpawners() {
        for (Enemy e: enemyList) {
            if (e instanceof MamaCoot) {
                addEntitySpawner(((MamaCoot) e).getBabyCootSpawner());
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

    @Override
    public void explicitUpdate(long l) {
        changeTileMap();
        spawnEnemy();

    if (spawnedEnemyList.size() > 0) {
        for (Enemy e: spawnedEnemyList){
            e.enemyPath();
            e.updateWalkedDistance(e.getMovementSpeed());
        }
    }

    if (enemyList.size() - 1 == 0){
        nextRoundButton.setFill(Color.GREEN);
    } else {
        nextRoundButton.setFill(Color.DARKRED);
    }

        if(nextRound) {
            int roundAdvance = 1;
            roundCounter.updateCounter("Round: ", roundAdvance);
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
        int enemySpawnInterval = 100;
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
                ((MamaCoot) e).getBabyCootSpawner().setNeedToSpawn(false);
            }
        }
        for (Enemy e: spawnedEnemyList) {
            if (e instanceof MamaCoot) {
                ((MamaCoot) e).getBabyCootSpawner().setNeedToSpawn(true);
                setupEntitySpawners();
            }
        }
    }

    public void changeTileMap(){
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
        if (Objects.equals(towerName, "Archer")) {
            towerPrice = Archer.getTowerPrice();
        } else if (Objects.equals(towerName, "Hitman")) {
            towerPrice = Hitman.getTowerPrice();
        } else {
            towerPrice = Freezer.getTowerPrice();
        }
        return coins >= towerPrice;
    }

    public void addNewTower(String towerSelectedName){
        if (Objects.equals(towerSelectedName, "Archer")) {
            Archer newTower = new Archer("sprites/towers/archer_tower.png", newTowerCoordinates, this);
            towers.add(newTower);
        } else if (Objects.equals(towerSelectedName, "Hitman")) {
            Hitman newTower = new Hitman("sprites/towers/hitman_tower.png", newTowerCoordinates, this);
            towers.add(newTower);
        } else if (Objects.equals(towerSelectedName, "Freezer")) {
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
            int gameFieldSize = 1050;
            if (mouseCoordinates.getX() < gameFieldSize) {
                int blockNrWidth = (int) Math.floor(mouseCoordinates.getX() / blockSize);
                double xCoordinateTower = blockNrWidth * blockSize + (blockSize / 2.0);
                int blockNrHeight = (int) Math.floor(mouseCoordinates.getY() / blockSize);
                double yCoordinateTower = blockNrHeight * blockSize + (blockSize / 2.0);
                newTowerCoordinates = new Coordinate2D(xCoordinateTower, yCoordinateTower);
                String towerSelectedName = BuyButton.currentTowerSelected;

                if (levelTileMap.freeSpace(blockNrWidth, blockNrHeight)) {
                    if (enoughMoney(towerSelectedName)) {
                        setBackgroundColor(Color.PAPAYAWHIP);
                        addNewTower(towerSelectedName);
                        coins -= towerPrice;
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

}