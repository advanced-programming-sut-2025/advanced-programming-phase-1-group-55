package model;

import enums.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    public static User mainUser;
    public static Menu currentMenu = Menu.Register;
    public static HashMap<String,User> playersInGame=new HashMap<>();

    public static WeatherType currentWeather;
    public static ArrayList<User> AllUsers=new ArrayList<>();
    public static ArrayList<String> questionsList;



    public static Menu getCurrentMenu() {
        return currentMenu;
    }
}
