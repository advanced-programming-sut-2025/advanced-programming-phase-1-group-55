package model;

import enums.Seasons;
import enums.WeatherType;
import model.GameTime;
import sun.security.tools.keytool.Main;

import java.util.Random;

import static enums.WeatherType.*;

public class weather {
    private static WeatherType CurrentWeather = Sunny;
    private static WeatherType tomorrowWeather;

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
        }
        return tomorrowWeather;
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
