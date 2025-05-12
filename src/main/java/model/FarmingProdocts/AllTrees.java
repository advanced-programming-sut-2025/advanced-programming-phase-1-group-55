package model.FarmingProdocts;

import java.util.Arrays;
import java.util.List;

public enum AllTrees {
    APRICOT_TREE("Apricot Tree", TreeSapling.Apricot_Sapling, Arrays.asList(7, 7, 7, 7), 28, "Apricot", 1, 59, true, 38),
    CHERRY_TREE("Cherry Tree", TreeSapling.Cherry_Sapling, Arrays.asList(7, 7, 7, 7), 28, "Cherry", 1, 80, true, 38),
    BANANA_TREE("Banana Tree", TreeSapling.Banana_Sapling, Arrays.asList(7, 7, 7, 7), 28, "Banana", 1, 150, true, 75),
    MANGO_TREE("Mango Tree", TreeSapling.Mango_Sapling, Arrays.asList(7, 7, 7, 7), 28, "Mango", 1, 130, true, 100),
    ORANGE_TREE("Orange Tree", TreeSapling.Orange_Sapling, Arrays.asList(7, 7, 7, 7), 28, "Orange", 1, 100, true, 38),
    PEACH_TREE("Peach Tree", TreeSapling.Peach_Sapling, Arrays.asList(7, 7, 7, 7), 28, "Peach", 1, 140, true, 38),
    APPLE_TREE("Apple Tree", TreeSapling.Apple_Sapling, Arrays.asList(7, 7, 7, 7), 28, "Apple", 1, 100, true, 38),
    POMEGRANATE_TREE("Pomegranate Tree", TreeSapling.Pomegranate_Sapling, Arrays.asList(7, 7, 7, 7), 28, "Pomegranate", 1, 140, true, 38),
    OAK_TREE("Oak Tree", TreeSapling.Acorns, Arrays.asList(7, 7, 7, 7), 28, "Oak Resin", 7, 150, false, 0),
    MAPLE_TREE("Maple Tree", TreeSapling.Maple_Seeds, Arrays.asList(7, 7, 7, 7), 28, "Maple Syrup", 9, 200, false, 0),
    PINE_TREE("Pine Tree", TreeSapling.Pine_Cones, Arrays.asList(7, 7, 7, 7), 28, "Pine Tar", 5, 100, false, 0),
    MAHOGANY_TREE("Mahogany Tree", TreeSapling.Mahogany_Seeds, Arrays.asList(7, 7, 7, 7), 28, "Sap", 1, 2, true, -2),
    MUSHROOM_TREE("Mushroom Tree", TreeSapling.Mushroom_Tree_Seeds, Arrays.asList(7, 7, 7, 7), 28, "Common Mushroom", 1, 40, true, 38),
    MYSTIC_TREE("Mystic Tree", TreeSapling.Mystic_Tree_Seeds, Arrays.asList(7, 7, 7, 7), 28, "Mystic Syrup", 7, 1000, true, 500);

    private final String name;
    private final Seed seedSource;
    private final List<Integer> stages;
    private final int totalHarvestTime;
    private final String fruits;
    private final int fruitHarvestCycle;
    private final int fruitBaseSellPrice;
    private final boolean isFruitEdible;
    private final int fruitEnergy;

    AllTrees(String name, Seed seedSource, List<Integer> stages, int totalHarvestTime, String fruits, int fruitHarvestCycle, int fruitBaseSellPrice, boolean isFruitEdible, int fruitEnergy) {
        this.name = name;
        this.seedSource = seedSource;
        this.stages = stages;
        this.totalHarvestTime = totalHarvestTime;
        this.fruits = fruits;
        this.fruitHarvestCycle = fruitHarvestCycle;
        this.fruitBaseSellPrice = fruitBaseSellPrice;
        this.isFruitEdible = isFruitEdible;
        this.fruitEnergy = fruitEnergy;
    }

    public String getName() {
        return name;
    }

    public Seed getSeedSource() {
        return seedSource;
    }

    public List<Integer> getStages() {
        return stages;
    }

    public int getTotalHarvestTime() {
        return totalHarvestTime;
    }

    public String getFruits() {
        return fruits;
    }

    public int getFruitHarvestCycle() {
        return fruitHarvestCycle;
    }

    public int getFruitBaseSellPrice() {
        return fruitBaseSellPrice;
    }

    public boolean isFruitEdible() {
        return isFruitEdible;
    }

    public int getFruitEnergy() {
        return fruitEnergy;
    }
}

