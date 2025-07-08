package com.StardewValley.View;


import  com.StardewValley.enums.Menu;
import  com.StardewValley.model.App;

import java.util.Scanner;

import static  com.StardewValley.model.App.getCurrentMenu;
import static  com.StardewValley.model.App.readfile;


public class AppView {


    public void run() {
        readfile();
        do {
            String input = App.scanner.nextLine();
            getCurrentMenu().checkCommand(input);
        } while (getCurrentMenu() != Menu.ExitMenu);
    }
}
