package Controller;
import Controller.SkillController;

import model.Skills;
import View.MiningView;
public class MiningController extends SkillController {
    private MiningView view;
    public MiningController(Skills miningSkill) {
        super(miningSkill);
        this.view = new MiningView();
    }

    @Override
    protected void onLevelUp(int newLevel) {

    }



    public void mineRock() {
        skill.pointUp(10);
        view.displayMiningMessage();
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


    public boolean hasExtraDropChance() {
        return skill.getLevel() >= 2;
    }

}
