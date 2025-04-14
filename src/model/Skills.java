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
    public void pointUp() {

    }
    public void checkAbilities() {

    }
    public void showAbilities() {

    }
}
