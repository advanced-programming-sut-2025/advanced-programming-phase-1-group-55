package model;

import java.util.HashMap;
import java.util.Map;

public class BackPack {
    private  Tools currentTool;
    private Map<String,Tools > availableTools=new HashMap<>();
    private int level=0;
    private int size;
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
        return  message.toString();
    }

    public int getSize() {
        return level==0?12:level==1?24:10000000;
    }
    public void recycleItem(String name){
        availableTools.remove(name);
    }
}
