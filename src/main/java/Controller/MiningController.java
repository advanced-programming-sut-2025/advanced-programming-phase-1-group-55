//package Controller;
//import enums.CraftingItemType;
//import model.User;
//import model.Skills;
//
//
//public class MiningController extends SkillController {
//    private User user;
//
//    public MiningController(Skills skill, User user) {
//        super(skill);
//        this.user = user;
//    }
//
//    @Override
//    protected void onLevelUp(int newLevel) {
//        switch (newLevel) {
//            case 1 -> {
//                user.getBackPack().learnCraftingRecipe(CraftingItemType.CHERRY_BOMB);
//            }
//            case 2 -> {
//                user.getBackPack().learnCraftingRecipe(CraftingItemType.BOMB);
//            }
//            case 3 -> {
//                user.getBackPack().learnCraftingRecipe(CraftingItemType.MEGA_BOMB);
//            }
//            case 4 -> {
//
//            }
//        }
//    }
//
//
//
//
//
//
////    public boolean hasExtraDropChance() {
////        return skill.getLevel() >= 2;
////    }
//
//}
