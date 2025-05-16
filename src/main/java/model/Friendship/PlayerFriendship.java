package model.Friendship;

import model.User;

import java.util.ArrayList;

public class PlayerFriendship extends FriendShip {
    private User user1;
    private User user2;
    private boolean todayHugged=false;
    private boolean todayTraded=false;
    private boolean todayGotFlower=false;
    private  boolean todayTalked=false;
    private boolean todayGotGift=false;
    private ArrayList<String> conversation=new ArrayList<>();
    private ArrayList<Gift> gifts=new ArrayList<>();

    public PlayerFriendship(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }
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

    public boolean isTodayHugged() {
        return todayHugged;
    }

    public void setTodayHugged(boolean todayHugged) {
        this.todayHugged = todayHugged;
    }

    public boolean isTodayTraded() {
        return todayTraded;
    }

    public void setTodayTraded(boolean todayTraded) {
        this.todayTraded = todayTraded;
    }

    public boolean isTodayGotFlower() {
        return todayGotFlower;
    }

    public void setTodayGotFlower(boolean todayGotFlower) {
        this.todayGotFlower = todayGotFlower;
    }

    public boolean isTodayTalked() {
        return todayTalked;
    }

    public void setTodayTalked(boolean todayTalked) {
        this.todayTalked = todayTalked;
    }

    public boolean isTodayGotGift() {
        return todayGotGift;
    }

    public void setTodayGotGift(boolean todayGotGift) {
        this.todayGotGift = todayGotGift;
    }

    public ArrayList<String> getConversation() {
        return conversation;
    }

    public void setConversation(ArrayList<String> conversation) {
        this.conversation = conversation;
    }
}
