package View;



import enums.Menu;

import java.util.Scanner;

import static model.Game.getCurrentMenu;


public class AppView {

    Scanner scanner = new Scanner(System.in);
    public void run() {
        do {
            String input=scanner.nextLine();
            getCurrentMenu().checkCommand(input);
        } while (getCurrentMenu() != Menu.ExitMenu);
    }
}