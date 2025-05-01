package model;

import enums.FishingPoleType;
import enums.Store;

public class FishingPole extends Tools {
    private final FishingPoleType type;
    private  final Store store=Store.fishShop;
    public Store getStore() {
        return store;
    }

    public FishingPoleType getType() {
        return type;
    }


    public FishingPole(FishingPoleType type) {
        this.type = type;
    }

    public boolean canUse(int fishingLevel) {
        return fishingLevel >= type.getRequiredLevel();
    }

    public int getEnergyUsage(int fishingLevel) {

        if (fishingLevel >= 10) {
            return Math.max(1, type.getEnergyPerUse() - 1);
        }
        return type.getEnergyPerUse();
    }

    public boolean canCatchAllFish() {
        return type.canCatchAllFish();
    }

}
