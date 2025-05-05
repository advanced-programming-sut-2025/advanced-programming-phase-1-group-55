package View;

import Controller.MainGameController;
import enums.mainGameCommands;

import java.util.Scanner;
import java.util.regex.Matcher;

public class MainGameView implements AppMenu{
    private final MainGameController controller=new MainGameController();
    @Override
    public void check(String input) {
        Matcher matcher=null;
       if((matcher= mainGameCommands.showAvailableTools.getMatcher(input))!=null){
           System.out.println(controller.showAvailableTools());
       } else if ((matcher=mainGameCommands.showCurrentTool.getMatcher(input))!=null) {
           System.out.println(controller.showCurrentTools());
       } else if ((matcher=mainGameCommands.upgradeTool.getMatcher(input))!=null) {
           System.out.println(controller.levelUpTool(matcher.group("name")));
       } else if ((matcher=mainGameCommands.toolEquipFromBackPack.getMatcher(input))!=null) {
           System.out.println(controller.equipToolFromBackPack(matcher.group("name")));
       }
    }
}
