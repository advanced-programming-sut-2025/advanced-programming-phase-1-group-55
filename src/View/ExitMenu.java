package View;
import enums.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import static model.Game.currentMenu;
public class ExitMenu extends AppView implements AppMenu {

    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine();
        Matcher matcher = null;
        if (input.matches("\\s*menu exit\\s*")) {

            currentMenu = Menu.ExitMenu;

        } else {
            System.out.println("invalid command!");
        }
    }
}
