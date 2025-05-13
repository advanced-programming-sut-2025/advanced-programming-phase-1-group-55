package View;

import Controller.inHouseController;
import enums.inHouseGameMenuCommands;
import model.App;
import model.Map.MainLocation;
import java.util.regex.Matcher;

public class InHouseView implements AppMenu {
    private final MainGameView mainGameView = new MainGameView();
    private final inHouseController inHouseControllers = new inHouseController();
    @Override
    public void check(String input) {
        if (!App.currentGame.currentUser.getMainLocation().equals(MainLocation.House)) {
            System.out.println("you are not in a house !");
            return;
        }

        Matcher matcher = null;

        if((matcher = inHouseGameMenuCommands.ShowLearnedRecipes.getMatcher(input)) != null) {
            System.out.println(inHouseControllers.ShowCraftingRecipe());
        } else if((matcher = inHouseGameMenuCommands.CraftItem.getMatcher(input)) != null) {
            String itemName = matcher.group("itemName");
            System.out.println(inHouseControllers.CraftItem(itemName));
        } else if ((matcher = inHouseGameMenuCommands.CheatAddItem.getMatcher(input)) != null) {
            String itemName = matcher.group("itemName");
            String count = matcher.group("count");
            System.out.println(inHouseControllers.CheatAddItem(itemName, count));
        } else if ((matcher = inHouseGameMenuCommands.PlaceItem.getMatcher(input)) != null) {
            String itemName = matcher.group("itemName");
            String direction = matcher.group("direction");
            System.out.println(inHouseControllers.PlaceItem(itemName, direction));
        } else {

            mainGameView.check(input);
        }

    }
}
