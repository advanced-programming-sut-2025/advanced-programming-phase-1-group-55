package com.StardewValley.View.oldView;
import  com.StardewValley.enums.*;

import java.util.regex.Matcher;
import static  com.StardewValley.model.App.currentMenu;
public class ExitMenu extends AppView implements AppMenu {

    @Override
    public void check(String input) {
        Matcher matcher = null;
        if (input.matches("\\s*menu exit\\s*")) {

            currentMenu = Menu.ExitMenu;

        } else {
            System.out.println("invalid command!");
        }
    }
}
