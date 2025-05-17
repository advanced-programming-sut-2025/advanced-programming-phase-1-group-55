package model.Animal;

import model.Item.Item;
import model.Item.ItemType;

import java.util.List;

public enum FarmBuildingType {
    BARN("Barn", 6000,
            List.of(new Item(ItemType.WOOD, 350),
                    new Item(ItemType.STONE, 150)), List.of(7, 4), 4, 1),

    BIG_BARN("Big Barn", 12000,
            List.of(new Item(ItemType.WOOD, 450),
                    new Item(ItemType.STONE, 200)), List.of(7, 4), 8, 1),

    DELUXE_BARN("Deluxe Barn", 25000,
            List.of(new Item(ItemType.WOOD, 550),
                    new Item(ItemType.STONE, 300)), List.of(7, 4), 12, 1),

    COOP("Coop", 4000,
            List.of(new Item(ItemType.WOOD, 300),
                    new Item(ItemType.STONE, 100)), List.of(6, 3), 4, 1),

    BIG_COOP("Big Coop", 10000,
            List.of(new Item(ItemType.WOOD, 400),
                    new Item(ItemType.STONE, 150)), List.of(6, 3), 8, 1),

    DELUXE_COOP("Deluxe Coop", 20000,
            List.of(new Item(ItemType.WOOD, 500),
                    new Item(ItemType.STONE, 200)), List.of(6, 3), 12, 1),

    WELL("Well", 1000,
            List.of(new Item(ItemType.STONE, 75)), List.of(3, 3), -1, 1),

    SHIPPING_BIN("Shipping Bin", 250,
            List.of(new Item(ItemType.WOOD, 150)), List.of(1, 1), -1, -1);










    private final String name;
    private final int price;
    private final List<Item> requirement;
    private final List<Integer> size;
    private final int capacity;
    private final int dailyLimit;

    FarmBuildingType(String name, int price, List<Item> requirement, List<Integer> size, int capacity, int dailyLimit) {
        this.name = name;
        this.price = price;
        this.requirement = requirement;
        this.size = size;
        this.capacity = capacity;
        this.dailyLimit = dailyLimit;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public List<Item> getRequirement() {
        return requirement;
    }

    public List<Integer> getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getDailyLimit() {
        return dailyLimit;
    }
    public static FarmBuildingType getFarmBuildingType(String name) {
        for (FarmBuildingType farmBuildingType : FarmBuildingType.values()) {
            if (farmBuildingType.getName().equalsIgnoreCase(name)) {
                return farmBuildingType;
            }
        }
        return null;
    }
    public int getWoodNumber() {
        for (Item item : requirement) {
            if (item.getItemType() == ItemType.WOOD) {
                return item.getNumber();
            }
        }
        return 0;
    }
    public int getStoneNumber() {
        for (Item item : requirement) {
            if (item.getItemType() == ItemType.STONE) {
                return item.getNumber();
            }
        }
        return 0;
    }
    public int getWidth() {
        return size.get(0);
    }
    public int getHeight() {
        return size.get(1);
    }
}
