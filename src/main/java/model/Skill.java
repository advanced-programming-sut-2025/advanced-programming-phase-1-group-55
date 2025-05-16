package model;

import enums.CookingItemType;
import enums.CraftingItemType;
import enums.SkillType;

import java.util.HashMap;

public class Skill {
    private final SkillType type;
    private int level;
    private int points;
    private final static int maxLevel = 4;
//    private List<Ability> abilities;


    public Skill(SkillType type) {
        this.type = type;
        this.level = 0;
        this.points = 0;
    }

    public SkillType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getPoints() {
        return points;
    }
    public void addLevel() {
        this.level ++;
        setPoints(0);
    }

    public void setPoints(int points) {
        this.points = points;
    }
    public void changePoints(int number) {
        this.points += number;
        if (number >= 0) handleLevelUp();
        else handleLevelDown();

        addCraftingRecipe();
        addCookingRecipe();
    }

    public boolean checkLevel() {
        switch (level) {
            case 0:
                if (points >= 50) {
                    return true;
                }
                break;
                case 1:
                    if (points >= 150) {
                        return true;
                    }
                    break;
                    case 2:
                        if (points >= 250) {
                            return true;
                        }
                        break;
                        case 3:
                            if (points >= 350) {
                                return true;
                            }
                            break;
        }
        return false;
    }
    private void levelUp(int threshold) {
        this.level++;
        this.points -= threshold;
    }
    private void handleLevelUp() {
        while (true) {
            switch (this.level) {
                case 0:
                    if (points >= 50) levelUp(50);
                    else return;
                    break;
                case 1:
                    if (points >= 150) levelUp(150);
                    else return;
                    break;
                case 2:
                    if (points >= 250) levelUp(250);
                    else return;
                    break;
                case 3:
                    if (points >= 350) levelUp(350);
                    else return;
                    break;
                default:
                    return;
            }
        }
    }
    private int getThresholdForLevel(int level) {
        return switch (level) {
            case 0 -> 50;
            case 1 -> 150;
            case 2 -> 250;
            case 3 -> 350;
            default -> Integer.MAX_VALUE;
        };
    }
    private void handleLevelDown() {
        while (this.level > 0) {
            int threshold = getThresholdForLevel(this.level - 1);
            if (this.points < 0) {
                this.level--;
                this.points += threshold;
            } else {
                break;
            }
        }
    }
    private void addCraftingRecipe() {
        HashMap<CraftingItemType, Integer> map = type.getCraftingRecipes();
        for (CraftingItemType key : map.keySet()) {
            if (level >= map.get(key)) {
                User user = App.currentGame.currentUser;
                if (!user.getBackPack().getCraftingRecipes().contains(key)) {
                    user.getBackPack().getCraftingRecipes().add(key);
                }
            }
        }
    }
    private void addCookingRecipe() {
        HashMap<CookingItemType, Integer> map = type.getCookingRecipes();
        for (CookingItemType key : map.keySet()) {
            if (level >= map.get(key)) {
                User user = App.currentGame.currentUser;
                if (!user.getBackPack().getCookingRecipes().contains(key)) {
                    user.getBackPack().getCookingRecipes().add(key);
                }
            }
        }
    }
}


