package Tool;

public enum FishingPoleType {
    TRAINING_ROD(0, 8, 25, false),
    BAMBOO_ROD( 0, 8, 500, true),
    FIBERGLASS_ROD( 2, 6, 1800, true),
    IRIDIUM_ROD( 4, 4, 7500, true);

    private final int requiredLevel;
    private final int energyPerUse;
    private final int price;
    private final boolean canCatchAllFish;

    FishingPoleType( int requiredLevel, int energyPerUse, int price, boolean canCatchAllFish) {

        this.requiredLevel = requiredLevel;
        this.energyPerUse = energyPerUse;
        this.price = price;
        this.canCatchAllFish = canCatchAllFish;
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
}
