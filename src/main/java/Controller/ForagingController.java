package Controller;

import View.ForagingView;
import model.Skills;
import View.MiningView;
public class ForagingController extends SkillController {
    private ForagingView view;
    public ForagingController(Skills foragingSkill) {
        super(foragingSkill);
        this.view = new ForagingView();
    }

    @Override
    protected void onLevelUp(int newLevel) {

    }



    public void collectItem() {
        skill.pointUp(10);
        view.displayCollectMessage();
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
