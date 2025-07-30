package com.StardewValley.Controller;

import com.StardewValley.enums.Menu;
import com.StardewValley.enums.mainGameCommands;
import com.StardewValley.model.App;
import com.StardewValley.model.Friendship.NpcFriendship;
import com.StardewValley.model.Friendship.PlayerFriendship;
import com.StardewValley.model.GameModel;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.Item.ItemType;
import com.StardewValley.model.Map.*;
import com.StardewValley.model.NPC.Npc;
import com.StardewValley.model.NPC.Quest;
import com.StardewValley.model.Result;
import com.StardewValley.model.Tool.BackPack;
import com.StardewValley.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;

import static com.StardewValley.model.App.*;


public class GameMenuController {
    private void setFriendships(GameMap map) {
        for (User user : currentGameModel.playersInGame) {
            user.setQuest(new HashMap<>());
            user.setEnergy(10000);
            user.setFriendsNpc(new HashMap<>());
            for (Npc npc : map.getVillage().getNpss().values()) {
                NpcFriendship friendship = new NpcFriendship(user, npc);
                user.getFriendsNpc().put(npc.getType().getDisplayName(), friendship);
                for (Quest quest : npc.getType().getQuests().values()) {
                    quest.setNpc(npc);
                }
            }
        }

    }

    public void setTileOwner(User user, Farm farm, GameMap map) {
//        System.out.println(user.getUsername() + mainUser.getUsername());
//        System.out.println(farm.getLocation().toString());
//        System.out.println(farm.getHeight());
//        System.out.println(farm.getWidth());
        for (int i = farm.getLocation().getY(); i < farm.getWIDTH() + farm.getLocation().getY(); i++) {
            for (int j = farm.getLocation().getX(); j < farm.getHEIGHT() + farm.getLocation().getX(); j++) {
//                System.out.println(i + "  " + j);
                map.tiles[i][j].setOwner(user);
            }
        }
    }

    //todo gereftan mazrae va map az player haa va pass dadn be mapbuilder
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
        map.BuildMap("Map1",Map1,Map2,Map3);
        currentGameModel = new GameModel(mainUser, map);
        currentGameModel.playersInGame.add(player0);
        currentGameModel.playersInGame.add( player1);
        if (player2 != null) currentGameModel.playersInGame.add(player2);
        if (player3 != null) currentGameModel.playersInGame.add(player3);
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
