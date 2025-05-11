package model;


import enums.DayOfTheWeeks;
import enums.Seasons;

import static enums.DayOfTheWeeks.*;
import static enums.Seasons.*;

import java.awt.*;
import java.time.LocalDate;

import static model.Game.*;

public class GameTime {

    private static int hour = 9;
    private static DayOfTheWeeks day = saturday;
    private static Seasons season = fall;
    private static int DayofMonth = 1;


    public static void setHour(int hour) {
        GameTime.hour = hour;
    }


    public static DayOfTheWeeks getDay() {
        return day;
    }

    public static void setDay(DayOfTheWeeks day) {
        GameTime.day = day;
    }

    public static int getHour() {
        return hour;
    }

    public static Seasons getSeason() {
        return season;
    }

    public static void setSeason(Seasons season) {
        GameTime.season = season;
    }

    public static int getDayofMonth() {
        return DayofMonth;
    }

    public static void setDayofMonth(int dayofMonth) {
        DayofMonth = dayofMonth;
    }

    // age zaman roo ziyad ezafe kone momkene bug bede
    public static void increaseHour(int hour) {
        GameTime.hour += hour;
        if (GameTime.hour >= 22) {
            GameTime.hour = 9;
            mainUser.setLocation(mainUser.getPlayerTommorowLocation());
            day = day.nextDay();
            DayofMonth += 1;
            if (DayofMonth > 28) {
                DayofMonth = 1;
                season = season.nextSeason();
            }


        }


    }

    public static void increaseDay(int number) {
        DayofMonth += number % 28;
        if (DayofMonth + number > 28) {
            season = season.nextSeason();
        } else if (DayofMonth + number > 56) {
            season = season.nextSeason().nextSeason();

        } else if (DayofMonth + number > 84) {
            season = season.nextSeason().nextSeason().nextSeason();
        }


    }


    public String getDayOfWeek() {
        return "";
    }


}
