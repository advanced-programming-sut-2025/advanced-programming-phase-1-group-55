package View;

import Controller.ProfileMenuController;
import enums.ProfileCommands;

import static enums.ProfileCommands.*;

import java.util.Scanner;
import java.util.regex.Matcher;

public class ProfileMenu extends AppView implements AppMenu {

    ProfileMenuController controller = new ProfileMenuController();

    @Override
    public void check(String input) {

         input = scanner.nextLine();
        Matcher changeUsername = ProfileCommands.changeUsername.getMatcher(input);
        Matcher changeNickname = ProfileCommands.changeNickname.getMatcher(input);
        Matcher changeEmail = ProfileCommands.changeEmail.getMatcher(input);
        Matcher changePassword = ProfileCommands.changePassword.getMatcher(input);
        Matcher userInfo = ProfileCommands.userInfo.getMatcher(input);

        if (changeUsername != null) {
            System.out.println(controller.changeUsername(changeUsername.group("username")));
        } else if (changeNickname != null) {
            System.out.println(controller.changenickName(changeNickname.group("nickname")));
        } else if (changeEmail != null) {
            System.out.println(controller.changeEmail(changeEmail.group("email")));

        } else if (changePassword != null) {
            System.out.println(changePassword.group("password"));
        } else if (userInfo != null) {
            System.out.println(controller.userInfo());
        }

    }
}
