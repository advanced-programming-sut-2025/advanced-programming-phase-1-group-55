package model;

import java.util.ArrayList;
import java.util.List;

public class Skills {
    private String name;
    private int level;
    private int points;
    private int maxLevel;
    private List<Ability> abilities;

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

    }
    public void pointUp(int i) {

    }
    public void checkAbilities() {

    }
    public void showAbilities() {

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
}
