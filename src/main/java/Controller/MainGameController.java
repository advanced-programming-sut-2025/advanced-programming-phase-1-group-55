package Controller;


import enums.WeatherType;
import model.Tool.Tools;
import model.Tool.Trashcan;
import model.Tool.WateringCan;
import model.Result;
import model.weather.*;

import static model.weather.*;

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
        } else if (type.equals("Snow")) {
            setTomorrowWeather(WeatherType.Snow);
        } else {
            return new Result(false, "invalid weather type");
        }
        return new Result(true, "weather successfully changed to : " + getCurrentWeather().name());
    }

    public Result levelUpTool(String name) {
        Tools tool = mainUser.getBackPack().getAvailableTools().get(name);
        if (tool.getLevel() == 5) {
            return new Result(false, "level of your tool is max , you can't upgrade it !");
        }
        /*
        to do
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
}
