package View;

import Controller.RegisterController;
import enums.Menu;
import enums.RegisterCommands;
import enums.Result;

import java.util.Scanner;
import java.util.regex.*;

import static model.Game.*;

public class Register extends AppView implements AppMenu {
    RegisterController controller = new RegisterController();

    @Override
    public void check(String input) {
        Matcher Register = RegisterCommands.Register.getMatcher(input);
        if (Register != null) {

            Result result = controller.Register(Register.group("username").trim(), Register.group("password").trim(), Register.group("passwordConfirmation").trim(), Register.group("nickname").trim(), Register.group("email").trim(), Register.group("gender").trim());
            System.out.println(result);


        } else if (input.matches("\\s*menu\\s+exit\\s*")) {

            currentMenu = Menu.ExitMenu;
        } else if (input.matches("\\s*login\\s*")) {
            currentMenu = Menu.LoginMenu;
            System.out.println("you are in login mode");
        } else if (input.matches("\\s*show\\s+current\\s+menu\\s*")) {
            System.out.println("you are in Register Menu now!");
        }


    }
}
