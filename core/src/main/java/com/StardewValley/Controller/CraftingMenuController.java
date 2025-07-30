//package com.StardewValley.Controller;
//
//import com.StardewValley.enums.CraftingItemType;
//import com.StardewValley.model.App;
//import com.StardewValley.model.CraftingItems.CraftingItem;
//import com.StardewValley.model.CraftingItems.CraftingItemCreator;
//import com.StardewValley.model.Item.ItemType;
//import com.StardewValley.model.User;
//import com.StardewValley.model.Tool.BackPack;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Controller class for the crafting menu. This controller responds to recipe
// * selections, checks whether the recipe is unlocked, verifies that the
// * user has the necessary ingredients and inventory space, and then crafts
// * the selected item by deducting resources and adding the new item to
// * the player's inventory. Messages about errors or successes are
// * propagated back to the view via setter methods.
// */
//public class CraftingMenuController {
//    // ارتباط با ویو
//    private com.StardewValley.View.newView.CraftingMenuView view;
//
//    // ست کردن ویو برای ارسال پیام
//    public void setView(com.StardewValley.View.newView.CraftingMenuView view) {
//        this.view = view;
//    }
//
//    // متد اصلی فراخوانی هنگام کلیک روی هر Recipe
//    public void handleRecipeClicked(CraftingItemType recipe) {
//        User user = App.currentGameModel.currentUser;
//        BackPack backPack = user.getBackPack();
//
//        // آیا Recipe باز شده است؟
//        if (!backPack.getCraftingRecipes().contains(recipe)) {
//            if (view != null) {
//                view.setErrorMessage("این دستورالعمل باز نشده است.");
//            }
//            return;
//        }
//
//        // بررسی وجود مواد اولیه به تعداد کافی
//        HashMap<ItemType, Integer> ingredients = recipe.getIngredients();
//        for (Map.Entry<ItemType, Integer> entry : ingredients.entrySet()) {
//            if (!backPack.hasEnoughInInventory(entry.getKey(), entry.getValue())) {
//                if (view != null) {
//                    view.setErrorMessage("مواد اولیه کافی برای " + entry.getKey().getDisplayName() + " ندارید");
//                }
//                return;
//            }
//        }
//
//        // بررسی فضای خالی در کیف
//        if (!backPack.inventoryHasCapacity()) {
//            if (view != null) {
//                view.setErrorMessage("فضای کافی در موجودی نیست");
//            }
//            return;
//        }
//
//        // کم کردن مواد اولیه
//        for (Map.Entry<ItemType, Integer> entry : ingredients.entrySet()) {
//            backPack.removeAmountFromInventory(entry.getKey(), entry.getValue());
//        }
//
//        // ساخت محصول و افزودن به موجودی
//        CraftingItem product = CraftingItemCreator.create(recipe);
//        backPack.addItemToInventory(product, 1);
//
//        // پیام موفقیت
//        if (view != null) {
//            view.setSuccessMessage(recipe.getProductName().getDisplayName() + " ساخته شد");
//        }
//    }
//}
//
