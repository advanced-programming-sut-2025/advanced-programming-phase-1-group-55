package com.StardewValley.Server.Controller;

import com.StardewValley.Client.View.CraftingMenuView;
import com.StardewValley.Common.enums.CraftingItemType;
import com.StardewValley.Common.model.App;
import com.StardewValley.Common.model.CraftingItems.CraftingItem;
import com.StardewValley.Common.model.CraftingItems.CraftingItemCreator;
import com.StardewValley.Common.model.Item.ItemType;
import com.StardewValley.Common.model.User;
import com.StardewValley.Common.model.Tool.BackPack;
import java.util.HashMap;
import java.util.Map;

public class CraftingMenuController {
    private CraftingMenuView view;

    public void setView(CraftingMenuView view) {
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

