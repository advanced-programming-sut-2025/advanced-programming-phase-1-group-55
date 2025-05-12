package View;
import Controller.*;
import enums.*;
import Controller.CraftingController;
import Controller.MainLocationController;
import enums.MainLocation;
import model.Game;
import model.User;

import java.util.regex.Matcher;

public class InHouseView implements AppMenu {
    private final MainGameView mainGameView = new MainGameView();
    private final CraftingController craftingController = new CraftingController();
    @Override
    public void check(String input) {

        if (!MainLocationController.isIn(MainLocation.House)) {
            System.out.println("you are not in a house !");
            return;
        }

        Matcher matcher = null;

        if((matcher = inHouseGameMenuCommands.ShowLearnedRecipes.getMatcher(input)) != null) {
            System.out.println(craftingController.getLearnedRecipes(Game.getMainUser()));
        } else {

            mainGameView.check(input);
        }
    }
}
