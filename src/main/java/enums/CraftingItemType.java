package enums;

import model.Ingredient;
import java.util.Arrays;
import java.util.List;

public enum CraftingItemType {

    CHERRY_BOMB("Cherry Bomb", Arrays.asList(
            new Ingredient("copper ore", 4),
            new Ingredient("coal", 1)
    ), "Mining Level 1", 50),

    BOMB("Bomb", Arrays.asList(
            new Ingredient("iron ore", 4),
            new Ingredient("coal", 1)
    ), "Mining Level 2", 50),

    MEGA_BOMB("Mega Bomb", Arrays.asList(
            new Ingredient("gold ore", 4),
            new Ingredient("coal", 1)
    ), "Mining Level 3", 50),

    SPRINKLER("Sprinkler", Arrays.asList(
            new Ingredient("copper bar", 1),
            new Ingredient("iron bar", 1)
    ), "Farming Level 1", 0),

    QUALITY_SPRINKLER("Quality Sprinkler", Arrays.asList(
            new Ingredient("iron bar", 1),
            new Ingredient("gold bar", 1)
    ), "Farming Level 2", 0),

    IRIDIUM_SPRINKLER("Iridium Sprinkler", Arrays.asList(
            new Ingredient("gold bar", 1),
            new Ingredient("iridium bar", 1)
    ), "Farming Level 3", 0),

    CHARCOAL_KILN("Charcoal Klin", Arrays.asList(
            new Ingredient("wood", 20),
            new Ingredient("copper bar", 2)
    ), "Foraging Level 1", 0),

    FURNACE("Furnace", Arrays.asList(
            new Ingredient("copper ore", 20),
            new Ingredient("stone", 25)
    ), "-", 0),

    SCARECROW("Scarecrow", Arrays.asList(
            new Ingredient("wood", 50),
            new Ingredient("coal", 1),
            new Ingredient("fiber", 20)
    ), "-", 0),

    DELUXE_SCARECROW("Deluxe Scarecrow", Arrays.asList(
            new Ingredient("wood", 50),
            new Ingredient("coal", 1),
            new Ingredient("fiber", 20),
            new Ingredient("iridium ore", 1)
    ), "Farming Level 2", 0),

    BEE_HOUSE("Bee House", Arrays.asList(
            new Ingredient("wood", 40),
            new Ingredient("coal", 8),
            new Ingredient("iron bar", 1)
    ), "Farming Level 1", 0),

    CHEESE_PRESS("Cheese Press", Arrays.asList(
            new Ingredient("wood", 45),
            new Ingredient("stone", 45),
            new Ingredient("copper bar", 1)
    ), "Farming Level 2", 0),

    KEG("Keg", Arrays.asList(
            new Ingredient("wood", 30),
            new Ingredient("copper bar", 1),
            new Ingredient("iron bar", 1)
    ), "Farming Level 3", 0),

    LOOM("Loom", Arrays.asList(
            new Ingredient("wood", 60),
            new Ingredient("fiber", 30)
    ), "Farming Level 3", 0),

    MAYONNAISE_MACHINE("Mayonnaise Machine", Arrays.asList(
            new Ingredient("wood", 15),
            new Ingredient("stone", 15),
            new Ingredient("copper bar", 1)
    ), "-", 0),

    OIL_MAKER("Oil Maker", Arrays.asList(
            new Ingredient("wood", 100),
            new Ingredient("gold bar", 1),
            new Ingredient("iron bar", 1)
    ), "Farming Level 3", 0),

    PRESERVES_JAR("Preserves Jar", Arrays.asList(
            new Ingredient("wood", 50),
            new Ingredient("stone", 40),
            new Ingredient("coal", 8)
    ), "Farming Level 2", 0),

    DEHYDRATOR("Dehydrator", Arrays.asList(
            new Ingredient("wood", 30),
            new Ingredient("stone", 20),
            new Ingredient("fiber", 30)
    ), "Pierre's General Store", 0),

    GRASS_STARTER("Grass Starter", Arrays.asList(
            new Ingredient("wood", 1),
            new Ingredient("fiber", 1)
    ), "Pierre's General Store", 0),

    FISH_SMOKER("Fish Smoker", Arrays.asList(
            new Ingredient("wood", 50),
            new Ingredient("iron bar", 3),
            new Ingredient("coal", 10)
    ), "Fish Shop", 0),

    MYSTIC_TREE_SEED("Mystic Tree Seed", Arrays.asList(
            new Ingredient("acorn", 5),
            new Ingredient("maple seed", 5),
            new Ingredient("pine cone", 5),
            new Ingredient("mahogany seed", 5)
    ), "Foraging Level 4", 100);

    private final String name;
    private final List<Ingredient> ingredients;
    private final String source;
    private final int sellPrice;

    CraftingItemType(String name, List<Ingredient> ingredients, String source, int sellPrice) {
        this.name = name;
        this.ingredients = ingredients;
        this.source = source;
        this.sellPrice = sellPrice;
    }

    public String getName() {
        return name;
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
}