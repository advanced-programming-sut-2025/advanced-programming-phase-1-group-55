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
        switch (newLevel) {
            case 1 -> {
                user.learnRecipe(CraftingItemType.CHARCOAL_KILN);
            }
            case 2 -> {

            }
            case 3 -> {

            }
            case 4 -> {
                user.learnRecipe(CraftingItemType.MYSTIC_TREE_SEED);
            }
        }
    }




}
