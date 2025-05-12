package model;

import model.Item.Item;

public class Trade {

    private User Sender;
    private User Reciver;
    private Item Item;
    private String type;//todo
    private int amount;
    private int price;
    private Item TargetItem;
    private int TargetAmount;
    private int id;
    private boolean Printed = false;
    private boolean Accepted = false;

    public User getSender() {
        return Sender;
    }

    public void setSender(User sender) {
        Sender = sender;
    }

    public User getReciver() {
        return Reciver;
    }

    public void setReciver(User reciver) {
        Reciver = reciver;
    }

    public Item getItem() {
        return Item;
    }

    public void setItem(Item item) {
        Item = item;
    }

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

    public Item getTargetItem() {
        return TargetItem;
    }

    public void setTargetItem(Item targetItem) {
        TargetItem = targetItem;
    }

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
}
