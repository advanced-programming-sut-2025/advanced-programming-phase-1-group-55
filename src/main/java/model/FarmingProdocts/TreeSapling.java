package model.FarmingProdocts;

public enum TreeSapling implements Seed {
    Apricot_Sapling("Apricot Sapling", "Spring"),
    Cherry_Sapling("Cherry Sapling", "Spring"),
    Banana_Sapling("Banana Sapling", "Summer"),
    Mango_Sapling("Mango Sapling", "Summer"),
    Orange_Sapling("Orange Sapling", "Summer"),
    Peach_Sapling("Peach Sapling", "Summer"),
    Apple_Sapling("Apple Sapling", "Fall"),
    Pomegranate_Sapling("Pomegranate Sapling", "Fall"),
    Acorns("Acorns", "Special"),
    Maple_Seeds("Maple Seeds", "Special"),
    Pine_Cones("Pine Cones", "Special"),
    Mahogany_Seeds("Mahogany Seeds", "Special"),
    Mushroom_Tree_Seeds("Mushroom Tree Seeds", "Special"),
    Mystic_Tree_Seeds("Mystic Tree Seeds", "Special");

    final String name;
    final String season;

    TreeSapling(String name, String season) {
        this.name = name;
        this.season = season;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSeason() {
        return season;
    }

    @Override
    public String toString() {
        return name;
    }
}
