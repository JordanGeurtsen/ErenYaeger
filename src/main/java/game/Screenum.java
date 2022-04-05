package game;

public enum Screenum {
    TITLE (1),
    GAME (2),
    FINAL (3);

    private final int id;

    Screenum(int id) {this.id = id;}

    public int getId() {return id;}
}
