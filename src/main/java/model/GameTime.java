package model;


import enums.DayOfTheWeeks;
import enums.Seasons;

import static enums.DayOfTheWeeks.*;
import static enums.Seasons.*;
import static model.weather.*;

import enums.WeatherType;

import static model.weather.*;

import model.Friendship.NpcFriendship;
import model.Friendship.PlayerFriendship;
import model.Item.Item;
import model.Map.Location;
import model.Store.Product;
import model.Store.Store;

import static model.App.*;

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
        for (User user : currentGame.playersInGame) {
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
        for (Item plant : currentGame.getAllPlants().values()) {
            plant.increaseStage(1);
        }

        for (User player : currentGame.playersInGame) {
            if (!player.isFainted()) {

                player.setLocation(new Location(player.getFarm().getLocation().getY() + 1, player.getFarm().getLocation().getX() + 1));
            }

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

//        if (DayofMonth >= 28 && DayofMonth < 56) {
//            DayofMonth = 1;
//
//            currentSeason = currentSeason.nextSeason();
//        } else if (DayofMonth >= 56 && DayofMonth < 84) {
//            DayofMonth = 1;
//            currentSeason = currentSeason.nextSeason().nextSeason();
//
//        } else if (DayofMonth > 84) {
//            DayofMonth = 1;
//            currentSeason = currentSeason.nextSeason().nextSeason().nextSeason();
//        }
        for (User user : currentGame.playersInGame) {
            user.increaseGold(user.getDailyMoney());
            user.setDailyMoney(0);
        }
        for (Store store : currentGame.getMap().getVillage().getStores().values()) {
            for (Product product : store.getProductsOfStore().values()) {
                product.setTodaySell(0);
            }
        }
        friendshipWorks();
        for (User user : currentGame.playersInGame) {
            for (NpcFriendship friendship : user.getFriendsNpc().values()) {
                friendship.increaseDayOfBeingFriend();
                friendship.setTodayMet(false);
                friendship.setTodayHadGift(false);
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
