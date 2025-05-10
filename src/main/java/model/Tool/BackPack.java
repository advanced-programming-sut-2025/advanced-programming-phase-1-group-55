package model.Tool;

import model.Game;

import java.util.HashMap;
import java.util.Map;

public class BackPack {
    private  Tools currentTool;
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
    private int level=1;
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
        return currentTool.toString();
    }
    public String showAvailableTools(){
        StringBuilder message=new StringBuilder();
        for(Tools tools:availableTools.values()){
            message.append(tools.getName());
        }
        return  message.toString();
    }

    public int getSize() {
        return level==1?12:level==2?24:10000000;
    }
    public void recycleItem(String name){
        //injaa bayad hame noe item ro recycle koni na faghat tools
        // TO DO 
        Game.mainUser.setMoney(Game.mainUser.getMoney()+
                (int)((availableTools.get(name).getPrice()*availableTools.get("Trashcan").getLevel()*15)/100));
        availableTools.remove(name);
    }

}
