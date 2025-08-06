package com.StardewValley.model.Friendship;

import com.StardewValley.model.App;
import com.StardewValley.model.User;
import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;

public class PlayerFriendship extends FriendShip implements Serializable {
    @Expose
    private User user1;

    @Expose
    private User user2;

    @Expose
    private boolean areMarried;

    @Expose
    private MarriageRequest marriageRequest;

    @Expose
    private boolean todayHugged;

    @Expose
    private boolean todayTraded;

    @Expose
    private boolean todayGotFlower;

    @Expose
    private boolean todayTalked;

    @Expose
    private boolean todayGotGift;

    @Expose
    private boolean hasReceivedFlower;

    @Expose
    private boolean hasMarriage;

    @Expose
    private ArrayList<Message> conversation;

    @Expose
    private ArrayList<Gift> gifts;


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

    public ArrayList<Message> getConversation() {
        return conversation;
    }

    public void setConversation(ArrayList<Message> conversation) {
        this.conversation = conversation;
    }

    public void increaseXp(int amount) {
        xp += amount;
        if (level == 0) {
            if (xp >= 100) {
                level++;
            }
        } else if (level == 1) {
            if (xp >= 300) {
                level++;
            }
        } else if (level == 2) {
            if (xp >= 600 && hasReceivedFlower) {
                level++;
            }
        } else if (level == 3) {
            if (xp >= 1000 && hasMarriage) {
                level++;
            }
        }
    }

    public boolean isHasReceivedFlower() {
        return hasReceivedFlower;
    }

    public void setHasReceivedFlower(boolean hasReceivedFlower) {
        this.hasReceivedFlower = hasReceivedFlower;
    }

    public boolean isHasMarriage() {
        return hasMarriage;
    }

    public void setHasMarriage(boolean hasMarriage) {
        this.hasMarriage = hasMarriage;
    }

    public boolean isAreMarried() {
        return areMarried;
    }

    public void setAreMarried(boolean areMarried) {
        this.areMarried = areMarried;
    }

    public MarriageRequest getMarriageRequest() {
        return marriageRequest;
    }

    public void setMarriageRequest(MarriageRequest marriageRequest) {
        this.marriageRequest = marriageRequest;
    }

    @Override
    public String toString() {
        String username = user1.getUsername().equals(App.getCurrentGameModel().getCurrentUser().getUsername()) ? user2.getUsername() : user1.getUsername();
        return
            "You: " + App.currentGameModel.currentUser.getUsername() +
                "\nYour friend: " + username +
                "\nFriendship level: " + level +
                "\nxp: " + xp +
                "\nareMarried: " + areMarried + "\n\n";
    }
}
