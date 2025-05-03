package View;


import enums.Menu;

import java.util.Scanner;

import static model.Game.getCurrentMenu;
import static model.Game.readfile;


public class AppView {

    Scanner scanner = new Scanner(System.in);

    public void run() {
        readfile();
        do {
            String input = scanner.nextLine();
            getCurrentMenu().checkCommand(input);
        } while (getCurrentMenu() != Menu.ExitMenu);
    }
}