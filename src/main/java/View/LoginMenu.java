package View;

import Controller.LoginMenuController;
import enums.LoginCommands;


import java.util.Scanner;
import java.util.regex.Matcher;

public class LoginMenu extends AppView implements AppMenu {
    LoginMenuController controller = new LoginMenuController();

    @Override
    public void check(String input) {
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

        } else if (input.matches("\\s*show\\s+current\\s+menu\\s*")) {
            System.out.println("you are in Login Menu now!");
        } else {
            System.out.println("invalid input in login menu");
        }


    }
}
