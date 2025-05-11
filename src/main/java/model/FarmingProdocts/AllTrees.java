package model.FarmingProdocts;

import java.util.Arrays;
import java.util.List;

public enum AllTrees {
    APRICOT_TREE(new Tree("Apricot Tree", TreeSapling.Apricot_Sapling, Arrays.asList(7, 7, 7, 7), 28, "Apricot", 1, 59, true, 38)),
    CHERRY_TREE(new Tree("Cherry Tree", TreeSapling.Cherry_Sapling, Arrays.asList(7, 7, 7, 7), 28, "Cherry", 1, 80, true, 38)),
    BANANA_TREE(new Tree("Banana Tree", TreeSapling.Banana_Sapling, Arrays.asList(7, 7, 7, 7), 28, "Banana", 1, 150, true, 75)),
    MANGO_TREE(new Tree("Mango Tree", TreeSapling.Mango_Sapling, Arrays.asList(7, 7, 7, 7), 28, "Mango", 1, 130, true, 100)),
    ORANGE_TREE(new Tree("Orange Tree", TreeSapling.Orange_Sapling, Arrays.asList(7, 7, 7, 7), 28, "Orange", 1, 100, true, 38)),
    PEACH_TREE(new Tree("Peach Tree", TreeSapling.Peach_Sapling, Arrays.asList(7, 7, 7, 7), 28, "Peach", 1, 140, true, 38)),
    APPLE_TREE(new Tree("Apple Tree", TreeSapling.Apple_Sapling, Arrays.asList(7, 7, 7, 7), 28, "Apple", 1, 100, true, 38)),
    POMEGRANATE_TREE(new Tree("Pomegranate Tree", TreeSapling.Pomegranate_Sapling, Arrays.asList(7, 7, 7, 7), 28, "Pomegranate", 1, 140, true, 38)),
    OAK_TREE(new Tree("Oak Tree", TreeSapling.Acorns, Arrays.asList(7, 7, 7, 7), 28, "Oak Resin", 7, 150, false, 0)),
    MAPLE_TREE(new Tree("Maple Tree", TreeSapling.Maple_Seeds, Arrays.asList(7, 7, 7, 7), 28, "Maple Syrup", 9, 200, false, 0)),
    PINE_TREE(new Tree("Pine Tree", TreeSapling.Pine_Cones, Arrays.asList(7, 7, 7, 7), 28, "Pine Tar", 5, 100, false, 0)),
    MAHOGANY_TREE(new Tree("Mahogany Tree", TreeSapling.Mahogany_Seeds, Arrays.asList(7, 7, 7, 7), 28, "Sap", 1, 2, true, -2)),
    MUSHROOM_TREE(new Tree("Mushroom Tree", TreeSapling.Mushroom_Tree_Seeds, Arrays.asList(7, 7, 7, 7), 28, "Common Mushroom", 1, 40, true, 38)),
    MYSTIC_TREE(new Tree("Mystic Tree", TreeSapling.Mystic_Tree_Seeds, Arrays.asList(7, 7, 7, 7), 28, "Mystic Syrup", 7, 1000, true, 500));

    private final Tree tree;

    AllTrees(Tree tree) {
        this.tree = tree;
    }

    public Tree getTree() {
        return tree;
    }
}

