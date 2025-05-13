package View;
import enums.*;
import Controller.inHouseController;
import Controller.MainLocationController;
import enums.MainLocation;
import model.App;

import java.util.regex.Matcher;

public class InHouseView implements AppMenu {
    private final MainGameView mainGameView = new MainGameView();
    private final inHouseController inHouseController = new inHouseController();
    @Override
    public void check(String input) {

        if (!MainLocationController.isIn(MainLocation.House)) {
            System.out.println("you are not in a house !");
            return;
        }

        Matcher matcher = null;

        if((matcher = mainGameCommands.ShowCraftingRecipe.getMatcher(input)) != null) {
            System.out.println(inHouseController.ShowCraftingRecipe());
//        } else if(){

        } else {

            mainGameView.check(input);
        }

    }
}
