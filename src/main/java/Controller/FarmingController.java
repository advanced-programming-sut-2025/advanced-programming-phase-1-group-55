package Controller;

import enums.CropQuality;
import model.App;
import model.Skill;
import model.User;

public class FarmingController extends SkillController {

    public FarmingController() {
        super(App.currentGame.currentUser.getFarmingSkill());
    }


    public void onHarvestProduct() {
        skill.changePoints(5);
    }


    public CropQuality getCropQualityByFarmingLevel() {
        int level = skill.getLevel();
        double random = Math.random();

        switch (level) {
            case 0:
                return CropQuality.NORMAL;

            case 1:
                if (random < 0.8) return CropQuality.NORMAL;
                else return CropQuality.SILVER;

            case 2:
                if (random < 0.6) return CropQuality.NORMAL;
                else if (random < 0.9) return CropQuality.SILVER;
                else return CropQuality.GOLD;

            case 3:
                if (random < 0.5) return CropQuality.NORMAL;
                else if (random < 0.8) return CropQuality.SILVER;
                else return CropQuality.GOLD;

            case 4:
                if (random < 0.4) return CropQuality.NORMAL;
                else if (random < 0.7) return CropQuality.SILVER;
                else if (random < 0.9) return CropQuality.GOLD;
                else return CropQuality.IRIDIUM;

            default:
                return CropQuality.NORMAL;
        }
    }

    public int getCurrentLevel() {
        return skill.getLevel();
    }

    public int getCurrentPoints() {
        return skill.getPoints();
    }

    public Skill getFarmingSkill() {
        return skill;
    }
}
