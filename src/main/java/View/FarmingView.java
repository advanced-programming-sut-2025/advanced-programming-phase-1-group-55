//package View;
//
//import model.Skill;
//
//public class FarmingView {
//
//    public void displayStatus(Skill farmingSkill) {
//        System.out.println("== Farming Skill ==");
//        System.out.println("Level: " + farmingSkill.getLevel() + "/" + farmingSkill.getMaxLevel());
//        System.out.println("Points: " + farmingSkill.getPoints());
//    }
//
//    public void displayLevelUpMessage(int level) {
//        System.out.println("Farming skill leveled up! New level: " + level);
//    }
//
//    public void displayAbilityUnlocked(String abilityName) {
//        System.out.println("New farming ability unlocked: " + abilityName);
//    }
//
//    public void displayHarvestMessage() {
//        System.out.println("You harvested a crop and gained farming experience.");
//    }
//
//    public void displayAbilities(Skill farmingSkill) {
//        System.out.println("Farming Abilities:");
//        farmingSkill.getAbilities().forEach(ability -> {
//            System.out.println("- " + ability.getName() + " (Unlocked at level " + ability.getLevelRequierd() + ")");
//        });
//    }
//}
