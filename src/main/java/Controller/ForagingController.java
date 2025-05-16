package Controller;

import model.App;
import model.Skill;

public class ForagingController extends SkillController {

    public ForagingController() {
        super(App.currentGame.currentUser.getForagingSkill());
    }


    public void onCollectNaturalItem() {
        skill.changePoints(10);
    }


    public int getCurrentLevel() {
        return skill.getLevel();
    }


    public int getCurrentPoints() {
        return skill.getPoints();
    }


    public Skill getForagingSkill() {
        return skill;
    }
}
