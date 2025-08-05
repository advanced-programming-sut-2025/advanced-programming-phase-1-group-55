package com.StardewValley.Controller;

import com.StardewValley.model.App;
import com.StardewValley.model.Friendship.NpcFriendship;
import com.StardewValley.model.Friendship.PlayerFriendship;
import com.StardewValley.model.GameModel;
import com.StardewValley.model.Item.CollisionRect;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.Item.ItemType;
import com.StardewValley.model.Map.*;
import com.StardewValley.model.NPC.Npc;
import com.StardewValley.model.NPC.Quest;
import com.StardewValley.model.Result;
import com.StardewValley.model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;
import java.util.HashMap;

import static com.StardewValley.model.App.*;


public class GameMenuController {
    private void setFriendships(GameMap map) {
        PlayerFriendship friendship1 = new PlayerFriendship(currentGameModel.playersInGame.get(0), currentGameModel.playersInGame.get(1));
        currentGameModel.playersInGame.get(0).getFriendsPlayer().put(currentGameModel.playersInGame.get(1), friendship1);
        currentGameModel.playersInGame.get(1).getFriendsPlayer().put(currentGameModel.playersInGame.get(0), friendship1);
        currentGameModel.getAllFriendships().add(friendship1);
        friendship1.setConversation(new ArrayList<>());
        if (currentGameModel.playersInGame.size() > 2) {
            PlayerFriendship friendship2 = new PlayerFriendship(currentGameModel.playersInGame.get(0), currentGameModel.playersInGame.get(2));
            PlayerFriendship friendship4 = new PlayerFriendship(currentGameModel.playersInGame.get(1), currentGameModel.playersInGame.get(2));
            currentGameModel.playersInGame.get(0).getFriendsPlayer().put(currentGameModel.playersInGame.get(2), friendship2);
            currentGameModel.playersInGame.get(2).getFriendsPlayer().put(currentGameModel.playersInGame.get(0), friendship2);
            currentGameModel.playersInGame.get(1).getFriendsPlayer().put(currentGameModel.playersInGame.get(2), friendship4);
            currentGameModel.playersInGame.get(2).getFriendsPlayer().put(currentGameModel.playersInGame.get(1), friendship4);
            currentGameModel.getAllFriendships().add(friendship2);
            currentGameModel.getAllFriendships().add(friendship4);
            friendship2.setConversation(new ArrayList<>());
            friendship4.setConversation(new ArrayList<>());
            if (currentGameModel.playersInGame.size() > 3) {
                PlayerFriendship friendship3 = new PlayerFriendship(currentGameModel.playersInGame.get(0), currentGameModel.playersInGame.get(3));
                PlayerFriendship friendship5 = new PlayerFriendship(currentGameModel.playersInGame.get(1), currentGameModel.playersInGame.get(3));
                PlayerFriendship friendship6 = new PlayerFriendship(currentGameModel.playersInGame.get(2), currentGameModel.playersInGame.get(3));
                currentGameModel.playersInGame.get(0).getFriendsPlayer().put(currentGameModel.playersInGame.get(3), friendship3);
                currentGameModel.playersInGame.get(3).getFriendsPlayer().put(currentGameModel.playersInGame.get(0), friendship3);
                currentGameModel.playersInGame.get(1).getFriendsPlayer().put(currentGameModel.playersInGame.get(3), friendship5);
                currentGameModel.playersInGame.get(3).getFriendsPlayer().put(currentGameModel.playersInGame.get(1), friendship5);
                currentGameModel.playersInGame.get(2).getFriendsPlayer().put(currentGameModel.playersInGame.get(3), friendship6);
                currentGameModel.playersInGame.get(3).getFriendsPlayer().put(currentGameModel.playersInGame.get(2), friendship6);
                currentGameModel.getAllFriendships().add(friendship3);
                currentGameModel.getAllFriendships().add(friendship5);
                currentGameModel.getAllFriendships().add(friendship6);
                friendship3.setConversation(new ArrayList<>());
                friendship5.setConversation(new ArrayList<>());
                friendship6.setConversation(new ArrayList<>());
            }
        }
    }

    private void addDefaultItems(User user) {
        user.setQuest(new HashMap<>());
        user.setEnergy(10000);
        user.setFriendsNpc(new HashMap<>());
        Item item = new Item(ItemType.WOOD);
        item.setPrice(10);
        user.getBackPack().addItemToInventory(item, 200);
        Item item2 = new Item(ItemType.GOLD_BAR);
        item2.setPrice(3000);
        user.getBackPack().addItemToInventory(item2, 20);
        Item item3 = new Item(ItemType.KEG_RECIPE);
        item3.setPrice(450);
        user.getBackPack().addItemToInventory(item3, 20);
        Item item4 = new Item(ItemType.LOOM_RECIPE);
        item4.setPrice(500);
        user.getBackPack().addItemToInventory(item4, 20);
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
        if (player1 == null) {
            return new Result(false, "Username not found (player1)");
        }if (player2 == null) {
            return new Result(false, "Username not found (player2)");
        }
        if (player3 == null) {
            return new Result(false, "Username not found (player3)");
        }


        GameMap map = new GameMap();
        currentGameModel = new GameModel(mainUser, map);
        currentGameModel.playersInGame.add(player0);
        currentGameModel.playersInGame.add(player1);
        player1.setGender("female");
        if (player2 != null) currentGameModel.playersInGame.add(player2);
        if (player3 != null) currentGameModel.playersInGame.add(player3);
        map.BuildFarm(Map1, Map2, Map3);
        map.BuildMap();
        setFriendships(map);
        setDefaultGameItems(map);
        for (User user : App.getCurrentGameModel().playersInGame) {
            user.setSprite(new Sprite(new Texture(Gdx.files.internal("walk/Alex_01.png"))));
            user.setCollisionRect(new CollisionRect(user.getFarm().getCollisionRect().getX() + 150,
                user.getFarm().getCollisionRect().getY() + 150, user.getSprite().getWidth(), user.getSprite().getHeight()));
            user.setLocation(new Location((int) (user.getFarm().getCollisionRect().getY() + 150), (int) (user.getFarm().getCollisionRect().getX() + 150)));
        }

        return new Result(true, "Game has been created successfully!");
    }

    public void setDefaultGameItems(GameMap map) {
        for (User user : currentGameModel.playersInGame) {
            addDefaultItems(user);
            for (Npc npc : map.getVillage().getNpss().values()) {
                NpcFriendship friendship = new NpcFriendship(user, npc);
                user.getFriendsNpc().put(npc.getType().getDisplayName(), friendship);
                for (Quest quest : npc.getType().getQuests().values()) {
                    quest.setNpc(npc);
                }

            }
        }
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

