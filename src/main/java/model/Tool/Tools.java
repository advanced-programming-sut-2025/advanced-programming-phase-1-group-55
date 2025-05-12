package model.Tool;

public   class Tools {
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

    public String getName() {
        return null;
    }

    public void useTool() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public int energyCost() {
        return 0;
    }

    public int getPriceToLevelUp() {
        return 0;
    }

    public int getPrice() {
        return 0;
    }
}
