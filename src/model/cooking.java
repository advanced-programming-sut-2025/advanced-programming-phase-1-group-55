package model;

import java.util.HashMap;
import java.util.Map;

public class cooking {
    private Map<String, Integer> recipes;
    private Map<String, Integer> inventory;
    private Map<String, Integer> refrigerator;
    private boolean inhouse;
    private int energy;

    public cooking(boolean inhouse, int energy) {
        this.inhouse = inhouse;
        this.energy = energy;
        this.recipes = new HashMap<>();
        this.inventory = new HashMap<>();
        this.refrigerator = new HashMap<>();
    }
    public void showRecipes() {

    }
    public void addRecipe(Recipe recipe) {

    }
    public void refrigerate(String cookingItemName) {

    }
    public void cook(String itemName) {

    }
    private boolean hasEnoughIngredients(Map<String, Integer> ingredients) {

    }
    private void consumeIngredient(Map<String, Integer> ingredient) {

    }
    private void addItemToInventory(String itemName) {

    }
    private void eat(String foodName) {

    }
    private void applyBuff() {

    }
    public boolean isBuffActive() {

    }

    public Map<String, Integer> getRecipes() {
        return recipes;
    }

    public void setRecipes(Map<String, Integer> recipes) {
        this.recipes = recipes;
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(Map<String, Integer> inventory) {
        this.inventory = inventory;
    }

    public Map<String, Integer> getRefrigerator() {
        return refrigerator;
    }

    public void setRefrigerator(Map<String, Integer> refrigerator) {
        this.refrigerator = refrigerator;
    }

    public boolean isInhouse() {
        return inhouse;
    }

    public void setInhouse(boolean inhouse) {
        this.inhouse = inhouse;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
