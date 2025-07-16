package com.StardewValley.Controller;

import com.StardewValley.model.FarmingProdocts.AllCrops;
import com.StardewValley.model.FarmingProdocts.Crop;
import com.StardewValley.model.FarmingProdocts.Fertilizable;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.Item.ItemType;
import com.StardewValley.model.Map.Location;
import com.StardewValley.model.Map.MainLocation;
import com.StardewValley.model.Map.Tile;
import com.StardewValley.model.Result;
import com.StardewValley.model.Tool.Tools;
import com.StardewValley.model.Tool.WateringCan;
import com.StardewValley.model.User;

import static com.StardewValley.model.Item.ItemType.*;


import static com.StardewValley.model.App.*;

public class FarmingController {

    public Result useTool(String direction) {
        int directionInt;
        try {
            directionInt = Integer.parseInt(direction);
        } catch (Exception e) {
            return new Result(false, "Invalid tool direction");
        }
        Tools tool = currentGameModel.currentUser.getBackPack().getCurrentTool();
        User user = currentGameModel.currentUser;
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
                        tile.setMohtaviat("+");
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
                    return new Result(false, "there is nothing to scythe");
                }
                case "Axe"->{
                    if(tile.getMohtaviat().equals("T")){
                        currentGameModel.currentUser.getBackPack().addItemToInventory(new Item(WOOD),200);
                        tile.setMohtaviat(".");
                        tile.setItemInThisTile(null);
                    } else if (tile.getMohtaviat().equals("&")||tile.getMohtaviat().equals("*")) {
                        currentGameModel.currentUser.getBackPack().addItemToInventory
                                (new Item(tile.getItemInThisTile().getItemType()),20);
                        tile.setMohtaviat(".");
                        tile.setItemInThisTile(null);
                    }
                } case "Pickaxe"->{
                    if(tile.getMohtaviat().equals("0")){
                        currentGameModel.currentUser.getBackPack().addItemToInventory
                                (new Item(tile.getItemInThisTile().getItemType()),20);
                        tile.setMohtaviat("^");
                        tile.setItemInThisTile(null);
                    } else if (tile.getMohtaviat().equals("I")) {
                        currentGameModel.currentUser.getBackPack().addItemToInventory
                                (new Item(tile.getItemInThisTile().getItemType()),tile.getItemInThisTile().getNumber());
                        tile.setMohtaviat(".");
                        tile.setItemInThisTile(null);
                    } else if (tile.getMohtaviat().equals("+")) {
                        tile.setMohtaviat(".");
                        tile.setShokhmed(false);
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

        User user = currentGameModel.currentUser;
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
        User user = currentGameModel.currentUser;
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
        Tile tile = currentGameModel.getMap().tiles[y][x];
        Item item = tile.getItemInThisTile();

        if (!(item instanceof Crop crop)) {
            return new Result(false, "There is no plant in this tile.");
        }

        StringBuilder info = new StringBuilder();
        info.append("Name: ").append(crop.getCropType().getName()).append("\n");
        info.append("Watered Today: ").append(crop.isWatered()).append("\n");
        info.append("Fertilized: ").append(crop.isFertilized()).append("\n");

        return new Result(true, info.toString());
    }


    public Result howMuchWater() {
        if (!currentGameModel.currentUser.getBackPack().getCurrentTool().getName().equals("WateringCan")) {
            return new Result(false, "your tool is not a watering can");
        }
        WateringCan wateringCan=(WateringCan) currentGameModel.currentUser.getBackPack().getCurrentTool();
        String message=" you have:"+wateringCan.getWaterContains()+"water in your watering can";
        return new Result(true, message);
    }

    private Tile getTileByDirection(int direction) {
        Location location = currentGameModel.currentUser.getLocation();
        int x = location.getX();
        int y = location.getY();
        return switch (direction) {
            case 1 -> currentGameModel.getMap().tiles[y - 1][x - 1];
            case 2 -> currentGameModel.getMap().tiles[y - 1][x];
            case 3 -> currentGameModel.getMap().tiles[y - 1][x + 1];
            case 4 -> currentGameModel.getMap().tiles[y][x + 1];
            case 5 -> currentGameModel.getMap().tiles[y + 1][x + 1];
            case 6 -> currentGameModel.getMap().tiles[y + 1][x];
            case 7 -> currentGameModel.getMap().tiles[y + 1][x - 1];
            case 8 -> currentGameModel.getMap().tiles[y][x - 1];
            default -> null;
        };
    }

}
