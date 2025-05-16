//package View;
//
//import model.Skill;
//
//public class MiningView {
//
//    public void displayStatus(Skill miningSkill) {
//        System.out.println("== Mining Skill ==");
//        System.out.println("Level: " + miningSkill.getLevel() + "/" + miningSkill.getMaxLevel());
//        System.out.println("Points: " + miningSkill.getPoints());
//    }
//
//    public void displayLevelUpMessage(int level) {
//        System.out.println("Mining skill leveled up! New level: " + level);
//    }
//
//    public void displayAbilityUnlocked(String abilityName) {
//        System.out.println("New mining ability unlocked: " + abilityName);
//    }
//
//    public void displayMiningMessage() {
//        System.out.println("You mined a rock and gained mining experience.");
//    }
//
//    public void displayAbilities(Skill miningSkill) {
//        System.out.println("Mining Abilities:");
//        miningSkill.getAbilities().forEach(ability -> {
//            System.out.println("- " + ability.getName() + " (Unlocked at level " + ability.getLevelRequierd() + ")");
//        });
//    }
//}
