package game;

public enum Round {
    ONE(0),
    TWO(1),
    THREE(2),
    FOUR(3),
    FIVE(4);

    private int id;

    Round(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setNextID(){this.id += 1;}
}

