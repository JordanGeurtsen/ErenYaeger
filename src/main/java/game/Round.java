package game;

public enum Round {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private int id;

    Round(int id) {this.id = id;}

    public int getId() {return this.id;}

    public void setNextId() {this.id += 1;}
}

