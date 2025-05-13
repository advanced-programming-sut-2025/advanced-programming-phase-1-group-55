package Controller;
import Controller.SkillController;
import enums.CraftingItemType;
import model.User;
import model.Ability;
import model.Skills;
import View.MiningView;
import model.User;


public class MiningController extends SkillController {
    private User user;

    public MiningController(Skills skill, User user) {
        super(skill);
        this.user = user;
    }

    @Override
    protected void onLevelUp(int newLevel) {
        if (newLevel == 1) {
//            user.learnRecipe(CraftingItemType.CHERRY_BOMB);
        } else if (newLevel == 2) {
//            user.learnRecipe(CraftingItemType.BOMB);
        } else if (newLevel == 3) {
//            user.learnRecipe(CraftingItemType.MEGA_BOMB);
        } else if (newLevel == 4) {

        }
    }






//    public boolean hasExtraDropChance() {
//        return skill.getLevel() >= 2;
//    }

}
