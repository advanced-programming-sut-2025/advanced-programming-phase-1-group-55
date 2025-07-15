package com.StardewValley.Controller;

import com.StardewValley.model.App;
import com.StardewValley.model.Skill;

public class ForagingController extends SkillController {

    public ForagingController() {
        super(App.currentGameModel.currentUser.getForagingSkill());
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
