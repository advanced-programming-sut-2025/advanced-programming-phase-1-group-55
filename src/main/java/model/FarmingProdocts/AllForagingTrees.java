package model.FarmingProdocts;

public enum AllForagingTrees {
    ACORNS(new ForagingTree("Acorns", "Special")),
    MAPLE_SEEDS(new ForagingTree("Maple Seeds", "Special")),
    PINE_CONES(new ForagingTree("Pine Cones", "Special")),
    MAHOGANY_SEEDS(new ForagingTree("Mahogany Seeds", "Special")),
    MUSHROOM_TREE_SEEDS(new ForagingTree("Mushroom Tree Seeds", "Special"));

    private final ForagingTree tree;

    AllForagingTrees(ForagingTree tree) {
        this.tree = tree;
    }

    public ForagingTree getForagingTree() {
        return tree;
    }
}
