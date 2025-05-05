package Controller;

import model.Skills;
import model.Ability;

import java.util.List;

public abstract class SkillController {
    protected Skills skill;
    private static final int MAX_LEVEL = 4;

    public SkillController(Skills skill) {
        this.skill = skill;
    }


    public void addPoints(int amount) {
        if (skill.getLevel() >= MAX_LEVEL) return;

        int currentPoints = skill.getPoints();
        currentPoints += amount;

        while (skill.getLevel() < MAX_LEVEL && currentPoints >= requiredPointsForNextLevel()) {
            currentPoints -= requiredPointsForNextLevel();
            skill.setLevel(skill.getLevel() + 1);
            onLevelUp(skill.getLevel());
        }

        skill.setPoints(currentPoints);
    }

    private int requiredPointsForNextLevel() {
        int level = skill.getLevel();
        return level * 100 + 50;
    }

    protected abstract void onLevelUp(int newLevel);

    public Skills getSkill() {
        return skill;
    }

    public List<Ability> getAbilities() {
        return skill.getAbilities();
    }
}
