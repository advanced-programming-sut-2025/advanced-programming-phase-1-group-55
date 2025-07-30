package com.StardewValley.Controller;

import com.StardewValley.enums.Menu;
import com.StardewValley.enums.mainGameCommands;
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
//    private void setFriendships(GameMap map) {
//        PlayerFriendship friendship1 = new PlayerFriendship(currentGameModel.playersInGame.get(0), currentGameModel.playersInGame.get(1));
//        PlayerFriendship friendship2 = new PlayerFriendship(currentGameModel.playersInGame.get(0), currentGameModel.playersInGame.get(2));
//        PlayerFriendship friendship3 = new PlayerFriendship(currentGameModel.playersInGame.get(0), currentGameModel.playersInGame.get(3));
//        PlayerFriendship friendship4 = new PlayerFriendship(currentGameModel.playersInGame.get(1), currentGameModel.playersInGame.get(2));
//        PlayerFriendship friendship5 = new PlayerFriendship(currentGameModel.playersInGame.get(1), currentGameModel.playersInGame.get(3));
//        PlayerFriendship friendship6 = new PlayerFriendship(currentGameModel.playersInGame.get(2), currentGameModel.playersInGame.get(3));
//        currentGameModel.playersInGame.get(0).getFriendsPlayer().put(currentGameModel.playersInGame.get(1), friendship1);
//        currentGameModel.playersInGame.get(1).getFriendsPlayer().put(currentGameModel.playersInGame.get(0), friendship1);
//        currentGameModel.playersInGame.get(0).getFriendsPlayer().put(currentGameModel.playersInGame.get(2), friendship2);
//        currentGameModel.playersInGame.get(2).getFriendsPlayer().put(currentGameModel.playersInGame.get(0), friendship2);
//        currentGameModel.playersInGame.get(0).getFriendsPlayer().put(currentGameModel.playersInGame.get(3), friendship3);
//        currentGameModel.playersInGame.get(3).getFriendsPlayer().put(currentGameModel.playersInGame.get(0), friendship3);
//        currentGameModel.playersInGame.get(1).getFriendsPlayer().put(currentGameModel.playersInGame.get(2), friendship4);
//        currentGameModel.playersInGame.get(2).getFriendsPlayer().put(currentGameModel.playersInGame.get(1), friendship4);
//        currentGameModel.playersInGame.get(1).getFriendsPlayer().put(currentGameModel.playersInGame.get(3), friendship5);
//        currentGameModel.playersInGame.get(3).getFriendsPlayer().put(currentGameModel.playersInGame.get(1), friendship5);
//        currentGameModel.playersInGame.get(2).getFriendsPlayer().put(currentGameModel.playersInGame.get(3), friendship6);
//        currentGameModel.playersInGame.get(3).getFriendsPlayer().put(currentGameModel.playersInGame.get(2), friendship6);
//        currentGameModel.getAllFriendships().add(friendship1);
//        currentGameModel.getAllFriendships().add(friendship2);
//        currentGameModel.getAllFriendships().add(friendship3);
//        currentGameModel.getAllFriendships().add(friendship4);
//        currentGameModel.getAllFriendships().add(friendship5);
//        currentGameModel.getAllFriendships().add(friendship6);
//        friendship1.setConversation(new ArrayList<>());
//        friendship2.setConversation(new ArrayList<>());
//        friendship3.setConversation(new ArrayList<>());
//        friendship4.setConversation(new ArrayList<>());
//        friendship5.setConversation(new ArrayList<>());
//        friendship6.setConversation(new ArrayList<>());
//        for (User user : currentGameModel.playersInGame) {
//            user.setQuest(new HashMap<>());
//            user.setFriendsNpc(new HashMap<>());
//            for (Npc npc : map.getVillage().getNpss().values()) {
//                NpcFriendship friendship = new NpcFriendship(user, npc);
//                user.getFriendsNpc().put(npc.getType().getDisplayName(), friendship);
//                for (Quest quest : npc.getType().getQuests().values()) {
//                    quest.setNpc(npc);
//                    if (quest.getLevel() == 1) {
//                        user.getQuest().put(quest.getId(), quest);
//                    }
//                }
//            }
//        }
//
//    }

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

        ArrayList<User> playersInGame = new ArrayList<>();
        FarmBuilder fb = new FarmBuilder();
        MapBuilder mb = new MapBuilder();
        GameMap Map = fb.mapCreator();

        fb.fillFarmTiles(Map, Map.getFarm1());
        fb.fillFarmTiles(Map, Map.getFarm2());
        fb.fillFarmTiles(Map, Map.getFarm3());
        fb.fillFarmTiles(Map, Map.getFarm4());
        mb.fillOtherTiles(Map);

        User Player0 = mainUser;
        User Player1 = AllUsers.get(Username1);
        User Player2 = Username2 != null ? AllUsers.get(Username2) : null;
        User Player3 = Username3 != null ? AllUsers.get(Username3) : null;

        playersInGame.add(Player0);
        playersInGame.add(Player1);
        if (Player2 != null) playersInGame.add(Player2);
        if (Player3 != null) playersInGame.add(Player3);

        assignFarmToPlayer(Player0, Map1, fb, Map);
        assignFarmToPlayer(Player1, Map2, fb, Map);
        if (Player2 != null) assignFarmToPlayer(Player2, Map3, fb, Map);
        if (Player3 != null) assignFarmToPlayer(Player3, "Map1", fb, Map);

        currentGameModel = new GameModel(mainUser, playersInGame, Map);
        currentMenu = Menu.MainGameMenu;

        for (User player : playersInGame) {
            player.setBackPack(new BackPack());
            Item item = new Item(ItemType.getItemType("Coal"));
            item.setPrice(150);
            item.setNumber(100);
            player.getBackPack().getInventory().put("Coal", item);
            player.setDailyMoney(0);
        }

//        setFriendships(Map);
        return new Result(true, "Game has been created successfully!");
    }


    private void assignFarmToPlayer(User player, String mapName, FarmBuilder fb, GameMap map) {
        if (mapName == null) mapName = "Map1";

        switch (mapName) {
            case "Map1":
                player.setFarm(fb.getFarm1());
                break;
            case "Map2":
                player.setFarm(fb.getFarm2());
                break;
//            case "Map3":
//                player.setFarm(fb.getFarm3());
//                break;
//            case "Map4":
//                player.setFarm(fb.getFarm4());
//                break;
            default:
                player.setFarm(fb.getFarm1());
                break;
        }

        player.setLocation(new Location(
            player.getFarm().getLocation().getY() + 1,
            player.getFarm().getLocation().getX() + 1
        ));

        setTileOwner(player, player.getFarm(), map);
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
