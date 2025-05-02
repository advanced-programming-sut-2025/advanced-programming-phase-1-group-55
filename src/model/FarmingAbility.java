package model;

import enums.SkillType;

public class FarmingAbility extends Ability {
    public FarmingAbility(String name, int levelRequierd, int pointsRequiredForNextLevel, SkillType skillType) {
        super(name, levelRequierd, pointsRequiredForNextLevel, skillType);
    }

    @Override
    public void activate() {
        super.activate();
    }
}
class MiningAbility extends Ability {
    public MiningAbility(String name, int levelRequierd, int pointsRequiredForNextLevel, SkillType skillType) {
        super(name, levelRequierd, pointsRequiredForNextLevel, skillType);
    }

    @Override
    public void activate() {
        super.activate();
    }
}
class ForagingAbility extends Ability {
    public ForagingAbility(String name, int levelRequierd, int pointsRequiredForNextLevel, SkillType skillType) {
        super(name, levelRequierd, pointsRequiredForNextLevel, skillType);
    }
    @Override
    public void activate() {
        super.activate();
    }
}
class FishingAbility extends Ability {
    public FishingAbility(String name, int levelRequierd, int pointsRequiredForNextLevel, SkillType skillType) {
        super(name, levelRequierd, pointsRequiredForNextLevel, skillType);
    }
    @Override
    public void activate() {
        super.activate();
    }
}
