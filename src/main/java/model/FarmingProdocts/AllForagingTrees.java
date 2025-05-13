package model.FarmingProdocts;

import enums.Seasons;

public enum AllForagingTrees {
    ACORNS("Acorns", Seasons.special),
    MAPLE_SEEDS("Maple Seeds", Seasons.special),
    PINE_CONES("Pine Cones", Seasons.special),
    MAHOGANY_SEEDS("Mahogany Seeds", Seasons.special),
    MUSHROOM_TREE_SEEDS("Mushroom Tree Seeds", Seasons.special);

    private final String name;
    private final Seasons season;

    AllForagingTrees(String name, Seasons season) {
        this.name = name;
        this.season = season;
    }

    public String getName() {
        return name;
    }

    public Seasons getSeason() {
        return season;
    }
}
