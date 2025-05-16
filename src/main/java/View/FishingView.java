//package View;
//
//import model.Skill;
//
//public class FishingView {
//
//    public void displayStatus(Skill fishingSkill) {
//        System.out.println("== Fishing Skill ==");
//        System.out.println("Level: " + fishingSkill.getLevel() + "/" + fishingSkill.getMaxLevel());
//        System.out.println("Points: " + fishingSkill.getPoints());
//    }
//
//    public void displayLevelUpMessage(int level) {
//        System.out.println("Fishing skill leveled up! New level: " + level);
//    }
//
//    public void displayAbilityUnlocked(String abilityName) {
//        System.out.println("New fishing ability unlocked: " + abilityName);
//    }
//
//    public void displayCatchMessage() {
//        System.out.println("You caught a fish and gained fishing experience.");
//    }
//
//    public void displayAbilities(Skill fishingSkill) {
//        System.out.println("Fishing Abilities:");
//        fishingSkill.getAbilities().forEach(ability -> {
//            System.out.println("- " + ability.getName() + " (Unlocked at level " + ability.getLevelRequierd() + ")");
//        });
//    }
//}
