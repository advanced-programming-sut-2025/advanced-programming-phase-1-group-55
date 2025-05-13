package model;

import enums.CraftingItemType;
import enums.RecipeType;
import model.Item.Item;

import java.util.List;
import java.util.Map;

public class Recipe {
    private CraftingItemType craftingItemType;

    public Recipe(CraftingItemType craftingItemType) {
        this.craftingItemType = craftingItemType;
    }

    public CraftingItemType getCraftingItemType() {
        return craftingItemType;
    }

    public void setCraftingItemType(CraftingItemType craftingItemType) {
        this.craftingItemType = craftingItemType;
    }
}
