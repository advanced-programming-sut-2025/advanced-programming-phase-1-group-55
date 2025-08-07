package com.StardewValley.Common.Messages;


import com.StardewValley.Common.DTO.UserDTO;

import java.io.Serializable;

public class PlayerMovedMessage implements Serializable {
    private UserDTO user;

    public PlayerMovedMessage(UserDTO user) {
        this.user = user;
    }

    public UserDTO getUser() { return user; }
}
