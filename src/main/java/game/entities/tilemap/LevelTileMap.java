package game.entities.tilemap;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.TileMap;
import game.entities.tilemap.ground.TowerGround;
import game.entities.tilemap.ground.SelectGround;
import game.entities.tilemap.ground.Water;
import game.entities.tilemap.ground.Grass;
import static game.entities.tilemap.TileIdentifier.*;

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
        addEntity(GRASS.getId(), Grass.class, "sprites/grass.jpg");
        addEntity(WATER.getId(), Water.class, "sprites/water.jpg");
        addEntity(TOWERGROUND.getId(), TowerGround.class, "sprites/grass.jpg");
        addEntity(SELECTGROUND.getId(), SelectGround.class, "sprites/grass_select.png");
    }

    @Override
    public int[][] defineMap() {
        return this.levelMap;
    }

    public void changeTile(int blockNrWidth, int blockNrHeight, int entityIdentifier) {
        this.levelMap[blockNrHeight][blockNrWidth] = entityIdentifier;
    }

    public boolean freeSpace(int blockNrWidth, int blockNrHeight) {
        return this.levelMap[blockNrHeight][blockNrWidth] == 4;
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