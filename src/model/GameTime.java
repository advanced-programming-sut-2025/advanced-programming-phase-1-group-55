package model;

import enums.DayOfTheWeeks;

import java.time.LocalDate;

public class GameTime  {
    private static LocalDate date;
    private static String time;
    private static int hour;
    private static int minute;
    private static boolean isNight = false;
    private static boolean isDay = true;
    private static int  numberOfWeek;
    private static DayOfTheWeeks  day= DayOfTheWeeks.saturday;
    private static int month;
    private static String season;

    public static LocalDate getDate() {
        return date;
    }

    public static void setDate(LocalDate date) {
        GameTime.date = date;
    }

    public static String getTime() {
        return time;
    }

    public static void setTime(String time) {
        GameTime.time = time;
    }

    public static int getHour() {
        return hour;
    }

    public static void setHour(int hour) {
        GameTime.hour = hour;
    }

    public static int getMinute() {
        return minute;
    }

    public static void setMinute(int minute) {
        GameTime.minute = minute;
    }
    public static void tick(){
        minute += 10;
        if(minute > 59){
            minute = 0;
            hour++;
        }
        if(hour > 12){
            isDay = false;
            isNight = true;
        }
        if(hour > 23){
            hour = 0;
            day.getDayByValue(day.getValue()+1) ;
            date = date.plusDays(1);
        }
        if(day.getValue()> 6){
            day=DayOfTheWeeks.saturday;
        }
        if(hour > 6){
            isNight = false;
            isDay = true;
        }


    }
    public String getDayOfWeek() {

    }



}
