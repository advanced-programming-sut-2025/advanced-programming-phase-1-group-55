package model;

import enums.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    public static User mainUser;
    public static HashMap<String,User> playersInGame=new HashMap<>();
    public static Menu currentMenu = Menu.SignupMenu;
    public static WeatherType currentWeather;
    private ArrayList<User> AllUsers;
    private static ArrayList<String> questionsList;

    public ArrayList<User> getAllUsers() {
        return AllUsers;
    }

    public void addUserToUsers(User user) {
        AllUsers.add(user);
    }

    public static Menu getCurrentMenu() {
        return currentMenu;
    }
}
