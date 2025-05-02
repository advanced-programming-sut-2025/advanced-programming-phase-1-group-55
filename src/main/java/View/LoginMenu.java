package View;

import Controller.LoginMenuController;
import enums.LoginCommands;
import sun.rmi.runtime.Log;

import java.util.Scanner;
import java.util.regex.Matcher;

public class LoginMenu extends AppView implements AppMenu {
    LoginMenuController controller=new LoginMenuController();
    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine();
        Matcher Login= LoginCommands.Login.getMatcher(input);
        if (Login!=null) {

        }

    }
}
