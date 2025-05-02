package enums;

import View.*;

import java.util.Scanner;
import java.util.regex.Pattern;

public enum Menu {
    ExitMenu(new ExitMenu()),
    Register(new Register()),
    LoginMenu(new LoginMenu()),
    GameMenu(new GameMenu()),
    ProfileMenu(new ProfileMenu()),
    MainMenu(new MainMenu()),
    AvatarMenu(new AvatarMenu()),;


    private final AppMenu menu;

    Menu(AppMenu menu) {
        this.menu = menu;
    }

    public void checkCommand(Scanner scanner) {
        this.menu.check(scanner);
    }
}
