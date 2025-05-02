package View;

import Controller.LoginMenuController;
import enums.LoginCommands;
import sun.rmi.runtime.Log;

import java.util.Scanner;
import java.util.regex.Matcher;

public class LoginMenu extends AppView implements AppMenu {
    LoginMenuController controller = new LoginMenuController();

    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine();
        Matcher Login = LoginCommands.Login.getMatcher(input);
        Matcher forgetPassword = LoginCommands.ForgetPassword.getMatcher(input);
        if (Login != null) {
            if (Login.group("stay") != null) {

                System.out.println(controller.login(Login.group("username").trim(), Login.group("password").trim(), Login.group("stay")));
            } else {
                System.out.println(controller.login(Login.group("username").trim(), Login.group("password").trim(), "no"));
            }
        } else if (forgetPassword != null) {
            System.out.println(controller.forgetPassword(forgetPassword.group("username").trim()));

        } else {
            System.out.println("invalid input in login menu");
        }


    }
}
