package model.FarmingProdocts;

import java.util.Arrays;
import java.util.List;

public enum AllTrees {
    APRICOT_TREE("Apricot Tree", TreeSapling.Apricot_Sapling, Arrays.asList(7, 7, 7, 7), 28, new Fruit(FruitType.Apricot)),
    CHERRY_TREE("Cherry Tree", TreeSapling.Cherry_Sapling, Arrays.asList(7, 7, 7, 7), 28, new Fruit(FruitType.Cherry)),
    BANANA_TREE("Banana Tree", TreeSapling.Banana_Sapling, Arrays.asList(7, 7, 7, 7), 28, new Fruit(FruitType.Banana)),
    MANGO_TREE("Mango Tree", TreeSapling.Mango_Sapling, Arrays.asList(7, 7, 7, 7), 28, new Fruit(FruitType.Mango)),
    ORANGE_TREE("Orange Tree", TreeSapling.Orange_Sapling, Arrays.asList(7, 7, 7, 7), 28, new Fruit(FruitType.Orange)),
    PEACH_TREE("Peach Tree", TreeSapling.Peach_Sapling, Arrays.asList(7, 7, 7, 7), 28, new Fruit(FruitType.Peach)),
    APPLE_TREE("Apple Tree", TreeSapling.Apple_Sapling, Arrays.asList(7, 7, 7, 7), 28, new Fruit(FruitType.Apple)),
    POMEGRANATE_TREE("Pomegranate Tree", TreeSapling.Pomegranate_Sapling, Arrays.asList(7, 7, 7, 7), 28, new Fruit(FruitType.Pomegranate)),
    OAK_TREE("Oak Tree", TreeSapling.Acorns, Arrays.asList(7, 7, 7, 7), 28, new Fruit(FruitType.OakResin)),
    MAPLE_TREE("Maple Tree", TreeSapling.Maple_Seeds, Arrays.asList(7, 7, 7, 7), 28, new Fruit(FruitType.MapleSyrup) ),
    PINE_TREE("Pine Tree", TreeSapling.Pine_Cones, Arrays.asList(7, 7, 7, 7), 28, new Fruit(FruitType.PineTar)),
    MAHOGANY_TREE("Mahogany Tree", TreeSapling.Mahogany_Seeds, Arrays.asList(7, 7, 7, 7), 28,new Fruit(FruitType.Sap)),
    MUSHROOM_TREE("Mushroom Tree", TreeSapling.Mushroom_Tree_Seeds, Arrays.asList(7, 7, 7, 7), 28,new Fruit(FruitType.CommonMushroom)),
    MYSTIC_TREE("Mystic Tree", TreeSapling.Mystic_Tree_Seeds, Arrays.asList(7, 7, 7, 7), 28, new Fruit(FruitType.MysticSyrup));

    private final String name;
    private final Seed seedSource;
    private final List<Integer> stages;
    private final int totalHarvestTime;
    private final Fruit fruits;

    AllTrees(String name, Seed seedSource, List<Integer> stages, int totalHarvestTime, Fruit fruits) {
        this.name = name;
        this.seedSource = seedSource;
        this.stages = stages;
        this.totalHarvestTime = totalHarvestTime;
        this.fruits = fruits;
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

    public Fruit getFruits() {
        return fruits;
    }

    public  static AllTrees getTypeByInt(int x){
        return switch (x) {
            case 0 -> APRICOT_TREE;
            case 1 -> CHERRY_TREE;
            case 2 -> BANANA_TREE;
            case 3 -> MANGO_TREE;
            case 4 -> ORANGE_TREE;
            case 5 -> PEACH_TREE;
            case 6 -> APPLE_TREE;
            case 7 -> POMEGRANATE_TREE;
            case 8 -> OAK_TREE;
            case 9 -> MAPLE_TREE;
            case 10 -> PINE_TREE;
            case 11 -> MAHOGANY_TREE;
            case 12 -> MUSHROOM_TREE;
            default -> MYSTIC_TREE;
        };
    }
}

