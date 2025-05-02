package enums;

public enum CraftingItemType {
    Cherry_Bomb("Cherry Bomb", "Mining Level 1", "4 copper ore + 1 coal", 50),
    Bomb("Bomb", "Mining Level 2", "4 iron ore + 1 coal", 50),
    Mega_Bomb("Mega Bomb", "Mining Level 3", "4 gold ore + 1 coal", 50),
    Sprinkler("Sprinkler", "Farming Level 1", "1 copper bar + 1 iron bar", null),
    Quality_Sprinkler("Quality Sprinkler", "Farming Level 2", "1 Iron bar + 1 Gold bar", null),
    Iridium_Sprinkler("Iridium Sprinkler", "Farming Level 3", "1 gold bar + 1 iridium bar", null),
    Charcoal_Klin("Charcoal Klin", "Foraging Level 1", "20 wood + 2 Copper bar", null),
    Furnace("Furnace", "null", "20 Copper ore + 25 Stone", null),
    Scarecrow("Scarecrow", "null", "50 wood + 1 coal + 20 Fiber", null),
    Deluxe_Scarecrow("Deluxe Scarecrow", "Farming Level 2", "50 wood + 1 coal + 20 Fiber + 1 iridium ore", null),
    Bee_House("Bee House", "Farming Level 1", "40 wood + 8 coal + 1 iron bar", null),
    Cheese_Press("Cheese Press", "Farming Level 2", "45 wood + 45 stone + 1 copper bar", null),
    Keg("Keg", "Farming Level 3", "30 wood + 1 copper bar + 1 iron bar", null),
    Loom("Loom", "Farming Level 3", "60 wood + 30 fiber", null),
    Mayonnaise_Machine("Mayonnaise Machine", "null", "15 wood + 15 stone + 1 copper bar", null),
    Oil_Maker("Oil Maker", "Farming Level 3", "100 wood + 1 gold bar + 1 iron bar", null),
    Preserves_Jar("Preserves Jar", "Farming Level 2", "50 wood + 40 stone + 8 coal", null),
    Dehydrator("Dehydrator", "Pierre's General Store", "30 wood + 20 stone + 30 fiber", null),
    Fish_Smoker("Fish Smoker", "Fish Shop", "50 wood + 3 iron bar + 10 coal", null),
    Mystic_Tree_Seed("Mystic Tree Seed", "Foraging Level 4", "5 acorn + 5 maple seed + 5 pine cone + 5 mahogany seed", 100);



    private final String name;
//    private final String description;
    private final int sellPrice;
    private final String source;
    private final String ingredients;

    CraftingItemType(String name, String source, String ingredients, Integer sellPrice) {
        this.name = name;
        this.source = source;
        this.ingredients = ingredients;
        this.sellPrice = sellPrice;
    }

    public String getName() {
        return name;
    }

//    public String getDescription() {
//        return description;
//    }

    public int getSellPrice() {
        return sellPrice;
    }

    public String getSource() {
        return source;
    }

    public String getIngredients() {
        return ingredients;
    }
}
