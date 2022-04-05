package game.entities.tilemap;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.TileMap;
import game.entities.tilemap.ground.TowerGround;
import game.entities.tilemap.ground.SelectGround;
import game.entities.tilemap.ground.Water;
import game.entities.tilemap.ground.Grass;

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

    public LevelTileMap() {
        super(new Coordinate2D(0, 0), new Size(1050, 675));
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

    public void changeTile(int blockNrWidth, int blockNrHeight, int entityIdentifier) {
        this.levelMap[blockNrHeight][blockNrWidth] = entityIdentifier;
    }

    public boolean freeSpace(int blockNrWidth, int blockNrHeight) {
        if (this.levelMap[blockNrHeight][blockNrWidth] == 4) {
            return true;
        } else {
            return false;
        }
    }

    public void changeTileMap(int oldIdentifier, int newIdentifier) {
        for (int blockNrHeight = 0; blockNrHeight < levelMap.length; blockNrHeight++) {
            for (int blockNrWidth = 0; blockNrWidth < levelMap[0].length; blockNrWidth++) {
                if (levelMap[blockNrHeight][blockNrWidth] == oldIdentifier) {
                    changeTile(blockNrWidth, blockNrHeight, newIdentifier);
                }
            }
        }
    }
}