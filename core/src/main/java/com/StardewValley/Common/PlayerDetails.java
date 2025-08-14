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
    public boolean canSleep;
    public int questCount;
    public int skillSum;
    public int gold;
    public Emoji emoji;
    public ArrayList<EmojiType> defaultEmojis=new ArrayList<>();

    public PlayerDetails(String username) {
        this.username = username;
        posX = 0;
        posY = 0;
        canSleep = false;
        questCount = 0;
        skillSum = 0;
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
        canSleep = (player.isFainted());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean isCanSleep() {
        return canSleep;
    }

    public void setCanSleep(boolean canSleep) {
        this.canSleep = canSleep;
    }

    public int getQuestCount() {
        return questCount;
    }

    public void setQuestCount(int questCount) {
        this.questCount = questCount;
    }

    public int getSkillSum() {
        return skillSum;
    }

    public void setSkillSum(int skillSum) {
        this.skillSum = skillSum;
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
