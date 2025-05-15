package View;

import Controller.GameMenuController;
import enums.Menu;
import model.App;
import model.Game;
import model.Map.*;
import enums.mainGameCommands;

import java.util.regex.Matcher;

import static model.App.*;


public class GameMenu extends AppView implements AppMenu {
    GameMenuController controller = new GameMenuController();

    @Override
    public void check(String input) {
        Matcher gameNew = mainGameCommands.gameNew.getMatcher(input);
        if (gameNew != null) {

            System.out.println(controller.newGame(gameNew.group("user1"), gameNew.group("user2"), gameNew.group("user3")));

        } else {
            System.out.println("invalid command in Game menu");
        }

    }
}
