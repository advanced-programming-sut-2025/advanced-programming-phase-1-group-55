package model.Tool;

public  abstract class Tools {
    protected int level=0;

    protected String name;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void increaseLevel(){
        level++;
    }
    public abstract String getName();
    public abstract void useTool();

    public void setName(String name) {
        this.name = name;
    }
    public abstract int energyCost();
    public abstract int getPriceToLevelUp();
    public  abstract int getPrice();
}
