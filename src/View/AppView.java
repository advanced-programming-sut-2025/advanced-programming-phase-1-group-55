package View;



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