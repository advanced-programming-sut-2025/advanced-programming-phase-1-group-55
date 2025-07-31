package com.StardewValley.Controller;

import com.StardewValley.enums.CraftingItemType;
import com.StardewValley.model.App;
import com.StardewValley.model.CraftingItems.CraftingItem;
import com.StardewValley.model.CraftingItems.CraftingItemCreator;
import com.StardewValley.model.Item.ItemType;
import com.StardewValley.model.User;
import com.StardewValley.model.Tool.BackPack;
import java.util.HashMap;
import java.util.Map;

public class CraftingMenuController {
    private com.StardewValley.View.newView.CraftingMenuView view;

    public void setView(com.StardewValley.View.newView.CraftingMenuView view) {
        this.view = view;
    }

    public void handleRecipeClicked(CraftingItemType recipe) {
        User user = App.currentGameModel.currentUser;
        BackPack backPack = user.getBackPack();




        if (!backPack.getCraftingRecipes().contains(recipe)) {
            if (view != null) {
                view.setErrorMessage("This recipe has not been unlocked.");
            }
            return;
        }



        HashMap<ItemType, Integer> ingredients = recipe.getIngredients();
        for (Map.Entry<ItemType, Integer> entry : ingredients.entrySet()) {
            if (!backPack.hasEnoughInInventory(entry.getKey(), entry.getValue())) {
                if (view != null) {
                    view.setErrorMessage("dont have enough ingredient");
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




        CraftingItem product = CraftingItemCreator.create(recipe);
        backPack.addItemToInventory(product, 1);



        if (view != null) {
            view.setSuccessMessage(recipe.getProductName().getDisplayName() + "crafted");
        }
    }
}

