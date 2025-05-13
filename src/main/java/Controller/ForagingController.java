package Controller;

import View.ForagingView;
import enums.CraftingItemType;
import model.Skills;
import View.MiningView;
import model.User;

public class ForagingController extends SkillController {
    private User user;

    public ForagingController(Skills skill, User user) {
        super(skill);
        this.user = user;
    }

    @Override
    protected void onLevelUp(int newLevel) {
        if (newLevel == 1) {
//            user.learnRecipe(CraftingItemType.CHARCOAL_KILN);
        } else if (newLevel == 2) {

        } else if (newLevel == 3) {

        } else if (newLevel == 4) {
//            user.learnRecipe(CraftingItemType.MYSTIC_TREE_SEED);
        }
    }




}
