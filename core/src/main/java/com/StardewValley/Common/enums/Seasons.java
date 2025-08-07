package com.StardewValley.Common.enums;

import java.util.List;

public enum Seasons {

    spring(0, "spring", List.of(WeatherType.Sunny, WeatherType.Rain, WeatherType.Storm)),
    summer(1, "summer", List.of(WeatherType.Sunny, WeatherType.Rain, WeatherType.Storm)),
    fall(2, "fall", List.of(WeatherType.Sunny, WeatherType.Rain, WeatherType.Storm)),
    winter(3, "winter", List.of(WeatherType.Sunny, WeatherType.Snow)),
    special(5,"special", List.of(WeatherType.Sunny, WeatherType.Snow, WeatherType.Rain, WeatherType.Storm)),;
    private int value;
    private String name;
    private final List<WeatherType> weatherTypes;

    Seasons(int value, String name, List<WeatherType> weatherTypes) {
        this.value = value;
        this.name = name;
        this.weatherTypes = weatherTypes;
    }
    @Override
    public String toString()
    {
        return name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public List<WeatherType> getWeatherTypes() {
        return weatherTypes;
    }

    public Seasons getSeasonByValue(int value) {
        for (Seasons season : Seasons.values()) {
            if (season.getValue() == value) {
                return season;
            }
        }
        return null;
    }

    public Seasons nextSeason() {
        System.out.println("value : "+this.value);
        return getSeasonByValue((this.value + 1) % 4);
    }

}
