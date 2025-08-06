package com.StardewValley.Controller;

import com.StardewValley.enums.AnimalCommands;
import com.StardewValley.enums.WeatherType;
import com.StardewValley.model.*;
import com.StardewValley.model.Animal.*;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.Item.ItemType;
import com.StardewValley.model.Map.*;
import com.StardewValley.model.Tool.FishingPole;
import com.StardewValley.model.Tool.Tools;

import java.util.ArrayList;
import java.util.Random;

public class AnimalController {

    public Result buildAnimalBuilding(String input) {
        String buildingName = AnimalCommands.BUILD_ANIMAL_HOUSE.getMatcher(input).group("name").trim();
        int x = Integer.parseInt(AnimalCommands.BUILD_ANIMAL_HOUSE.getMatcher(input).group("x").trim());
        int y = Integer.parseInt(AnimalCommands.BUILD_ANIMAL_HOUSE.getMatcher(input).group("y").trim());
        User user = App.currentGameModel.currentUser;
        Farm farm = user.getFarm();
        NpcVillage city = App.currentGameModel.getMap().getVillage();
        Tile targetTile = farm.getTile(x, y);
        FarmBuildingType farmBuilding = FarmBuildingType.getFarmBuildingType(buildingName);
        if (farmBuilding == null) {
            return new Result(false, "invalid Building Name");
        }
        if (!farm.isInBounds(x, y)) {
            return new Result(false, "invalid Building Location");
        }
        int width = farmBuilding.getWidth();
        int height = farmBuilding.getHeight();

//        if (!farm.isGoodForAnimalBuilding(targetTile, width, height))
//        {
//            return new Result(false, "you can't build this building here");
//        }



        int price = farmBuilding.getPrice();
        int wood = farmBuilding.getWoodNumber();
        int stone = farmBuilding.getStoneNumber();
        boolean canAfford = true;
        if(user.getGold() <= price){
            canAfford = false;
        }
        if (user.getBackPack().howManyInInventory(ItemType.WOOD) <= wood) {
            canAfford = false;
        }
        if (user.getBackPack().howManyInInventory(ItemType.STONE) <= stone) {
            canAfford = false;
        }
        if (!canAfford) {
            return new Result(false, "you are poor");
        }
        user.increaseGold(-1 * price);
        user.getBackPack().removeAmountFromInventory(ItemType.WOOD, wood);
        user.getBackPack().removeAmountFromInventory(ItemType.STONE, stone);
        farm.buildAnimalBuilding(new AnimalBuildingOld(targetTile, farmBuilding));
        System.out.println("DEBUG: animalBuildings.size()=" + farm.getAnimalBuildings().size());
        return new Result(true, "Animal Building built successfully");
    }


    public Result buyAnimal(String input) {
        String animal = AnimalCommands.BUY_ANIMAL.getMatcher(input).group("animal").trim();
        String name = AnimalCommands.BUY_ANIMAL.getMatcher(input).group("name").trim();
        User user = App.currentGameModel.currentUser;
        Farm farm = user.getFarm();
        NpcVillage city = App.currentGameModel.getMap().getVillage();

        FarmAnimalType animalType = FarmAnimalType.getFarmAnimalsType(animal);
        if (animalType == null) {
            return new Result(false, "invalid Animal Type");
        }
        if(!user.validAnimalName(name)){
            return new Result(false, "invalid Animal Name");
        }
        AnimalBuildingOld animalBuildingOld = farm.getBuildingForAnimal(animalType);
        if (animalBuildingOld == null) {
            return new Result(false, "you dint have a place for this animal");
        }
        int price = animalType.getPrice();
        if (user.getGold() < price) {
            return new Result(false, "you are poor");
        }
        user.increaseGold(-1 * price);
        animalBuildingOld.putAnimalInBuilding(new Animal(name, animalType));
        return new Result(true, "Animal buy successfully");
    }
    public Result pet(String input) {
        String name = AnimalCommands.PET_ANIMAL.getMatcher(input).group("name").trim();
        User user = App.currentGameModel.currentUser;
        Animal animal = user.findAnimal(name);
        if (animal == null) {
            return new Result(false, "animal not found");
        }
        if (!user.isNear(animal.getTile().getLocation())) {
            Location location = animal.getTile().getLocation();
            int x = location.getX();
            int y = location.getY();
            System.out.println("Animal is at: (" + x + ", " + y + ")");
            return new Result(false, "you are far away from animal");
        }
        animal.pet();
        return new Result(true, "The animal was petted.");
    }
    public Result cheatSetFriendship(String input) {
        String name = AnimalCommands.SET_FRIENDSHIP.getMatcher(input).group("name").trim();
        int amount = Integer.parseInt(AnimalCommands.SET_FRIENDSHIP.getMatcher(input).group("amount").trim());
        User user = App.currentGameModel.currentUser;
        Animal animal = user.findAnimal(name);
        if (animal == null) {
            return new Result(false, "animal not found");
        }
        animal.setFriendship(amount);
        return new Result(true, "The animal friendship was cheated.");
    }
    public Result showAnimalDetails() {
        User user = App.currentGameModel.currentUser;
        ArrayList<Animal> animals = user.getAnimals();
        if (animals.isEmpty()) {
            return new Result(false, "you dont have any animals");
        }

        for (Animal animal : animals) {
            StringBuilder sb = new StringBuilder("Crop found:\n");
            sb.append(animal.getInfo());
            return new Result(true, sb.toString());
        }
        return new Result(false, "You have no animals");
    }
    public Result shepherdAnimal(String input) {
        String name = AnimalCommands.SHEPHERD_ANIMAL.getMatcher(input).group("name").trim();
        int x = Integer.parseInt(AnimalCommands.SHEPHERD_ANIMAL.getMatcher(input).group("x").trim());
        int y = Integer.parseInt(AnimalCommands.SHEPHERD_ANIMAL.getMatcher(input).group("y").trim());
        User user = App.currentGameModel.currentUser;
        Animal animal = user.findAnimal(name);
        if (animal == null) {
            return new Result(false, "animal not found");
        }
        Farm farm = user.getFarm();
        if (!animal.isIn()) {
            if (!farm.isInBounds(x, y)) {
                return new Result(false, "invalid location");
            }
            AnimalBuildingOld animalBuildingOld = user.getFarm().getAnimalBuilding(animal);
            Tile tile = farm.getTile(x, y);
            if (!animalBuildingOld.getTiles().contains(tile)) {
                return new Result(false, "This location is not suitable for this animal. ");
            }
            animal.goIn();
            tile.setItemInThisTile(null);
            return new Result(true, "The animal went home");
        }
        WeatherType currentWeather = weather.getCurrentWeather();
        if (currentWeather.equals(WeatherType.Snow)){
            return new Result(false, "you cannot shepherd in snow");
    }
        if(currentWeather.equals(WeatherType.Rain)){
            return new Result(false, "you cannot shepherd in rain");
        }
        if(currentWeather.equals(WeatherType.Storm)){
            return new Result(false, "you cannot shepherd in storm");
        }
        if (!farm.isInBounds(x, y))
        {
            return new Result(false, "invalid location");
        }
        Tile tile = farm.getTile(x, y);
        if (tile.getItemInThisTile() != null)
        {
            return new Result(false, "this tile is not empty");
        }
        if ( tile.getType() != TileType.grass){
            return new Result(false, "you cant put on this tile");
        }
        animal.goOut();
        tile.setItemInThisTile(animal);
        return new Result(true, "The animal went out");


    }
    public Result showProducts() {
        ArrayList<Animal> animals = App.currentGameModel.currentUser.getAnimals();
        ArrayList<Animal> animalsWithProducts = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.isHasProduct()) {
                animalsWithProducts.add(animal);
            }
        }
            if (animalsWithProducts.isEmpty()){
                return new Result(false, "you dont have any animal with products");
            }
            for (Animal animal1 : animalsWithProducts) {
                StringBuilder sb = new StringBuilder("Crop found:\n");
                sb.append(animal1.getInfo());
                return new Result(true, sb.toString());
            }
            return new Result(false, "You have no animal with products");


    }



//    public Result collectProducts(String input) {
//        String name = AnimalCommands.COLLECT_PRODUCES.getMatcher(input).group("name").trim();
//        User user = App.currentGameModel.currentUser;
//        Animal animal = user.findAnimal(name);
//        if (animal == null) {
//            return new Result(false, "animal not found");
//        }
//        if (!animal.isHasProduct()) {
//            return new Result(false, "this animal dont have any products");
//        }
//        if (!user.getBackPack().inventoryHasCapacity()) {
//            return new Result(false, "you dont have inventory for collecting products");
//        }
//        Item product = animal.getProduct();
//        user.getBackPack().addItemToInventory(product, 1);
//        return new Result(true, "The product has been collected");
//
//    }
    public Result feedHay(String input) {
        String name = AnimalCommands.FEED_HAY.getMatcher(input).group("name").trim();
        User user = App.currentGameModel.currentUser;
        Animal animal = user.findAnimal(name);
        if (animal == null) {
            return new Result(false, "animal not found");
        }
        if (!user.getBackPack().hasEnoughInInventory(ItemType.HAY, 1)){
            return new Result(false, "you dont have HAY inventory");
        }
        user.getBackPack().removeAmountFromInventory(ItemType.HAY, 1);
        animal.feed();
        return new Result(true, "The animal has been feeded");
    }

    public Result sellAnimal(String input) {
        String name = AnimalCommands.SELL_ANIMAL.getMatcher(input).group("name").trim();
        User user = App.currentGameModel.currentUser;
        Animal animal = user.findAnimal(name);
        if (animal == null) {
            return new Result(false, "animal not found");
        }
        int price = animal.getPrice();
        Farm farm = user.getFarm();
        AnimalBuildingOld animalBuildingOld = user.getFarm().getAnimalBuilding(animal);
        animalBuildingOld.sellAnimal(animal);
        user.increaseGold(price);
        return new Result(true, "The animal has been sold");

    }
    private int numberOfFishes()
    {
        Random random = new Random();
        double R = 0.5 + 0.5 * random.nextDouble();
        double M;
        int skill = App.currentGameModel.currentUser.getFishingSkill().getLevel();

        switch (weather.getCurrentWeather()) {
            case WeatherType.Sunny -> M = 1.5;
            case WeatherType.Rain -> M = 1.2;
            case WeatherType.Storm -> M = 0.5;
            default -> M = 1;
        }

        int result = (int) (R * M * (skill + 2));
        return Math.min(result, 6);
    }


    public Result fishing(String input) {
        Random random = new Random();
        String fishingPoleName = AnimalCommands.FISHING.getMatcher(input).group("fishingPole").trim();
        User user = App.currentGameModel.currentUser;
        Tools tool = user.getBackPack().getCurrentTool();
        if (!MainLocation.isNearTheWater(user.getLocation())) {
            return new Result(false, "you are not near the water");
        }
        if (tool == null) {
            return new Result(false, "tool not found");
        }
        if (!(user.getBackPack().getCurrentTool() instanceof FishingPole)) {
            return new Result(false, "you should use a FishingPole");
        }
//        if (!user.getBackPack().getCurrentTool().equals(fishingPoleName)) {
//            return new Result(false, "you should use a FishingPole");
//        }


        int numberOfFishes = numberOfFishes();
        FishingPole fishingPole = (FishingPole) user.getBackPack().getCurrentTool();
        ArrayList<Fish> fishes = new ArrayList<>();
        for (int i = 0; i < numberOfFishes; i++) {
            FishType type = FishType.getRandomFish(fishingPole.getType());
            if (type != null) {
                fishes.add(new Fish(type));
            }
        }
            if (fishes.isEmpty()) {
                return new Result(false, "you dont have any fish");
            }
            if (!user.getBackPack().inventoryHasCapacity()){
                return new Result(false, "you dont have inventory");
            }

            for (Fish fish : fishes) {
                fish.calculateQuality(fishingPole.getType());
                user.getFishingSkill().changePoints(5);
                user.getBackPack().addItemToInventory(fish, 1);
            }
        StringBuilder sb = new StringBuilder();
        sb.append("You caught ").append(fishes.size()).append(" fish(es):\n");
        for (Fish fish : fishes) {
            String qualityName = Fish.getQualityName(fish.getQuality());
            sb.append("- ").append(fish.getType().getDisplayName())
                    .append(" (quality: ").append(qualityName).append(")\n");
        }
        return new Result(true, sb.toString());



        }



}
