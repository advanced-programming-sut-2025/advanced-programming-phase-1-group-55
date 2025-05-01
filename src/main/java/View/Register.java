package View;

import Controller.RegisterController;
import enums.RegisterCommands;

import java.util.Scanner;
import java.util.regex.*;


public class Register extends AppView implements AppMenu {
    RegisterController controller = new RegisterController();

    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine();
        Matcher Register = RegisterCommands.Register.getMatcher(input);
        if (Register != null) {
            controller.Register(Register.group("username").trim(), Register.group("password").trim(), Register.group("passwordConfirmation").trim(), Register.group("email").trim() );

        }


    }
}
