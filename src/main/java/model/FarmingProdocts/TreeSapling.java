package model.FarmingProdocts;

import enums.Seasons;

public enum TreeSapling implements Seed {
    Apricot_Sapling("Apricot Sapling", Seasons.spring),
    Cherry_Sapling("Cherry Sapling", Seasons.spring),
    Banana_Sapling("Banana Sapling", Seasons.summer),
    Mango_Sapling("Mango Sapling", Seasons.summer),
    Orange_Sapling("Orange Sapling", Seasons.summer),
    Peach_Sapling("Peach Sapling", Seasons.summer),
    Apple_Sapling("Apple Sapling", Seasons.fall),
    Pomegranate_Sapling("Pomegranate Sapling", Seasons.fall),
    Acorns("Acorns", Seasons.special),
    Maple_Seeds("Maple Seeds", Seasons.special),
    Pine_Cones("Pine Cones", Seasons.special),
    Mahogany_Seeds("Mahogany Seeds", Seasons.special),
    Mushroom_Tree_Seeds("Mushroom Tree Seeds", Seasons.special),
    Mystic_Tree_Seeds("Mystic Tree Seeds", Seasons.special);

    final String name;
    final Seasons season;

    TreeSapling(String name, Seasons season) {
        this.name = name;
        this.season = season;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Seasons getSeason() {
        return season;
    }

    @Override
    public String toString() {
        return name;
    }
}
