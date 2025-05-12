package View;


import enums.Menu;

import java.util.Scanner;

import static model.App.getCurrentMenu;
import static model.App.readfile;


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