package model.CraftingItems;

import enums.CraftingItemType;

public class CraftingItemCreator {
    public static CraftingItem create(CraftingItemType type) {
        if (type == null) return null;

        return switch (type) {
            case CraftingItemType.CHERRY_BOMB_RECIPE -> new Cherry_Bomb();
            case CraftingItemType.BOMB_RECIPE -> new Bomb();
            case CraftingItemType.MEGA_BOMB_RECIPE -> new Mega_Bomb();
            case CraftingItemType.SPRINKLER_RECIPE -> new Sprinkler();
            case CraftingItemType.QUALITY_SPRINKLER_RECIPE -> new Quality_Sprinkler();
            case CraftingItemType.IRIDIUM_SPRINKLER_RECIPE -> new Iridium_Sprinkler();
            case CraftingItemType.CHARCOAL_KILN_RECIPE -> new Charcoal_Klin();
            case CraftingItemType.FURNACE_RECIPE -> new Furnace();
            case CraftingItemType.SCARECROW_RECIPE -> new Scarecrow();
            case CraftingItemType.DELUXE_SCARECROW_RECIPE -> new Deluxe_Scarecrow();
            case CraftingItemType.BEE_HOUSE_RECIPE -> new Bee_House();
            case CraftingItemType.CHEESE_PRESS_RECIPE -> new Cheese_Press();
            case CraftingItemType.KEG_RECIPE -> new Keg();
            case CraftingItemType.LOOM_RECIPE -> new Loom();
            case CraftingItemType.MAYONNAISE_MACHINE_RECIPE -> new Mayonnaise_Machine();
            case CraftingItemType.OIL_MAKER_RECIPE -> new Oil_Maker();
            case CraftingItemType.PRESERVES_JAR_RECIPE -> new Preserves_Jar();
            case CraftingItemType.DEHYDRATOR_RECIPE -> new Dehydrator();
            case CraftingItemType.GRASS_STARTER_RECIPE -> new Grass_Starter();
            case CraftingItemType.FISH_SMOKER_RECIPE -> new Fish_Smoker();
            case CraftingItemType.MYSTIC_TREE_SEED_RECIPE -> new Mystic_Tree_Seed();
        };
    }
}
