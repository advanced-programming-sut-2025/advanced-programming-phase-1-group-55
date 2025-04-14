package model;

import enums.*;

import java.util.ArrayList;

public class Game {
    public static User mainUser;
    public static Menu currentMenu = Menu.SignupMenu;

    public static Menu getCurrentMenu() {
        return currentMenu;
    }
}
