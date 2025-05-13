package Controller;

import View.FishingView;
import enums.CraftingItemType;
import model.Ability;
import model.Skills;
import model.User;


public class FishingController extends SkillController {
    private User user;

    public FishingController(Skills skill, User user) {
        super(skill);
        this.user = user;
    }

    @Override
    protected void onLevelUp(int newLevel) {
        switch (newLevel) {
            case 1 -> {

            }
            case 2 -> {

            }
            case 3 -> {

            }
            case 4 -> {

            }
        }
    }


}
