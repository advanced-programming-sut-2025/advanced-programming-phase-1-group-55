package model;

import enums.RecipeType;
import model.Item.Item;

import java.util.List;
import java.util.Map;

public class Recipe {
    private String itemName;
    private List<Item> ingredients;
    private int level;
    private int price;
    private int energy;
    private RecipeType type;

    public Recipe(String itemName, List<Item> ingredients, int level, int price, int energy, RecipeType type) {
        this.itemName = itemName;
        this.ingredients = ingredients;
        this.level = level;
        this.price = price;
        this.energy = energy;
        this.type = type;
    }

    public String getItemName() {
        return itemName;
    }

    public List<Item> getIngredients() {
        return ingredients;
    }

    public int getLevel() {
        return level;
    }

    public int getPrice() {
        return price;
    }

    public int getEnergy() {
        return energy;
    }

    public RecipeType getType() {
        return type;
    }
}
