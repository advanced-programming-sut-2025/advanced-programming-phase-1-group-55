package model.Friendship;

import model.Item.Item;
import model.User;

public class Gift {
    private User sender;
    private User receiver;
    private Item item;
    private int rate;

    public Gift(User sender, User receiver, Item item) {
        this.sender = sender;
        this.receiver = receiver;
        this.item = item;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
