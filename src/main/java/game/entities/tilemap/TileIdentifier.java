package game.entities.tilemap;

public enum TileIdentifier {
    GRASS (1),
    WATER (2),
    TOWERGROUND (3),
    SELECTGROUND (4);

    private final int id;

    TileIdentifier(int id) {
        this.id = id;
    }

    public int getId() {return id;}
}

