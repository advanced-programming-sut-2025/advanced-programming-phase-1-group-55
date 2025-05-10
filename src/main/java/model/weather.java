package model;

import enums.WeatherType;

import static enums.WeatherType.*;

public class weather {
    private static WeatherType CurrentWeather = Sunny;
    private static WeatherType tomorrowWeather;

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
