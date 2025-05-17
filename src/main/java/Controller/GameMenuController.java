package Controller;

import enums.Menu;
import enums.mainGameCommands;
import model.App;
import model.Friendship.FriendShip;
import model.Friendship.PlayerFriendship;
import model.Game;
import model.Item.Item;
import model.Item.ItemType;
import model.Map.*;
import model.Result;
import model.Tool.BackPack;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;

import static javax.swing.UIManager.put;
import static model.App.*;


public class GameMenuController {
    private void setFriendships(GameMap map){
        PlayerFriendship friendship1=new PlayerFriendship(currentGame.playersInGame.get(0),currentGame.playersInGame.get(1));
        PlayerFriendship friendship2=new PlayerFriendship(currentGame.playersInGame.get(0),currentGame.playersInGame.get(2));
        PlayerFriendship friendship3=new PlayerFriendship(currentGame.playersInGame.get(0),currentGame.playersInGame.get(3));
        PlayerFriendship friendship4=new PlayerFriendship(currentGame.playersInGame.get(1),currentGame.playersInGame.get(2));
        PlayerFriendship friendship5=new PlayerFriendship(currentGame.playersInGame.get(1),currentGame.playersInGame.get(3));
        PlayerFriendship friendship6=new PlayerFriendship(currentGame.playersInGame.get(2),currentGame.playersInGame.get(3));
        currentGame.playersInGame.get(0).getFriendsPlayer().put(currentGame.playersInGame.get(1),friendship1);
        currentGame.playersInGame.get(1).getFriendsPlayer().put(currentGame.playersInGame.get(0),friendship1);
        currentGame.playersInGame.get(0).getFriendsPlayer().put(currentGame.playersInGame.get(2),friendship2);
        currentGame.playersInGame.get(2).getFriendsPlayer().put(currentGame.playersInGame.get(0),friendship2);
        currentGame.playersInGame.get(0).getFriendsPlayer().put(currentGame.playersInGame.get(3),friendship3);
        currentGame.playersInGame.get(3).getFriendsPlayer().put(currentGame.playersInGame.get(0),friendship3);
        currentGame.playersInGame.get(1).getFriendsPlayer().put(currentGame.playersInGame.get(2),friendship4);
        currentGame.playersInGame.get(2).getFriendsPlayer().put(currentGame.playersInGame.get(1),friendship4);
        currentGame.playersInGame.get(1).getFriendsPlayer().put(currentGame.playersInGame.get(3),friendship5);
        currentGame.playersInGame.get(3).getFriendsPlayer().put(currentGame.playersInGame.get(1),friendship5);
        currentGame.playersInGame.get(2).getFriendsPlayer().put(currentGame.playersInGame.get(3),friendship6);
        currentGame.playersInGame.get(3).getFriendsPlayer().put(currentGame.playersInGame.get(2),friendship6);
        currentGame.getAllFriendships().add(friendship1);
        currentGame.getAllFriendships().add(friendship2);
        currentGame.getAllFriendships().add(friendship3);
        currentGame.getAllFriendships().add(friendship4);
        currentGame.getAllFriendships().add(friendship5);
        currentGame.getAllFriendships().add(friendship6);
        friendship1.setConversation(new ArrayList<>());
        friendship2.setConversation(new ArrayList<>());
        friendship3.setConversation(new ArrayList<>());
        friendship4.setConversation(new ArrayList<>());
        friendship5.setConversation(new ArrayList<>());
        friendship6.setConversation(new ArrayList<>());
        for(User user:currentGame.playersInGame){
            user.setQuest(new HashMap<>());
            user.setFriendsNpc(new HashMap<>());
            for (Npc npc:map.getVillage().getNpss().values()){
                NpcFriendship friendship=new NpcFriendship(user,npc);
                user.getFriendsNpc().put(npc.getType().getDisplayName(),friendship);
                for (Quest quest:npc.getType().getQuests().values()){
                    quest.setNpc(npc);
                    if (quest.getLevel()==1){
                        user.getQuest().put(quest.getId(),quest);
                    }
                }
            }
        }

    }
    public void setTileOwner(User user, Farm farm, GameMap map) {
//        System.out.println(user.getUsername() + mainUser.getUsername());
//        System.out.println(farm.getLocation().toString());
//        System.out.println(farm.getHeight());
//        System.out.println(farm.getWidth());
        for (int i = farm.getLocation().getY(); i < farm.getWidth() + farm.getLocation().getY(); i++) {
            for (int j = farm.getLocation().getX(); j < farm.getHeight() + farm.getLocation().getX(); j++) {
//                System.out.println(i + "  " + j);
                map.tiles[i][j].setOwner(user);
            }
        }
    }

    //todo gereftan mazrae va map az player haa va pass dadn be mapbuilder
    public Result newGame(String Username1, String Username2, String Username3) {
        //todo error hash ro bezan
        if (AllUsers.get(Username1) == null || AllUsers.get(Username2) == null || AllUsers.get(Username3) == null) {
            return new Result(false, "Username is not correct");
        } else if (Username1 == null) {
            return new Result(false, "Username is empty you should at least add one user");
        }

        //todo agar bishtar az se nam karbari dashtim
        ArrayList<User> playersInGame = new ArrayList<>();
        farmBuilder fb = new farmBuilder();
        mapBuilder mb = new mapBuilder();
        GameMap Map = fb.mapCreator();
        fb.fillFarmTiles(Map, Map.getFarm1());
        fb.fillFarmTiles(Map, Map.getFarm2());
        fb.fillFarmTiles(Map, Map.getFarm3());
        fb.fillFarmTiles(Map, Map.getFarm4());
        mb.fillOtherTiles(Map);
        User Player0 = mainUser;
        User Player1 = AllUsers.get(Username1);
        playersInGame.add(Player0);
        playersInGame.add(Player1);
        User Player2 = null;
        User Player3 = null;
        int numberOFPlayers = 1;
        numberOFPlayers++;
        if (Username2 != null) {
            numberOFPlayers++;
            Player2 = AllUsers.get(Username2);
            playersInGame.add(Player2);


        }
        if (Username3 != null) {
            numberOFPlayers++;
            Player3 = AllUsers.get(Username3);
            playersInGame.add(Player3);


        }
        boolean farm1IsOwned = false;
        boolean farm2IsOwned = false;
        System.out.println("choose number of map for players : ");
        int mapNumber;
        for (int i = 0; i < numberOFPlayers; i++) {
            String input = scanner.nextLine();
            Matcher chooseMap = mainGameCommands.chooseMap.getMatcher(input);
            if (chooseMap == null) {
                return new Result(false, "incorrect format for map selecting ");
            } else {

                try {
                    mapNumber = Integer.parseInt(chooseMap.group("X"));
                    if (mapNumber > 2 || mapNumber < 1) {
                        return new Result(false, "Invalid map number");
                    }
                } catch (Exception e) {
                    return new Result(false, "Invalid map number");

                }
            }
            if (i == 0 && mapNumber == 1) {
                Player0.setFarm(fb.getFarm1());
                farm1IsOwned = true;
                Player0.setLocation(new Location(Player0.getFarm().getLocation().getY() + 1, Player0.getFarm().getLocation().getX() + 1));
                setTileOwner(Player0, Player0.getFarm(), Map);
            } else if (i == 0) {
                Player0.setFarm(fb.getFarm2());
                farm2IsOwned = true;
                Player0.setLocation(new Location(Player0.getFarm().getLocation().getY() + 1, Player0.getFarm().getLocation().getX() + 1));
                setTileOwner(Player0, Player0.getFarm(), Map);
            }
            if (i == 1 && mapNumber == 1) {
                if (!farm1IsOwned) {
                    Player1.setFarm(fb.getFarm1());
                } else {

                    Player1.setFarm(fb.getFarm1_copy());
                }

                Player1.setLocation(new Location(Player1.getFarm().getLocation().getY() + 1, Player1.getFarm().getLocation().getX() + 1));
                setTileOwner(Player1, Player1.getFarm(), Map);

            } else if (i == 1) {
                if (!farm2IsOwned) {
                    Player1.setFarm(fb.getFarm2());
                } else {

                    Player1.setFarm(fb.getFarm2_copy());
                }

                Player1.setLocation(new Location(Player1.getFarm().getLocation().getY() + 1, Player1.getFarm().getLocation().getX() + 1));
                setTileOwner(Player1, Player1.getFarm(), Map);
            }
            if (i == 2 && mapNumber == 1) {
                assert Player2 != null;
                if (!farm1IsOwned) {
                    Player2.setFarm(fb.getFarm1());
                } else {

                    Player2.setFarm(fb.getFarm1_copy());
                }

                Player2.setLocation(new Location(Player2.getFarm().getLocation().getY() + 1, Player2.getFarm().getLocation().getX() + 1));
                setTileOwner(Player2, Player2.getFarm(), Map);
            } else if (i == 2) {
                assert Player2 != null;
                if (!farm2IsOwned) {
                    Player2.setFarm(fb.getFarm2());
                } else {

                    Player2.setFarm(fb.getFarm2_copy());
                }

                Player2.setLocation(new Location(Player2.getFarm().getLocation().getY() + 1, Player2.getFarm().getLocation().getX() + 1));
                setTileOwner(Player2, Player2.getFarm(), Map);
            }
            if (i == 3 && mapNumber == 1) {

                assert Player3 != null;
                if (!farm1IsOwned) {
                    Player3.setFarm(fb.getFarm1());
                } else {

                    Player3.setFarm(fb.getFarm1_copy());
                }

                Player3.setLocation(new Location(Player3.getFarm().getLocation().getY() + 1, Player3.getFarm().getLocation().getX() + 1));
                setTileOwner(Player3, Player3.getFarm(), Map);
            } else if (i == 3) {
                assert Player3 != null;
                if (!farm1IsOwned) {
                    Player3.setFarm(fb.getFarm2());
                } else {

                    Player3.setFarm(fb.getFarm2_copy());
                }

                Player3.setLocation(new Location(Player3.getFarm().getLocation().getY() + 1, Player3.getFarm().getLocation().getX() + 1));
                setTileOwner(Player3, Player3.getFarm(), Map);
            }


        }


        currentGame = new Game(mainUser, playersInGame, Map);
        currentMenu = Menu.MainGameMenu;

        for (User player : playersInGame) {
            player.setBackPack(new BackPack());
            player.getBackPack().getInventory().put("maple seed", new Item(ItemType.getItemType("maple seed")));
            player.getBackPack().getInventory().get("maple seed").setNumber(100);
            player.setDailyMoney(0);
        }

        setFriendships(Map);
        return new Result(true, "game has created successfully !");
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
