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

//        if ()) {
//            System.out.println("you are not in a house !");
//            return;
//        }

        Matcher matcher = null;

        if((matcher = inHouseGameMenuCommands.ShowLearnedRecipes.getMatcher(input)) != null) {
            System.out.println(inHouseController.ShowCraftingRecipe());
        } else if((matcher = inHouseGameMenuCommands.CraftItem.getMatcher(input)) != null) {
            String itemName = matcher.group("itemName");
            System.out.println(inHouseController.CraftItem(itemName));
        } else if ((matcher = inHouseGameMenuCommands.CheatAddItem.getMatcher(input)) != null) {
            String itemName = matcher.group("itemName");
            String count = matcher.group("count");
            System.out.println(inHouseController.CheatAddItem(itemName, count));
        }else {

            mainGameView.check(input);
        }

    }
}
