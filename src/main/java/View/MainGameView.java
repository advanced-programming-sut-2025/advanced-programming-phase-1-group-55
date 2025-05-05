package View;
import Controller.CropController;
import Controller.TreeCotroller;
import enums.CropMenuCommands;
import java.util.regex.Matcher;
import Controller.MainGameController;
import enums.TreesCommands;
import enums.mainGameCommands;

import java.util.Scanner;
import java.util.regex.Matcher;

public class MainGameView implements AppMenu{
    private final MainGameController controller=new MainGameController();
    private final CropController controller2 = new CropController();
    private final TreeCotroller controller3 = new TreeCotroller();
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
       } else if ((matcher=CropMenuCommands.ShowCropByName.getMatcher(input))!=null) {
           System.out.println(controller2.getCropByName(matcher.group("name")));
       } else if ((matcher= TreesCommands.ShowTreeByName.getMatcher(input))!=null) {
           System.out.println(controller3.getCropByName(matcher.group("name")));
       }
    }
}
