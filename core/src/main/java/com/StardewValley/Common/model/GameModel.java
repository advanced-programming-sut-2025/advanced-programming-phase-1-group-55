package com.StardewValley.Common.model;


import java.io.Serializable;
import java.util.*;


import com.StardewValley.Common.model.Friendship.PlayerFriendship;
import com.StardewValley.Common.model.Map.GameMap;
import com.StardewValley.Common.model.NPC.Dialog;


import java.util.List;

public class GameModel implements Serializable {
    public User currentUser;
    public ArrayList<User> playersInGame = new ArrayList<>();
    private GameMap map;
    private ArrayList<PlayerFriendship> allFriendships = new ArrayList<>();
    private HashMap<Integer, Trade> AllTrades = new HashMap<>();
    private int numberOfAllGifts = 0;
    private final List<Dialog> allDialogs = new ArrayList<>(Arrays.asList(Dialog.values()));

    public GameModel(User currentUser, GameMap map) {
        this.currentUser = currentUser;
        this.map = map;
    }

    private int turnCounter = 0;


    public void increaseNumberOfGifts() {
        numberOfAllGifts++;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public ArrayList<User> getPlayersInGame() {
        return playersInGame;
    }

    public void setPlayersInGame(ArrayList<User> playersInGame) {
        this.playersInGame = playersInGame;
    }

    public GameMap getMap() {
        return map;
    }

    public void setMap(GameMap map) {
        this.map = map;
    }

    public ArrayList<PlayerFriendship> getAllFriendships() {
        return allFriendships;
    }



    public void setAllTrades(HashMap<Integer, Trade> allTrades) {
        AllTrades = allTrades;
    }

    public void addToAllTrade(Trade trade) {
        AllTrades.put(trade.getId(), trade);
    }

    public int getNumberOfAllGifts() {
        return numberOfAllGifts;
    }
}
