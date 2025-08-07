package com.StardewValley.Server.Controller;

import com.StardewValley.Common.model.Animal.Animal;
import com.StardewValley.Common.model.Animal.FarmAnimalType;
import com.StardewValley.Common.model.Item.ItemType;
import com.StardewValley.Common.model.User;

public class BuyAnimalMenuController {

    private final User user;

    public BuyAnimalMenuController(User user) {
        this.user = user;
    }

    public boolean canBuyAnimal(FarmAnimalType animalType) {
        ItemType selectedItem = user.getBackPack().getSelectedItem();
        if (selectedItem == null || selectedItem != animalType.getType()) {
            return false;
        } else {
            return true;

//            return getAvailableBuilding(animalType) != null;
        }
    }

    public String tryBuyAnimal(FarmAnimalType animalType) {
        if (!canBuyAnimal(animalType)) {
            return "You have not selected the item for this animal or the appropriate building has not been built.";
        }

//        AnimalBuilding building = getAvailableBuilding(animalType);
        if (!user.getFarmHadPlaceForAnimals()) {
            return "There is no suitable building for this animal.";
        }

        Animal animal = new Animal(animalType.getName(), animalType);
        user.getBackPack().removeAmountFromInventory(user.getBackPack().getSelectedItem(), 1);
        user.getMyAnimals().add(animal);


        return animalType.getName() + " has been successfully bought!";
    }
}
