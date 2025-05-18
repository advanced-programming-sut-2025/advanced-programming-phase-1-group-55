package model.Animal;

import enums.WeatherType;
import model.App;
import model.Item.Item;
import model.Item.ItemType;
import model.Tool.FishingPoleType;
import model.weather;

import java.util.Random;

public class Fish extends Item {
    private FishType type;
    private double quality = 0.0;

    public Fish(FishType type) {
        super.itemType = type.getType();
        this.type = type;
    }

//    @Override
    public FishType getType() {
        return type;
    }

    public double getQuality() {

        return quality;
    }
    public static String getQualityName(double quality) {
        if (quality < 0.5)
            return "normal";
        else if (quality < 0.7)
            return "silver";
        else if (quality < 0.9)
            return "gold";
        else
            return "iridium";
    }
    public void calculateQuality(FishingPoleType type)
    {
        Random random = new Random();
        int R = random.nextInt(2);
        int skill = App.currentGame.currentUser.getFishingSkill().getLevel();
        double M;
        double pole = 0;
        switch (weather.getCurrentWeather())
        {
            case WeatherType.Sunny -> M = 1.5;
            case WeatherType.Rain -> M = 1.2;
            case WeatherType.Storm -> M = 0.5;
            default -> M = 1;
        }
        switch (type)
        {
            case FishingPoleType.TRAINING_ROD -> pole = 0.1;
            case FishingPoleType.BAMBOO_ROD -> pole = 0.5;
            case FishingPoleType.FIBERGLASS_ROD -> pole = 0.9;
            case FishingPoleType.IRIDIUM_ROD -> pole = 1.2;
        }

        this.quality = (R * (skill + 2) * pole) / (7 - M);
    }
    private int numberOfFishes()
    {
        Random random = new Random();
        double R = 0.5 + 0.5 * random.nextDouble();
        double M;
        int skill = App.currentGame.currentUser.getFishingSkill().getLevel();

        switch (weather.getCurrentWeather()) {
            case WeatherType.Sunny -> M = 1.5;
            case WeatherType.Rain -> M = 1.2;
            case WeatherType.Storm -> M = 0.5;
            default -> M = 1;
        }

        int result = (int) (R * M * (skill + 2));
        return result;
    }

}
