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
//        List<Ability> abilities = skill.getAbilities();
        if (newLevel == 1) {
            user.learnRecipe(CraftingItemType.SPRINKLER);
            user.learnRecipe(CraftingItemType.BEE_HOUSE);
        } else if (newLevel == 2) {
            user.learnRecipe(CraftingItemType.QUALITY_SPRINKLER);
            user.learnRecipe(CraftingItemType.DELUXE_SCARECROW);
            user.learnRecipe(CraftingItemType.CHEESE_PRESS);
            user.learnRecipe(CraftingItemType.PRESERVES_JAR);
        } else if (newLevel == 3) {
            user.learnRecipe(CraftingItemType.IRIDIUM_SPRINKLER);
            user.learnRecipe(CraftingItemType.KEG);
            user.learnRecipe(CraftingItemType.OIL_MAKER);
        } else if (newLevel == 4) {

        }
    }


//    public double getQualityBoostChance() {
//        return 0.1 * skill.getLevel();
//    }
}
