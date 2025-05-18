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

    public Fish(ItemType itemtype, FishType type) {
        super(itemtype);
        this.type = type;
    }

//    @Override
    public FishType getType() {
        return type;
    }

    public double getQuality() {
        return quality;
    }
    public void calculateQuality(FishingPoleType level)
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
        switch (level)
        {
            case FishingPoleType.TRAINING_ROD -> pole = 0.1;
            case FishingPoleType.BAMBOO_ROD -> pole = 0.5;
            case FishingPoleType.FIBERGLASS_ROD -> pole = 0.9;
            case FishingPoleType.IRIDIUM_ROD -> pole = 1.2;
        }

        this.quality = (R * (skill + 2) * pole) / (7 - M);
    }
}
