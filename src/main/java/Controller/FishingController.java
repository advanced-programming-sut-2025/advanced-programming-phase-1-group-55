package Controller;

import model.App;
import model.Skill;

public class FishingController extends SkillController {

    public FishingController() {
        super(App.currentGame.currentUser.getFishingSkill());
    }


    public void onCatchFish() {
        skill.changePoints(5);
    }


    public int getCurrentLevel() {
        return skill.getLevel();
    }


    public int getCurrentPoints() {
        return skill.getPoints();
    }


    public Skill getFishingSkill() {
        return skill;
    }
}
