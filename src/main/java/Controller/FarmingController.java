package Controller;

import Controller.SkillController;
import View.FarmingView;
import enums.CraftingItemType;
import model.Ability;
import model.Skills;
import model.User;

import java.util.List;

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
                user.getBackPack().learnRecipe(CraftingItemType.SPRINKLER);
                user.getBackPack().learnRecipe(CraftingItemType.BEE_HOUSE);
            }
            case 2 -> {
                user.getBackPack().learnRecipe(CraftingItemType.QUALITY_SPRINKLER);
                user.getBackPack().learnRecipe(CraftingItemType.DELUXE_SCARECROW);
                user.getBackPack().learnRecipe(CraftingItemType.CHEESE_PRESS);
                user.getBackPack().learnRecipe(CraftingItemType.PRESERVES_JAR);
            }
            case 3 -> {
                user.getBackPack().learnRecipe(CraftingItemType.IRIDIUM_SPRINKLER);
                user.getBackPack().learnRecipe(CraftingItemType.KEG);
                user.getBackPack().learnRecipe(CraftingItemType.OIL_MAKER);
            }
            case 4 -> {

            }
        }
    }


//    public double getQualityBoostChance() {
//        return 0.1 * skill.getLevel();
//    }
}
