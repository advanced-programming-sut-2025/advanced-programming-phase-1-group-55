package model.FarmingProdocts;

import java.util.Arrays;
import java.util.List;

public enum AllTrees {
    APRICOT_TREE(new Tree("Apricot Tree", "Apricot Sapling", Arrays.asList(7, 7, 7, 7), 28, "Apricot", 1, 59, true, 38, "Spring")),
    CHERRY_TREE(new Tree("Cherry Tree", "Cherry Sapling", Arrays.asList(7, 7, 7, 7), 28, "Cherry", 1, 80, true, 38, "Spring")),
    BANANA_TREE(new Tree("Banana Tree", "Banana Sapling", Arrays.asList(7, 7, 7, 7), 28, "Banana", 1, 150, true, 75, "Summer")),
    MANGO_TREE(new Tree("Mango Tree", "Mango Sapling", Arrays.asList(7, 7, 7, 7), 28, "Mango", 1, 130, true, 100, "Summer")),
    ORANGE_TREE(new Tree("Orange Tree", "Orange Sapling", Arrays.asList(7, 7, 7, 7), 28, "Orange", 1, 100, true, 38, "Summer")),
    PEACH_TREE(new Tree("Peach Tree", "Peach Sapling", Arrays.asList(7, 7, 7, 7), 28, "Peach", 1, 140, true, 38, "Summer")),
    APPLE_TREE(new Tree("Apple Tree", "Apple Sapling", Arrays.asList(7, 7, 7, 7), 28, "Apple", 1, 100, true, 38, "Fall")),
    POMEGRANATE_TREE(new Tree("Pomegranate Tree", "Pomegranate Sapling", Arrays.asList(7, 7, 7, 7), 28, "Pomegranate", 1, 140, true, 38, "Fall")),
    OAK_TREE(new Tree("Oak Tree", "Acorns", Arrays.asList(7, 7, 7, 7), 28, "Oak Resin", 7, 150, false, 0, "Special")),
    MAPLE_TREE(new Tree("Maple Tree", "Maple Seeds", Arrays.asList(7, 7, 7, 7), 28, "Maple Syrup", 9, 200, false, 0, "Special")),
    PINE_TREE(new Tree("Pine Tree", "Pine Cones", Arrays.asList(7, 7, 7, 7), 28, "Pine Tar", 5, 100, false, 0, "Special")),
    MAHOGANY_TREE(new Tree("Mahogany Tree", "Mahogany Seeds", Arrays.asList(7, 7, 7, 7), 28, "Sap", 1, 2, true, -2, "Special")),
    MUSHROOM_TREE(new Tree("Mushroom Tree", "Mushroom Tree Seeds", Arrays.asList(7, 7, 7, 7), 28, "Common Mushroom", 1, 40, true, 38, "Special")),
    MYSTIC_TREE(new Tree("Mystic Tree", "Mystic Tree Seeds", Arrays.asList(7, 7, 7, 7), 28, "Mystic Syrup", 7, 1000, true, 500, "Special"));

    private final Tree tree;

    AllTrees(Tree tree) {
        this.tree = tree;
    }

    public Tree getTree() {
        return tree;
    }
}

