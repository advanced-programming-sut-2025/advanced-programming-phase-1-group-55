package com.StardewValley.model.Friendship;

import com.StardewValley.model.Item.Item;
import com.StardewValley.model.User;

public class Gift {
    private User sender;
    private User receiver;
    private Item item;
    private int rate;
    private  int id;

    public Gift(User sender, User receiver, Item item,int id) {
        this.sender = sender;
        this.receiver = receiver;
        this.item = item;
        this.id=id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return
                "sender:" + sender.getUsername() +
                "\nreceiver:" + receiver.getUsername() +
                "\nitem:" + item.getItemType().getDisplayName() +
                "\namount:"+item.getNumber()+
                "\nrate:" + rate +
                "\nid:" + id+"\n\n";
    }
}
