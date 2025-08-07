package com.StardewValley.Common.DTO;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private int id;
    private String nickname;
    private int x;
    private int y;

    public UserDTO(int id, String nickname, int x, int y) {
        this.id = id;
        this.nickname = nickname;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
