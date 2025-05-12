package model;

import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;
import enums.*;


import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.*;


import com.google.gson.GsonBuilder;

import enums.Menu;
import model.Map.GameMap;


import java.util.List;

public class Game {
    public static User mainUser;
    public static Menu currentMenu = Menu.Register;
    public static HashMap<String, User> playersInGame = new HashMap<>();
    private static GameMap map;

  
    public static HashMap<String, User> AllUsers = new HashMap<>();

    public static void readfile() {

        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileReader reader = new FileReader("users.json");

            Type userListType = new TypeToken<List<User>>() {
            }.getType();

            List<User> userList = gson.fromJson(reader, userListType);
            if (userList != null) {

                for (User user : userList) {
                    AllUsers.put(user.getUsername(), user);
                }


            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static Map<Integer, String> questionsList = new HashMap<>();

    static {
        questionsList.put(1, "What was the name of your first-grade teacher?");
        questionsList.put(2, "What was the first phone number you ever memorized?");
        questionsList.put(3, "What is the name of your childhood best friend?");
    }

    public static User getMainUser() {
        return mainUser;
    }

    public static void setMainUser(User mainUser) {
        Game.mainUser = mainUser;
    }

    public static void setCurrentMenu(Menu currentMenu) {
        Game.currentMenu = currentMenu;
    }

    public static HashMap<String, User> getPlayersInGame() {
        return playersInGame;
    }

    public static void setPlayersInGame(HashMap<String, User> playersInGame) {
        Game.playersInGame = playersInGame;
    }

    public static GameMap getMap() {
        return map;
    }

    public static void setMap(GameMap map) {
        Game.map = map;
    }

    public static WeatherType getCurrentWeather() {
        return currentWeather;
    }

    public static void setCurrentWeather(WeatherType currentWeather) {
        Game.currentWeather = currentWeather;
    }

    public static HashMap<String, User> getAllUsers() {
        return AllUsers;
    }

    public static void setAllUsers(HashMap<String, User> allUsers) {
        AllUsers = allUsers;
    }

    public static Map<Integer, String> getQuestionsList() {
        return questionsList;
    }

    public static void setQuestionsList(Map<Integer, String> questionsList) {
        Game.questionsList = questionsList;
    }

    public static Menu getCurrentMenu() {
        return currentMenu;
    }
}
