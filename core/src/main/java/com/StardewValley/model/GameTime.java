package com.StardewValley.model;


import com.StardewValley.enums.DayOfTheWeeks;
import com.StardewValley.enums.Seasons;

import static com.StardewValley.enums.DayOfTheWeeks.*;
import static com.StardewValley.enums.Seasons.*;
import static com.StardewValley.model.weather.*;


import com.StardewValley.enums.WeatherType;

import com.StardewValley.model.Friendship.NpcFriendship;
import com.StardewValley.model.Friendship.PlayerFriendship;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.Map.farmBuilder;
import com.StardewValley.model.Store.Product;
import com.StardewValley.model.Store.Store;

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
        if (weather.getCurrentWeather().equals(WeatherType.Rain)) {
            setEnergyLoser(1.5);
        } else if (weather.getCurrentWeather().equals(WeatherType.Snow)) {
            setEnergyLoser(2);
        }

        if (weather.getCurrentWeather().equals(WeatherType.Storm)) {
            System.out.println(RandomThor());
            System.out.println("Current Weather is " + weather.getCurrentWeather());

        }
        for (Item plant : currentGameModel.getAllPlants().values()) {
            plant.increaseStage(1);
            if (plant.getStage() == 5) {
                currentGameModel.getMap().tiles[plant.getLocation().getY()][plant.getLocation().getX()].setMohtaviat("?");
                currentGameModel.getAllPlants().remove(plant.getItemType().getDisplayName());
            }
        }
        for (User player : currentGameModel.playersInGame) {
            //in moheme paak nakonid faghat baraaye saadegi tahvil comment kardim!!!!!!!!!!!!!!
//            if (!player.isFainted()) {
//
//                player.setLocation(new Location(player.getFarm().getLocation().getY() + 1, player.getFarm().getLocation().getX() + 1));
//            }

            if (player.isFainted()) {
                player.setFainted(false);
                player.setEnergy(150);
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
            farmBuilder.placeRandomForaggings(user.getFarm(), currentGameModel.getMap(),2,2,1,false);
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
            if(user.isSad()){
                user.increaseTimeToBeSad();
                if (user.getTimePassedBeingSad()>=7){
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

    //todo age zaman roo ziyad ezafe kone momkene bug bede
    //todo mitooni ye tabe bezani be esm rooz bad va karayy ke dar rooz bad bayad bokoni ro too on bezani
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
