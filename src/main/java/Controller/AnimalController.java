package Controller;

import enums.AnimalCommands;
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



    }
}
