package Controller;


import enums.AnsiColor;
import model.App;
import model.Game;
import model.Item.Item;
import model.Map.GameMap;
import model.Map.GreenHouse;
import model.Map.Location;
import enums.WeatherType;
import model.Map.MainLocation;
import model.Tool.Tools;
import model.Tool.Trashcan;
import model.Tool.WateringCan;
import model.Result;
import enums.AnsiColor;

import static model.Item.ItemType.*;

import model.User;
import model.weather.*;

import static model.weather.*;


import static model.App.*;
import static model.GameTime.*;

public class MainGameController {
    public Result equipToolFromBackPack(String toolsName) {
        if (currentGame.currentUser.getBackPack() == null || !currentGame.currentUser.getBackPack().getAvailableTools().containsKey(toolsName)) {
            return new Result(false, "you don't have this tool :(");
        }
        currentGame.currentUser.getBackPack().setCurrentTool(currentGame.currentUser.getBackPack().getAvailableTools().get(toolsName));
        return new Result(true, "you equipped " + toolsName);
    }

    public Result showCurrentTools() {
        return new Result(true, currentGame.currentUser.getBackPack().showCurrentTool());
    }

    public Result showAvailableTools() {
        if (currentGame.currentUser.getBackPack() == null || currentGame.currentUser.getBackPack().getAvailableTools().isEmpty()) {
            return new Result(false, "your backpackis empty:(");
        }
        return new Result(true, currentGame.currentUser.getBackPack().showAvailableTools());
    }

    public Result time() {

        return new Result(true, String.valueOf(getHour()));
    }

    public Result date() {
        StringBuilder sb = new StringBuilder();
        sb.append(getDayofMonth()).append(" of ").append(getSeason());

        return new Result(true, sb.toString());
    }

    public Result dateTime() {
        StringBuilder sb = new StringBuilder();
        sb.append("hour : ").append(getHour()).append("\nday : ").append(getDay()).append("\nseason : ").append(getSeason());
        return new Result(true, sb.toString());
    }

    public Result dayOfWeek() {

        return new Result(true, getDay().toString());
    }

    public Result cheatHour(String X) {
        int hour;
        try {
            hour = Integer.parseInt(X);
        } catch (Exception e) {
            return new Result(false, "invalid cheat hour");
        }
        increaseHour(hour);
        return new Result(true, "cheat hour " + hour + " confirmed");
    }

    public Result cheatDay(String X) {
        int Day;
        try {
            Day = Integer.parseInt(X);
        } catch (Exception e) {
            return new Result(false, "invalid cheat Day");
        }
        increaseDay(Day);
        return new Result(true, "cheat Day " + Day + " confirmed");
    }

    public Result cheatThor(String X, String Y) {
        int x, y;

        try {
            x = Integer.parseInt(X);
            y = Integer.parseInt(Y);
        } catch (Exception e) {
            return new Result(false, "invalid cheat Thor");
        }
        if (currentGame.getMap().tiles[y][x].getMohtaviat().equals("T")) {
            currentGame.getMap().tiles[y][x].setMohtaviat("Z");
            currentGame.getMap().tiles[y][x].setItemInThisTile(new Item(COAL));

        }
        return new Result(true, "cheat Thor " + x + " " + y + " confirmed");

    }

    public Result season() {
        return new Result(true, String.valueOf(getSeason()));
    }

    public Result showEnergy() {
        return new Result(true, "your energy : " + currentGame.currentUser.getEnergy());
    }

    public Result setEnergy(String energy) {
        try {
            currentGame.currentUser.setEnergy(Integer.parseInt(energy));
        } catch (Exception e) {
            return new Result(false, "invalid energy");
        }
        return new Result(true, "your energy set to " + energy);

    }

    public Result unlimitedEnergy() {
        currentGame.currentUser.setEnergy(Double.MAX_VALUE * 2);
        return new Result(true, "your energy unlimited");
    }

    public Result weather() {
        return new Result(true, getCurrentWeather().name());
    }

    public Result weatherForecast() {
        return new Result(true, getTomorrowWeather().name());
    }

    public Result weatherCheat(String type) {
        if (type.equals("Sunny")) {
            setTomorrowWeather(WeatherType.Sunny);
        } else if (type.equals("Rain")) {
            setTomorrowWeather(WeatherType.Rain);
        } else if (type.equals("Storm")) {
            setTomorrowWeather(WeatherType.Storm);
            System.out.println(RandomThor());
        } else if (type.equals("Snow")) {
            setTomorrowWeather(WeatherType.Snow);
        } else {
            return new Result(false, "invalid weather type");
        }
        return new Result(true, "weather successfully changed to : " + getTomorrowWeather().name());
    }

    public Result levelUpTool(String name) {
        Tools tool = currentGame.currentUser.getBackPack().getAvailableTools().get(name);
        if (!currentGame.currentUser.getMainLocation().equals(MainLocation.BlackSmithStore)) {
            return new Result(false, "you should go to blacksmith store to upgrade your tool!");
        }
        if (tool.getLevel() == 5) {
            return new Result(false, "level of your tool is max , you can't upgrade it !");
        }

        if (name.equals("trashcan")) {
            Trashcan can = currentGame.currentUser.getBackPack().getTrashcan();
            if (can.getPriceToLevelUp() > currentGame.currentUser.getGold()) {
                return new Result(false, "you don't have enough money to levelUp your tool");
            } else {
                currentGame.currentUser.setGold(currentGame.currentUser.getGold() - can.getPriceToLevelUp());
                can.increaseLevel(1);
            }
        } else if (tool instanceof WateringCan can) {
            if (can.getPriceToLevelUp() > currentGame.currentUser.getGold()) {
                return new Result(false, "you don't have enough money to levelUp your tool");
            } else {
                currentGame.currentUser.setGold(currentGame.currentUser.getGold() - can.getPriceToLevelUp());
                can.increaseLevel(1);
            }
        } else {
            if (tool.getPriceToLevelUp() > currentGame.currentUser.getGold()) {
                return new Result(false, "you don't have enough money to levelUp your tool");
            } else {
                currentGame.currentUser.setGold(currentGame.currentUser.getGold() - tool.getPriceToLevelUp());
                tool.increaseLevel(1);
            }
        }
        return new Result(true, name + " upgraded successfully");
    }

    public Result helpReadMap() {
        String message = "";
        message += "T: trees\n&: Foraging Crobs\n*: Foraging Seeds\nh: house area\n#: walls\n" +
                "=: doors\ng: greenhouse area\n" + "W: water area(lake)\n^: quarry area\n" +
                "0: rocks\n$: starDropSaloon\ns: SEBASTIAN's house\n" + "B: blacksmith store\n" +
                "O: ojaMart store\nA: ABIGAIL's house\nH: HARVEY's house\n" + "L: LEAH's house\n" +
                "R: ROBIN's house\n" + "G: General store\nC: Carpenter Shop\nF: fish store\nM: marnieRanch store";
        return new Result(true, message);
    }

    public Result showFullMap() {
        return new Result(true, currentGame.getMap().printMap(new Location(0, 0), 160, 41));
    }

    public Result showMap(int x, int y, int size) {
        return new Result(true, currentGame.getMap().printMap(new Location(y, x), size, size));
    }

    //cheat code baraye test map hamintori zadam trlrport kone;
    public Result teleport(int x, int y) {
        currentGame.currentUser.setLocation(new Location(y, x));
        return new Result(true, " you teleported to " + "y:" + y + " x:" + x);
    }

    public Result buildGreenHouse() {
        User user = currentGame.currentUser;
        if (user.getGold() < 1000 || user.getBackPack().getInventory().get("wood") == null || user.getBackPack().getInventory().get("wood").getNumber() < 500) {
            return new Result(false, "you dont have enough material to build green house");
        } else {

            user.setGreenHouse(user.getFarm().getGreenHouse());
            user.getGreenHouse().setRepaired(true);
            user.increaseGold(-1000);
            user.getBackPack().getInventory().get("wood").addNumber(-500);
            return new Result(true, "green house build successfully");
        }
    }

    public Result showOwner(int x, int y) {
        if (currentGame.getMap().tiles[y][x].getOwner() == null) {
            return new Result(false, "Default tile");
        }
        return new Result(true, "this tile is in " + currentGame.getMap().tiles[y][x].getOwner().getUsername() + "'s farm" + "Mohtaviat :" + currentGame.getMap().tiles[y][x].getMohtaviat());
    }

    public Result changePlayer(String username) {
        User user = FriendshipController.findUser(username);
        if (user == null) {
            return new Result(false, "user not found!");
        }
        currentGame.currentUser = user;
        StringBuilder message = new StringBuilder();
        if (currentGame.currentUser.isHasGiftToday()) {
            message.append("you received new gift!\n");
            currentGame.currentUser.setHasGiftToday(false);
        }
        if (currentGame.currentUser.isHasMessageToday()) {
            message.append("you received new message!");
            currentGame.currentUser.setHasMessageToday(false);
        }
        return new Result(true, username + " is now the main player\n" + message);
    }

    public Result trashItem(String name, int amount) {
        if (!App.currentGame.currentUser.getBackPack().getInventory().containsKey(name)) {
            return new Result(false, "you don't have this item");
        }
        Item item = App.currentGame.currentUser.getBackPack().getInventory().get(name);
        if (item.getNumber() < amount) {
            return new Result(false, "you don't have enough item to trash");
        }

        if (item.getPrice()==0) {
            item.setPrice(150);
        }
        App.currentGame.currentUser.getBackPack().removeAmountFromInventory(item.getItemType(), amount);
        App.currentGame.currentUser.increaseGold
                ((int) (amount * item.getPrice() * currentGame.currentUser
                        .getBackPack().getTrashcan().getRatio()));
        return new Result(true, "you sold " + name + "successfully!");
    }
}
