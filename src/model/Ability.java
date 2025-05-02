package model;

import enums.SkillType;

public class Ability {
    private String name;
    private int levelRequierd;
    private int pointsRequiredForNextLevel;
    private SkillType skillType;

    public Ability(String name, int levelRequierd, int pointsRequiredForNextLevel, SkillType skillType) {
        this.name = name;
        this.levelRequierd = levelRequierd;
        this.pointsRequiredForNextLevel = pointsRequiredForNextLevel;
        this.skillType = skillType;
    }

    public String getName() {
        return name;
    }

    public int getLevelRequierd() {
        return levelRequierd;
    }

    public int getPointsRequiredForNextLevel() {
        return pointsRequiredForNextLevel;
    }

    public void activate() {
        System.out.println("Activating " + name);
    }

    public SkillType getSkillType() {
        return skillType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevelRequierd(int levelRequierd) {
        this.levelRequierd = levelRequierd;
    }


}
