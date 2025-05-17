package model.Friendship;

import model.NPC.Npc;
import model.User;

public class NpcFriendship extends FriendShip {
    private User user;
    private Npc npc;
    private int dayToBeFriend=0;
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
                ", level=" + level +
                ", xp=" + xp +
                '}';
    }
    public void increaseDayOfBeingFriend(){
        dayToBeFriend++;
    }
}
