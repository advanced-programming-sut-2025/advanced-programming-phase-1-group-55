package com.StardewValley.Common.model.Chat;

public class Emoji {
    private Boolean isActive=false;
    private Boolean isPicture=true;
    private EmojiType type;
    private String message;

    public Emoji(EmojiType type) {
        this.type = type;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getPicture() {
        return isPicture;
    }

    public void setPicture(Boolean picture) {
        isPicture = picture;
    }

    public EmojiType getType() {
        return type;
    }

    public void setType(EmojiType type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
