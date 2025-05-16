package Controller;

import model.Skill;

public class SkillController {
    protected final Skill skill;

    public SkillController(Skill skill) {
        this.skill = skill;
    }

    public void addPoints(int amount) {
        skill.changePoints(amount);
    }

    public int getLevel() {
        return skill.getLevel();
    }

    public int getPoints() {
        return skill.getPoints();
    }

    public Skill getSkill() {
        return skill;
    }
}
