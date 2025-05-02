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
    public void check(Scanner scanner) {
        String input = scanner.nextLine();
        Matcher Register = RegisterCommands.Register.getMatcher(input);
        if (Register != null) {
//            boolean exit = false;
//            while (!exit) {
                Result result = controller.Register(Register.group("username").trim(), Register.group("password").trim(), Register.group("passwordConfirmation").trim(),Register.group("nickname").trim(), Register.group("email").trim(),Register.group("gender").trim());
                System.out.println(result);
//                exit = result.IsSuccess();
//                if (exit == false) {
//                    if (result.Message().equals("Password is not valid") || result.Message().equals("Password is not strong")) {
//                        System.out.println("");
//                    }
//                    input = scanner.nextLine();
//                    Register = RegisterCommands.Register.getMatcher(input);
//                }
//            }

        } else if (input.matches("\\s*menu\\s+exit\\s*")) {

            currentMenu = Menu.ExitMenu;
        } else if (input.matches("\\s*show\\s+current\\s*menu\\s*")) {

            System.out.println(currentMenu + " menu");
        }


    }
}
