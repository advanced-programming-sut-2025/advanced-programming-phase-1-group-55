package model.FarmingProdocts;

public class ForagingTree {
    private final String name;
    private final String season;

    public ForagingTree(String name, String season) {
        this.name = name;
        this.season = season;
    }

    public String getName() {
        return name;
    }

    public String getSeason() {
        return season;
    }
    @Override
    public String toString() {
        return "Crop{" +
                "name='" + name + '\'' +
                ", season=" + season +
                '}';
    }
}
