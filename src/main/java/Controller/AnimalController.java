package Controller;

import View.MainGameView;
import enums.AnimalCommands;
import enums.WeatherType;
import model.*;
import model.Animal.Animal;
import model.Animal.AnimalBuilding;
import model.Animal.FarmAnimalType;
import model.Animal.FarmBuildingType;
import model.Item.Item;
import model.Item.ItemType;
import model.Map.*;

import java.util.ArrayList;

import static model.App.currentGame;

public class AnimalController {
//    public boolean locationsAreNear(Location location1, Location location2) {
//        int dx = Math.abs(location1.getX() - location2.getX());
//        int dy = Math.abs(location1.getY() - location2.getY());
//
//        return (dx <= 1 && dy <= 1) ;
//    }
    public Result buildAnimalBuilding(String input) {
        String buildingName = AnimalCommands.BUILD_ANIMAL_HOUSE.getMatcher(input).group("name").trim();
        int x = Integer.parseInt(AnimalCommands.BUILD_ANIMAL_HOUSE.getMatcher(input).group("x").trim());
        int y = Integer.parseInt(AnimalCommands.BUILD_ANIMAL_HOUSE.getMatcher(input).group("y").trim());
        User user = App.currentGame.currentUser;
        Farm farm = user.getFarm();
        NpcVillage city = App.currentGame.getMap().getVillage();
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
        farm.buildAnimalBuilding(new AnimalBuilding(targetTile, farmBuilding));
        return new Result(true, "Animal Building built successfully");
    }


    public Result buyAnimal(String input) {
        String animal = AnimalCommands.BUY_ANIMAL.getMatcher(input).group("animal").trim();
        String name = AnimalCommands.BUY_ANIMAL.getMatcher(input).group("name").trim();
        User user = App.currentGame.currentUser;
        Farm farm = user.getFarm();
        NpcVillage city = App.currentGame.getMap().getVillage();

        FarmAnimalType animalType = FarmAnimalType.getFarmAnimalsType(animal);
        if (animalType != null) {
            return new Result(false, "invalid Animal Type");
        }
        if(!user.validAnimalName(name)){
            return new Result(false, "invalid Animal Name");
        }
        AnimalBuilding animalBuilding = farm.getBuildingForAnimal(animalType);
        if (animalBuilding != null) {
            return new Result(false, "you dint have a place for this animal");
        }
        int price = animalType.getPrice();
        if (user.getGold() < price) {
            return new Result(false, "you are poor");
        }
        user.increaseGold(-1 * price);
        animalBuilding.putAnimalInBuilding(new Animal(name, animalType));
        return new Result(true, "Animal buy successfully");
    }
    public Result pet(String input) {
        String name = AnimalCommands.PET_ANIMAL.getMatcher(input).group("name").trim();
        User user = App.currentGame.currentUser;
        Animal animal = user.findAnimal(name);
        if (animal == null) {
            return new Result(false, "animal not found");
        }
        if (!user.isNear(animal.getTile().getLocation())) {
            return new Result(false, "you are far away from animal");
        }
        animal.pet();
        return new Result(true, "The animal was petted.");
    }
    public Result cheatSetFriendship(String input) {
        String name = AnimalCommands.SET_FRIENDSHIP.getMatcher(input).group("name").trim();
        int amount = Integer.parseInt(AnimalCommands.SET_FRIENDSHIP.getMatcher(input).group("amount").trim());
        User user = App.currentGame.currentUser;
        Animal animal = user.findAnimal(name);
        if (animal == null) {
            return new Result(false, "animal not found");
        }
        animal.setFriendship(amount);
        return new Result(true, "The animal friendship was cheated.");
    }
    public Result showAnimalDetails() {
        User user = App.currentGame.currentUser;
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
        User user = App.currentGame.currentUser;
        Animal animal = user.findAnimal(name);
        if (animal == null) {
            return new Result(false, "animal not found");
        }
        Farm farm = user.getFarm();
        if (!animal.isIn()) {
            if (farm.isInBounds(x, y)) {
                return new Result(false, "invalid location");
            }
            AnimalBuilding animalBuilding = user.getFarm().getAnimalBuilding(animal);
            Tile tile = farm.getTile(x, y);
            if (!animalBuilding.getTiles().contains(tile)) {
                return new Result(false, "This location is not suitable for this animal. ");
            }
            animal.goIn();
            tile.setItemInThisTile(null);
            return new Result(true, "The animal went home");
        }
        WeatherType currentWeather = Weather.getCurrentWeather();
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
        if ( tile.getTexture() != TileTexture.grass){
            return new Result(false, "you cant put on this tile");
        }
        animal.goOut();
        tile.setItemInThisTile(animal);
        return new Result(true, "The animal went out");


    }
    public Result collectProducts(String input) {
        String name = AnimalCommands.COLLECT_PRODUCES.getMatcher(input).group("name").trim();
        User user = App.currentGame.currentUser;
        Animal animal = user.findAnimal(name);
        if (animal == null) {
            return new Result(false, "animal not found");
        }
        if (!animal.isHasProduct()) {
            return new Result(false, "this animal dont have any products");
        }
        if (!user.getBackPack().inventoryHasCapacity()) {
            return new Result(false, "you dont have inventory for collecting products");
        }
        Item product = animal.getProduct();
        user.getBackPack().addItemToInventory(product, 1);
        return new Result(true, "The product has been collected");

    }
    public Result feedHay(String input) {
        String name = AnimalCommands.FEED_HAY.getMatcher(input).group("name").trim();
        User user = App.currentGame.currentUser;
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
        User user = App.currentGame.currentUser;
        Animal animal = user.findAnimal(name);
        if (animal == null) {
            return new Result(false, "animal not found");
        }
        int price = animal.getPrice();
        Farm farm = user.getFarm();
        AnimalBuilding animalBuilding = user.getFarm().getAnimalBuilding(animal);
        animalBuilding.sellAnimal(animal);
        user.increaseGold(price);
        return new Result(true, "The animal has been sold");

    }





}
