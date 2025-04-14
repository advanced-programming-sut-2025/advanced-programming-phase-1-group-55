package enums;

import View.*;

import java.util.Scanner;

public enum Menu {
    ExitMenu(new ExitMenu()),
    SignupMenu(new Register()),
    LoginMenu(new LoginMenu()),
    DashboardMenu(new GameMenu()),
    ProfileMenu(new ProfileMenu());


    private final AppMenu menu;

    Menu(AppMenu menu) {
        this.menu = menu;
    }

    public void checkCommand(Scanner scanner) {
        this.menu.check(scanner);
    }
}
