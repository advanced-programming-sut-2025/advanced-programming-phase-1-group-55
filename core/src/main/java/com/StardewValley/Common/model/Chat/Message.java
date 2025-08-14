package com.StardewValley.Common.model.Chat;

public class Message {
    private String sender;
    private String text;

    public Message( String text,String sender) {
        this.sender = sender;
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
