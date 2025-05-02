package View;

import Controller.MainMenuController;
import enums.Menu;

import java.util.Scanner;

import static model.Game.*;

public class MainMenu extends AppView implements AppMenu {
    MainMenuController controller = new MainMenuController();

    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine();
        if (input.matches("\\s*user\\s+logout\\s*")) {
            currentMenu = Menu.Register;
            System.out.println("going to Register menu"  );
        }

    }
}
