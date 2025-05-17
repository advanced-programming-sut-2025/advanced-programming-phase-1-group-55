package Controller;

import enums.CropQuality;
import model.App;
import model.Item.Item;
import model.Map.Location;
import model.Map.Tile;
import model.Result;
import model.Skill;
import model.Tool.Tools;
import model.User;

import static model.Item.ItemType.*;


import static model.App.*;

import java.util.ResourceBundle;

public class FarmingController {

//    public FarmingController() {
//        super(App.currentGame.currentUser.getFarmingSkill());
//    }


//    public void onHarvestProduct() {
//        skill.changePoints(5);
//    }
//
//
//    public CropQuality getCropQualityByFarmingLevel() {
//        int level = skill.getLevel();
//        double random = Math.random();
//
//        switch (level) {
//            case 0:
//                return CropQuality.NORMAL;
//
//            case 1:
//                if (random < 0.8) return CropQuality.NORMAL;
//                else return CropQuality.SILVER;
//
//            case 2:
//                if (random < 0.6) return CropQuality.NORMAL;
//                else if (random < 0.9) return CropQuality.SILVER;
//                else return CropQuality.GOLD;
//
//            case 3:
//                if (random < 0.5) return CropQuality.NORMAL;
//                else if (random < 0.8) return CropQuality.SILVER;
//                else return CropQuality.GOLD;
//
//            case 4:
//                if (random < 0.4) return CropQuality.NORMAL;
//                else if (random < 0.7) return CropQuality.SILVER;
//                else if (random < 0.9) return CropQuality.GOLD;
//                else return CropQuality.IRIDIUM;
//
//            default:
//                return CropQuality.NORMAL;
//        }
//    }

    public Result useTool(String direction) {
        int directionInt;
        try {
            directionInt = Integer.parseInt(direction);
        } catch (Exception e) {
            return new Result(false, "Invalid tool direction");
        }
        Tools tool = currentGame.currentUser.getBackPack().getCurrentTool();
        User user = currentGame.currentUser;
        Tile tile = getTileByDirection(directionInt);
        if (tool.energyCost() > user.getEnergy()) {
            return new Result(false, "You do not have enough energy to use this tool");
        } else {
            tool.useTool();
            if (tool.getName().equals("Hoe")) {
                if (tile.isShokhmed() || !tile.isEmpty()) {
                    return new Result(false, "failed! tile shokhm khorde");
                } else {

                    tile.setShokhmed(true);
                    return new Result(true, "tile shokhmed successfully");
                }

            }
        }
        return new Result(false, "failed! tool not found");

    }

    public Result plantSeed(String seed, String direction) {
        System.out.println(seed);
        int directionInt;
        try {
            directionInt = Integer.parseInt(direction);
        } catch (Exception e) {
            return new Result(false, "Invalid tool direction");
        }
        User user = currentGame.currentUser;
        Tile tile = getTileByDirection(directionInt);
        System.out.println(getItemType(seed).getDisplayName());
        if (user.getBackPack().getInventory().get(getItemType(seed).getDisplayName()) == null) {
            return new Result(false, "you dont have this seed in your inventory");
        } else {
            if (!tile.isShokhmed() || !tile.isEmpty()) {
                return new Result(false, "you cant plant on this tile");
            } else {
                tile.setItemInThisTile(new Item(getItemType(seed)));
                return new Result(true, "seed planted successfully");
            }
        }


    }

    private Tile getTileByDirection(int direction) {
        Location location = currentGame.currentUser.getLocation();
        int x = location.getX();
        int y = location.getY();
        return switch (direction) {
            case 1 -> currentGame.getMap().tiles[y - 1][x - 1];
            case 2 -> currentGame.getMap().tiles[y - 1][x];
            case 3 -> currentGame.getMap().tiles[y - 1][x + 1];
            case 4 -> currentGame.getMap().tiles[y][x + 1];
            case 5 -> currentGame.getMap().tiles[y + 1][x + 1];
            case 6 -> currentGame.getMap().tiles[y + 1][x];
            case 7 -> currentGame.getMap().tiles[y + 1][x - 1];
            case 8 -> currentGame.getMap().tiles[y][x - 1];
            default -> null;
        };
    }


//    public int getCurrentLevel() {
//        return skill.getLevel();
//    }
//
//    public int getCurrentPoints() {
//        return skill.getPoints();
//    }
//
//    public Skill getFarmingSkill() {
//        return skill;
//    }
}
