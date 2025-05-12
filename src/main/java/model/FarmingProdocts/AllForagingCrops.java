package model.FarmingProdocts;

public enum AllForagingCrops {
    COMMON_MUSHROOM("Common Mushroom", "Special", 40, 38, 0),
    DAFFODIL("Daffodil", "Spring", 30, 0, 1),
    DANDELION("Dandelion", "Spring", 40, 25, 2),
    LEEK("Leek", "Spring", 60, 40, 3),
    MOREL("Morel", "Spring", 150, 20, 4),
    SALMONBERRY("Salmonberry", "Spring", 5, 25, 5),
    SPRING_ONION("Spring Onion", "Spring", 8, 13, 6),
    WILD_HORSERADISH("Wild Horseradish", "Spring", 50, 13, 7),
    FIDDLEHEAD_FERN("Fiddlehead Fern", "Summer", 90, 25, 8),
    GRAPE("Grape", "Summer", 80, 38, 9),
    RED_MUSHROOM("Red Mushroom", "Summer", 75, -50, 10),
    SPICE_BERRY("Spice Berry", "Summer", 80, 25, 11),
    SWEET_PEA("Sweet Pea", "Summer", 50, 0, 12),
    BLACKBERRY("Blackberry", "Fall", 25, 25, 13),
    CHANTERELLE("Chanterelle", "Fall", 160, 75, 14),
    HAZELNUT("Hazelnut", "Fall", 40, 38, 15),
    PURPLE_MUSHROOM("Purple Mushroom", "Fall", 90, 30, 16),
    WILD_PLUM("Wild Plum", "Fall", 80, 25, 17),
    CROCUS("Crocus", "Winter", 60, 0, 18),
    CRYSTAL_FRUIT("Crystal Fruit", "Winter", 150, 63, 19),
    HOLLY("Holly", "Winter", 80, -37, 20),
    SNOW_YAM("Snow Yam", "Winter", 100, 30, 21),
    WINTER_ROOT("Winter Root", "Winter", 70, 25, 22);

    private final String name;
    private final String season;
    private final int baseSellPrice;
    private final int energy;
    private final int id;

    AllForagingCrops(String name, String season, int baseSellPrice, int energy, int id) {
        this.name = name;
        this.season = season;
        this.baseSellPrice = baseSellPrice;
        this.energy = energy;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSeason() {
        return season;
    }

    public int getBaseSellPrice() {
        return baseSellPrice;
    }

    public int getEnergy() {
        return energy;
    }

    public int getId() {
        return id;
    }

    public static AllForagingCrops fromId(int id) {
        for (AllForagingCrops crop : values()) {
            if (crop.getId() == id) {
                return crop;
            }
        }
        throw new IllegalArgumentException("Invalid crop ID: " + id);
    }
}
