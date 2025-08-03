package com.StardewValley.model.Tool;

import com.StardewValley.enums.CookingItemType;
import com.StardewValley.enums.CraftingItemType;
import com.StardewValley.model.App;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.Item.ItemType;
import com.StardewValley.model.Result;


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

    public String showCurrentTool(){
        return currentTool.getName();
    }
    public String showAvailableTools(){
        StringBuilder message=new StringBuilder();
        for(Tools tools:availableTools.values()){
            message.append(tools.getName()).append("\n");
        }
        return  message.toString();
    }

    public int getSize() {
        return level==1?12:level==2?24:10000000;
    }

    public void addToInventory(Item item){
        if (inventory.size() < getSize()) {
            inventory.put(item.getItemType().name(),item);
            if(item.getNumber()==0){
                item.setNumber(1);
            }
        }
    }
    public int getInventorySize() {
        return inventory.size();
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

    public int howManyInInventory(ItemType itemType) {
        for (Item item : inventory.values()) {
            if (item.getItemType().equals(itemType)) {
                return item.getNumber();
            }
        }
        return 0;
    }

    public void removeAmountFromInventory(ItemType itemType, int quantity) {
        for (Item item : inventory.values()) {
            if (item.getItemType().equals(itemType)) {
                item.addNumber(-quantity);
                if (item.getNumber() <= 0) {
                    this.inventory.remove(item.getItemType().getDisplayName());
                }
                break;
            }
        }
    }
    public void removeItemFromInventory(Item item) {
        if (this.inventory.containsKey(item.getItemType().getDisplayName())) {
            item.addNumber(-1);
            if (item.getNumber() <= 0) {
                this.inventory.remove(item.getItemType().getDisplayName());
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

    public void setAvailableTools(Map<String, Tools> availableTools) {
        this.availableTools = availableTools;
    }

    public void setCraftingRecipes(ArrayList<CraftingItemType> craftingRecipes) {
        this.craftingRecipes = craftingRecipes;
    }

    public void setCookingRecipes(ArrayList<CookingItemType> cookingRecipes) {
        this.cookingRecipes = cookingRecipes;
    }
}
