package enums;

import model.Ingredient;

import java.util.List;

public enum CraftingItemType {
    CHERRY_BOMB(List.of(new Ingredient("copper ore", 4), new Ingredient("coal", 1)), "Mining Level 1", 50),
    BOMB(List.of(new Ingredient("iron ore", 4), new Ingredient("coal", 1)), "Mining Level 2", 50),
    MEGA_BOMB(List.of(new Ingredient("gold ore", 4), new Ingredient("coal", 1)), "Mining Level 3", 50),
    SPRINKLER(List.of(new Ingredient("copper bar", 1), new Ingredient("iron bar", 1)), "Farming Level 1", -1),
    QUALITY_SPRINKLER(List.of(new Ingredient("Iron bar", 1), new Ingredient("Gold bar", 1)), "Farming Level 2", -1),
    IRIDIUM_SPRINKLER(List.of(new Ingredient("gold bar", 1), new Ingredient("iridium bar", 1)), "Farming Level 3", -1),
    CHARCOAL_KILN(List.of(new Ingredient("wood", 20), new Ingredient("Copper bar", 2)), "Foraging Level 1", -1),
    FURNACE(List.of(new Ingredient("Copper ore", 20), new Ingredient("Stone", 25)), "-", -1),
    SCARECROW(List.of(new Ingredient("wood", 50), new Ingredient("coal", 1), new Ingredient("Fiber", 20)), "-", -1),
    DELUXE_SCARECROW(List.of(new Ingredient("wood", 50), new Ingredient("coal", 1), new Ingredient("Fiber", 20), new Ingredient("iridium ore", 1)), "Farming Level 2", -1),
    BEE_HOUSE(List.of(new Ingredient("wood", 40), new Ingredient("coal", 8), new Ingredient("iron bar", 1)), "Farming Level 1", -1),
    CHEESE_PRESS(List.of(new Ingredient("wood", 45), new Ingredient("stone", 45), new Ingredient("copper bar", 1)), "Farming Level 2", -1),
    KEG(List.of(new Ingredient("wood", 30), new Ingredient("copper bar", 1), new Ingredient("iron bar", 1)), "Farming Level 3", -1),
    LOOM(List.of(new Ingredient("wood", 60), new Ingredient("fiber", 30)), "Farming Level 3", -1),
    MAYONNAISE_MACHINE(List.of(new Ingredient("wood", 15), new Ingredient("stone", 15), new Ingredient("copper bar", 1)), "-", -1),
    OIL_MAKER(List.of(new Ingredient("wood", 100), new Ingredient("gold bar", 1), new Ingredient("iron bar", 1)), "Farming Level 3", -1),
    PRESERVES_JAR(List.of(new Ingredient("wood", 50), new Ingredient("stone", 40), new Ingredient("coal", 8)), "Farming Level 2", -1),
    DEHYDRATOR(List.of(new Ingredient("wood", 30), new Ingredient("stone", 20), new Ingredient("fiber", 30)), "Pierre's General Store", -1),
    GRASS_STARTER(List.of(new Ingredient("wood", 1), new Ingredient("fiber", 1)), "Pierre's General Store", -1),
    FISH_SMOKER(List.of(new Ingredient("wood", 50), new Ingredient("iron bar", 3), new Ingredient("coal", 10)), "Fish Shop", -1),
    MYSTIC_TREE_SEED(List.of(new Ingredient("acorn", 5), new Ingredient("maple seed", 5), new Ingredient("pine cone", 5), new Ingredient("mahogany seed", 5)), "Foraging Level 4", 100);

    private final List<Ingredient> ingredients;
    private final String source;
    private final int sellPrice;

    CraftingItemType(List<Ingredient> ingredients, String source, int sellPrice) {
        this.ingredients = ingredients;
        this.source = source;
        this.sellPrice = sellPrice;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getSource() {
        return source;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    @Override
    public String toString() {
        return name() + ": " + ingredients + ", Source: " + source + ", Sell Price: " + (sellPrice > 0 ? sellPrice + "g" : "Not available");
    }
}
