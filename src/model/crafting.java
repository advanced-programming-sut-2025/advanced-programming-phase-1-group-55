package model;

import java.util.HashMap;
import java.util.Map;

public class crafting {
    private Map<String, Recipe> recipes;
    private Map<String, Integer> inventory;
    private boolean inhouse;
    private int energy;
    private int level;

    public crafting(boolean inhouse, int energy, int level) {
        this.inhouse = inhouse;
        this.energy = energy;
        this.level = level;
        this.recipes = new HashMap<>();
        this.inventory = new HashMap<>();
    }
    public void addRecipe(String itemName, Map<String, Integer> ingredients, int level, int price) {

    }
    public void crafting(String itemName, Map<String, Integer> ingredients, int level, int price) {

    }
    private boolean hasEnoughEnergy(int energy) {

    }
    private boolean hasEnoughIngredients(Map<String, Integer> ingredients) {

    }
    public void addInventory(String itemName) {

    }
    public void showRecipes() {

    }
    public void showInventory() {

    }
    public void placeItem(String itemName, int x, int y) {

    }
    public void addItemCheatCode(String itemName, int count) {

    }

}
