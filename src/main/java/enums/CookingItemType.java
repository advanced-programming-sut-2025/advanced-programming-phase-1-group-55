package enums;

import model.Item.ItemType;

import java.util.HashMap;

public enum CookingItemType {

//    Fried_egg("Fried egg", "1 egg", 50, "", "Starter", 35);
    FRIED_EGG(ItemType.FRIED_EGG, new HashMap<>() {{
        put(ItemType.EGG, 1);
    }}, 50, "", "Starter", 35),

    BAKED_FISH(ItemType.BAKED_FISH, new HashMap<>() {{
        put(ItemType.SARDINE, 1);
        put(ItemType.SALMON, 1);
        put(ItemType.WHEAT_FLOUR, 1);
    }}, 75, "", "Starter", 100),

    SALAD(ItemType.SALAD, new HashMap<>() {{
        put(ItemType.LEEK, 1);
        put(ItemType.DANDELION, 1);
    }}, 113, "", "Starter", 110),

    OMELET(ItemType.OMELET, new HashMap<>() {{
        put(ItemType.EGG, 1);
        put(ItemType.MILK, 1);
    }}, 100, "", "Stardrop Saloon", 125),

    PUMPKIN_PIE(ItemType.PUMPKIN_PIE, new HashMap<>() {{
        put(ItemType.PUMPKIN, 1);
        put(ItemType.WHEAT_FLOUR, 1);
        put(ItemType.MILK, 1);
        put(ItemType.SUGAR, 1);
    }}, 225, "", "Stardrop Saloon", 385),

    SPAGHETTI(ItemType.SPAGHETTI, new HashMap<>() {{
        put(ItemType.WHEAT_FLOUR, 1);
        put(ItemType.TOMATO, 1);
    }}, 75, "", "Stardrop Saloon", 120),

    PIZZA(ItemType.PIZZA, new HashMap<>() {{
        put(ItemType.WHEAT_FLOUR, 1);
        put(ItemType.TOMATO, 1);
        put(ItemType.CHEESE, 1);
    }}, 150, "", "Stardrop Saloon", 300),

    TORTILLA(ItemType.TORTILLA, new HashMap<>() {{
        put(ItemType.CORN, 1);
    }}, 50, "", "Stardrop Saloon", 50),

    MAKI_ROLL(ItemType.MAKI_ROLL, new HashMap<>() {{
        put(ItemType.ANY_FISH, 1);
        put(ItemType.RICE, 1);
        put(ItemType.FIBER, 1);
    }}, 100, "", "Stardrop Saloon", 220),

    TRIPLE_SHOT_ESPRESSO(ItemType.TRIPLE_SHOT_ESPRESSO, new HashMap<>() {{
        put(ItemType.COFFEE, 3);
    }}, 200, "Max Energy +100 (5 hours)", "Stardrop Saloon", 450),

    COOKIE(ItemType.COOKIE, new HashMap<>() {{
        put(ItemType.WHEAT_FLOUR, 1);
        put(ItemType.SUGAR, 1);
        put(ItemType.EGG, 1);
    }}, 90, "", "Stardrop Saloon", 140),

    HASH_BROWNS(ItemType.HASH_BROWNS, new HashMap<>() {{
        put(ItemType.POTATO, 1);
        put(ItemType.OIL, 1);
    }}, 90, "Farming (5 hours)", "Stardrop Saloon", 120),

    PANCAKES(ItemType.PANCAKES, new HashMap<>() {{
        put(ItemType.WHEAT_FLOUR, 1);
        put(ItemType.EGG, 1);
    }}, 90, "Foraging (11 hours)", "Stardrop Saloon", 80),

    FRUIT_SALAD(ItemType.FRUIT_SALAD, new HashMap<>() {{
        put(ItemType.BLUEBERRY, 1);
        put(ItemType.MELON, 1);
        put(ItemType.APRICOT, 1);
    }}, 263, "", "Stardrop Saloon", 450),

    RED_PLATE(ItemType.RED_PLATE, new HashMap<>() {{
        put(ItemType.RED_CABBAGE, 1);
        put(ItemType.RADISH, 1);
    }}, 240, "Max Energy +50 (3 hours)", "Stardrop Saloon", 400),

    BREAD(ItemType.BREAD, new HashMap<>() {{
        put(ItemType.WHEAT_FLOUR, 1);
    }}, 50, "", "Stardrop Saloon", 60),

    SALMON_DINNER(ItemType.SALMON_DINNER, new HashMap<>() {{
        put(ItemType.SALMON, 1);
        put(ItemType.AMARANTH, 1);
        put(ItemType.KALE, 1);
    }}, 125, "", "Leah reward", 300),

    VEGETABLE_MEDLEY(ItemType.VEGETABLE_MEDLEY, new HashMap<>() {{
        put(ItemType.TOMATO, 1);
        put(ItemType.BEET, 1);
    }}, 165, "", "Foraging Level 2", 120),

    FARMERS_LUNCH(ItemType.FARMERS_LUNCH, new HashMap<>() {{
        put(ItemType.OMELET, 1);
        put(ItemType.PARSNIP, 1);
    }}, 200, "Farming (5 hours)", "Farming Level 1", 150),

    SURVIVAL_BURGER(ItemType.SURVIVAL_BURGER, new HashMap<>() {{
        put(ItemType.BREAD, 1);
        put(ItemType.CARROT, 1);
        put(ItemType.EGGPLANT, 1);
    }}, 125, "Foraging (5 hours)", "Foraging Level 3", 180),

    DISH_O_THE_SEA(ItemType.DISH_O_THE_SEA, new HashMap<>() {{
        put(ItemType.SARDINE, 2);
        put(ItemType.HASH_BROWNS, 1);
    }}, 150, "Fishing (5 hours)", "Fishing Level 2", 220),

    SEAFOAM_PUDDING(ItemType.SEAFOAM_PUDDING, new HashMap<>() {{
        put(ItemType.FLOUNDER, 1);
        put(ItemType.MIDNIGHT_CARP, 1);
    }}, 175, "Fishing (10 hours)", "Fishing Level 3", 300),

    MINERS_TREAT(ItemType.MINERS_TREAT, new HashMap<>() {{
        put(ItemType.CARROT, 2);
        put(ItemType.SUGAR, 1);
        put(ItemType.MILK, 1);
    }}, 125, "Mining (5 hours)", "Mining Level 1", 200);







    private final ItemType productName;
    private final HashMap<ItemType, Integer> ingredients;
    private final int energy;
    private final String Buff;
    private final String source;
    private final int sellPrice;

    CookingItemType(ItemType productName, HashMap<ItemType, Integer> ingredients, int energy, String buff, String source, int sellPrice) {
        this.productName = productName;
        this.ingredients = ingredients;
        this.energy = energy;
        this.Buff = buff;
        this.source = source;
        this.sellPrice = sellPrice;
    }

    public ItemType getProductName() {
        return productName;
    }

    public HashMap<ItemType, Integer> getIngredients() {
        return ingredients;
    }

    public int getEnergy() {
        return energy;
    }

    public String getBuff() {
        return Buff;
    }

    public String getSource() {
        return source;
    }

    public int getSellPrice() {
        return sellPrice;
    }
    public static CookingItemType getCookingItemType(String name) {
        for (CookingItemType recipe : CookingItemType.values()) {
            if (name.equalsIgnoreCase(recipe.productName.toString()))
                return recipe;
        }
        return null;
    }
}
