package Controller;

import enums.CraftingItemType;
import model.App;
import model.App.*;
import model.CraftingItems.CraftingItem;
import model.CraftingItems.CraftingItemCreator;
import model.Ingredient;
import model.Item.Item;
import model.Item.ItemType;
import model.Map.Tile;
import model.Result;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;

public class inHouseController {
    public Result ShowCraftingRecipe() {
        ArrayList<CraftingItemType> recipes = App.currentGame.currentUser.getCraftingRecipes();
        if (recipes == null || recipes.isEmpty()) {
            return new Result(false, "No recipe found");
        }
        StringBuilder result = new StringBuilder();
        for (CraftingItemType recipe : recipes) {
            result.append(recipe.getProductName()).append(": ")
                    .append("ingredient: ").append(recipe.getIngredients()).append("\n")
                    .append("Sell Price: ").append(recipe.getSellPrice()).append("\n");
        }
        return new Result(true, result.toString().trim());
    }
    public Result CraftItem(String itemName) {
        User user = App.currentGame.currentUser;
        CraftingItemType recipe = CraftingItemType.getCraftingItemType(itemName);
        if (recipe == null) {
            return new Result(false, "No recipe found");
        }
        ArrayList<CraftingItemType> recipes = user.getCraftingRecipes();
        if (!recipes.contains(recipe)) {
            return new Result(false, "you dont have access to this recipe");
        }
        HashMap<ItemType, Integer> ingredient = recipe.getIngredients();
        boolean canCraft = true;
        for (ItemType itemType : ingredient.keySet()) {
            if (!user.hasEnoughInInventory(itemType, ingredient.get(itemType))) {
                canCraft = false;
            }
        }
        if (!canCraft) {
            return new Result(false, "you dont have enough ingredients");
        }
        if (!user.inventoryHasCapacity()) {
            return new Result(false, "you dont have enough inventory");
        }
        for (ItemType itemType : ingredient.keySet()) {
            user.removeAmountFromInventory(itemType, ingredient.get(itemType));
        }
        user.decreaseEnergy(2);
        CraftingItem product = CraftingItemCreator.create(recipe);
        user.addToInventory(product);
        return new Result(true, recipe.getProductName() + " has been crafted");
    }
    public Result CheatAddItem(String itemName, String amount) {
        User user = App.currentGame.currentUser;
        ItemType type = ItemType.getItemType(itemName);
        if (type == null) {
            return new Result(false, "No item found");
        }
        if (!user.inventoryHasCapacity()) {
            return new Result(false, "you dont have enough inventory");
        }
        int count = Integer.parseInt(amount);
        Item item = new Item(type, count);
        user.addToInventory(item);
        return new Result(true, itemName + " has been cheated");
    }
    public Result PlaceItem(String itemName, String direction) {
        User user = App.currentGame.currentUser;
        ItemType type = ItemType.getItemType(itemName);
        if (type == null) {
            return new Result(false, "No item found");
        }
        Item item = user.getItemInInventory(type);
        if (item == null) {
            return new Result(false, "you dont have dis item now!");
        }

    }










//    public Result getLearnedRecipes(User user) {
//        Set<CraftingItemType> recipes = user.getLearnedCraftingRecipes();
//        if (recipes.isEmpty()) {
//            return new Result(false, "You haven't learned any crafting recipes yet.");
//        }
//        StringBuilder message = new StringBuilder("Crafting Recipes You Have Learned:\n");
//        for (CraftingItemType recipe : recipes) {
//            message.append("- ").append().append("\n");
//        }
//
//        return new Result(true, message.toString());
//
//    }
}
