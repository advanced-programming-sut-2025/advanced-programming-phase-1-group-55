package com.StardewValley.Common.model;


import com.StardewValley.Common.DTO.UserDTO;

import java.io.Serializable;
import java.util.List;

public class GameStateDTO implements Serializable {
    private List<UserDTO> players;

    public GameStateDTO(List<UserDTO> players) {
        this.players = players;
    }

    public List<UserDTO> getPlayers() {
        return players;
    }
}
