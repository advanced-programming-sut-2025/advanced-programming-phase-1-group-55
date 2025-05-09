package View;

import Controller.*;
import enums.*;

import java.util.regex.Matcher;

import java.util.Scanner;
import java.util.regex.Matcher;

public class MainGameView implements AppMenu {
    private final MainGameController controller = new MainGameController();
    private final CropController controller2 = new CropController();
    private final TreeCotroller controller3 = new TreeCotroller();
    private final ForagingCropController controller4 = new ForagingCropController();
    private final ForagingTreeController controller5 = new ForagingTreeController();

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
        } else if ((matcher = TreesCommands.ShowTreeByName.getMatcher(input)) != null) {
            System.out.println(controller3.getCropByName(matcher.group("name")));
        } else if ((matcher = ForagingCropsCommands.showForagingCropsByName.getMatcher(input)) != null) {
            System.out.println(controller4.getForagingCropsByName(matcher.group("name")));
        } else if ((matcher = ForagingTreesCommands.showForagingTreesByName.getMatcher(input)) != null) {
            System.out.println(controller5.getForagingTreesByName(matcher.group("name")));
        } else if ((matcher = mainGameCommands.date.getMatcher(input)) != null) {
            System.out.println(controller.date());

        } else if ((matcher = mainGameCommands.time.getMatcher(input)) != null) {
            System.out.println(controller.time());

        }
    }
}
