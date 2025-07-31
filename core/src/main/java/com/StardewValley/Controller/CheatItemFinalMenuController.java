package com.StardewValley.Controller;

import com.StardewValley.View.newView.CheatItemFinalView;
import com.StardewValley.enums.CookingItemType;
import com.StardewValley.enums.CraftingItemType;
import com.StardewValley.model.App;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.Item.ItemType;
import com.StardewValley.model.User;

import java.util.Vector;

public class CheatItemFinalMenuController {
    private CheatItemFinalView view;
    private User user;
    private Item item;

    public CheatItemFinalMenuController(User user, Item item) {
        this.user = user;
        this.item = item;
    }
    public void handleButton() {
        if (view != null) {
            if (view.getBackButton().isChecked()) {
                view.getBackButton().setChecked(false);
                App.gameApp.setScreen(view.getCheatItemView());
            } else if (view.getConfirmButton().isChecked()) {
                view.getConfirmButton().setChecked(false);
                ItemType addedType = item.getItemType();
                int quantity = view.getQuantity();
                user.getBackPack().addItemToInventory(new Item(addedType), quantity);
                String typeName = addedType.name();
                if (typeName.endsWith("_RECIPE")) {
                    String baseName = typeName.substring(0, typeName.length() - "_RECIPE".length());
                    try {
                        CookingItemType cookingEnum = CookingItemType.valueOf(baseName);
                        if (!user.getBackPack().getCookingRecipes().contains(cookingEnum)) {
                            user.getBackPack().getCookingRecipes().add(cookingEnum);
                        }
                    } catch (IllegalArgumentException e) {
                    }
                    try {
                        com.StardewValley.enums.CraftingItemType craftingEnum =
                            com.StardewValley.enums.CraftingItemType.valueOf(baseName);
                        if (!user.getBackPack().getCraftingRecipes().contains(craftingEnum)) {
                            user.getBackPack().getCraftingRecipes().add(craftingEnum);
                        }
                    } catch (IllegalArgumentException e) {
                    }
                } else {
                    for (com.StardewValley.enums.CraftingItemType ct :
                        com.StardewValley.enums.CraftingItemType.values()) {
                        if (ct.getProductName().equals(addedType)) {
                            if (!user.getBackPack().getCraftingRecipes().contains(ct)) {
                                user.getBackPack().getCraftingRecipes().add(ct);
                            }
                            break;
                        }
                    }
                }

                view.setSuccessMessage("You successfully added " + quantity + " " +
                    addedType.getDisplayName() + " to the inventory");
            }
        }
    }




    public CheatItemFinalView getView() {
        return view;
    }

    public void setView(CheatItemFinalView view) {
        this.view = view;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
