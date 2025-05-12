package model.FarmingProdocts;


import java.util.List;

public enum AllCrops {
    BLUE_JAZZ("Blue Jazz", ForagingSeed.BLUE_JAZZ_SEEDS, List.of(1, 2, 2, 2), 7, true, 0, 50, true, 45, false),
    CARROT("Carrot", ForagingSeed.CARROT_SEEDS, List.of(1, 1, 1), 3, true, 0, 35, true, 25, false),
    CAULIFLOWER("Cauliflower", ForagingSeed.CAULIFLOWER_SEEDS, List.of(1, 2, 4, 4, 1), 12, true, 0, 175, true, 75, true),
    COFFEE_BEAN("Coffee Bean", ForagingSeed.COFFEE_BEAN, List.of(1, 2, 2, 3, 2), 10, false, 2, 15, false, 0, false),
    GARLIC("Garlic", ForagingSeed.GARLIC_SEEDS, List.of(1, 1, 1, 1), 4, true, 0, 60, true, 20, false),
    GREEN_BEAN("Green Bean", ForagingSeed.BEAN_STARTER, List.of(1, 1, 1, 3, 4), 10, false, 3, 40, true, 25, false),
    KALE("Kale", ForagingSeed.KALE_SEEDS, List.of(1, 2, 2, 1), 6, true, 0, 110, true, 50, false),
    PARSNIP("Parsnip", ForagingSeed.PARSNIP_SEEDS, List.of(1, 1, 1, 1), 4, true, 0, 35, true, 25, false),
    POTATO("Potato", ForagingSeed.POTATO_SEEDS, List.of(1, 1, 1, 2, 1), 6, true, 0, 80, true, 25, false),
    RHUBARB("Rhubarb", ForagingSeed.RHUBARB_SEEDS, List.of(2, 2, 2, 3, 4), 13, true, 0, 220, false, 0, false),
    STRAWBERRY("Strawberry", ForagingSeed.STRAWBERRY_SEEDS, List.of(1, 1, 2, 2, 2), 8, false, 4, 120, true, 50, false),
    TULIP("Tulip", ForagingSeed.TULIP_BULB, List.of(1, 1, 2, 2), 6, true, 0, 30, true, 45, false),
    UNMILLED_RICE("Unmilled Rice", ForagingSeed.RICE_SHOOT, List.of(1, 2, 2, 3), 8, true, 0, 30, true, 3, false),
    BLUEBERRY("Blueberry", ForagingSeed.BLUEBERRY_SEEDS, List.of(1, 3, 3, 4, 2), 13, false, 4, 50, true, 25, false),
    CORN("Corn", ForagingSeed.CORN_SEEDS, List.of(2, 3, 3, 3, 3), 14, false, 4, 50, true, 25, false),
    HOPS("Hops", ForagingSeed.HOPS_STARTER, List.of(1, 1, 2, 3, 4), 11, false, 1, 25, true, 45, false),
    HOT_PEPPER("Hot Pepper", ForagingSeed.PEPPER_SEEDS, List.of(1, 1, 1, 1, 1), 5, false, 3, 40, true, 13, false),
    MELON("Melon", ForagingSeed.MELON_SEEDS, List.of(1, 2, 3, 3, 3), 12, true, 0, 250, true, 113, true),
    POPPY("Poppy", ForagingSeed.POPPY_SEEDS, List.of(1, 2, 2, 2), 7, true, 0, 140, true, 45, false),
    RADISH("Radish", ForagingSeed.RADISH_SEEDS, List.of(2, 1, 2, 1), 6, true, 0, 90, true, 45, false),
    RED_CABBAGE("Red Cabbage", ForagingSeed.RED_CABBAGE_SEEDS, List.of(2, 1, 2, 2, 2), 9, true, 0, 260, true, 75, false),
    STARFRUIT("Starfruit", ForagingSeed.STARFRUIT_SEEDS, List.of(2, 3, 2, 3, 3), 13, true, 0, 750, true, 125, false),
    SUMMER_SPANGLE("Summer Spangle", ForagingSeed.SPANGLE_SEEDS, List.of(1, 2, 3, 1), 8, true, 0, 90, true, 45, false),
    SUMMER_SQUASH("Summer Squash", ForagingSeed.SUMMER_SQUASH_SEEDS, List.of(1, 1, 1, 2, 1), 6, false, 3, 45, true, 63, false),
    SUNFLOWER("Sunflower", ForagingSeed.SUNFLOWER_SEEDS, List.of(1, 2, 3, 2), 8, true, 0, 80, true, 45, false),
    TOMATO("Tomato", ForagingSeed.TOMATO_SEEDS, List.of(2, 2, 2, 2, 3), 11, false, 4, 60, true, 20, false),
    WHEAT("Wheat", ForagingSeed.WHEAT_SEEDS, List.of(1, 1, 1, 1), 4, true, 0, 25, false, 0, false),
    AMARANTH("Amaranth", ForagingSeed.AMARANTH_SEEDS, List.of(1, 2, 2, 2), 7, true, 0, 150, true, 50, false),
    ARTICHOKE("Artichoke", ForagingSeed.ARTICHOKE_SEEDS, List.of(2, 2, 1, 2, 1), 8, true, 0, 160, true, 30, false),
    BEET("Beet", ForagingSeed.BEET_SEEDS, List.of(1, 1, 2, 2), 6, true, 0, 100, true, 30, false),
    BOK_CHO("Bok Choy", ForagingSeed.BOK_CHOYS_SEEDS, List.of(1, 1, 1, 1), 4, true, 0, 80, true, 25, false),
    BROCCOLI("Broccoli", ForagingSeed.BROCCOLI_SEEDS, List.of(2, 2, 2, 2), 8, false, 4, 70, true, 63, false),
    CRANBERRIES("Cranberries", ForagingSeed.CRANBERRY_SEEDS, List.of(1, 2, 1, 1, 2), 7, false, 5, 75, true, 38, false),
    EGGPLANT("Eggplant", ForagingSeed.EGGPLANT_SEEDS, List.of(1, 1, 1, 1), 5, false, 5, 60, true, 20, false),
    FAIRY_ROSE("Fairy Rose", ForagingSeed.FAIRY_SEEDS, List.of(1, 4, 4, 3), 12, true, 0, 290, true, 45, false),
    GRAPE("Grape", ForagingSeed.GRAPE_STARTER, List.of(1, 1, 2, 3, 3), 10, false, 3, 80, true, 38, false),
    PUMPKIN("Pumpkin", ForagingSeed.PUMPKIN_SEEDS, List.of(1, 2, 3, 4, 3), 13, true, 0, 320, false, 0, true),
    YAM("Yam", ForagingSeed.YAM_SEEDS, List.of(1, 3, 3, 2), 10, false, 4, 100, true, 45, false);

    private final String name;
    private final Seed seed;
    private final List<Integer> stages;
    private final int totalHarvestTime;
    private final boolean isOneTime;
    private final int regrowthTime;
    private final int baseSellPrice;
    private final boolean isEdible;
    private final int baseEnergy;
    private final boolean canBecomeGiant;

    AllCrops(String name, Seed seed, List<Integer> stages, int totalHarvestTime, boolean isOneTime, int regrowthTime, int baseSellPrice, boolean isEdible, int baseEnergy, boolean canBecomeGiant) {
        this.name = name;
        this.seed = seed;
        this.stages = stages;
        this.totalHarvestTime = totalHarvestTime;
        this.isOneTime = isOneTime;
        this.regrowthTime = regrowthTime;
        this.baseSellPrice = baseSellPrice;
        this.isEdible = isEdible;
        this.baseEnergy = baseEnergy;
        this.canBecomeGiant = canBecomeGiant;
    }

    public String getName() {
        return name;
    }

    public Seed getSeed() {
        return seed;
    }

    public List<Integer> getStages() {
        return stages;
    }

    public int getTotalHarvestTime() {
        return totalHarvestTime;
    }

    public boolean isOneTime() {
        return isOneTime;
    }

    public int getRegrowthTime() {
        return regrowthTime;
    }

    public int getBaseSellPrice() {
        return baseSellPrice;
    }

    public boolean isEdible() {
        return isEdible;
    }

    public int getBaseEnergy() {
        return baseEnergy;
    }

    public boolean isCanBecomeGiant() {
        return canBecomeGiant;
    }
}



