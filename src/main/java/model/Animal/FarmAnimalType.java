package model.Animal;

import model.Item.Item;
import model.Item.ItemType;

import java.util.List;

public enum FarmAnimalType {
    CHICKEN(ItemType.CHICKEN, "Chicken", 800,
            List.of(new Item(ItemType.EGG, 50), new Item(ItemType.LARGE_EGG, 95)),
            AnimalType.COOP, List.of(FarmBuildingType.COOP, FarmBuildingType.BIG_COOP, FarmBuildingType.DELUXE_COOP)),

    DUCK(ItemType.DUCK, "Duck", 1200,
            List.of(new Item(ItemType.DUCK_EGG, 95), new Item(ItemType.DUCK_FEATHER, 250)),
            AnimalType.COOP, List.of(FarmBuildingType.BIG_COOP, FarmBuildingType.DELUXE_COOP)),

    RABBIT(ItemType.RABBIT, "Rabbit", 8000,
            List.of(new Item(ItemType.WOOL, 340), new Item(ItemType.RABBITS_FOOT, 565)),
            AnimalType.COOP, List.of(FarmBuildingType.DELUXE_COOP)),

    DINOSAUR(ItemType.DINOSAUR, "Dinosaur", 14000,
            List.of(new Item(ItemType.DINOSAUR_EGG, 350)),
            AnimalType.COOP, List.of(FarmBuildingType.BIG_COOP)),

    COW(ItemType.COW, "Cow", 1500,
            List.of(new Item(ItemType.MILK, 125), new Item(ItemType.LARGE_MILK, 190)),
            AnimalType.BARN, List.of(FarmBuildingType.BARN, FarmBuildingType.BIG_BARN, FarmBuildingType.DELUXE_BARN)),
    GOAT(ItemType.GOAT, "Goat", 4000,
            List.of(new Item(ItemType.GOAT_MILK, 225), new Item(ItemType.LARGE_GOAT_MILK, 345)),
            AnimalType.BARN, List.of(FarmBuildingType.BIG_BARN, FarmBuildingType.DELUXE_BARN)),

    SHEEP(ItemType.SHEEP, "Sheep", 8000,
            List.of(new Item(ItemType.WOOL, 340)),
            AnimalType.BARN, List.of(FarmBuildingType.DELUXE_BARN)),

    PIG(ItemType.PIG, "Pig", 16000,
            List.of(new Item(ItemType.TRUFFLE, 625)),
            AnimalType.BARN, List.of(FarmBuildingType.DELUXE_BARN));


    private final ItemType type;
    private final String name;
    private final int price;
    private final List<Item> product;
    private final AnimalType animalType;
    private final List<FarmBuildingType> buildings;

    FarmAnimalType(ItemType type, String name, int price, List<Item> product, AnimalType animalType, List<FarmBuildingType> buildings) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.product = product;
        this.animalType = animalType;
        this.buildings = buildings;
    }

    public ItemType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public List<Item> getProduct() {
        return product;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public List<FarmBuildingType> getBuildings() {
        return buildings;
    }
}
