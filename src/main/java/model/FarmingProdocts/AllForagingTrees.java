package model.FarmingProdocts;

import enums.Seasons;
import model.Item.ItemType;

public enum AllForagingTrees {
    ACORNS("Acorns", ItemType.ACORNS_FORAGING_TREE, Seasons.special),
    MAPLE_SEEDS("Maple Seeds", ItemType.MAPLE_FORAGING_TREE, Seasons.special),
    PINE_CONES("Pine Cones", ItemType.PINE_FORAGING_TREE, Seasons.special),
    MAHOGANY_SEEDS("Mahogany Seeds", ItemType.MAHOGANY_FORAGING_TREE, Seasons.special),
    MUSHROOM_TREE_SEEDS("Mushroom Tree Seeds", ItemType.MUSHROOM_FORAGING_TREE, Seasons.special);

    private final String name;
    private final ItemType type;
    private final Seasons season;

    AllForagingTrees(String name, ItemType type, Seasons season) {
        this.name = name;
        this.type = type;
        this.season = season;
    }

    public String getName() {
        return name;
    }

    public ItemType getType() {
        return type;
    }

    public Seasons getSeason() {
        return season;
    }
}
