package com.StardewValley.Controller;

import com.StardewValley.View.newView.AnimalMenuView;
import com.StardewValley.model.Animal.AnimalBuilding;
import com.StardewValley.model.App;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.Item.ItemType;
import com.StardewValley.model.User;
import com.StardewValley.model.Animal.FarmBuildingType;

public class AnimalMenuController {
    private AnimalMenuView view;
    private final User user;

    public AnimalMenuController(User user) {
        this.user = user;
    }

    public void setView(AnimalMenuView view) {
        this.view = view;
    }

    public void handleBuildRequest(String buildingName) {
        ItemType selectedItem = user.getBackPack().getSelectedItem();
        if (selectedItem == null || !buildingName.equalsIgnoreCase(selectedItem.getDisplayName())) {
            view.setErrorMessage("Please select a " + buildingName + " item first!");
            return;
        }
        FarmBuildingType buildingType = FarmBuildingType.getFarmBuildingType(buildingName);
        if (buildingType == null) {
            view.setErrorMessage("Invalid building type!");
            return;
        }
        if (user.getGold() < buildingType.getPrice()) {
            view.setErrorMessage("Not enough gold for " + buildingName + ".");
            return;
        }
        // choob lazem baraye sakht ra darim ya na
//        if (user.getWood() < buildingType.getWoodNumber() || user.getStone() < buildingType.getStoneNumber()) {
//            view.setErrorMessage("Not enough materials to build " + buildingName + ".");
//            return;
//        }
        user.getBackPack().removeAmountFromInventory(selectedItem, 1);
        App.currentGameGraphicView.startBuildingMode(buildingType);
        App.gameApp.setScreen(App.currentGameGraphicView);
//        user.addFarmBuilding(buildingType);
        user.setFarmHadPlaceForAnimals(true);

    }
}
