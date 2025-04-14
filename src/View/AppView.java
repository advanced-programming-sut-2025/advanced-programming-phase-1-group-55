package View;

/*
Explanation:
- This is a view class for the App.
- our app needs a place that handle menus (:
 */

import enums.Menu;

import java.util.Scanner;

import static model.Game.getCurrentMenu;


public class AppView {

    Scanner scanner = new Scanner(System.in);

    public void run() {

        do {
            getCurrentMenu().checkCommand(scanner);
        } while (getCurrentMenu() != Menu.ExitMenu);
    }
}