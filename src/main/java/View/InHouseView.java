package View;

import model.App;
import model.Map.MainLocation;
import java.util.regex.Matcher;

public class InHouseView implements AppMenu {
    private final MainGameView mainGameView = new MainGameView();
    private final inHouseController inHouseController = new inHouseController();
    @Override
    public void check(String input) {
        if (!App.currentGame.currentUser.getMainLocation().equals(MainLocation.House)) {
            System.out.println("you are not in a house !");
            return;
        }

        Matcher matcher = null;

        if((matcher = inHouseGameMenuCommands.ShowLearnedRecipes.getMatcher(input)) != null) {
            System.out.println(inHouseController.ShowCraftingRecipe());
        } else if((matcher = inHouseGameMenuCommands.CraftItem.getMatcher(input)) != null) {
            String itemName = matcher.group("itemName");
            System.out.println(inHouseController.CraftItem(itemName));
        } else {

            mainGameView.check(input);
        }

    }
}
