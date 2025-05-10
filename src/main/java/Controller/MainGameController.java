package Controller;

import model.Tool.Tools;
import model.Tool.Trashcan;
import model.Tool.WateringCan;
import model.Result;

import static model.Game.*;

public class MainGameController {
    public Result equipToolFromBackPack(String toolsName){
        if(mainUser.getBackPack()==null||!mainUser.getBackPack().getAvailableTools().containsKey(toolsName)){
            return  new Result(false,"you don't have this tool :(");
        }
        mainUser.getBackPack().setCurrentTool(mainUser.getBackPack().getAvailableTools().get(toolsName));
        return new Result(true,"you equipped "+toolsName);
    }
    public Result showCurrentTools(){
        return new Result(true,mainUser.getBackPack().showCurrentTool());
    }
    public Result showAvailableTools(){
        if(mainUser.getBackPack()==null||mainUser.getBackPack().getAvailableTools().isEmpty()){
            return  new Result(false,"your backpackis empty:(");
        }
        return  new Result(true,mainUser.getBackPack().showAvailableTools());
    }
    public Result levelUpTool(String name){
        Tools tool= mainUser.getBackPack().getAvailableTools().get(name);
        if(tool.getLevel()==5){
            return  new Result(false,"level of your tool is max , you can't upgrade it !");
        }
        /*
        todo
        baayad shart boodn dar ahan gari ro emaal knm , bad zadan map;
        */
        if(tool instanceof Trashcan can){
            if(can.getPriceToLevelUp()>mainUser.getMoney()){
                return new Result(false,"you don't have enough money to levelUp your tool");
            }else {
                mainUser.setMoney(mainUser.getMoney()-can.getPriceToLevelUp());
                can.increaseLevel();
            }
        } else if(tool instanceof WateringCan can) {
            if(can.getPriceToLevelUp()>mainUser.getMoney()){
                return new Result(false,"you don't have enough money to levelUp your tool");
            }else {
                mainUser.setMoney(mainUser.getMoney()-can.getPriceToLevelUp());
                can.increaseLevel();
            }
        }else {
            if(tool.getPriceToLevelUp()>mainUser.getMoney()){
                return new Result(false,"you don't have enough money to levelUp your tool");
            }else {
                mainUser.setMoney(mainUser.getMoney()-tool.getPriceToLevelUp());
                tool.increaseLevel();
            }
        }
        return new Result(true,name+" upgraded successfully");
    }
}
