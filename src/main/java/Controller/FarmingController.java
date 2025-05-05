package Controller;

import Controller.SkillController;
import View.FarmingView;
import model.Ability;
import model.Skills;

import java.util.List;

public class FarmingController extends SkillController {
    private FarmingView view;
    public FarmingController(Skills skill) {
        super(skill);
        this.view = new FarmingView();
    }



    public void harvestCrop() {
        skill.pointUp(5);
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


    @Override
    protected void onLevelUp(int newLevel) {
//        List<Ability> abilities = skill.getAbilities();
//        switch (newLevel) {
//            case 1:
//                abilities.add(new Ability("آبیاری سریع", "ابزار آبیاری سریع‌تر کار می‌کند"));
//                break;
//            case 2:
//                abilities.add(new Ability("بذرپاشی گسترده", "بذرپاشی چندتایی با یک حرکت"));
//                break;
//            case 3:
//                abilities.add(new Ability("افزایش کیفیت محصولات", "احتمال دریافت محصول با کیفیت بالا بیشتر می‌شود"));
//                break;
//            case 4:
//                abilities.add(new Ability("برداشت خودکار", "امکان برداشت خودکار محصولات فراهم می‌شود"));
//                break;
//        }
    }


    public double getQualityBoostChance() {
        return 0.1 * skill.getLevel();
    }
}
