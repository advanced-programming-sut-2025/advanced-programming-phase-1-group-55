package com.StardewValley.Common;


import com.StardewValley.Common.model.App;
import com.StardewValley.Common.model.Chat.Emoji;
import com.StardewValley.Common.model.Chat.EmojiType;
import com.StardewValley.Common.model.User;

import java.util.ArrayList;

public class PlayerDetails {
    public String username;
    public int posX;
    public int posY;
    public int gold;
    public int skills;
    public int quests;
    public Emoji emoji;
    public ArrayList<EmojiType> defaultEmojis=new ArrayList<>();

    public PlayerDetails(String username) {
        this.username = username;
        posX = 0;
        posY = 0;
        gold = 0;
        emoji=new Emoji(EmojiType.Emoji0);
        for (int i=0;i<10;i++) {
            defaultEmojis.add(EmojiType.getFromId(i));
        }
    }

    public void updateInfo() {
        User player = App.currentGameModel.currentUser;
        posX = player.getLocation().getX();
        posY = player.getLocation().getY();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Emoji getEmoji() {
        return emoji;
    }

    public void setEmoji(Emoji emoji) {
        this.emoji = emoji;
    }
}
