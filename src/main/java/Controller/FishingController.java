package Controller;

import View.FishingView;
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
//        if (newLevel == 1) {
//
//        } else if (newLevel == 2) {
//            skill.addAbility(new Ability("Cast Mastery", "Longer casting range."));
//        } else if (newLevel == 3) {
//            skill.addAbility(new Ability("Quick Catch", "Faster fish catching."));
//        } else if (newLevel == 4) {
//            skill.addAbility(new Ability("Rare Fish Finder", "Higher chance for rare fish."));
//        }
    }


}
