package com.StardewValley.Common;


import com.StardewValley.Common.model.App;
import com.StardewValley.Common.model.Chat.Emoji;
import com.StardewValley.Common.model.Chat.EmojiType;
import com.StardewValley.Common.model.Friendship.NpcFriendship;
import com.StardewValley.Common.model.NPC.Quest;
import com.StardewValley.Common.model.NPC.QuestStatus;
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
        gold=player.getGold();
        skills=player.getFarmingSkill().getLevel()+
            player.getFishingSkill().getLevel()+
            player.getForagingSkill().getLevel()+
            player.getMiningSkill().getLevel();
        int xp=0;
        for (NpcFriendship friendship:player.getFriendsNpc().values()){
            for (int i=0;i<3;i++){
                if (friendship.getQuestStatus()[i].equals(QuestStatus.Completed)){
                    xp++;
                }
            }
        }
        quests=xp;
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

    public int getSkills() {
        return skills;
    }

    public void setSkills(int skills) {
        this.skills = skills;
    }

    public int getQuests() {
        return quests;
    }

    public void setQuests(int quests) {
        this.quests = quests;
    }

    public ArrayList<EmojiType> getDefaultEmojis() {
        return defaultEmojis;
    }

    public void setDefaultEmojis(ArrayList<EmojiType> defaultEmojis) {
        this.defaultEmojis = defaultEmojis;
    }
}
