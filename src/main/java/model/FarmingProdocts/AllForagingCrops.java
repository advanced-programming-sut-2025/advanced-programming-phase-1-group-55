package model.FarmingProdocts;

import enums.Seasons;
import model.Item.ItemType;

public enum AllForagingCrops {
    COMMON_MUSHROOM("Common Mushroom", Seasons.special, 40, 38, 0,ItemType.COMMON_MUSHROOM),
    DAFFODIL("Daffodil", Seasons.spring, 30, 0, 1,ItemType.DAFFODIL),
    DANDELION("Dandelion", Seasons.spring, 40, 25, 2,ItemType.DANDELION),
    LEEK("Leek", Seasons.spring, 60, 40, 3,ItemType.LEEK),
    MOREL("Morel", Seasons.spring, 150, 20, 4,ItemType.MOREL),
    SALMONBERRY("Salmonberry", Seasons.spring, 5, 25, 5,ItemType.SALMON_BERRY),
    SPRING_ONION("Spring Onion", Seasons.spring, 8, 13, 6,ItemType.SPRING_ONION),
    WILD_HORSERADISH("Wild Horseradish", Seasons.spring, 50, 13, 7,ItemType.WILD_HORSERADISH),
    FIDDLEHEAD_FERN("Fiddlehead Fern", Seasons.summer, 90, 25, 8,ItemType.FIDDLEHEAD_FERN),
    GRAPE("Grape", Seasons.summer, 80, 38, 9,ItemType.GRAPES),
    RED_MUSHROOM("Red Mushroom", Seasons.summer, 75, -50, 10,ItemType.RED_MUSHROOM),
    SPICE_BERRY("Spice Berry", Seasons.summer, 80, 25, 11,ItemType.SPICE_BERRY),
    SWEET_PEA("Sweet Pea", Seasons.summer, 50, 0, 12,ItemType.SWEET_PEA),
    BLACKBERRY("Blackberry", Seasons.fall, 25, 25, 13,ItemType.BLACKBERRY),
    CHANTERELLE("Chanterelle", Seasons.fall, 160, 75, 14,ItemType.CHANTERELLE),
    HAZELNUT("Hazelnut", Seasons.fall, 40, 38, 15,ItemType.HAZELNUT),
    PURPLE_MUSHROOM("Purple Mushroom", Seasons.fall, 90, 30, 16,ItemType.PURPLE_MUSHROOM),
    WILD_PLUM("Wild Plum", Seasons.fall, 80, 25, 17,ItemType.WILD_PLUM),
    CROCUS("Crocus", Seasons.winter, 60, 0, 18,ItemType.CROCUS),
    CRYSTAL_FRUIT("Crystal Fruit", Seasons.winter, 150, 63, 19,ItemType.CRYSTAL_FRUIT),
    HOLLY("Holly", Seasons.winter, 80, -37, 20,ItemType.HOLLY),
    SNOW_YAM("Snow Yam", Seasons.winter, 100, 30, 21,ItemType.SNOW_YAM),
    WINTER_ROOT("Winter Root", Seasons.winter, 70, 25, 22,ItemType.WINTER_ROOT);

    private final String name;
    private final Seasons season;
    private final int baseSellPrice;
    private final int energy;
    private final int id;
    private final ItemType itemType;

    AllForagingCrops(String name, Seasons season, int baseSellPrice, int energy, int id,ItemType itemType) {
        this.name = name;
        this.season = season;
        this.baseSellPrice = baseSellPrice;
        this.energy = energy;
        this.id = id;
        this.itemType=itemType;
    }

    public ItemType getItemType() {
        return itemType;
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
