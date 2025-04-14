package model;

import enums.FishingPole;

import java.util.List;

public class Fish {
    private String name;
    private String quality;
    private boolean isLegendary;
    private int basePrice;

    public Fish(String name, String quality, boolean isLegendary, int basePrice) {
        this.name = name;
        this.quality = quality;
        this.isLegendary = isLegendary;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public String getQuality() {
        return quality;
    }

    public boolean isLegendary() {
        return isLegendary;
    }

    public int getBasePrice() {
        return basePrice;
    }
    public int getSellPrice() {

    }
    public List<Fish> fishing(FishingPole pole, int skill, String season) {

    }

}
