package model;

import Controller.MainGameController;
import enums.Seasons;
import enums.WeatherType;


import java.security.SecureRandom;
import java.util.Random;

import static enums.WeatherType.*;

public class weather {
    private static WeatherType CurrentWeather = Sunny;
    private static WeatherType tomorrowWeather = RandomWeatherForTommorow();
    private static double EnergyLoser = 1;

    public static double getEnergyLoser() {
        return EnergyLoser;
    }

    public static void setEnergyLoser(double energyLoser) {
        EnergyLoser = energyLoser;
    }

    public static WeatherType RandomWeatherForTommorow() {
        Random random = new Random();
        int randomValue = random.nextInt(100);
        if (GameTime.getSeason() == Seasons.winter) {
            tomorrowWeather = Snow;

        } else if (GameTime.getSeason() == Seasons.spring) {
            if (randomValue % 3 == 0) {
                tomorrowWeather = Sunny;
            } else if (randomValue % 3 == 1) {
                tomorrowWeather = Rain;
            } else {
                tomorrowWeather = Storm;
            }
        } else if (GameTime.getSeason() == Seasons.fall) {

            if (randomValue % 3 == 0) {
                tomorrowWeather = Storm;
            } else if (randomValue % 3 == 1) {
                tomorrowWeather = Rain;
            } else {
                tomorrowWeather = Sunny;
            }
        } else {
            if (randomValue % 3 == 0) {
                tomorrowWeather = Rain;
            } else if (randomValue % 3 == 1) {
                tomorrowWeather = Storm;
            } else {
                tomorrowWeather = Sunny;
            }
        }
        return tomorrowWeather;

    }

    public static StringBuilder RandomThor() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nRandom thor because of storm weather");
        for (int i = 0; i < 3; i++) {

            SecureRandom random = new SecureRandom();
            int x = random.nextInt(160);
            int y = random.nextInt(40);
            MainGameController controller = new MainGameController();
            Result result = controller.cheatThor(Integer.toString(x), Integer.toString(y));
            if (result.IsSuccess()) {

                sb.append("\nx: ").append(x).append(" y: ").append(y).append("\n");
            }
        }
        return sb;

    }

    ;

    public static WeatherType getCurrentWeather() {
        return CurrentWeather;
    }

    public static void setCurrentWeather(WeatherType currentWeather) {
        CurrentWeather = currentWeather;
    }

    public static WeatherType getTomorrowWeather() {
        return tomorrowWeather;
    }

    public static void setTomorrowWeather(WeatherType tomorrowWeather) {
        weather.tomorrowWeather = tomorrowWeather;
    }
}
