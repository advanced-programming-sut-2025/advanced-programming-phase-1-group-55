package com.StardewValley.View.oldView;


import  com.StardewValley.enums.Menu;
import  com.StardewValley.model.App;

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
