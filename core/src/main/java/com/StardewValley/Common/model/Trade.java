package com.StardewValley.Common.model;

import com.StardewValley.Common.model.Item.Item;

import java.io.Serializable;


public class Trade implements Serializable {

    private String Sender;
    private String Reciver;
    //    private transient Item Item;
    private String type;
    private int amount;
    private int price;
//    private Item TargetItem;
    private int TargetAmount;
    private int id;
    private transient boolean Printed = false;
    private transient boolean Accepted = false;
    private transient boolean answered = false;

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public Trade(String sender, String reciver, Item item, String type, int amount, int price, Item targetItem, int targetAmount, int id) {
        Sender = sender;
        Reciver = reciver;
//        Item = item;
        this.type = type;
        this.amount = amount;
        this.price = price;
//        TargetItem = targetItem;
        TargetAmount = targetAmount;
        this.id = id;
    }


    public String getSender() {
        return Sender;
    }

    public void setSender(String sender) {
        Sender = sender;
    }

    public String getReciver() {
        return Reciver;
    }

    public void setReciver(String reciver) {
        Reciver = reciver;
    }

//    public Item getItem() {
//        return Item;
//    }

//    public void setItem(Item item) {
//        Item = item;
//    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

//    public Item getTargetItem() {
//        return TargetItem;
//    }
//
//    public void setTargetItem(Item targetItem) {
//        TargetItem = targetItem;
//    }

    public int getTargetAmount() {
        return TargetAmount;
    }

    public void setTargetAmount(int targetAmount) {
        TargetAmount = targetAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPrinted() {
        return Printed;
    }

    public void setPrinted(boolean printed) {
        Printed = printed;
    }

    public boolean isAccepted() {
        return Accepted;
    }

    public void setAccepted(boolean accepted) {
        Accepted = accepted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Trade info {").append(" id : ").append(getId()).append(" sender : ").append(getSender()).append(" reciver : ").append(" amount :").append(getAmount()).append(" type : ").append(getType());
//        if (price == 0) {
//            sb.append("\ntarget item : ").append(getTargetItem().getItemType().getDisplayName()).append("target amount : ").append(getTargetAmount());
//        } else {
//            sb.append(" price : ").append(getPrice());
//        }
//        sb.append(" accepted : ").append(isAccepted()).append(" }");
        return sb.toString();
    }
}
