package View;

import Controller.*;
import enums.*;
import model.App;
import model.Map.MainLocation;

import java.util.regex.Matcher;

import static model.App.*;

public class MainGameView implements AppMenu {
    private final MainGameController controller = new MainGameController();
    private final CropController controller2 = new CropController();
    private final StoreController controller3 = new StoreController();
    private final walkController controller4 = new walkController();
    //    private final TreeCotroller controller3 = new TreeCotroller();
//    private final ForagingCropController controller4 = new ForagingCropController();
//    private final ForagingTreeController controller5 = new ForagingTreeController();
    private final inHouseController inHouseController = new inHouseController();

    @Override
    public void check(String input) {
        Matcher matcher = null;
        if ((matcher = mainGameCommands.showAvailableTools.getMatcher(input)) != null) {
            System.out.println(controller.showAvailableTools());
        } else if ((matcher = mainGameCommands.showCurrentTool.getMatcher(input)) != null) {
            System.out.println(controller.showCurrentTools());
        } else if ((matcher = mainGameCommands.upgradeTool.getMatcher(input)) != null) {
            System.out.println(controller.levelUpTool(matcher.group("name")));
        } else if ((matcher = mainGameCommands.toolEquipFromBackPack.getMatcher(input)) != null) {
            System.out.println(controller.equipToolFromBackPack(matcher.group("name")));
        } else if ((matcher = CropMenuCommands.ShowCropByName.getMatcher(input)) != null) {
            System.out.println(controller2.getCropByName(matcher.group("name")));
            System.out.println(controller2.getTreeByName(matcher.group("name")));
            System.out.println(controller2.getForagingCropsByName(matcher.group("name")));
            System.out.println(controller2.getForagingTreesByName(matcher.group("name")));
//        } else if ((matcher = TreesCommands.ShowTreeByName.getMatcher(input)) != null) {
//            System.out.println(controller3.getTreeByName(matcher.group("name")));
//        } else if ((matcher = ForagingCropsCommands.showForagingCropsByName.getMatcher(input)) != null) {
//            System.out.println(controller4.getForagingCropsByName(matcher.group("name")));
//        } else if ((matcher = ForagingTreesCommands.showForagingTreesByName.getMatcher(input)) != null) {
//            System.out.println(controller5.getForagingTreesByName(matcher.group("name")));
//        } else if ((matcher = inHouseGameMenuCommands.ShowLearnedRecipes.getMatcher(input)) != null) {
//            System.out.println(inHouseController.getLearnedRecipes(currentGame.currentUser));
            // یادت نره این باید بره تو inHouseView برای تست لینجا گذاشتم
        } else if ((matcher = mainGameCommands.ShowCraftingRecipe.getMatcher(input)) != null) {
            System.out.println(inHouseController.ShowCraftingRecipe());
        } else if ((matcher = mainGameCommands.date.getMatcher(input)) != null) {
            System.out.println(controller.date());

        } else if ((matcher = mainGameCommands.time.getMatcher(input)) != null) {
            System.out.println(controller.time());

        } else if ((matcher = mainGameCommands.dateTime.getMatcher(input)) != null) {
            System.out.println(controller.dateTime());

        } else if ((matcher = mainGameCommands.dayOfWeek.getMatcher(input)) != null) {
            System.out.println(controller.dayOfWeek());

        } else if ((matcher = mainGameCommands.cheatHour.getMatcher(input)) != null) {
            System.out.println(controller.cheatHour(matcher.group("X")));
        } else if ((matcher = mainGameCommands.cheatday.getMatcher(input)) != null) {
            System.out.println(controller.cheatDay(matcher.group("X")));
        } else if (mainGameCommands.helpReadMap.getMatcher(input) != null) {
            System.out.println(controller.helpReadMap());
        } else if ((matcher = mainGameCommands.printMap.getMatcher(input)) != null) {
            System.out.println(controller.showMap(Integer.parseInt(matcher.group("x"))
                    , Integer.parseInt(matcher.group("y")), Integer.parseInt(matcher.group("size"))));
        } else if ((mainGameCommands.printFullMap.getMatcher(input)) != null) {
            System.out.println(controller.showFullMap());
        } else if ((matcher = mainGameCommands.season.getMatcher(input)) != null) {
            System.out.println(controller.season());
        } else if ((matcher = mainGameCommands.energyShow.getMatcher(input)) != null) {
            System.out.println(controller.showEnergy());
        } else if ((matcher = mainGameCommands.energySet.getMatcher(input)) != null) {
            System.out.println(controller.setEnergy(matcher.group("V")));
        } else if ((matcher = mainGameCommands.UnlimitedEnergy.getMatcher(input)) != null) {
            System.out.println(controller.unlimitedEnergy());
        } else if ((matcher = mainGameCommands.weather.getMatcher(input)) != null) {
            System.out.println(controller.weather());
        } else if ((matcher = mainGameCommands.weatherForecast.getMatcher(input)) != null) {
            System.out.println(controller.weatherForecast());
        } else if ((matcher = mainGameCommands.cheatWeatherSet.getMatcher(input)) != null) {
            System.out.println(controller.weatherCheat(matcher.group("type").trim()));
        } else if ((matcher = mainGameCommands.teleport.getMatcher(input)) != null) {
            System.out.println(controller.teleport(Integer.parseInt(matcher.group("x")),
                    Integer.parseInt(matcher.group("y"))));
            System.out.println("you are now in: " + currentGame.currentUser.getMainLocation());
        }
//        else if ((matcher = inHouseGameMenuCommands.ShowLearnedRecipes.getMatcher(input)) != null) {
//            System.out.println("you are now in: "+currentGame.currentUser.getMainLocation());
//        }
        else if ((matcher = inHouseGameMenuCommands.ShowLearnedCratingRecipes.getMatcher(input)) != null) {
            if (MainLocation.House.equals(currentGame.currentUser.getMainLocation())) {
                System.out.println(inHouseController.ShowCraftingRecipe());
            } else {
                System.out.println("You must be at home for this.");
            }
        } else if ((matcher = inHouseGameMenuCommands.CraftItem.getMatcher(input)) != null) {
            if (MainLocation.House.equals(currentGame.currentUser.getMainLocation())) {
                String itemName = matcher.group("itemName");
                System.out.println(inHouseController.CraftItem(itemName));
            } else {
                System.out.println("You must be at home for this.");
            }
        } else if ((matcher = inHouseGameMenuCommands.CheatAddItem.getMatcher(input)) != null) {
            if (MainLocation.House.equals(currentGame.currentUser.getMainLocation())) {
                String itemName = matcher.group("itemName");
                String count = matcher.group("count");
                System.out.println(inHouseController.CheatAddItem(itemName, count));
            } else {
                System.out.println("You must be at home for this.");
            }
        } else if ((matcher = inHouseGameMenuCommands.PlaceItem.getMatcher(input)) != null) {
            if (MainLocation.House.equals(currentGame.currentUser.getMainLocation())) {
                String itemName = matcher.group("itemName");
                String direction = matcher.group("direction");
                System.out.println(inHouseController.PlaceItem(itemName, direction));
            } else {
                System.out.println("You must be at home for this.");
            }
        } else if ((matcher = inHouseGameMenuCommands.PutInRefrigerator.getMatcher(input)) != null) {
            if (MainLocation.House.equals(currentGame.currentUser.getMainLocation())) {
                String item = matcher.group("item");
                System.out.println(inHouseController.PutInRefrigerator(item));
            } else {
                System.out.println("You must be at home for this.");
            }
        } else if ((matcher = inHouseGameMenuCommands.PickFromRefrigerator.getMatcher(input)) != null) {
            if (MainLocation.House.equals(currentGame.currentUser.getMainLocation())) {
                String item = matcher.group("item");
                System.out.println(inHouseController.PickFromRefrigerator(item));
            } else {
                System.out.println("You must be at home for this.");
            }
        } else if ((matcher = inHouseGameMenuCommands.ShowLearnedCookingRecipes.getMatcher(input)) != null) {
            if (MainLocation.House.equals(currentGame.currentUser.getMainLocation())) {
                System.out.println(inHouseController.ShowCookingRecipe());
            } else {
                System.out.println("You must be at home for this.");
            }
        } else if ((matcher = inHouseGameMenuCommands.CookItem.getMatcher(input)) != null) {
            if (MainLocation.House.equals(currentGame.currentUser.getMainLocation())) {
                String recipeName = matcher.group("recipeName");
                System.out.println(inHouseController.CookItem(recipeName));
            } else {
                System.out.println("You must be at home for this.");
            }
        } else if ((matcher = inHouseGameMenuCommands.Eat.getMatcher(input)) != null) {
            if (MainLocation.House.equals(currentGame.currentUser.getMainLocation())) {
                String feed = matcher.group("feed");
                System.out.println(inHouseController.Eat(feed));
            } else {
                System.out.println("You must be at home for this.");
            }
        } else if (input.matches("\\s*next\\s+turn\\s*")) {
            currentGame.nextTurn();


        } else if (input.matches("exit")) {
            currentMenu = Menu.ExitMenu;
        } else if ((matcher = StoreCommands.cheatMoney.getMatcher(input)) != null) {
            System.out.println(controller3.cheatAddMoney(Integer.parseInt(matcher.group("count").trim())));
        } else if (StoreCommands.showAllAvailableProducts.getMatcher(input) != null) {
            System.out.println(controller3.showAvailableProducts());
        } else if (StoreCommands.showAllProducts.getMatcher(input) != null) {
            System.out.println(controller3.showAllProducts());
        } else if ((matcher = mainGameCommands.walk.getMatcher(input)) != null) {
            System.out.println(controller4.walk(matcher.group("x"), matcher.group("y"), currentGame.getMap().tiles));
        } else if ((matcher = mainGameCommands.cheatThor.getMatcher(input)) != null) {
            System.out.println(controller.cheatThor(matcher.group("X"), matcher.group("Y")));

        } else if ((matcher = mainGameCommands.showOwner.getMatcher(input)) != null) {
            System.out.println(controller.showOwner(Integer.parseInt(matcher.group("x")), Integer.parseInt(matcher.group("y"))));
        } else if ((matcher=StoreCommands.sellItem.getMatcher(input))!=null) {
            if(matcher.group("count")!=null){
                System.out.println(controller3.sellItem(Integer.parseInt(matcher.group("count")),matcher.group("name")));
            }else {
                System.out.println(controller3.sellItem(1,matcher.group("name")));
            }
        } else if ((matcher=StoreCommands.purchaseItem.getMatcher(input))!=null) {
            if(matcher.group("count")!=null){
                System.out.println(controller3.purchaseItem(Integer.parseInt(matcher.group("count")),matcher.group("name")));
            }else {
                System.out.println(controller3.purchaseItem(1,matcher.group("name")));
            }
        }
    }
}
