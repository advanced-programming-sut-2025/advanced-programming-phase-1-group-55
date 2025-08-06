package com.StardewValley.Controller;

import com.StardewValley.model.Animal.*;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.Item.ItemType;
import com.StardewValley.model.User;

import java.util.List;

public class BuyAnimalMenuController {

    private final User user;

    public BuyAnimalMenuController(User user) {
        this.user = user;
    }

    public boolean canBuyAnimal(FarmAnimalType animalType) {
        ItemType selectedItem = user.getBackPack().getSelectedItem();
        if (selectedItem == null || selectedItem != animalType.getType()) {
            return false;
        }
        else {
            return true;
//        return getAvailableBuilding(animalType) != null;
        }
    }

    public String tryBuyAnimal(FarmAnimalType animalType) {
        if (!canBuyAnimal(animalType)) {
            return "You have not selected the item for this animal or the appropriate building has not been built.";
        }

        AnimalBuilding building = getAvailableBuilding(animalType);
        if (building == null) {
            return "There is no suitable building for this animal.";
        }

        Animal animal = new Animal(animalType.getName(), animalType);
        user.getBackPack().removeAmountFromInventory(user.getBackPack().getSelectedItem(), 1);
        user.addAnimalToBuilding(animalType);

        return animal.getName() + " Successfully added to " + building.getFarmBuildingType().getName() ;
    }

    private AnimalBuilding getAvailableBuilding(FarmAnimalType animalType) {
        List<FarmBuildingType> allowedBuildings = animalType.getBuildings();
        for (AnimalBuilding building : user.getFarmBuildings()) {
            if (allowedBuildings.contains(building.getFarmBuildingType())) {
                return building;
            }
        }
        return null;
    }
}
