package model;

import enums.ToolType;

public class simpleTools extends Tools{
    private ToolType type;

    public ToolType getType() {
        return type;
    }
    public String getName(){
        return type.name();
    }
    public void setType(ToolType type) {
        this.type = type;
    }
}
