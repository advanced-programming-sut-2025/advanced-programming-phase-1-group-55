package com.StardewValley.Controller;

import com.StardewValley.model.Friendship.NpcFriendship;
import com.StardewValley.model.GameModel;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.Item.ItemType;
import com.StardewValley.model.Map.*;
import com.StardewValley.model.NPC.Npc;
import com.StardewValley.model.NPC.Quest;
import com.StardewValley.model.Result;
import com.StardewValley.model.User;

import java.util.HashMap;

import static com.StardewValley.model.App.*;


public class GameMenuController {
    private void setFriendships(GameMap map) {
        for (User user : currentGameModel.playersInGame) {
            user.setQuest(new HashMap<>());
            user.setEnergy(10000);
            user.setFriendsNpc(new HashMap<>());
            Item item=new Item(ItemType.WOOD);
            item.setPrice(10);
            user.getBackPack().addItemToInventory(item,200);
            Item item2=new Item(ItemType.GOLD_BAR);
            item2.setPrice(3000);
            user.getBackPack().addItemToInventory(item2,20);
            Item item3=new Item(ItemType.KEG_RECIPE);
            item3.setPrice(450);
            user.getBackPack().addItemToInventory(item3,20);
            Item item4=new Item(ItemType.LOOM_RECIPE);
            item4.setPrice(500);
            user.getBackPack().addItemToInventory(item4,20);
            for (Npc npc : map.getVillage().getNpss().values()) {
                NpcFriendship friendship = new NpcFriendship(user, npc);
                user.getFriendsNpc().put(npc.getType().getDisplayName(), friendship);
                for (Quest quest : npc.getType().getQuests().values()) {
                    quest.setNpc(npc);
                }
            }
        }

    }


    public Result newGame(String Username1, String Username2, String Username3,
                          String Map1, String Map2, String Map3) {

        if (Username1 == null || Username1.isEmpty()) {
            return new Result(false, "Username is empty. At least one user must be added.");
        }


        User player0 = mainUser;
        User player1 = AllUsers.get(Username1);
        User player2 = Username2 != null ? AllUsers.get(Username2) : null;
        User player3 = Username3 != null ? AllUsers.get(Username3) : null;


        GameMap map = new GameMap();
        map.BuildMap();
        currentGameModel = new GameModel(mainUser, map);
        currentGameModel.playersInGame.add(player0);
        currentGameModel.playersInGame.add( player1);
        if (player2 != null) currentGameModel.playersInGame.add(player2);
        if (player3 != null) currentGameModel.playersInGame.add(player3);
        map.BuildFarm(Map1,Map2,Map3);
        setFriendships(map);

        return new Result(true, "Game has been created successfully!");
    }

    public Result loadGame(String Username1, String Username2, String Username3) {
        return null;
    }

    public Result exitGame(String Username1, String Username2, String Username3) {
        return null;
    }

    public Result deleteGame() {
        return null;
    }

    public Result nextTurn() {
        return null;
    }


}
