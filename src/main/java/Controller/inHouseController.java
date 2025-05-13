package Controller;

import enums.CraftingItemType;
import model.App;
import model.App.*;
import model.Result;

import java.util.ArrayList;

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
