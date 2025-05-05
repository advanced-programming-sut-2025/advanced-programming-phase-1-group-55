package model.FarmingProdocts;
import java.util.List;

public enum AllCrops {
    BLUE_JAZZ(new Crop("Blue Jazz", "Jazz Seeds", List.of(1, 2, 2, 2), 7, true, 0,50, true, 45, "Spring", false)),
    CARROT(new Crop("Carrot", "Carrot Seeds", List.of(1, 1, 1), 3, true, 0, 35, true, 25, "Spring", false)),
    CAULIFLOWER(new Crop("Cauliflower", "Cauliflower Seeds", List.of(1, 2, 4, 4, 1), 12, true, 0, 175, true, 75, "Spring", true)),
    COFFEE_BEAN(new Crop("Coffee Bean", "Coffee Bean", List.of(1, 2, 2, 3, 2), 10, false, 2, 15, false, 0, "Spring & Summer", false)),
    GARLIC(new Crop("Garlic", "Garlic Seeds", List.of(1, 1, 1, 1), 4, true, 0, 60, true, 20, "Spring", false)),
    GREEN_BEAN(new Crop("Green Bean", "Bean Starter", List.of(1, 1, 1, 3, 4), 10, false, 3, 40, true, 25, "Spring", false)),
    KALE(new Crop("Kale", "Kale Seeds", List.of(1, 2, 2, 1), 6, true, 0, 110, true, 50, "Spring", false)),
    PARSNIP(new Crop("Parsnip", "Parsnip Seeds", List.of(1, 1, 1, 1), 4, true, 0, 35, true, 25, "Spring", false)),
    POTATO(new Crop("Potato", "Potato Seeds", List.of(1, 1, 1, 2, 1), 6, true, 0, 80, true, 25, "Spring", false)),
    RHUBARB(new Crop("Rhubarb", "Rhubarb Seeds", List.of(2, 2, 2, 3, 4), 13, true, 0, 220, false, 0, "Spring", false)),
    STRAWBERRY(new Crop("Strawberry", "Strawberry Seeds", List.of(1, 1, 2, 2, 2), 8, false, 4, 120, true, 50, "Spring", false)),
    TULIP(new Crop("Tulip", "Tulip Bulb", List.of(1, 1, 2, 2), 6, true, 0, 30, true, 45, "Spring", false)),
    UNMILLED_RICE(new Crop("Unmilled Rice", "Rice Shoot", List.of(1, 2, 2, 3), 8, true, 0, 30, true, 3, "Spring", false)),
    BLUEBERRY(new Crop("Blueberry", "Blueberry Seeds", List.of(1, 3, 3, 4, 2), 13, false, 4, 50, true, 25, "Summer", false)),
    CORN(new Crop("Corn", "Corn Seeds", List.of(2, 3, 3, 3, 3), 14, false, 4, 50, true, 25, "Summer & Fall", false)),
    HOPS(new Crop("Hops", "Hops Starter", List.of(1, 1, 2, 3, 4), 11, false, 1, 25, true, 45, "Summer", false)),
    HOT_PEPPER(new Crop("Hot Pepper", "Pepper Seeds", List.of(1, 1, 1, 1, 1), 5, false, 3, 40, true, 13, "Summer", false)),
    MELON(new Crop("Melon", "Melon Seeds", List.of(1, 2, 3, 3, 3), 12, true, 0, 250, true, 113, "Summer", true)),
    POPPY(new Crop("Poppy", "Poppy Seeds", List.of(1, 2, 2, 2), 7, true, 0, 140, true, 45, "Summer", false)),
    RADISH(new Crop("Radish", "Radish Seeds", List.of(2, 1, 2, 1), 6, true, 0, 90, true, 45, "Summer", false)),
    RED_CABBAGE(new Crop("Red Cabbage", "Red Cabbage Seeds", List.of(2, 1, 2, 2, 2), 9, true, 0, 260, true, 75, "Summer", false)),
    STARFRUIT(new Crop("Starfruit", "Starfruit Seeds", List.of(2, 3, 2, 3, 3), 13, true, 0, 750, true, 125, "Summer", false)),
    SUMMER_SPANGLE(new Crop("Summer Spangle", "Spangle Seeds", List.of(1, 2, 3, 1), 8, true, 0, 90, true, 45, "Summer", false)),
    SUMMER_SQUASH(new Crop("Summer Squash", "Summer Squash Seeds", List.of(1, 1, 1, 2, 1), 6, false, 3, 45, true, 63, "Summer", false)),
    SUNFLOWER(new Crop("Sunflower", "Sunflower Seeds", List.of(1, 2, 3, 2), 8, true, 0, 80, true, 45, "Summer & Fall", false)),
    TOMATO(new Crop("Tomato", "Tomato Seeds", List.of(2, 2, 2, 2, 3), 11, false, 4, 60, true, 20, "Summer", false)),
    WHEAT(new Crop("Wheat", "Wheat Seeds", List.of(1, 1, 1, 1), 4, true, 0, 25, false, 0, "Summer & Fall", false)),
    AMARANTH(new Crop("Amaranth", "Amaranth Seeds", List.of(1, 2, 2, 2), 7, true, 0, 150, true, 50, "Fall", false)),
    ARTICHOKE(new Crop("Artichoke", "Artichoke Seeds", List.of(2, 2, 1, 2, 1), 8, true, 0, 160, true, 30, "Fall", false)),
    BEET(new Crop("Beet", "Beet Seeds", List.of(1, 1, 2, 2), 6, true, 0, 100, true, 30, "Fall", false)),
    BOK_CHO(new Crop("Bok Choy", "Bok Choy Seeds", List.of(1, 1, 1, 1), 4, true, 0, 80, true, 25, "Fall", false)),
    BROCCOLI(new Crop("Broccoli", "Broccoli Seeds", List.of(2, 2, 2, 2), 8, false, 4, 70, true, 63, "Fall", false)),
    CRANBERRIES(new Crop("Cranberries", "Cranberry Seeds", List.of(1, 2, 1, 1, 2), 7, false, 5, 75, true, 38, "Fall", false)),
    EGGPLANT(new Crop("Eggplant", "Eggplant Seeds", List.of(1, 1, 1, 1), 5, false, 5, 60, true, 20, "Fall", false)),
    FAIRY_ROSE(new Crop("Fairy Rose", "Fairy Seeds", List.of(1, 4, 4, 3), 12, true, 0, 290, true, 45, "Fall", false)),
    GRAPE(new Crop("Grape", "Grape Starter", List.of(1, 1, 2, 3, 3), 10, false, 3, 80, true, 38, "Fall", false)),
    PUMPKIN(new Crop("Pumpkin", "Pumpkin Seeds", List.of(1, 2, 3, 4, 3), 13, true, 0, 320, false, 0, "Fall", true)),
    YAM(new Crop("Yam", "Yam Seeds", List.of(1, 3, 3, 3), 10, true, 0, 160, true, 45, "Fall", false)),
    SWEET_GEM_BERRY(new Crop("Sweet Gem Berry", "Rare Seed", List.of(2, 4, 6, 6, 6), 24, true, 0, 3000, false, 0, "Fall", false)),
    POWDERMELON(new Crop("Powdermelon", "Powdermelon Seeds", List.of(1, 2, 1, 2, 1), 7, true, 0, 60, true, 63, "Winter", true)),
    ANCIENT_FRUIT(new Crop("Ancient Fruit", "Ancient Seed", List.of(2, 3, 4, 5), 16, true, 7, 800, true, 50, "All Seasons", true));

    private final Crop crop;

    AllCrops(Crop crop) {
        this.crop = crop;
    }

    public Crop getCrop() {
        return crop;
    }

    @Override
    public String toString() {
        return crop.toString();
    }
}

