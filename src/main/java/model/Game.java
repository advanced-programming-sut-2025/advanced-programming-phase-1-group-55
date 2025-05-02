package model;

import enums.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Game {
    public static User mainUser;
    public static Menu currentMenu = Menu.Register;
    public static HashMap<String, User> playersInGame = new HashMap<>();

    public static WeatherType currentWeather;
    public static HashMap<String,User> AllUsers = new HashMap<>();
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
