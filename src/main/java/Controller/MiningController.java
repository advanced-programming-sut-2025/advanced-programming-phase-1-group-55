package Controller;

import model.App;
import model.Skill;

public class MiningController extends SkillController {

    public MiningController() {
        super(App.currentGame.currentUser.getMiningSkill());
    }


    public void onBreakStone() {
        skill.changePoints(10);
//        return skill.getLevel() >= 2;
    }


    public int getCurrentLevel() {
        return skill.getLevel();
    }


    public int getCurrentPoints() {
        return skill.getPoints();
    }


    public Skill getMiningSkill() {
        return skill;
    }
}
