package Controller;

import View.MainGameView;
import enums.AnimalCommands;
import model.Animal.Animal;
import model.Animal.AnimalBuilding;
import model.Animal.FarmAnimalType;
import model.Animal.FarmBuildingType;
import model.App;
import model.Item.ItemType;
import model.Map.Farm;
import model.Map.Location;
import model.Map.NpcVillage;
import model.Map.Tile;
import model.Recipe;
import model.Result;
import model.User;

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
        if (farmBuilding != null) {
            return new Result(false, "invalid Building Name");
        }
        if (farm.isInBounds(x, y)) {
            return new Result(false, "invalid Building Location");
        }
        int width = farmBuilding.getWidth();
        int height = farmBuilding.getHeight();
        int price = farmBuilding.getPrice();
        int wood = farmBuilding.getWoodNumber();
        int stone = farmBuilding.getStoneNumber();
        boolean canAfford = true;
        if(user.getGold() < price){
            canAfford = false;
        }
        if (user.getBackPack().howManyInInventory(ItemType.WOOD) < wood) {
            canAfford = false;
        }
        if (user.getBackPack().howManyInInventory(ItemType.STONE) < stone) {
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
    



}
