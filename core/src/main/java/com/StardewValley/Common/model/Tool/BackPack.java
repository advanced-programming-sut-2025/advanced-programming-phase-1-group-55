package com.StardewValley.Common.model.Tool;

import com.StardewValley.Common.enums.CookingItemType;
import com.StardewValley.Common.enums.CraftingItemType;
import com.StardewValley.Common.model.Item.Item;
import com.StardewValley.Common.model.Item.ItemType;


import java.util.*;

public class BackPack {
    private  transient Tools currentTool=new Hoe();
    private ItemType selectedItem;
    private transient Map<String, Tools> availableTools = new HashMap<>() {{
        put("Hoe", new Hoe());
        put("Pickaxe", new Pickaxe());
        put("Axe", new Axe());
        put("WateringCan", new WateringCan());
        put("Scythe", new Scythe());
        put("FishingPole",new FishingPole(FishingPoleType.TRAINING_ROD));
    }};
    private transient Trashcan trashcan=new Trashcan();
    private Map<String,Item> inventory = new HashMap<>();
    private int level = 1;
    public Map<String, Tools> getAvailableTools() {
        return availableTools;
    }

    public Tools getCurrentTool() {
        return currentTool;
    }

    public void setCurrentTool(Tools currentTool) {
        this.currentTool = currentTool;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    public int getSize() {
        return level==1?12:level==2?24:10000000;
    }

    public Map<String,Item> getInventory()
    {
        return inventory;
    }

    public void setInventory(Map<String,Item> inventory) {
        this.inventory = inventory;
    }
    private ArrayList<CraftingItemType> craftingRecipes = new ArrayList<>();
    private ArrayList<CookingItemType> cookingRecipes = new ArrayList<>(
            Arrays.asList(CookingItemType.FRIED_EGG, CookingItemType.BAKED_FISH, CookingItemType.SALAD)
    );


    public ArrayList<CraftingItemType> getCraftingRecipes() {
        return craftingRecipes;
    }



    public ArrayList<CookingItemType> getCookingRecipes() {
        return cookingRecipes;
    }

    public Item getItemInInventory(ItemType itemType) {
        for (Item item : inventory.values()) {
            if (item.getItemType().equals(itemType)) {
                return item;
            }
        }
        return null;
    }

    public boolean inventoryHasCapacity() {
        int capacity = getSize();
        int currentSize = inventory.size();
        return currentSize < capacity;
    }


    public void addItemToInventory(Item item, int quantity) {
        Item itemx = getItemInInventory(item.getItemType());
        if (itemx != null) {
            itemx.addNumber(quantity);
        } else {
            item.setNumber(quantity);
            inventory.put(item.getItemType().getDisplayName(),item);
        }
    }

    public boolean hasEnoughInInventory(ItemType itemType, int quantity) {
        for (Item item : inventory.values()) {
            if (item.getItemType().equals(itemType) && item.getNumber() >= quantity) {
                return true;
            }
        }
        return false;
    }

    public void removeAmountFromInventory(ItemType itemType, int quantity) {
        for (Item item : inventory.values()) {
            if (item.getItemType().equals(itemType)) {
                item.addNumber(-quantity);
                if (item.getNumber() <= 0) {
                    this.inventory.remove(item.getItemType().getDisplayName());
                    if (selectedItem == itemType) {
                        selectedItem = null;
                    }
                }
                break;
            }
        }
    }

    public Trashcan getTrashcan() {
        return trashcan;
    }

    public void setTrashcan(Trashcan trashcan) {
        this.trashcan = trashcan;
    }

    public ItemType getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(ItemType selectedItem) {
        this.selectedItem = selectedItem;
    }


}
