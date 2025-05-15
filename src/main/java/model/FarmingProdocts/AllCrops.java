package model.FarmingProdocts;


import model.Item.Item;
import model.Item.ItemType;

import java.util.List;

public enum AllCrops {
    BLUE_JAZZ("Blue Jazz" , ItemType.BLUE_JAZZ_CROP, AllForagingSeeds.JAZZ_SEED, List.of(1, 2, 2, 2), 7, true, 0, 50, true, 45, false),
    CARROT("Carrot",ItemType.CARROT_CROP, AllForagingSeeds.CARROT_SEEDS, List.of(1, 1, 1), 3, true, 0, 35, true, 25, false),
    CAULIFLOWER( "Cauliflower",ItemType.CAULIFLOWER_CROP, AllForagingSeeds.CAULIFLOWER_SEEDS, List.of(1, 2, 4, 4, 1), 12, true, 0, 175, true, 75, true),
    COFFEE_BEAN( "Coffee Bean",ItemType.COFFEE_BEAN_CROP, AllForagingSeeds.COFFEE_BEAN, List.of(1, 2, 2, 3, 2), 10, false, 2, 15, false, 0, false),
    GARLIC("Garlic",ItemType.GARLIC_CROP, AllForagingSeeds.GARLIC_SEEDS, List.of(1, 1, 1, 1), 4, true, 0, 60, true, 20, false),
    GREEN_BEAN("Green Bean",ItemType.GREEN_BEAN_CROP, AllForagingSeeds.BEAN_STARTER, List.of(1, 1, 1, 3, 4), 10, false, 3, 40, true, 25, false),
    KALE("Kale",ItemType.KALE_CROP, AllForagingSeeds.KALE_SEEDS, List.of(1, 2, 2, 1), 6, true, 0, 110, true, 50, false),
    PARSNIP("Parsnip",ItemType.PARSNIP_CROP, AllForagingSeeds.PARSNIP_SEEDS, List.of(1, 1, 1, 1), 4, true, 0, 35, true, 25, false),
    POTATO("Potato",ItemType.POTATO_CROP, AllForagingSeeds.POTATO_SEEDS, List.of(1, 1, 1, 2, 1), 6, true, 0, 80, true, 25, false),
    RHUBARB("Rhubarb",ItemType.RHUBARB_CROP, AllForagingSeeds.RHUBARB_SEEDS, List.of(2, 2, 2, 3, 4), 13, true, 0, 220, false, 0, false),
    STRAWBERRY("Strawberry",ItemType.STRAWBERRY_CROP, AllForagingSeeds.STRAWBERRY_SEEDS, List.of(1, 1, 2, 2, 2), 8, false, 4, 120, true, 50, false),
    TULIP("Tulip",ItemType.TULIP_CROP, AllForagingSeeds.TULIP_BULB, List.of(1, 1, 2, 2), 6, true, 0, 30, true, 45, false),
    UNMILLED_RICE("Unmilled Rice",ItemType.UNMILLED_RICE_CROP, AllForagingSeeds.RICE_SHOOT, List.of(1, 2, 2, 3), 8, true, 0, 30, true, 3, false),
    BLUEBERRY("Blueberry",ItemType.BLUEBERRY_CROP, AllForagingSeeds.BLUEBERRY_SEEDS, List.of(1, 3, 3, 4, 2), 13, false, 4, 50, true, 25, false),
    CORN("Corn",ItemType.CORN_CROP, AllForagingSeeds.CORN_SEEDS, List.of(2, 3, 3, 3, 3), 14, false, 4, 50, true, 25, false),
    HOPS("Hops",ItemType.HOPS_CROP, AllForagingSeeds.HOPS_STARTER, List.of(1, 1, 2, 3, 4), 11, false, 1, 25, true, 45, false),
    HOT_PEPPER("Hot Pepper",ItemType.HOT_PEPPER_CROP, AllForagingSeeds.PEPPER_SEEDS, List.of(1, 1, 1, 1, 1), 5, false, 3, 40, true, 13, false),
    MELON("Melon",ItemType.MELON_CROP, AllForagingSeeds.MELON_SEEDS, List.of(1, 2, 3, 3, 3), 12, true, 0, 250, true, 113, true),
    POPPY("Poppy",ItemType.POPPY_CROP, AllForagingSeeds.POPPY_SEEDS, List.of(1, 2, 2, 2), 7, true, 0, 140, true, 45, false),
    RADISH("Radish",ItemType.RADISH_CROP, AllForagingSeeds.RADISH_SEEDS, List.of(2, 1, 2, 1), 6, true, 0, 90, true, 45, false),
    RED_CABBAGE("Red Cabbage",ItemType.RED_CABBAGE_CROP, AllForagingSeeds.RED_CABBAGE_SEEDS, List.of(2, 1, 2, 2, 2), 9, true, 0, 260, true, 75, false),
    STARFRUIT("Starfruit",ItemType.STARFRUIT_CROP, AllForagingSeeds.STARFRUIT_SEEDS, List.of(2, 3, 2, 3, 3), 13, true, 0, 750, true, 125, false),
    SUMMER_SPANGLE("Summer Spangle",ItemType.SUMMER_SPANGLE_CROP, AllForagingSeeds.SPANGLE_SEEDS, List.of(1, 2, 3, 1), 8, true, 0, 90, true, 45, false),
    SUMMER_SQUASH("Summer Squash",ItemType.SUMMER_SQUASH_CROP, AllForagingSeeds.SUMMER_SQUASH_SEEDS, List.of(1, 1, 1, 2, 1), 6, false, 3, 45, true, 63, false),
    SUNFLOWER("Sunflower",ItemType.SUNFLOWER_CROP, AllForagingSeeds.SUNFLOWER_SEEDS, List.of(1, 2, 3, 2), 8, true, 0, 80, true, 45, false),
    TOMATO("Tomato",ItemType.TOMATO_CROP, AllForagingSeeds.TOMATO_SEEDS, List.of(2, 2, 2, 2, 3), 11, false, 4, 60, true, 20, false),
    WHEAT("Wheat",ItemType.WHEAT_CROP, AllForagingSeeds.WHEAT_SEEDS, List.of(1, 1, 1, 1), 4, true, 0, 25, false, 0, false),
    AMARANTH("Amaranth",ItemType.AMARANTH_CROP, AllForagingSeeds.AMARANTH_SEEDS, List.of(1, 2, 2, 2), 7, true, 0, 150, true, 50, false),
    ARTICHOKE("Artichoke",ItemType.ARTICHOKE_CROP, AllForagingSeeds.ARTICHOKE_SEEDS, List.of(2, 2, 1, 2, 1), 8, true, 0, 160, true, 30, false),
    BEET("Beet",ItemType.BEET_CROP, AllForagingSeeds.BEET_SEEDS, List.of(1, 1, 2, 2), 6, true, 0, 100, true, 30, false),
    BOK_CHOY("Bok Choy",ItemType.BOK_CHOY_CROP, AllForagingSeeds.BOK_CHOYS_SEEDS, List.of(1, 1, 1, 1), 4, true, 0, 80, true, 25, false),
    BROCCOLI("Broccoli",ItemType.BROCCOLI_CROP, AllForagingSeeds.BROCCOLI_SEEDS, List.of(2, 2, 2, 2), 8, false, 4, 70, true, 63, false),
    CRANBERRIES("Cranberries",ItemType.CRANBERRIES_CROP, AllForagingSeeds.CRANBERRY_SEEDS, List.of(1, 2, 1, 1, 2), 7, false, 5, 75, true, 38, false),
    EGGPLANT("Eggplant",ItemType.EGGPLANT_CROP, AllForagingSeeds.EGGPLANT_SEEDS, List.of(1, 1, 1, 1), 5, false, 5, 60, true, 20, false),
    GRAPE("Grape",ItemType.GRAPE_CROP, AllForagingSeeds.GRAPE_STARTER, List.of(1, 1, 2, 3, 3), 10, false, 3, 80, true, 38, false),
    PUMPKIN("Pumpkin",ItemType.PUMPKIN_CROP, AllForagingSeeds.PUMPKIN_SEEDS, List.of(1, 2, 3, 4, 3), 13, true, 0, 320, false, 0, true),
    YAM("Yam",ItemType.YAM_CROP, AllForagingSeeds.YAM_SEEDS, List.of(1, 3, 3, 2), 10, false, 4, 100, true, 45, false),
    FAIRY_ROSE("Fairy Rose", ItemType.FAIRY_ROSE_CROP, AllForagingSeeds.FAIRY_SEEDS, List.of(1, 4, 4, 3), 12, true, 0, 290, true, 45, false),
    SWEET_GEM_BERRY("Sweet Gem Berry", ItemType.SWEET_GEM_BERRY_CROP, AllForagingSeeds.RARE_SEED, List.of(2, 4, 6, 6, 6), 24, true, 0, 3000, false, 0, false),
    POWDERMELON("Powdermelon", ItemType.POWDERMELON_CROP, AllForagingSeeds.POWDERMELON_SEEDS, List.of(1, 2, 1, 2, 1), 7, true, 0, 60, true, 63, true),
    ANCIENT_FRUIT("Ancient Fruit", ItemType.ANCIENT_FRUIT_CROP, AllForagingSeeds.ANCIENT_SEEDS, List.of(2, 7, 7, 7, 5), 28, false, 7, 550, false, 0, false);

    private final String name;
    private final ItemType type;
    private final Seed seed;
    private final List<Integer> stages;
    private final int totalHarvestTime;
    private final boolean isOneTime;
    private final int regrowthTime;
    private final int baseSellPrice;
    private final boolean isEdible;
    private final int baseEnergy;
    private final boolean canBecomeGiant;

    AllCrops(String name, ItemType type, Seed seed, List<Integer> stages, int totalHarvestTime, boolean isOneTime, int regrowthTime, int baseSellPrice, boolean isEdible, int baseEnergy, boolean canBecomeGiant) {
        this.name = name;
        this.type = type;
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

    public ItemType getType() {
        return type;
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



    public static AllCrops getCropType(String name) {
        for (AllCrops cropType : AllCrops.values()) {
            if (cropType.getName().equalsIgnoreCase(name)) {
                return cropType;
            }
        }
        return null;
    }









}



