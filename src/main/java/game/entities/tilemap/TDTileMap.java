package game.entities.tilemap;

import com.github.hanyaeger.api.scenes.TileMap;
import game.entities.tilemap.ground.Grass;
import game.entities.tilemap.ground.Path;
import game.entities.towers.Archer;
import game.entities.towers.Freezer;
import game.entities.towers.Hitman;

public class TDTileMap extends TileMap{

    private int[][] map;

    public TDTileMap (int[][] map){
        this.map = map;
    }

    @Override
    public void setupEntities() {
        addEntity(0, Grass.class);
        addEntity(1, Path.class);
        addEntity(2, Archer.class);
        addEntity(3, Freezer.class);
        addEntity(4, Hitman.class);
    }

    @Override
    public int[][] defineMap() {
        return map;
    }

}