package game.entities.tilemap;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.TileMap;
import game.entities.tilemap.ground.TowerGround;
import game.entities.tilemap.ground.SelectGround;
import game.entities.tilemap.ground.Water;
import game.entities.tilemap.ground.Grass;

import java.util.concurrent.CopyOnWriteArrayList;

public class LevelTileMap extends TileMap {
    public int[][] levelMap = {
            {1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1},
            {1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 2, 1, 1, 1},
            {1, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 1, 1, 1},
            {1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 2, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1},
            {1, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 2, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1}
    };

    private int blockNrWidth;
    private int blockNrHeight;
    private final int blockSize = 75;

    public LevelTileMap (){
        super(new Coordinate2D(0,0), new Size(1050, 675));
    }


    @Override
    public void setupEntities() {
        addEntity(1, Grass.class, "sprites/grass.jpg");
        addEntity(2, Water.class, "sprites/water.jpg");
        addEntity(3, TowerGround.class, "sprites/grass.jpg");
        addEntity(4, SelectGround.class, "sprites/grass_select.png");
    }

    @Override
    public int[][] defineMap() {
        return this.levelMap;
    }

    public void setupSelectTileMap() {
        int[][] map = this.levelMap;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = 4;
                }
            }
        }
        this.levelMap = map;
    }

    public void setupNormalTileMap(){
        int[][] map = this.levelMap;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 4) {
                    map[i][j] = 1;
                }
            }
        }
        this.levelMap = map;
    }

    public void changeTile(int blockNrWidth, int blockNrHeight, int entityIdentifier){
        this.levelMap[blockNrHeight][blockNrWidth] = entityIdentifier;
    }

    public boolean freeSpace(int blockNrWidth, int blockNrHeight){
        if(this.levelMap[blockNrHeight][blockNrWidth] == 4){
            return true;
        } else{
            return false;
        }
    }

//    public int getTileID(Coordinate2D coordinate2D){
//        blockNrWidth = (int) Math.floor(coordinate2D.getX() / blockSize);
//        blockNrHeight = (int) Math.floor(coordinate2D.getY() / blockSize);
//        return this.levelMap[blockNrHeight][blockNrWidth];
//    }

    public void resetLevelMap(){
        for(int i = 0; i < levelMap.length; i++){
            for(int j = 0; j < levelMap[0].length; j++){
                if(levelMap[i][j] == 3 || levelMap[i][j] == 4) {
                    changeTile(i, j, 1);
                }
            }
        }
    }
}