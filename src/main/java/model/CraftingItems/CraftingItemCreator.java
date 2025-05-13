package model.CraftingItems;

import enums.CraftingItemType;

public class CraftingItemCreator {
    public static CraftingItem create(CraftingItemType type) {
        if (type == null) return null;

        return switch (type) {
            case CraftingItemType.CHERRY_BOMB -> new Cherry_Bomb();
            case CraftingItemType.BOMB -> new Bomb();
            case CraftingItemType.MEGA_BOMB -> new Mega_Bomb();
            case CraftingItemType.SPRINKLER -> new Sprinkler();
            case CraftingItemType.QUALITY_SPRINKLER -> new Quality_Sprinkler();
            case CraftingItemType.IRIDIUM_SPRINKLER -> new Iridium_Sprinkler();
            case CraftingItemType.CHARCOAL_KILN -> new Charcoal_Klin();
            case CraftingItemType.FURNACE -> new Furnace();
            case CraftingItemType.SCARECROW -> new Scarecrow();
            case CraftingItemType.DELUXE_SCARECROW -> new Deluxe_Scarecrow();
            case CraftingItemType.BEE_HOUSE -> new Bee_House();
            case CraftingItemType.CHEESE_PRESS -> new Cheese_Press();
            case CraftingItemType.KEG -> new Keg();
            case CraftingItemType.LOOM -> new Loom();
            case CraftingItemType.MAYONNAISE_MACHINE -> new Mayonnaise_Machine();
            case CraftingItemType.OIL_MAKER -> new Oil_Maker();
            case CraftingItemType.PRESERVES_JAR -> new Preserves_Jar();
            case CraftingItemType.DEHYDRATOR -> new Dehydrator();
            case CraftingItemType.GRASS_STARTER -> new Grass_Starter();
            case CraftingItemType.FISH_SMOKER -> new Fish_Smoker();
            case CraftingItemType.MYSTIC_TREE_SEED -> new Mystic_Tree_Seed();
        };
    }
}
