package Controller;

import model.Ability;
import model.Skills;

public class SkillsController {
    private Skills skill;
    public SkillsController(Skills skills) {
        this.skill = skills;
    }
    public void levelUp() {
        skill.levelUp();
    }
    public void gainPoints(int amount) {
        skill.gainPoints(amount);
    }
    public void addAbilitiesToSkills(Ability ability) {
        skill.addAbility(ability);
        System.out.println("Added Ability: " + ability + " to Skills: " + skill);
    }
    public void checkAbilities() {
        skill.checkAbilities();
    }
    public void activateAbility(String abilityName) {
        for (Ability ability : skill.getAbilities()) {
            if (ability.getName().equals(abilityName)) {
                if (skill.getLevel() >= ability.getLevelRequierd()) {
                    ability.activate();
                } else {
                    System.out.println("you don't have enough level to activate Ability: " + ability);
                }
                return;
            }
        }
        System.out.println("ability" + abilityName + " not found");
    }
    public void showSkillsDetails() {
        System.out.println("skills: " + skill.getName() + "level: " + skill.getLevel() + "abilities: " + skill.getAbilities());
        checkAbilities();

    }



}
