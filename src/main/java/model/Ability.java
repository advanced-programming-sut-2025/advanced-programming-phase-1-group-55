package model;

public class Ability {
    private String name;
    private int levelRequierd;
    private int pointsRequiredForNextLevel;

    public Ability(String name, int levelRequierd, int unitsRequiredForNextLevel) {
        this.name = name;
        this.levelRequierd = levelRequierd;
        this.pointsRequiredForNextLevel = unitsRequiredForNextLevel;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setLevelRequierd(int levelRequierd) {
        this.levelRequierd = levelRequierd;
    }

    public void setPointsRequiredForNextLevel(int pointsRequiredForNextLevel) {
        this.pointsRequiredForNextLevel = pointsRequiredForNextLevel;
    }
}
