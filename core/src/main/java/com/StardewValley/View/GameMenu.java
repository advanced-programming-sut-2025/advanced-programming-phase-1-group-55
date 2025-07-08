package com.StardewValley.View;

import  com.StardewValley.Controller.GameMenuController;
import  com.StardewValley.enums.Menu;

import  com.StardewValley.model.Map.*;
import  com.StardewValley.enums.mainGameCommands;

import java.util.regex.Matcher;

import static  com.StardewValley.model.App.*;


public class GameMenu extends AppView implements AppMenu {
    GameMenuController controller = new GameMenuController();

    @Override
    public void check(String input) {
        Matcher gameNew = mainGameCommands.gameNew.getMatcher(input);
        if (gameNew != null) {

            System.out.println(controller.newGame(gameNew.group("user1"), gameNew.group("user2"), gameNew.group("user3")));

        } else if (input.equals("back")) {
            currentMenu = Menu.MainMenu;
            System.out.println("Redirecting to main menu !");

        } else {
            System.out.println("invalid command in Game menu");
        }

    }
}
