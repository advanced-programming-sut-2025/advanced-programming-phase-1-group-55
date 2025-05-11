package model;

import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;
import enums.*;


import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.*;


import com.google.gson.GsonBuilder;

import enums.Menu;


import java.util.List;

public class Game {
    public static User mainUser;
    public static Menu currentMenu = Menu.GameMenu;
    public static HashMap<String, User> playersInGame = new HashMap<>();


    public static WeatherType currentWeather;
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


    public static Menu getCurrentMenu() {
        return currentMenu;
    }
}
