package model;

import enums.SkillType;

import java.util.ArrayList;
import java.util.List;

public class Skills {
    private String name;
    private int level;
    private int points;
    private int maxLevel;
    private List<Ability> abilities;
    private SkillType skillType;

    public Skills(String name, int maxLevel) {
        this.name = name;
        this.maxLevel = maxLevel;
        this.level = 0;
        this.points = 0;
        this.abilities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void levelUp() {
        if(level < maxLevel) {
            level++;
            points = 0;
            System.out.println((name + " level up!"));
        } else {
            System.out.println("Maximum level reached for " + name);
        }
    }
    public void gainPoints(int points) {
        this.points += points;
        System.out.println(points + " points gained for " + name);
        if (this.points >= getPointsRequiredForNextLevel()) {
            levelUp();
        }
    }
    public int getPointsRequiredForNextLevel() {
        return 100 * level + 50;
    }

    public void checkAbilities() {
        for(Ability ability : abilities) {
            if(level > ability.getLevelRequierd()) {
                System.out.println(ability.getName() + " has level " + ability.getLevelRequierd());
            } else {
                System.out.println(ability.getName() + "is locked");
            }
        }
    }
    public void showAbilities() {
        System.out.println(("abilities for " + skillType + ":"));
        for(Ability ability : abilities) {
            System.out.println(ability.getName());
        }
    }
    public void gainFarmingExperience() {
        if (skillType == SkillType.FARMING) {
            gainPoints(5);
        }
    }
    public void gainMiningExperience() {
        if (skillType == SkillType.MINING) {
            gainPoints(10);
            if (level > 2) {
                System.out.println("you gain extra item");
            }
        }
    }
    public void gainForagingExperience() {
        if (skillType == SkillType.FORAGING) {
            gainPoints(10);
            if (level > 2) {
                System.out.println("better fishing");
            }
        }
    }
    public void gainFishingExperience() {
        if (skillType == SkillType.FISHING) {
            gainPoints(10);
        }
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public void addAbility(Ability ability) {
        abilities.add(ability);
    }

}
