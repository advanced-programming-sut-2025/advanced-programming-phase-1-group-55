package model.Friendship;

public abstract class FriendShip {
    protected   int level=0;
    protected int xp;
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public int XpToNextLevel(){
        return (level+1)*100;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

}
