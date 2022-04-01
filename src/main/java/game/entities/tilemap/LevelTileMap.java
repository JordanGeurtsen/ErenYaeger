package game.entities.tilemap;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.TileMap;
import game.entities.tilemap.ground.SelectGround;
import game.entities.tilemap.ground.Water;
import game.entities.tilemap.ground.Grass;
import game.entities.towers.Archer;
import game.entities.towers.Freezer;
import game.entities.towers.Hitman;

public class LevelTileMap extends TileMap {
    private int[][] levelMap = {
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



    public LevelTileMap (){
        super(new Coordinate2D(0,0), new Size(1050, 675));
    }


    @Override
    public void setupEntities() {
        addEntity(1, Grass.class, "sprites/grass.jpg");
        addEntity(2, Water.class, "sprites/water.jpg");
        addEntity(3, Archer.class);
        addEntity(4, Freezer.class);
        addEntity(5, Hitman.class);
        addEntity(6, SelectGround.class, "sprites/grass_select.png");
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
                    map[i][j] = 6;
                }
            }
        }
        this.levelMap = map;
    }

    public void setupNormalTileMap(){
        int[][] map = this.levelMap;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 6) {
                    map[i][j] = 1;
                }
            }
        }
        this.levelMap = map;
    }
}