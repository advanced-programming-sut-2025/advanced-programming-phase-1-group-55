package com.StardewValley.Common.Messages;

import com.StardewValley.Common.DTO.UserDTO;

import java.io.Serializable;

public class PlayerJoinedMessage implements Serializable {
    private UserDTO newPlayer;

    public PlayerJoinedMessage(UserDTO newPlayer) {
        this.newPlayer = newPlayer;
    }

    public UserDTO getNewPlayer() {
        return newPlayer;
    }
}
