package model.FarmingProdocts;

import enums.Seasons;
import model.Item.ItemType;

public enum AllForagingCrops {
    COMMON_MUSHROOM("Common Mushroom", ItemType.COMMON_MUSHROOM_FORAGING_CROP, Seasons.special, 40, 38, 0),
    DAFFODIL("Daffodil", ItemType.DAFFODIL_FORAGING_CROP, Seasons.spring, 30, 0, 1),
    DANDELION("Dandelion", ItemType.DANDELION_FORAGING_CROP, Seasons.spring, 40, 25, 2),
    LEEK("Leek", ItemType.LEEK_FORAGING_CROP, Seasons.spring, 60, 40, 3),
    MOREL("Morel", ItemType.SALMONBERRY_FORAGING_CROP, Seasons.spring, 150, 20, 4),
    SALMONBERRY("Salmonberry", ItemType.SALMONBERRY_FORAGING_CROP, Seasons.spring, 5, 25, 5),
    SPRING_ONION("Spring Onion", ItemType.SPRING_ONION_FORAGING_CROP, Seasons.spring, 8, 13, 6),
    WILD_HORSERADISH("Wild Horseradish", ItemType.WILD_HORSERADISH_FORAGING_CROP, Seasons.spring, 50, 13, 7),
    FIDDLEHEAD_FERN("Fiddlehead Fern", ItemType.FIDDLEHEAD_FERN_FORAGING_CROP, Seasons.summer, 90, 25, 8),
    GRAPE("Grape", ItemType.GRAPE_FORAGING_CROP, Seasons.summer, 80, 38, 9),
    RED_MUSHROOM("Red Mushroom", ItemType.RED_MUSHROOM_FORAGING_CROP, Seasons.summer, 75, -50, 10),
    SPICE_BERRY("Spice Berry", ItemType.SPICE_BERRY_FORAGING_CROP, Seasons.summer, 80, 25, 11),
    SWEET_PEA("Sweet Pea", ItemType.SWEET_PEA_FORAGING_CROP, Seasons.summer, 50, 0, 12),
    BLACKBERRY("Blackberry", ItemType.BLACKBERRY_FORAGING_CROP, Seasons.fall, 25, 25, 13),
    CHANTERELLE("Chanterelle", ItemType.CHANTERELLE_FORAGING_CROP, Seasons.fall, 160, 75, 14),
    HAZELNUT("Hazelnut", ItemType.HAZELNUT_FORAGING_CROP, Seasons.fall, 40, 38, 15),
    PURPLE_MUSHROOM("Purple Mushroom", ItemType.PURPLE_MUSHROOM_FORAGING_CROP, Seasons.fall, 90, 30, 16),
    WILD_PLUM("Wild Plum", ItemType.WILD_HORSERADISH_FORAGING_CROP, Seasons.fall, 80, 25, 17),
    CROCUS("Crocus", ItemType.CROCUS_FORAGING_CROP, Seasons.winter, 60, 0, 18),
    CRYSTAL_FRUIT("Crystal Fruit", ItemType.CRYSTAL_FRUIT_FORAGING_CROP, Seasons.winter, 150, 63, 19),
    HOLLY("Holly", ItemType.HOLLY_FORAGING_CROP, Seasons.winter, 80, -37, 20),
    SNOW_YAM("Snow Yam", ItemType.SNOW_YAM_FORAGING_CROP, Seasons.winter, 100, 30, 21),
    WINTER_ROOT("Winter Root", ItemType.WINTER_ROOT_FORAGING_CROP, Seasons.winter, 70, 25, 22);

    private final String name;
    private final ItemType type;
    private final Seasons season;
    private final int baseSellPrice;
    private final int energy;
    private final int id;

    AllForagingCrops(String name, ItemType type, Seasons season, int baseSellPrice, int energy, int id) {
        this.name = name;
        this.type = type;
        this.season = season;
        this.baseSellPrice = baseSellPrice;
        this.energy = energy;
        this.id = id;
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
