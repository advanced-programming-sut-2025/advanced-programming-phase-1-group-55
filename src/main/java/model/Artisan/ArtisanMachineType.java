package model.Artisan;

import enums.CraftingItemType;
import model.Item.ItemType;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public enum ArtisanMachineType {

    HONEY(ItemType.HONEY, CraftingItemType.BEE_HOUSE_RECIPE, "It's a sweet syrup produced by bees.", 75, 56, null, 350),

    CHEESE_1(ItemType.CHEESE, CraftingItemType.CHEESE_PRESS_RECIPE, "It's your basic cheese.", 100, 3,
            new HashMap<>() {{
                put(ItemType.MILK, 1);
            }}, 230),

    CHEESE_2(ItemType.CHEESE, CraftingItemType.CHEESE_PRESS_RECIPE, "It's your basic cheese.", 100, 3,
            new HashMap<>() {{
                put(ItemType.MILK, 1);
            }}, 345),

    GOAT_CHEESE_1(ItemType.GOAT_CHEESE, CraftingItemType.CHEESE_PRESS_RECIPE, "Soft cheese made from goat's milk.", 100, 3,
            new HashMap<>() {{
                put(ItemType.GOAT_MILK, 1);
            }}, 400),

    GOAT_CHEESE_2(ItemType.GOAT_CHEESE, CraftingItemType.CHEESE_PRESS_RECIPE, "Soft cheese made from goat's milk.", 100, 3,
            new HashMap<>() {{
                put(ItemType.LARGE_GOAT_MILK, 1);
            }}, 600),

    BEER(ItemType.BEER, CraftingItemType.KEG_RECIPE, "Drink in moderation.", 50, 14,
            new HashMap<>() {{
                put(ItemType.WHEAT, 1);
            }}, 200),

    VINEGAR(ItemType.VINEGAR, CraftingItemType.KEG_RECIPE, "An aged fermented liquid used in many cooking recipes.", 13, 10,
            new HashMap<>() {{
                put(ItemType.RICE, 1);
            }}, 100),

    COFFEE(ItemType.COFFEE, CraftingItemType.KEG_RECIPE, "It smells delicious. This is sure to give you a boost.", 75, 2,
            new HashMap<>() {{
                put(ItemType.COFFEE_BEAN, 5);
            }}, 150),

    MEAD(ItemType.MEAD, CraftingItemType.KEG_RECIPE, "A fermented beverage made from honey. Drink in moderation.", 100, 10,
            new HashMap<>() {{
                put(ItemType.HONEY, 1);
            }}, 300),

    PALE_ALE(ItemType.PALE_ALE, CraftingItemType.KEG_RECIPE, "Drink in moderation.", 50, 42,
            new HashMap<>() {{
                put(ItemType.HOPS_CROP, 1);
            }}, 300),

    RAISINS(ItemType.RAISIN, CraftingItemType.DEHYDRATOR_RECIPE, "It's said to be the Junimos' favorite food.", 125, -1,
            new HashMap<>() {{
                put(ItemType.GRAPE, 5);
            }}, 600),

    COAL(ItemType.COAL, CraftingItemType.CHARCOAL_KILN_RECIPE, "Turns 10 pieces of wood into one piece of coal.", -1, 1,
            new HashMap<>() {{
                put(ItemType.WOOD, 10);
            }}, 50),

    CLOTH(ItemType.CLOTH, CraftingItemType.LOOM_RECIPE, "A bolt of fine wool cloth.", -1, 4,
            new HashMap<>() {{
                put(ItemType.WOOL, 1);
            }}, 470),

    MAYONNAISE_1(ItemType.MAYONNAISE, CraftingItemType.MAYONNAISE_MACHINE_RECIPE, "It looks spreadable.", 50, 3,
            new HashMap<>() {{
                put(ItemType.EGG, 1);
            }}, 190),

    MAYONNAISE_2(ItemType.MAYONNAISE, CraftingItemType.MAYONNAISE_MACHINE_RECIPE, "It looks spreadable.", 50, 3,
            new HashMap<>() {{
                put(ItemType.LARGE_EGG, 1);
            }}, 237),

    DUCK_MAYONNAISE(ItemType.DUCK_MAYONNAISE, CraftingItemType.MAYONNAISE_MACHINE_RECIPE, "It's a rich, yellow mayonnaise.", 75, 3,
            new HashMap<>() {{
                put(ItemType.DUCK_EGG, 1);
            }}, 37),

    DINOSAUR_MAYONNAISE(ItemType.DINOSAUR_MAYONNAISE, CraftingItemType.MAYONNAISE_MACHINE_RECIPE, "It's thick and creamy, with a vivid green hue. It smells like grass and leather.", 125, 3,
            new HashMap<>() {{
                put(ItemType.DINOSAUR_EGG, 1);
            }}, 800),

    TRUFFLE_OIL(ItemType.TRUFFLE_OIL, CraftingItemType.OIL_MAKER_RECIPE, "A gourmet cooking ingredient.", 38, 6,
            new HashMap<>() {{
                put(ItemType.TRUFFLE, 1);
            }}, 1065),

    OIL_1(ItemType.OIL, CraftingItemType.OIL_MAKER_RECIPE, "All purpose cooking oil.", 13, 6,
            new HashMap<>() {{
                put(ItemType.CORN, 1);
            }}, 100),

    OIL_2(ItemType.OIL, CraftingItemType.OIL_MAKER_RECIPE, "All purpose cooking oil.", 13, 28,
            new HashMap<>() {{
                put(ItemType.SUNFLOWER_SEEDS, 1);
            }}, 100),

    OIL_3(ItemType.OIL, CraftingItemType.OIL_MAKER_RECIPE, "All purpose cooking oil.", 13, 1,
            new HashMap<>() {{
                put(ItemType.SUNFLOWER, 1);
            }}, 100),

    SMOKED_FISH(ItemType.SMOKED_FISH, CraftingItemType.FISH_SMOKER_RECIPE, "A whole fish, smoked to perfection.", -1, 1, null, -1),

    ANY_METAL_BAR(null, CraftingItemType.FURNACE_RECIPE, "Turns ore and coal into metal bars.", -1, 4, null, -1);

    ;


    private final ItemType type;
    private final CraftingItemType device;
    private final String description;
    private final int energy;
    private final int processTime; // hours (each day is 14 hours)
    private final Map<ItemType, Integer> ingredients;
    private final int sellPrice;

    ArtisanMachineType(ItemType type, CraftingItemType device, String description, int energy, int processTime, Map<ItemType, Integer> ingredients, int sellPrice) {
        this.type = type;
        this.device = device;
        this.description = description;
        this.energy = energy;
        this.processTime = processTime;
        this.ingredients = ingredients;
        this.sellPrice = sellPrice;
    }

    public CraftingItemType getDevice() {
        return device;
    }

    public String getDescription() {
        return description;
    }

    public int getEnergy() {
        return energy;
    }

    public Map<ItemType, Integer> getIngredients() {
        return ingredients;
    }

    public int getProcessTime() {
        return processTime;
    }



    public int getSellPrice() {
        return sellPrice;
    }

    public ItemType getType()
    {
        if (type == null)
        {
            Random rand = new Random();
            int random = rand.nextInt(4);

            if (random == 0)
            {
                return ItemType.COPPER_BAR;
            }

            if (random == 1)
            {
                return ItemType.IRIDIUM_BAR;
            }

            if (random == 2)
            {
                return ItemType.IRON_BAR;
            }

            return ItemType.GOLD_BAR;
        }

        return type;
    }
    public boolean isEdible()
    {
        if ( type == null || type.equals(ItemType.COAL) || type.equals(ItemType.CLOTH))
        {
            return false;
        }

        return true;
    }
    public static ArtisanMachineType getArtisanType(String name)
    {
        CraftingItemType craft = CraftingItemType.getRecipeFromItemName(name);

        if (craft == null)
        {
            return null;
        }

        for (ArtisanMachineType type : ArtisanMachineType.values())
        {
            if (type.getDevice() == craft)
            {
                return type;
            }
        }

        return null;
    }
    public boolean hasIngredient(ItemType type) {
        if (this.ingredients == null || this.ingredients.isEmpty()) {
            return false;
        }
        return this.ingredients.containsKey(type);
    }


    public static ArtisanMachineType getTypeFromDevicesAndIngredient(CraftingItemType craftingItem, ItemType ingredient) {
        for (ArtisanMachineType type : ArtisanMachineType.values()) {
            if (type.getDevice().equals(craftingItem) && type.ingredients != null && type.ingredients.containsKey(ingredient)) {
                return type;
            }
        }
        return null;
    }



}
