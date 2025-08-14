package com.StardewValley.Common;


import com.StardewValley.Common.model.App;
import com.StardewValley.Common.model.User;

public class PlayerDetails {
    public String username;
    public int posX;
    public int posY;
    public boolean canSleep;
    public int questCount;
    public int skillSum;
    public int gold;

    public PlayerDetails(String username) {
        this.username = username;
        posX = 0;
        posY = 0;
        canSleep = false;
        questCount = 0;
        skillSum = 0;
        gold = 0;
    }

    public void updateInfo() {
        User player = App.currentGameModel.currentUser;
        posX = player.getLocation().getX();
        posY = player.getLocation().getY();
        canSleep = (player.isFainted());
    }
}
