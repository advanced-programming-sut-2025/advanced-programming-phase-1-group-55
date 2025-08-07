package com.StardewValley.Common.Messages;


import com.StardewValley.Common.DTO.UserDTO;

import java.io.Serializable;
import java.util.List;

public class InitialPlayersStateMessage implements Serializable {
    private List<UserDTO> allPlayers;

    public InitialPlayersStateMessage(List<UserDTO> allPlayers) {
        this.allPlayers = allPlayers;
    }

    public List<UserDTO> getAllPlayers() {
        return allPlayers;
    }
}
