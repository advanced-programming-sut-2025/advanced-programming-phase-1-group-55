package enums;

import java.util.HashMap;
import static javax.swing.UIManager.put;

public enum SkillType {
    Farming(new HashMap<>() {
        {
            put(CraftingItemType.SPRINKLER_RECIPE, 1);
            put(CraftingItemType.QUALITY_SPRINKLER_RECIPE, 2);
            put(CraftingItemType.IRIDIUM_SPRINKLER_RECIPE, 3);
            put(CraftingItemType.DELUXE_SCARECROW_RECIPE, 2);
            put(CraftingItemType.BEE_HOUSE_RECIPE, 1);
            put(CraftingItemType.CHEESE_PRESS_RECIPE, 2);
            put(CraftingItemType.KEG_RECIPE, 3);
            put(CraftingItemType.LOOM_RECIPE, 3);
            put(CraftingItemType.OIL_MAKER_RECIPE, 3);
            put(CraftingItemType.PRESERVES_JAR_RECIPE, 2);
        }
    }, new HashMap<>() {
        {
           put(CookingItemType.FARMERS_LUNCH, 1);
        }
    }),
    Mining(new HashMap<>() {{
        put(CraftingItemType.CHERRY_BOMB_RECIPE, 1);
        put(CraftingItemType.BOMB_RECIPE, 2);
        put(CraftingItemType.MEGA_BOMB_RECIPE, 3);
    }}, new HashMap<>() {{
        put(CookingItemType.MINERS_TREAT, 1);
    }}),
    Fishing(new HashMap<>() {{}}, new HashMap<>() {{
        put(CookingItemType.DISH_O_THE_SEA, 2);
        put(CookingItemType.SEAFOAM_PUDDING, 3);
    }}),
    Foraging(new HashMap<>() {{
        put(CraftingItemType.CHARCOAL_KILN_RECIPE, 1);
        put(CraftingItemType.MYSTIC_TREE_SEED_RECIPE, 4);
    }}, new HashMap<>() {{
        put(CookingItemType.VEGETABLE_MEDLEY, 2);
        put(CookingItemType.SURVIVAL_BURGER, 3);
    }}),
    Max_Energy(new HashMap<>() {{}}, new HashMap<>() {{}});


    private final HashMap<CraftingItemType, Integer> craftingRecipes;
    private final HashMap<CookingItemType, Integer> cookingRecipes;

    SkillType(HashMap<CraftingItemType, Integer> craftingRecipes, HashMap<CookingItemType, Integer> cookingRecipes) {
        this.craftingRecipes = craftingRecipes;
        this.cookingRecipes = cookingRecipes;
    }

    public HashMap<CraftingItemType, Integer> getCraftingRecipes() {
        return craftingRecipes;
    }

    public HashMap<CookingItemType, Integer> getCookingRecipes() {
        return cookingRecipes;
    }
}
