package com.StardewValley.Controller;
import com.StardewValley.enums.CookingItemType;
import com.StardewValley.model.App;
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
            view.setSuccessMessage(productType.getDisplayName() + "cooked");
        }
    }
}
