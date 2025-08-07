package com.StardewValley.Common.model.FarmingProdocts;

import com.StardewValley.Common.enums.Seasons;
import com.StardewValley.Common.model.Item.ItemType;

public enum AllForagingTrees {
    ACORNS(ItemType.ACORN, "Acorns", Seasons.special),
    MAPLE_SEEDS(ItemType.MAPLE_SEED, "Maple Seeds", Seasons.special),
    PINE_CONES(ItemType.PINE_CONE, "Pine Cones", Seasons.special),
    MAHOGANY_SEEDS(ItemType.MAHOGANY_SEED, "Mahogany Seeds", Seasons.special),
    MUSHROOM_TREE_SEEDS(ItemType.MUSHROOM_TREE_SEEDS, "Mushroom Tree Seeds", Seasons.special);

    private final ItemType type;
    private final String name;
    private final Seasons season;

    AllForagingTrees(ItemType type, String name, Seasons season) {
        this.type = type;
        this.name = name;
        this.season = season;
    }

    public String getName() {
        return name;
    }

    public Seasons getSeason() {
        return season;
    }

    public ItemType getType() {
        return type;
    }
}
