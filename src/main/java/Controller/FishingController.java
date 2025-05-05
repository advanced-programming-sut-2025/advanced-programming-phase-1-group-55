package Controller;

import View.FishingView;
import model.Skills;

public class FishingController extends SkillController {
    private FishingView view;
    public FishingController(Skills fishingSkill) {
        super(fishingSkill);
//        this.view = view;
        this.view = new FishingView();
    }

    @Override
    protected void onLevelUp(int newLevel) {

    }



    public void catchFish() {
        skill.pointUp(5);
        view.displayCatchMessage();
        handleLevelUp();
    }
    private void handleLevelUp() {
        int oldLevel = skill.getLevel();
        skill.levelUp();
        if (skill.getLevel() > oldLevel) {
            view.displayLevelUpMessage(skill.getLevel());
            skill.getAbilities().stream()
                    .filter(ability -> ability.getLevelRequierd() == skill.getLevel())
                    .forEach(ability -> view.displayAbilityUnlocked(ability.getName()));
        }
    }
    public void showStatus() {
        view.displayStatus(skill);
    }

    public void showAbilities() {
        view.displayAbilities(skill);
    }


}
