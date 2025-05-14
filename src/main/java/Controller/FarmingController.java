package Controller;

import enums.CraftingItemType;
import model.Skills;
import model.User;

public class FarmingController extends SkillController {
    private User user;

    public FarmingController(Skills skill, User user) {
        super(skill);
        this.user = user;
    }

    @Override
    protected void onLevelUp(int newLevel) {
        switch (newLevel) {
            case 1 -> {
                user.getBackPack().learnCraftingRecipe(CraftingItemType.SPRINKLER);
                user.getBackPack().learnCraftingRecipe(CraftingItemType.BEE_HOUSE);
            }
            case 2 -> {
                user.getBackPack().learnCraftingRecipe(CraftingItemType.QUALITY_SPRINKLER);
                user.getBackPack().learnCraftingRecipe(CraftingItemType.DELUXE_SCARECROW);
                user.getBackPack().learnCraftingRecipe(CraftingItemType.CHEESE_PRESS);
                user.getBackPack().learnCraftingRecipe(CraftingItemType.PRESERVES_JAR);
            }
            case 3 -> {
                user.getBackPack().learnCraftingRecipe(CraftingItemType.IRIDIUM_SPRINKLER);
                user.getBackPack().learnCraftingRecipe(CraftingItemType.KEG);
                user.getBackPack().learnCraftingRecipe(CraftingItemType.OIL_MAKER);
            }
            case 4 -> {

            }
        }
    }


//    public double getQualityBoostChance() {
//        return 0.1 * skill.getLevel();
//    }
}
