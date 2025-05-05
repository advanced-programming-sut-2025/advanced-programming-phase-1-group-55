package View;

import model.Skills;

public class ForagingView {

    public void displayStatus(Skills foragingSkill) {
        System.out.println("== Foraging Skill ==");
        System.out.println("Level: " + foragingSkill.getLevel() + "/" + foragingSkill.getMaxLevel());
        System.out.println("Points: " + foragingSkill.getPoints());
    }

    public void displayLevelUpMessage(int level) {
        System.out.println("Foraging skill leveled up! New level: " + level);
    }

    public void displayAbilityUnlocked(String abilityName) {
        System.out.println("New foraging ability unlocked: " + abilityName);
    }

    public void displayCollectMessage() {
        System.out.println("You collected an item from nature and gained foraging experience.");
    }

    public void displayAbilities(Skills foragingSkill) {
        System.out.println("Foraging Abilities:");
        foragingSkill.getAbilities().forEach(ability -> {
            System.out.println("- " + ability.getName() + " (Unlocked at level " + ability.getLevelRequierd() + ")");
        });
    }
}
