package model.FarmingProdocts;

public class Fruit {
    private FruitType type;

    public Fruit(FruitType type) {
        this.type = type;
    }

    public FruitType getType() {
        return type;
    }

    public void setType(FruitType type) {
        this.type = type;
    }
}
