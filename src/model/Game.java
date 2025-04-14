package model;

import enums.*;

import java.util.ArrayList;

public class Game {
    public static User mainUser;
    public static Menu currentMenu = Menu.SignupMenu;
    private static ArrayList<String> questionsList;

    public static Menu getCurrentMenu() {
        return currentMenu;
    }
}
