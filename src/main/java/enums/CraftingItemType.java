package enums;

import model.Ingredient;
import model.Item.ItemType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public enum CraftingItemType {
    CHERRY_BOMB(ItemType.CHERRY_BOMB, new HashMap<>() {{
        put(ItemType.COPPER_ORE, 4);
        put(ItemType.COAL, 1);
    }}, "Mining Level 1", 50),

    BOMB(ItemType.BOMB, new HashMap<>() {{
        put(ItemType.IRON_ORE, 4);
        put(ItemType.COAL, 1);
    }}, "Mining Level 2", 50),

    MEGA_BOMB(ItemType.MEGA_BOMB, new HashMap<>() {{
        put(ItemType.GOLD_ORE, 4);
        put(ItemType.COAL, 1);
    }}, "Mining Level 3", 50),

    SPRINKLER(ItemType.SPRINKLER, new HashMap<>() {{
        put(ItemType.COPPER_BAR, 1);
        put(ItemType.IRON_BAR, 1);
    }}, "Farming Level 1", 0),

    QUALITY_SPRINKLER(ItemType.QUALITY_SPRINKLER, new HashMap<>() {{
        put(ItemType.IRON_BAR, 1);
        put(ItemType.GOLD_BAR, 1);
    }}, "Farming Level 2", 0),

    IRIDIUM_SPRINKLER(ItemType.IRIDIUM_SPRINKLER, new HashMap<>() {{
        put(ItemType.GOLD_BAR, 1);
        put(ItemType.IRIDIUM_BAR, 1);
    }}, "Farming Level 3", 0),

    CHARCOAL_KILN(ItemType.CHARCOAL_KILN, new HashMap<>() {{
        put(ItemType.WOOD, 20);
        put(ItemType.COPPER_BAR, 2);
    }}, "Foraging Level 1", 0),

    FURNACE(ItemType.FURNACE, new HashMap<>() {{
        put(ItemType.COPPER_ORE, 20);
        put(ItemType.STONE, 25);
    }}, "-", 0),

    SCARECROW(ItemType.SCARECROW, new HashMap<>() {{
        put(ItemType.WOOD, 50);
        put(ItemType.COAL, 1);
        put(ItemType.FIBER, 20);
    }}, "-", 0),

    DELUXE_SCARECROW(ItemType.DELUXE_SCARECROW, new HashMap<>() {{
        put(ItemType.WOOD, 50);
        put(ItemType.COAL, 1);
        put(ItemType.FIBER, 20);
        put(ItemType.IRIDIUM_ORE, 1);
    }}, "Farming Level 2", 0),

    BEE_HOUSE(ItemType.BEE_HOUSE, new HashMap<>() {{
        put(ItemType.WOOD, 40);
        put(ItemType.COAL, 8);
        put(ItemType.IRON_BAR, 1);
    }}, "Farming Level 1", 0),

    CHEESE_PRESS(ItemType.CHEESE_PRESS, new HashMap<>() {{
        put(ItemType.WOOD, 45);
        put(ItemType.STONE, 45);
        put(ItemType.COPPER_BAR, 1);
    }}, "Farming Level 2", 0),

    KEG(ItemType.KEG, new HashMap<>() {{
        put(ItemType.WOOD, 30);
        put(ItemType.COPPER_BAR, 1);
        put(ItemType.IRON_BAR, 1);
    }}, "Farming Level 3", 0),

    LOOM(ItemType.LOOM, new HashMap<>() {{
        put(ItemType.WOOD, 60);
        put(ItemType.FIBER, 30);
    }}, "Farming Level 3", 0),

    MAYONNAISE_MACHINE(ItemType.MAYONNAISE_MACHINE, new HashMap<>() {{
        put(ItemType.WOOD, 15);
        put(ItemType.STONE, 15);
        put(ItemType.COPPER_BAR, 1);
    }}, "-", 0),

    OIL_MAKER(ItemType.OIL_MAKER, new HashMap<>() {{
        put(ItemType.WOOD, 100);
        put(ItemType.GOLD_BAR, 1);
        put(ItemType.IRON_BAR, 1);
    }}, "Farming Level 3", 0),

    PRESERVES_JAR(ItemType.PRESERVES_JAR, new HashMap<>() {{
        put(ItemType.WOOD, 50);
        put(ItemType.STONE, 40);
        put(ItemType.COAL, 8);
    }}, "Farming Level 2", 0),

    DEHYDRATOR(ItemType.DEHYDRATOR, new HashMap<>() {{
        put(ItemType.WOOD, 30);
        put(ItemType.STONE, 20);
        put(ItemType.FIBER, 30);
    }}, "Pierre's General Store", 0),

    GRASS_STARTER(ItemType.GRASS_STARTER, new HashMap<>() {{
        put(ItemType.WOOD, 1);
        put(ItemType.FIBER, 1);
    }}, "Pierre's General Store", 0),

    FISH_SMOKER(ItemType.FISH_SMOKER, new HashMap<>() {{
        put(ItemType.WOOD, 50);
        put(ItemType.IRON_BAR, 3);
        put(ItemType.COAL, 10);
    }}, "Fish Shop", 0),

    MYSTIC_TREE_SEED(ItemType.MYSTIC_TREE_SEED, new HashMap<>() {{
        put(ItemType.ACORN, 5);
        put(ItemType.MAPLE_SEED, 5);
        put(ItemType.PINE_CONE, 5);
        put(ItemType.MAHOGANY_SEED, 5);
    }}, "Foraging Level 4", 100);



    private final ItemType productName;
    private final HashMap<ItemType, Integer> ingredients;
    private final String source;
    private final int sellPrice;

    CraftingItemType(ItemType productName, HashMap<ItemType, Integer> ingredients, String source, int sellPrice) {
        this.productName = productName;
        this.ingredients = ingredients;
        this.source = source;
        this.sellPrice = sellPrice;
    }

    public ItemType getProductName() {
        return productName;
    }

    public HashMap<ItemType, Integer> getIngredients() {
        return ingredients;
    }

    public String getSource() {
        return source;
    }

    public int getSellPrice() {
        return sellPrice;
    }
    public static CraftingItemType getCraftingItemType(String name) {
        for (CraftingItemType recipe : CraftingItemType.values()) {
            if (name.equalsIgnoreCase(recipe.getProductName().toString())) {
                return recipe;
            }
        }
        return null;
    }

}

