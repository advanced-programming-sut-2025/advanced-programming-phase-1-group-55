package model.FarmingProdocts;


import java.util.List;

public enum AllCrops {
    BLUE_JAZZ(new Crop("Blue Jazz", ForagingSeed.BLUE_JAZZ_SEEDS, List.of(1, 2, 2, 2), 7, true, 0, 50, true, 45, false)),
    CARROT(new Crop("Carrot", ForagingSeed.CARROT_SEEDS, List.of(1, 1, 1), 3, true, 0, 35, true, 25, false)),
    CAULIFLOWER(new Crop("Cauliflower", ForagingSeed.CAULIFLOWER_SEEDS, List.of(1, 2, 4, 4, 1), 12, true, 0, 175, true, 75, true)),
    COFFEE_BEAN(new Crop("Coffee Bean", ForagingSeed.COFFEE_BEAN, List.of(1, 2, 2, 3, 2), 10, false, 2, 15, false, 0, false)),
    GARLIC(new Crop("Garlic", ForagingSeed.GARLIC_SEEDS, List.of(1, 1, 1, 1), 4, true, 0, 60, true, 20, false)),
    GREEN_BEAN(new Crop("Green Bean", ForagingSeed.BEAN_STARTER, List.of(1, 1, 1, 3, 4), 10, false, 3, 40, true, 25, false)),
    KALE(new Crop("Kale", ForagingSeed.KALE_SEEDS, List.of(1, 2, 2, 1), 6, true, 0, 110, true, 50, false)),
    PARSNIP(new Crop("Parsnip", ForagingSeed.PARSNIP_SEEDS, List.of(1, 1, 1, 1), 4, true, 0, 35, true, 25, false)),
    POTATO(new Crop("Potato", ForagingSeed.POTATO_SEEDS, List.of(1, 1, 1, 2, 1), 6, true, 0, 80, true, 25, false)),
    RHUBARB(new Crop("Rhubarb", ForagingSeed.RHUBARB_SEEDS, List.of(2, 2, 2, 3, 4), 13, true, 0, 220, false, 0, false)),
    STRAWBERRY(new Crop("Strawberry", ForagingSeed.STRAWBERRY_SEEDS, List.of(1, 1, 2, 2, 2), 8, false, 4, 120, true, 50, false)),
    TULIP(new Crop("Tulip", ForagingSeed.TULIP_BULB, List.of(1, 1, 2, 2), 6, true, 0, 30, true, 45, false)),
    UNMILLED_RICE(new Crop("Unmilled Rice", ForagingSeed.RICE_SHOOT, List.of(1, 2, 2, 3), 8, true, 0, 30, true, 3, false)),
    BLUEBERRY(new Crop("Blueberry", ForagingSeed.BLUEBERRY_SEEDS, List.of(1, 3, 3, 4, 2), 13, false, 4, 50, true, 25, false)),
    CORN(new Crop("Corn", ForagingSeed.CORN_SEEDS, List.of(2, 3, 3, 3, 3), 14, false, 4, 50, true, 25, false)),
    HOPS(new Crop("Hops", ForagingSeed.HOPS_STARTER, List.of(1, 1, 2, 3, 4), 11, false, 1, 25, true, 45, false)),
    HOT_PEPPER(new Crop("Hot Pepper", ForagingSeed.PEPPER_SEEDS, List.of(1, 1, 1, 1, 1), 5, false, 3, 40, true, 13, false)),
    MELON(new Crop("Melon", ForagingSeed.MELON_SEEDS, List.of(1, 2, 3, 3, 3), 12, true, 0, 250, true, 113, true)),
    POPPY(new Crop("Poppy", ForagingSeed.POPPY_SEEDS, List.of(1, 2, 2, 2), 7, true, 0, 140, true, 45, false)),
    RADISH(new Crop("Radish", ForagingSeed.RADISH_SEEDS, List.of(2, 1, 2, 1), 6, true, 0, 90, true, 45, false)),
    RED_CABBAGE(new Crop("Red Cabbage", ForagingSeed.RED_CABBAGE_SEEDS, List.of(2, 1, 2, 2, 2), 9, true, 0, 260, true, 75, false)),
    STARFRUIT(new Crop("Starfruit", ForagingSeed.STARFRUIT_SEEDS, List.of(2, 3, 2, 3, 3), 13, true, 0, 750, true, 125, false)),
    SUMMER_SPANGLE(new Crop("Summer Spangle", ForagingSeed.SPANGLE_SEEDS, List.of(1, 2, 3, 1), 8, true, 0, 90, true, 45, false)),
    SUMMER_SQUASH(new Crop("Summer Squash", ForagingSeed.SUMMER_SQUASH_SEEDS, List.of(1, 1, 1, 2, 1), 6, false, 3, 45, true, 63, false)),
    SUNFLOWER(new Crop("Sunflower", ForagingSeed.SUNFLOWER_SEEDS, List.of(1, 2, 3, 2), 8, true, 0, 80, true, 45, false)),
    TOMATO(new Crop("Tomato", ForagingSeed.TOMATO_SEEDS, List.of(2, 2, 2, 2, 3), 11, false, 4, 60, true, 20, false)),
    WHEAT(new Crop("Wheat", ForagingSeed.WHEAT_SEEDS, List.of(1, 1, 1, 1), 4, true, 0, 25, false, 0, false)),
    AMARANTH(new Crop("Amaranth", ForagingSeed.AMARANTH_SEEDS, List.of(1, 2, 2, 2), 7, true, 0, 150, true, 50, false)),
    ARTICHOKE(new Crop("Artichoke", ForagingSeed.ARTICHOKE_SEEDS, List.of(2, 2, 1, 2, 1), 8, true, 0, 160, true, 30, false)),
    BEET(new Crop("Beet", ForagingSeed.BEET_SEEDS, List.of(1, 1, 2, 2), 6, true, 0, 100, true, 30, false)),
    BOK_CHO(new Crop("Bok Choy", ForagingSeed.BOK_CHOYS_SEEDS, List.of(1, 1, 1, 1), 4, true, 0, 80, true, 25, false)),
    BROCCOLI(new Crop("Broccoli", ForagingSeed.BROCCOLI_SEEDS, List.of(2, 2, 2, 2), 8, false, 4, 70, true, 63, false)),
    CRANBERRIES(new Crop("Cranberries", ForagingSeed.CRANBERRY_SEEDS, List.of(1, 2, 1, 1, 2), 7, false, 5, 75, true, 38, false)),
    EGGPLANT(new Crop("Eggplant", ForagingSeed.EGGPLANT_SEEDS, List.of(1, 1, 1, 1), 5, false, 5, 60, true, 20, false)),
    FAIRY_ROSE(new Crop("Fairy Rose", ForagingSeed.FAIRY_SEEDS, List.of(1, 4, 4, 3), 12, true, 0, 290, true, 45, false)),
    GRAPE(new Crop("Grape", ForagingSeed.GRAPE_STARTER, List.of(1, 1, 2, 3, 3), 10, false, 3, 80, true, 38, false)),
    PUMPKIN(new Crop("Pumpkin", ForagingSeed.PUMPKIN_SEEDS, List.of(1, 2, 3, 4, 3), 13, true, 0, 320, false, 0, true)),
    YAM(new Crop("Yam", ForagingSeed.YAM_SEEDS, List.of(1, 3, 3, 2), 10, false, 4, 100, true, 45, false));

    private final Crop crop;

    AllCrops(Crop crop) {
        this.crop = crop;
    }

    public Crop getCrop() {
        return crop;
    }
}



