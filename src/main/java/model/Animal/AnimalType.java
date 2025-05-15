package model.Animal;

import model.Item.Item;
import model.Item.ItemType;

public enum AnimalType {

    Chicken("chicken", 800, new Item(ItemType.EGG), 50, new Item(ItemType.BIG_EGG), 95);


    private final String name;
    private final int buyPrice;
    private final Item firstProduct;
    private final int firstProductPrice;
    private final Item secondProduct;
    private final int secondProductPrice;

    AnimalType(String name, int buyPrice, Item firstProduct, int firstProductPrice, Item secondProduct, int secondProductPrice) {
        this.name = name;
        this.buyPrice = buyPrice;
        this.firstProduct = firstProduct;
        this.firstProductPrice = firstProductPrice;
        this.secondProduct = secondProduct;
        this.secondProductPrice = secondProductPrice;
    }

    public String getName() {
        return name;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public Item getFirstProduct() {
        return firstProduct;
    }

    public int getFirstProductPrice() {
        return firstProductPrice;
    }

    public Item getSecondProduct() {
        return secondProduct;
    }

    public int getSecondProductPrice() {
        return secondProductPrice;
    }
}
