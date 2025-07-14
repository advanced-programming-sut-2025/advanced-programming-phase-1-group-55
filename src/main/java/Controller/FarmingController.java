package Controller;

import model.FarmingProdocts.*;
import model.Item.Item;
import model.Item.ItemType;
import model.Map.Location;
import model.Map.MainLocation;
import model.Map.Tile;
import model.Result;
import model.Tool.Tools;
import model.Tool.WateringCan;
import model.User;

import static model.Item.ItemType.*;


import static model.App.*;

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
        System.out.println(tool.energyCost());
        if (tool.energyCost() > user.getEnergy()) {
            return new Result(false, "You do not have enough energy to use this tool");
        } else {
            tool.useTool();
            switch (tool.getName()) {
                case "Hoe" -> {
                    if (tile.getMohtaviat().equals("g")) {
                        if (user.getGreenHouse() == null) {
                            return new Result(false, "failed! you have no green house");
                        }
                        return new Result(true, "you shokmed green house");
                    }
                    if (tile.isShokhmed() || !tile.isEmpty()) {
                        return new Result(false, "failed! you can't shokhm this tile");
                    } else {
                        tile.setShokhmed(true);
                        return new Result(true, "tile shokhmed successfully");
                    }
                }
                case "Scythe" -> {
                    if (tile.getMohtaviat().equals("?")) {
                        Item item = tile.getItemInThisTile();
                        if (!(item instanceof Crop crop)) {
                            return new Result(false, "There is no crop to harvest in this tile.");
                        }
                        String cropName = crop.getCropType().getName();
                        ItemType itemType = ItemType.getItemType(cropName);
                        if (itemType == null) {
                            return new Result(false, "Unknown crop item: " + cropName);
                        }
                        user.getBackPack().getInventory()
                                .computeIfAbsent(itemType.getDisplayName(), k -> new Item(itemType))
                                .addNumber(1);
                        tile.setItemInThisTile(null);
                        tile.setMohtaviat(".");
                        tile.setShokhmed(false);
                        return new Result(true, "You received 1 " + cropName);
                    }
                    return new Result(false, "There is nothing to scythe");
                }
                case "Axe"->{
                    if(tile.getMohtaviat().equals("T")){
                        currentGame.currentUser.getBackPack().addItemToInventory(new Item(WOOD),200);
                        tile.setMohtaviat(".");
                        tile.setItemInThisTile(null);
                    } else if (tile.getMohtaviat().equals("&")||tile.getMohtaviat().equals("*")) {
                        currentGame.currentUser.getBackPack().addItemToInventory
                                (new Item(tile.getItemInThisTile().getItemType()),20);
                        tile.setMohtaviat(".");
                        tile.setItemInThisTile(null);
                    }
                } case "Pickaxe"->{
                    if(tile.getMohtaviat().equals("0")){
                        currentGame.currentUser.getBackPack().addItemToInventory
                                (new Item(tile.getItemInThisTile().getItemType()),20);
                        tile.setMohtaviat("^");
                        tile.setItemInThisTile(null);
                    } else if (tile.getMohtaviat().equals("I")) {
                        currentGame.currentUser.getBackPack().addItemToInventory
                                (new Item(tile.getItemInThisTile().getItemType()),tile.getItemInThisTile().getNumber());
                        tile.setMohtaviat(".");
                        tile.setItemInThisTile(null);
                    }
                }
                case "WateringCan"->{
                    if(user.getMainLocation().equals(MainLocation.NearTheWater)){
                        if (tool instanceof WateringCan can) {
                            can.setWaterContains(can.getCapacity());
                            return new Result(true,"you filled your wateringCan: "+can.getWaterContains());
                        }

                    } else if (tile.getMohtaviat().equals("?")) {
                        WateringCan can=(WateringCan)tool;
                        if (can.getWaterContains() < 20) {
                            return new Result(false, "Not enough water in watering can");
                        }

                        if (!(tile.getItemInThisTile() instanceof Fertilizable plant)) {
                            return new Result(false, "There is no plant to water on this tile.");
                        }

                        if (plant.isWatered()) {
                            return new Result(false, "This plant is already watered today.");
                        }
                        can.setWaterContains(can.getWaterContains() - 20);
                        plant.setWatered(true);
//                        plant.resetDaysWithoutWater();
                        String message = "You have " + can.getWaterContains() + " water left.";
                        return new Result(true, message + " You watered the plant successfully.");
                    }
                }
                default -> {
                    return new Result(false, "failed! tool not found");
                }
            }

        }
        return new Result(false,"tool used successfully");
    }

public Result plantSeed(String seed, String direction) {
    int directionInt;
    try {
        directionInt = Integer.parseInt(direction);
    } catch (Exception e) {
        return new Result(false, "Invalid tool direction.");
    }

    User user = currentGame.currentUser;
    Tile tile = getTileByDirection(directionInt);

    ItemType seedType = getItemType(seed);
    if (seedType == null) {
        return new Result(false, "Invalid seed name.");
    }
    Item seedItem = user.getBackPack().getInventory().get(seedType.getDisplayName());
    if (seedItem == null || seedItem.getNumber() <= 0) {
        return new Result(false, "You don't have this seed in your inventory.");
    }
    if (!tile.isShokhmed() || !tile.isEmpty() ) {
        return new Result(false, "You can't plant on this tile.");
    }
    AllCrops cropType = getCropTypeBySeed(seedType);
    if (cropType == null) {
        return new Result(false, "No crop matches this seed.");
    }
    Crop crop = new Crop(cropType, tile.getLocation());
    tile.setItemInThisTile(crop);
    tile.setMohtaviat("?");
    seedItem.addNumber(-1);

    return new Result(true, "Seed planted successfully.");
}

    private AllCrops getCropTypeBySeed(ItemType seedItemType) {
        for (AllCrops crop : AllCrops.values()) {
            if (crop.getSeed().getName().equalsIgnoreCase(seedItemType.getDisplayName())) {
                return crop;
            }
        }
        return null;
    }










    public Result fertilizePlant(String fertilizer, String direction) {
        int directionInt;
        try {
            directionInt = Integer.parseInt(direction);
        } catch (Exception e) {
            return new Result(false, "Invalid direction value.");
        }
        User user = currentGame.currentUser;
        Tile tile = getTileByDirection(directionInt);
        Item fertilizerItem = user.getBackPack().getInventory().get(fertilizer);
        if (fertilizerItem == null || fertilizerItem.getNumber() <= 0) {
            return new Result(false, "You do not have this fertilizer.");
        }
        Item itemInTile = tile.getItemInThisTile();
        if (!(itemInTile instanceof Fertilizable plant)) {
            return new Result(false, "There is no plant to fertilize on this tile.");
        }
        if (plant.isFertilized()) {
            return new Result(false, "This plant is already fertilized.");
        }
        plant.setFertilized(true);
        fertilizerItem.addNumber(-1);
        return new Result(true, "Fertilizer applied successfully.");
    }


public Result showPlant(int x, int y) {
    Tile tile = currentGame.getMap().tiles[y][x];
    Item item = tile.getItemInThisTile();

    if (!(item instanceof Crop crop)) {
        return new Result(false, "There is no plant in this tile.");
    }

    StringBuilder info = new StringBuilder();
    info.append("Name: ").append(crop.getCropType().getName()).append("\n");
    info.append("Watered Today: ").append(crop.isWatered()).append("\n");
    info.append("Fertilized: ").append(crop.isFertilized()).append("\n");
    // info.append("Current Stage: ").append(crop.getCurrentStage()).append("\n");
    // info.append("Days Until Harvest: ").append(crop.getDaysUntilHarvest()).append("\n");
    // info.append("Quality: ").append(crop.getQuality());

    return new Result(true, info.toString());
}







    public Result howMuchWater() {
        if (!currentGame.currentUser.getBackPack().getCurrentTool().getName().equals("WateringCan")) {
            return new Result(false, "your tool is not a watering can");
        }
        WateringCan wateringCan=(WateringCan)currentGame.currentUser.getBackPack().getCurrentTool();
        String message=" you have:"+wateringCan.getWaterContains()+"water in your watering can";
        return new Result(true, message);
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



}
