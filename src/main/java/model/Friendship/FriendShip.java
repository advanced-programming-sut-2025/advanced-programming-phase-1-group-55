package model.Friendship;

public abstract class FriendShip {
    private  int level=0;
    private int xp;
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
    public void increaseXp(int amount){
        xp+=amount;
        if(level==0){
            if(xp>=100){
                level++;
            }
        } else if (level==1) {
            if(xp>=300){
                level++;
            }
        } else if (level==2) {
            if(xp>=600){
                level++;
            }
        } else if (level==3) {
            if(xp>=1000){
                level++;
            }
        }
    }
}
