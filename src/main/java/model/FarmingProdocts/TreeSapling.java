package model.FarmingProdocts;

import enums.Seasons;
import model.Item.ItemType;

public enum TreeSapling implements Seed {
    Apricot_Sapling("Apricot Sapling", ItemType.Apricot_Sapling, Seasons.spring),
    Cherry_Sapling("Cherry Sapling", ItemType.Cherry_Sapling, Seasons.spring),
    Banana_Sapling("Banana Sapling", ItemType.Banana_Sapling, Seasons.summer),
    Mango_Sapling("Mango Sapling", ItemType.Mango_Sapling, Seasons.summer),
    Orange_Sapling("Orange Sapling", ItemType.Orange_Sapling, Seasons.summer),
    Peach_Sapling("Peach Sapling", ItemType.Peach_Sapling, Seasons.summer),
    Apple_Sapling("Apple Sapling", ItemType.Apple_Sapling, Seasons.fall),
    Pomegranate_Sapling("Pomegranate Sapling", ItemType.Pomegranate_Sapling, Seasons.fall),
    Acorns("Acorns", ItemType.Acorns, Seasons.special),
    Maple_Seeds("Maple Seeds", ItemType.Maple_Seeds, Seasons.special),
    Pine_Cones("Pine Cones", ItemType.Pine_Cones, Seasons.special),
    Mahogany_Seeds("Mahogany Seeds", ItemType.Mahogany_Seeds, Seasons.special),
    Mushroom_Tree_Seeds("Mushroom Tree Seeds", ItemType.Mushroom_Tree_Seeds, Seasons.special),
    Mystic_Tree_Seeds("Mystic Tree Seeds", ItemType.Mystic_Tree_Seed, Seasons.special);

    private final String name;
    private final ItemType type;
    private final Seasons season;

    TreeSapling(String name, ItemType type, Seasons season) {
        this.name = name;
        this.type = type;
        this.season = season;
    }

    public ItemType getType() {
        return type;
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
