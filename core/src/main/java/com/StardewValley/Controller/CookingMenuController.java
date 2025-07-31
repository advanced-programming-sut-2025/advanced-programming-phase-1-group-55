package com.StardewValley.Controller;
import com.StardewValley.enums.CookingItemType;
import com.StardewValley.model.App;
import com.StardewValley.model.CookingItems.CookingItem;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.User;
import com.StardewValley.model.Tool.BackPack;
import com.StardewValley.model.Item.ItemType;
import java.util.HashMap;
import java.util.Map;





public class CookingMenuController {
    private com.StardewValley.View.newView.CookingMenuView view;

    public void setView(com.StardewValley.View.newView.CookingMenuView view) {
        this.view = view;
    }

    public void handleRecipeClicked(CookingItemType recipe) {
        User user = App.currentGameModel.currentUser;
        BackPack backPack = user.getBackPack();
        if (!backPack.getCookingRecipes().contains(recipe)) {
            if (view != null) {
                view.setErrorMessage("dont have this cooking recipe");
            }
            return;
        }


        HashMap<ItemType, Integer> ingredients = recipe.getIngredients();
        for (Map.Entry<ItemType, Integer> entry : ingredients.entrySet()) {
            if (!backPack.hasEnoughInInventory(entry.getKey(), entry.getValue())) {
                if (view != null) {
                    view.setErrorMessage("dont have enough ingredients");
                }
                return;
            }
        }


        if (!backPack.inventoryHasCapacity()) {
            if (view != null) {
                view.setErrorMessage("dont have enough inventory");
            }
            return;
        }


        for (Map.Entry<ItemType, Integer> entry : ingredients.entrySet()) {
            backPack.removeAmountFromInventory(entry.getKey(), entry.getValue());
        }


        ItemType productType = recipe.getProductName();

        Item cookedItem = new Item(productType);


        backPack.addItemToInventory(cookedItem, 1);

        if (view != null) {
            view.setSuccessMessage(productType.getDisplayName() + " cooked");
        }
    }


    public void moveItemToFridge(ItemType itemType) {
        User user = App.currentGameModel.currentUser;
        BackPack backPack = user.getBackPack();

        int amountToMove = 1;

        if (!backPack.hasEnoughInInventory(itemType, amountToMove)) {
            if (view != null) {
                view.setErrorMessage("dont have enough amount of this item in your back pack");
            }
            return;
        }


        CookingItemType cookingType = null;
        for (CookingItemType ct : CookingItemType.values()) {
            if (ct.getProductName().equals(itemType)) {
                cookingType = ct;
                break;
            }
        }
        if (cookingType == null) {
            if (view != null) {
                view.setErrorMessage("this item isnt Edible");
            }
            return;
        }
        CookingItem existing = user.getFromRefrigerator(itemType);
        if (existing == null) {
            backPack.removeAmountFromInventory(itemType, amountToMove);
            CookingItem newItem = new CookingItem(cookingType);
            newItem.setNumber(amountToMove);
            user.getRefrigerator().add(newItem);
        } else {
            existing.setNumber(existing.getNumber() + amountToMove);
        }
        if (view != null) {
            view.setSuccessMessage(itemType.getDisplayName() + " moved to fridge");
            view.refreshFridgeDialog();
        }

    }
}
