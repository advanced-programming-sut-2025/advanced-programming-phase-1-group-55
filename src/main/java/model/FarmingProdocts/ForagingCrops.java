package model.FarmingProdocts;

import model.Item.Item;

public class ForagingCrops  {
    private String name;
    private final String season;
    private final int baseSellPrice;
    private final int energy;

    public ForagingCrops(String name, String season, int baseSellPrice, int energy) {
        this.name = name;
        this.season = season;
        this.baseSellPrice = baseSellPrice;
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public String getSeason() {
        return season;
    }

    public int getBaseSellPrice() {
        return baseSellPrice;
    }

    public int getEnergy() {
        return energy;
    }

    @Override
    public String toString() {
        return "Crop{" +
                "name='" + name + '\'' +
                ", season='" + season + '\'' +
                ", base sell price=" + baseSellPrice +
                ", energy=" + energy +
                '}';
    }
}
