package Controller;

import enums.CookingItemType;
import enums.CraftingItemType;
import model.App;
import model.CookingItems.CookingItem;
import model.CraftingItems.CraftingItem;
import model.CraftingItems.CraftingItemCreator;
import model.Item.Item;
import model.Item.ItemType;
import model.Map.Tile;
import model.Result;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;

public class inHouseController {
    public Result ShowCraftingRecipe() {
        ArrayList<CraftingItemType> recipes = App.currentGame.currentUser.getBackPack().getCraftingRecipes();
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
    public Result cheatAddCraftingRecipe(String itemName) {
        User user = App.currentGame.currentUser;
        CraftingItemType recipe = CraftingItemType.getRecipeFromItemName(itemName);
        if (recipe == null) {
            return new Result(false, "Recipe not found");
        }
        ArrayList<CraftingItemType> recipes = App.currentGame.currentUser.getBackPack().getCraftingRecipes();
        if (recipes.contains(recipe)) {
            return new Result(false, "there is no crafting recipe with this name");
        }
        recipes.add(recipe);
        return new Result(true, "Added crafting recipe with this name");
    }
    public Result CraftItem(String itemName) {
        User user = App.currentGame.currentUser;
        CraftingItemType recipe = CraftingItemType.getRecipeFromItemName(itemName);
        if (recipe == null) {
            return new Result(false, "No recipe found");
        }
        ArrayList<CraftingItemType> recipes = user.getBackPack().getCraftingRecipes();
        if (!recipes.contains(recipe)) {
            return new Result(false, "you dont have access to this recipe");
        }
        HashMap<ItemType, Integer> ingredient = recipe.getIngredients();
        boolean canCraft = true;
        for (ItemType itemType : ingredient.keySet()) {
            if (!user.getBackPack().hasEnoughInInventory(itemType, ingredient.get(itemType))) {
                canCraft = false;
            }
        }
        if (!canCraft) {
            return new Result(false, "you dont have enough ingredients");
        }
        if (!user.getBackPack().inventoryHasCapacity()) {
            return new Result(false, "you dont have enough inventory");
        }
        for (ItemType itemType : ingredient.keySet()) {
            user.getBackPack().removeAmountFromInventory(itemType, ingredient.get(itemType));
        }
        user.decreaseEnergy(2);
        if (user.isFainted()) {
            return new Result(false, "you ran out of energy and fainted");
        }
        CraftingItem product = CraftingItemCreator.create(recipe);
        product.setNumber(1);
//        user.getBackPack().addToInventory(product);
        user.getBackPack().addItemToInventory(product, 1);
        return new Result(true, recipe.getProductName() + " has been crafted");
    }
    public Result CheatAddItem(String itemName, String amount) {
        User user = App.currentGame.currentUser;
        ItemType type = ItemType.getItemType(itemName);
        if (type == null) {
            return new Result(false, "No item found");
        }
        if (!user.getBackPack().inventoryHasCapacity()) {
            return new Result(false, "you dont have enough inventory");
        }
        int count = Integer.parseInt(amount);
        Item item = new Item(type);
        item.setNumber(count);
//        user.getBackPack().addToInventory(item);
        user.getBackPack().addItemToInventory(item, count);
        return new Result(true, itemName + " has been cheated");
    }
    public Result PlaceItem(String itemName, String direction) {
        User user = App.currentGame.currentUser;
        ItemType type = ItemType.getItemType(itemName);
        if (type == null) {
            return new Result(false, "No item found");
        }
        Item item = user.getBackPack().getItemInInventory(type);
        if (item == null) {
            return new Result(false, "you dont have dis item now!");
        }
        Tile tile = App.currentGame.getTileFromDirection(direction);
        if (tile == null) {
            return new Result(false, "this tile does not exist");
        }
        if (tile.getMohtaviat() != null||!tile.getMohtaviat().equals("h")) {
            return new Result(false, "this tile has something ");
        }
        user.getBackPack().removeItemFromInventory(item);
        tile.setItemInThisTile(item);
        return new Result(true, itemName + " has been placed");

    }

    public Result PutInRefrigerator(String itemName) {
        User user = App.currentGame.currentUser;
        ItemType type = ItemType.getItemType(itemName);
        if (type == null) {
            return new Result(false, "No item found");
        }
        Item item = user.getBackPack().getItemInInventory(type);
        if (item == null) {
            return new Result(false, "you dont have dis item now!");
        }
        CookingItemType cookingItemType = CookingItemType.isEdible(type);
        if (cookingItemType == null) {
            return new Result(false, "you cant put non-edible item in refrigerator");
        }
        CookingItem thing = new CookingItem(cookingItemType);
        user.getRefrigerator().add(thing);
        user.getBackPack().removeItemFromInventory(item);
        return new Result(true, itemName + " has been put into refrigerator");
    }
    public Result PickFromRefrigerator(String itemName) {
        User user = App.currentGame.currentUser;
        ItemType type = ItemType.getItemType(itemName);
        if (type == null) {
            return new Result(false, "No item found");
        }
        CookingItemType cookingItemType = CookingItemType.isEdible(type);
        if (cookingItemType == null) {
            return new Result(false, "this item not edible so cant pick from refrigerator");
        }
        CookingItem thing = user.getFromRefrigerator(type);
        if (thing == null) {
            return new Result(false, "this item isnt in refrigerator");
        }
        if (!user.getBackPack().inventoryHasCapacity()) {
            return new Result(false, "you dont have enough inventory");
        }
        Item item = new Item(type);
        item.setNumber(thing.getNumber());
        user.getBackPack().addToInventory(item);
        user.getRefrigerator().remove(thing);
        return new Result(true, itemName + " has been picked from refrigerator");
    }
    public Result ShowCookingRecipe() {
        ArrayList<CookingItemType> recipes = App.currentGame.currentUser.getBackPack().getCookingRecipes();
//        if (recipes == null || recipes.isEmpty()) {
//            return new Result(false, "No recipe found");
//        }
        StringBuilder result = new StringBuilder();
        if (!recipes.isEmpty()) {
        for (CookingItemType recipe : recipes) {
            result.append(recipe.getProductName()).append(": ")
                    .append("ingredient: ").append(recipe.getIngredients()).append("\n")
                    .append("Sell Price: ").append(recipe.getSellPrice()).append("\n");
        }}
        return new Result(true, result.toString().trim());
    }
    public Result CookItem(String itemName) {
        User user = App.currentGame.currentUser;
        ItemType type = ItemType.getItemType(itemName);
        if (type == null) {
            return new Result(false, "No item found");
        }
        CookingItemType recipe = CookingItemType.getKitchenRecipe(itemName);
        if (recipe == null) {
            return new Result(false, "this item does not have cooking recipe");
        }
        ArrayList<CookingItemType> recipes = App.currentGame.currentUser.getBackPack().getCookingRecipes();
        if (!recipes.contains(recipe)) {
            return new Result(false, "you dont have this item recipe");
        }
        if (!user.getBackPack().inventoryHasCapacity()) {
            return new Result(false, "you dont have enough inventory");
        }
        ArrayList<CookingItem> refrigerator = user.getRefrigerator();
        HashMap<ItemType, Integer> ingredients = recipe.getIngredients();
        boolean canCook = true;
        for (ItemType itemType : ingredients.keySet()) {
            int AllWeHave = user.getBackPack().howManyInInventory(itemType) + user.howManyInRefrigerator(itemType);
            if (AllWeHave < ingredients.get(itemType)) {
                canCook = false;
            }
        }
        if (!canCook) {
            return new Result(false, "you dont have enough ingredients for this recipe");
        }
        for (ItemType itemType : ingredients.keySet()) {
            int removedFromInventory = Math.min(user.getBackPack().howManyInInventory(itemType), ingredients.get(itemType));
            if (removedFromInventory > 0) {
                user.getBackPack().removeAmountFromInventory(itemType, removedFromInventory);
            }
            int removedFromRefrigerator = ingredients.get(itemType) - removedFromInventory;
            if (removedFromRefrigerator > 0) {
                user.removeFromRefrigerator(itemType, removedFromRefrigerator);
            }
        }
        user.decreaseEnergy(3);
        if (user.isFainted()) {
            return new Result(false, "you ran out of energy and fainted");
        }
        CookingItem food = new CookingItem(recipe);
//        user.getBackPack().addToInventory(food);
        user.getBackPack().addItemToInventory(food, 1);
        return new Result(true, food.getItemType().getDisplayName() + " was cooked and added to inventory.");
    }
    public Result Eat(String itemName) {
        User user = App.currentGame.currentUser;
        ItemType type = ItemType.getItemType(itemName);
        if (type == null) {
            return new Result(false, "No item found");
        }
        CookingItemType feed = CookingItemType.isEdible(type);
        if (feed == null) {
            return new Result(false, "this item isnt edible");
        }
        int quantity = user.getBackPack().howManyInInventory(type);
        if (quantity == 0) {
            return new Result(false, "you dont have this item for eat!");
        }
        user.getBackPack().removeAmountFromInventory(type, 1);
        user.increaseEnergy(feed.getEnergy());
        return new Result(true, itemName + " has been eaten");
    }
}
