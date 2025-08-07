package com.StardewValley.model;


import com.StardewValley.enums.AssetManager;
import com.StardewValley.enums.DayOfTheWeeks;
import com.StardewValley.enums.Seasons;

import static com.StardewValley.enums.DayOfTheWeeks.*;
import static com.StardewValley.enums.Seasons.*;
import static com.StardewValley.model.weather.*;


import com.StardewValley.enums.WeatherType;

import com.StardewValley.model.Friendship.NpcFriendship;
import com.StardewValley.model.Friendship.PlayerFriendship;
import com.StardewValley.model.Store.Product;
import com.StardewValley.model.Store.Store;
import com.badlogic.gdx.graphics.Texture;

import static com.StardewValley.model.App.*;

public class GameTime {

    private static int hour = 9;
    private static DayOfTheWeeks day = saturday;
    private static Seasons currentSeason = fall;
    private static int DayofMonth = 1;
    private static MainTime mainTime = MainTime.Day;

    public static void setHour(int hour) {
        GameTime.hour = hour;
    }

    public static void friendshipWorks() {
        for (User user : currentGameModel.playersInGame) {
            for (PlayerFriendship friendship : user.getFriendsPlayer().values()) {
                friendship.setTodayTalked(false);
                friendship.setTodayGotFlower(false);
                friendship.setTodayGotGift(false);
                friendship.setTodayHugged(false);
                friendship.setTodayTraded(false);
            }
        }
    }

    public static void roozbad() {
        GameTime.hour = 9;
        weather.setCurrentWeather(weather.getTomorrowWeather());
        weather.RandomWeatherForTommorow();
        mainTime = MainTime.Day;
        if (weather.getCurrentWeather().equals(WeatherType.Rain)) {
            setEnergyLoser(1.5);
        } else if (weather.getCurrentWeather().equals(WeatherType.Snow)) {
            setEnergyLoser(2);
        }


        for (User player : currentGameModel.playersInGame) {

            if (player.isFainted()) {
                player.setFainted(false);
                player.setEnergy(10000);
            }
        }
        day = day.nextDay();
        DayofMonth += 1;
        if (DayofMonth > 28) {
            DayofMonth = 1;
            currentSeason = currentSeason.nextSeason();
        }
        for (User user : currentGameModel.playersInGame) {
            user.increaseGold(user.getDailyMoney());
            user.setDailyMoney(0);
            // FarmBuilder.placeRandomForaggings(user.getFarm(), currentGameModel.getMap(),2,2,1,false);
        }
        for (Store store : currentGameModel.getMap().getVillage().getStores().values()) {
            for (Product product : store.getProductsOfStore().values()) {
                product.setTodaySell(0);
            }
        }
        friendshipWorks();
        for (User user : currentGameModel.playersInGame) {
            for (NpcFriendship friendship : user.getFriendsNpc().values()) {
                friendship.increaseDayOfBeingFriend();
                friendship.setTodayMet(false);
                friendship.setTodayHadGift(false);
            }
            if (user.isSad()) {
                user.increaseTimeToBeSad();
                if (user.getTimePassedBeingSad() >= 7) {
                    user.setTimePassedBeingSad(0);
                    user.setSad(false);
                }
            }
        }

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
        return currentSeason;
    }

    public static void setSeason(Seasons season) {
        GameTime.currentSeason = season;
    }

    public static int getDayofMonth() {
        return DayofMonth;
    }

    public static void setDayofMonth(int dayofMonth) {
        DayofMonth = dayofMonth;
    }


    public static void increaseHour(int hour) {
        GameTime.hour += hour;
        if (GameTime.hour >= 22) {
            roozbad();
        }
        if (GameTime.hour > 17) {
            mainTime = MainTime.Night;
        }


    }

    public static void increaseDay(int number) {
        DayofMonth += number % 28;
        for (int i = 0; i < number; i++) {
            roozbad();

        }


    }
    public static Texture getCurrentBackgroundTexture() {
        if (hour > 17) {
            return AssetManager.NIGHT_BACKGROUND.getTexture();
        } else {
            return AssetManager.DAY_BACKGROUND.getTexture();
        }
    }

    public static MainTime getMainTime() {
        return mainTime;
    }

    public static void setMainTime(MainTime mainTime) {
        GameTime.mainTime = mainTime;
    }


    public String getDayOfWeek() {
        return "";
    }


}
