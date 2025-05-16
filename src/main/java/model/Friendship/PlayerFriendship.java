package model.Friendship;

import model.User;

import java.util.ArrayList;

public class PlayerFriendship extends FriendShip {
    private User user1;
    private User user2;
    private ArrayList<Gift> gifts=new ArrayList<>();
    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public ArrayList<Gift> getGifts() {
        return gifts;
    }

    public void setGifts(ArrayList<Gift> gifts) {
        this.gifts = gifts;
    }
}
