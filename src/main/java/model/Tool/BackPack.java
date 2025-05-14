package model.Tool;

import enums.CraftingItemType;
import model.App;
import model.Game;
import model.Item.Item;
import model.Item.ItemType;


import java.util.*;

public class BackPack {
    private  Tools currentTool=new Hoe();
    private Map<String, Tools> availableTools = new HashMap<>() {{
        put("Hoe", new Hoe());
        put("Pickaxe", new Pickaxe());
        put("Axe", new Axe());
        put("WateringCan", new WateringCan());
        put("Scythe", new Scythe());
        put("FishingPole", new FishingPole(FishingPoleType.TRAINING_ROD));
        put("Trashcan",new Trashcan());
    }};
// todo havij , goosht zoghaal va ... yadet nare , bakhsh inventory moonde !!!!!!!
    private Map<String,Item> inventory = new HashMap<>();
    private int level = 1;
    public Map<String, Tools> getAvailableTools() {
        return availableTools;
    }

    public void setAvailableTools(Map<String, Tools> availableTools) {
        this.availableTools = availableTools;
    }
    private Set<CraftingItemType> learnedCraftingRecipes = new HashSet<>();

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
    public void recycleItem(String name){
        //injaa bayad hame noe item ro recycle koni na faghat tools
        // TODO
        App.currentGame.currentUser.setGold(App.currentGame.currentUser.getGold()+
                (int)((availableTools.get(name).getPrice()*availableTools.get("Trashcan").getLevel()*15)/100));
        availableTools.remove(name);
    }


    public boolean addToInventory(Item item){
        if (inventory.size() < getSize()) {
            inventory.put(item.getItemType().name(),item);
            return true;
        }
        return false;
    }
    public void removeFromInventory(Item item){
         inventory.remove(item.getItemType().getDisplayName());
    }
    public String ShowInventory(){
        if (inventory.isEmpty()) {
            return "inventory is empty";
        }
        StringBuilder message = new StringBuilder("Inventory:\n");
        for(Item item:inventory.values()){
            message.append("- ").append(item.getItemType()).append("\n");
        }
        return message.toString().trim();
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

    public void setCraftingRecipes(ArrayList<CraftingItemType> craftingRecipes) {
        this.craftingRecipes = craftingRecipes;
    }

    public Set<CraftingItemType> getLearnedCraftingRecipes() {
        return learnedCraftingRecipes;
    }

    public void setLearnedCraftingRecipes(Set<CraftingItemType> learnedCraftingRecipes) {
        this.learnedCraftingRecipes = learnedCraftingRecipes;
    }

    public ArrayList<CraftingItemType> getCraftingRecipes() {
        return craftingRecipes;
    }

    public void learnRecipe(CraftingItemType recipe) {
        if (!craftingRecipes.contains(recipe)) {
            craftingRecipes.add(recipe);
        }
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


    public void addItemToInventory(ItemType itemType, int quantity) {
        Item item = getItemInInventory(itemType);
        if (item != null) {
            item.addNumber(quantity);
        } else {
            if (inventoryHasCapacity()) {
                Item newItem = new Item(itemType);
                newItem.setNumber(quantity);
                inventory.put(newItem.getItemType().getDisplayName(),newItem);
            }
        }
    }

    public int getInventoryCapacity() {
        int capacity = getSize();
        if (capacity == -1) {
            return -1;
        }
        return capacity - getInventorySize();
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
            if (item.getNumber() == 0) {
                this.inventory.remove(item.getItemType().getDisplayName());
            }
        }
    }
}
