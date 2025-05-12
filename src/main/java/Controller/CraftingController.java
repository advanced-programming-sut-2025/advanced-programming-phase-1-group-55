package Controller;

import enums.CraftingItemType;
import model.Recipe;
import model.Result;
import model.User;

import java.util.Set;

public class CraftingController {
    public Result getLearnedRecipes(User user) {
        Set<CraftingItemType> recipes = user.getLearnedCraftingRecipes();
        if (recipes.isEmpty()) {
            return new Result(false, "You haven't learned any crafting recipes yet.");
        }
        StringBuilder message = new StringBuilder("Crafting Recipes You Have Learned:\n");
        for (CraftingItemType recipe : recipes) {
            message.append("- ").append(recipe.getName()).append("\n");
        }

        return new Result(true, message.toString());

    }
}
