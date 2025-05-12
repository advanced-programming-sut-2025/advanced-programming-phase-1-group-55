package View;


import enums.Menu;
import model.App;

import java.util.Scanner;

import static model.App.getCurrentMenu;
import static model.App.readfile;


public class AppView {


    public void run() {
        readfile();
        do {
            String input = App.scanner.nextLine();
            getCurrentMenu().checkCommand(input);
        } while (getCurrentMenu() != Menu.ExitMenu);
    }
}