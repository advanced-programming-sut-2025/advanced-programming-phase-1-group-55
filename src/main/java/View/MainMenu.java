package View;

import Controller.MainMenuController;
import enums.Menu;

import java.util.Scanner;

import static model.Game.*;

public class MainMenu extends AppView implements AppMenu {

    MainMenuController controller = new MainMenuController();

    @Override
    public void check(String input) {


        if (input.matches("\\s*user\\s+logout\\s*")) {
            currentMenu = Menu.Register;
            System.out.println("going to Register menu");
        } else if (input.matches("\\s*menu\\s+enter\\s+profile")) {

            currentMenu = Menu.ProfileMenu;
            System.out.println("going to Profile menu");
        } else if (input.matches("\\s*menu\\s+enter\\s+avatar")) {

            currentMenu = Menu.AvatarMenu;
            System.out.println("going to Avatar menu");
        } else if (input.matches("\\s*menu\\s+enter\\s+game\\s*")) {

            currentMenu = Menu.MainGameMenu;
            System.out.println("going to Game menu");
        } else if (input.matches("\\s*show\\s+current\\s+menu\\s*")) {
            System.out.println("you are in Main Menu now!");
        } else {
            System.out.println("invalid input in MAIN MENU");
        }


    }
}
