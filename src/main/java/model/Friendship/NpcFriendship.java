package model.Friendship;

import model.NPC.Npc;
import model.NPC.Quest;
import model.User;

import static java.lang.Math.min;

public class NpcFriendship extends FriendShip {
    private User user;
    private Npc npc;
    private int dayToBeFriend=0;
    private boolean todayMet=false;
    private boolean todayHadGift=false;
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Npc getNpc() {
        return npc;
    }

    public void setNpc(Npc npc) {
        this.npc = npc;
    }

    public boolean isTodayHadGift() {
        return todayHadGift;
    }

    public void setTodayHadGift(boolean todayHadGift) {
        this.todayHadGift = todayHadGift;
    }

    public int getDayToBeFriend() {
        return dayToBeFriend;
    }

    public void setDayToBeFriend(int dayToBeFriend) {
        this.dayToBeFriend = dayToBeFriend;
    }

    public NpcFriendship(User user, Npc npc) {
        this.user = user;
        this.npc = npc;
    }

    @Override
    public String toString() {
        return "NpcFriendship{" +
                "user=" + user.getUsername() +
                ", npc=" + npc.getType().getDisplayName() +
                ", dayToBeFriend=" + dayToBeFriend +
                ", level=" + (level) +
                ", xp=" + xp +
                '}';
    }
    public void increaseDayOfBeingFriend(){
        dayToBeFriend++;
    }
    public void checkQuest(){
        if (level>=1){
            for (Quest quest1:npc.getType().getQuests().values()){
                if (quest1.getLevel()==2&&!quest1.isHasAlreadyFinished()){
                    user.getQuest().put(quest1.getId(),quest1);
                }
            }
        }
    }
    public  void  increaseXp(int amount){
        xp=min(amount+xp,799);
        if (xp>=200){
            level=1;
        }
        if (xp>=400){
            level=2;
        }
        if (xp>=600){
            level=3;
        }
        checkQuest();
    }

    public boolean isTodayMet() {
        return todayMet;
    }

    public void setTodayMet(boolean todayMet) {
        this.todayMet = todayMet;
    }
}
