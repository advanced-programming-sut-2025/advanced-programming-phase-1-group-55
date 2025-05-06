package model.FarmingProdocts;

public enum AllForagingCrops {
    COMMON_MUSHROOM(new ForagingCrops("Common Mushroom", "Special", 40, 38)),
    DAFFODIL(new ForagingCrops("Daffodil", "Spring", 30, 0)),
    DANDELION(new ForagingCrops("Dandelion", "Spring", 40, 25)),
    LEEK(new ForagingCrops("Leek", "Spring", 60, 40)),
    MOREL(new ForagingCrops("Morel", "Spring", 150, 20)),
    SALMONBERRY(new ForagingCrops("Salmonberry", "Spring", 5, 25)),
    SPRING_ONION(new ForagingCrops("Spring Onion", "Spring", 8, 13)),
    WILD_HORSERADISH(new ForagingCrops("Wild Horseradish", "Spring", 50, 13)),
    FIDDLEHEAD_FERN(new ForagingCrops("Fiddlehead Fern", "Summer", 90, 25)),
    GRAPE(new ForagingCrops("Grape", "Summer", 80, 38)),
    RED_MUSHROOM(new ForagingCrops("Red Mushroom", "Summer", 75, -50)),
    SPICE_BERRY(new ForagingCrops("Spice Berry", "Summer", 80, 25)),
    SWEET_PEA(new ForagingCrops("Sweet Pea", "Summer", 50, 0)),
    BLACKBERRY(new ForagingCrops("Blackberry", "Fall", 25, 25)),
    CHANTERELLE(new ForagingCrops("Chanterelle", "Fall", 160, 75)),
    HAZELNUT(new ForagingCrops("Hazelnut", "Fall", 40, 38)),
    PURPLE_MUSHROOM(new ForagingCrops("Purple Mushroom", "Fall", 90, 30)),
    WILD_PLUM(new ForagingCrops("Wild Plum", "Fall", 80, 25)),
    CROCUS(new ForagingCrops("Crocus", "Winter", 60, 0)),
    CRYSTAL_FRUIT(new ForagingCrops("Crystal Fruit", "Winter", 150, 63)),
    HOLLY(new ForagingCrops("Holly", "Winter", 80, -37)),
    SNOW_YAM(new ForagingCrops("Snow Yam", "Winter", 100, 30)),
    WINTER_ROOT(new ForagingCrops("Winter Root", "Winter", 70, 25));

    private final ForagingCrops crop;

    AllForagingCrops(ForagingCrops crop) {
        this.crop = crop;
    }

    public ForagingCrops getForagingCrop() {
        return crop;
    }

    @Override
    public String toString() {
        return crop.toString();
    }
}
