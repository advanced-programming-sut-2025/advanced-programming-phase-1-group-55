package com.StardewValley.Common.Messages;

import java.io.Serializable;

public class PlayerJoinRequest implements Serializable {
    private String username;

    public PlayerJoinRequest(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
