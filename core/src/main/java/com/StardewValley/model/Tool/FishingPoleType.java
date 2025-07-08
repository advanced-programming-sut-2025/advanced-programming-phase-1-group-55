package com.StardewValley.model.Tool;

public enum FishingPoleType {
    TRAINING_ROD(0, 8, 25, false, 0.1),
    BAMBOO_ROD( 0, 8, 500, true, 0.5),
    FIBERGLASS_ROD( 2, 6, 1800, true, 0.9),
    IRIDIUM_ROD( 4, 4, 7500, true, 1.2);

    private final int requiredLevel;
    private final int energyPerUse;
    private final int price;
    private final boolean canCatchAllFish;
    private final double fishQuality;

    FishingPoleType(int requiredLevel, int energyPerUse, int price, boolean canCatchAllFish, double fishQuality) {
        this.requiredLevel = requiredLevel;
        this.energyPerUse = energyPerUse;
        this.price = price;
        this.canCatchAllFish = canCatchAllFish;
        this.fishQuality = fishQuality;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public int getEnergyPerUse() {
        return energyPerUse;
    }

    public int getPrice() {
        return price;
    }

    public boolean canCatchAllFish() {
        return canCatchAllFish;
    }

    public double getFishQuality() {
        return fishQuality;
    }
}
