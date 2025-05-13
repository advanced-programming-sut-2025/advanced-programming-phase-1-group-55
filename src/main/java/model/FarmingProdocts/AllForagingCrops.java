package model.FarmingProdocts;

import enums.Seasons;

public enum AllForagingCrops {
    COMMON_MUSHROOM("Common Mushroom", Seasons.special, 40, 38, 0),
    DAFFODIL("Daffodil", Seasons.spring, 30, 0, 1),
    DANDELION("Dandelion", Seasons.spring, 40, 25, 2),
    LEEK("Leek", Seasons.spring, 60, 40, 3),
    MOREL("Morel", Seasons.spring, 150, 20, 4),
    SALMONBERRY("Salmonberry", Seasons.spring, 5, 25, 5),
    SPRING_ONION("Spring Onion", Seasons.spring, 8, 13, 6),
    WILD_HORSERADISH("Wild Horseradish", Seasons.spring, 50, 13, 7),
    FIDDLEHEAD_FERN("Fiddlehead Fern", Seasons.summer, 90, 25, 8),
    GRAPE("Grape", Seasons.summer, 80, 38, 9),
    RED_MUSHROOM("Red Mushroom", Seasons.summer, 75, -50, 10),
    SPICE_BERRY("Spice Berry", Seasons.summer, 80, 25, 11),
    SWEET_PEA("Sweet Pea", Seasons.summer, 50, 0, 12),
    BLACKBERRY("Blackberry", Seasons.fall, 25, 25, 13),
    CHANTERELLE("Chanterelle", Seasons.fall, 160, 75, 14),
    HAZELNUT("Hazelnut", Seasons.fall, 40, 38, 15),
    PURPLE_MUSHROOM("Purple Mushroom", Seasons.fall, 90, 30, 16),
    WILD_PLUM("Wild Plum", Seasons.fall, 80, 25, 17),
    CROCUS("Crocus", Seasons.winter, 60, 0, 18),
    CRYSTAL_FRUIT("Crystal Fruit", Seasons.winter, 150, 63, 19),
    HOLLY("Holly", Seasons.winter, 80, -37, 20),
    SNOW_YAM("Snow Yam", Seasons.winter, 100, 30, 21),
    WINTER_ROOT("Winter Root", Seasons.winter, 70, 25, 22);

    private final String name;
    private final Seasons season;
    private final int baseSellPrice;
    private final int energy;
    private final int id;

    AllForagingCrops(String name, Seasons season, int baseSellPrice, int energy, int id) {
        this.name = name;
        this.season = season;
        this.baseSellPrice = baseSellPrice;
        this.energy = energy;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Seasons getSeason() {
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
