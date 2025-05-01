package Controller;

import enums.Result;

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
}
