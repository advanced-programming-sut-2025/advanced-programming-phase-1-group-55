package Controller;


import model.Tool.Tools;
import model.Tool.Trashcan;
import model.Tool.WateringCan;
import model.Result;

import static model.Game.*;
import static model.GameTime.*;

public class MainGameController {
    public Result equipToolFromBackPack(String toolsName) {
        if (mainUser.getBackPack() == null || !mainUser.getBackPack().getAvailableTools().containsKey(toolsName)) {
            return new Result(false, "you don't have this tool :(");
        }
        mainUser.getBackPack().setCurrentTool(mainUser.getBackPack().getAvailableTools().get(toolsName));
        return new Result(true, "you equipped " + toolsName);
    }

    public Result showCurrentTools() {
        return new Result(true, mainUser.getBackPack().showCurrentTool());
    }

    public Result showAvailableTools() {
        if (mainUser.getBackPack() == null || mainUser.getBackPack().getAvailableTools().isEmpty()) {
            return new Result(false, "your backpackis empty:(");
        }
        return new Result(true, mainUser.getBackPack().showAvailableTools());
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

    public Result season() {
        return new Result(true, String.valueOf(getSeason()));
    }

    public Result showEnergy() {
        return new Result(true, "your energy : " + mainUser.getEnergy());
    }

    public Result setEnergy(String energy) {
        try {
            mainUser.setEnergy(Integer.parseInt(energy));
        } catch (Exception e) {
            return new Result(false, "invalid energy");
        }
        return new Result(true, "your energy set to " + energy);

    }

    public Result unlimitedEnergy() {
        mainUser.setEnergy(Double.MAX_VALUE * 2);
        return new Result(true, "your energy unlimited");
    }

    public Result levelUpTool(String name) {
        Tools tool = mainUser.getBackPack().getAvailableTools().get(name);
        if (tool.getLevel() == 5) {
            return new Result(false, "level of your tool is max , you can't upgrade it !");
        }
        /*
        todo
        baayad shart boodn dar ahan gari ro emaal knm , bad zadan map;
        */
        if (tool instanceof Trashcan can) {
            if (can.getPriceToLevelUp() > mainUser.getMoney()) {
                return new Result(false, "you don't have enough money to levelUp your tool");
            } else {
                mainUser.setMoney(mainUser.getMoney() - can.getPriceToLevelUp());
                can.increaseLevel();
            }
        } else if (tool instanceof WateringCan can) {
            if (can.getPriceToLevelUp() > mainUser.getMoney()) {
                return new Result(false, "you don't have enough money to levelUp your tool");
            } else {
                mainUser.setMoney(mainUser.getMoney() - can.getPriceToLevelUp());
                can.increaseLevel();
            }
        } else {
            if (tool.getPriceToLevelUp() > mainUser.getMoney()) {
                return new Result(false, "you don't have enough money to levelUp your tool");
            } else {
                mainUser.setMoney(mainUser.getMoney() - tool.getPriceToLevelUp());
                tool.increaseLevel();
            }
        }
        return new Result(true, name + " upgraded successfully");
    }
    public Result helpReadMap(){
        String message="";
        message+="T: trees\n&: plants and seeds\nh: house area\n#: walls\n=: doors\ng: greenhouse area\n" +
                "W: water area(lake)\n^: quarry area\n0: rocks\n$: starDropSaloon\ns: SEBASTIAN's house\n" +
                "B: blacksmith store\nO: ojaMart store\nA: ABIGAIL's house\nH: HARVEY's house\n" +
                "L: LEAH's house\nR: ROBIN's house\n" +
                "G: General store\nC: Carpenter Shop\nF: fish store\nM: marnieRanch store";
        return  new Result(true,message);
    }
}
