package model.Tool;

import model.App;
import model.Game;
import model.Item.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    private ArrayList<Item> inventory = new ArrayList<>();
    private int level = 1;
    public Map<String, Tools> getAvailableTools() {
        return availableTools;
    }

    public void setAvailableTools(Map<String, Tools> availableTools) {
        this.availableTools = availableTools;
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
    public void recycleItem(String name){
        //injaa bayad hame noe item ro recycle koni na faghat tools
        // TO DO
        App.currentGame.currentUser.setMoney(App.currentGame.currentUser.getMoney()+
                (int)((availableTools.get(name).getPrice()*availableTools.get("Trashcan").getLevel()*15)/100));
        availableTools.remove(name);
    }


    public boolean addToInventory(Item item){
        if (inventory.size() < getSize()) {
            inventory.add(item);
            return true;
        }
        return false;
    }
    public boolean removeFromInventory(Item item){
        return inventory.remove(item);
    }
    public String ShowInventory(){
        if (inventory.isEmpty()) {
            return "inventory is empty";
        }
        StringBuilder message = new StringBuilder("Inventory:\n");
        for(Item item:inventory){
            message.append("- ").append(item.getItemType()).append("\n");
        }
        return message.toString().trim();
    }
    public int getInventorySize() {
        return inventory.size();
    }
    public ArrayList<Item> getInventory()
    {
        return inventory;
    }
//    public int getCapicity() {
//        return level == 1 ? 12 : level == 2 ? 24 : 10000000;
//    }
//    public int getSize() {
//        return inventory.size();
//    }


}
