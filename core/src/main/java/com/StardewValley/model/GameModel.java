package com.StardewValley.model;


import java.util.*;


import com.StardewValley.model.Friendship.PlayerFriendship;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.Map.GameMap;
import com.StardewValley.model.Map.Tile;
import com.StardewValley.model.NPC.Dialog;

import static com.StardewValley.model.GameTime.*;

import com.google.gson.annotations.Expose;

import java.util.*;

import java.util.List;

public class GameModel {
    @Expose
    public User currentUser;

    @Expose
    public ArrayList<User> playersInGame = new ArrayList<>();

//    @Expose
    private GameMap map;

//    @Expose
    private ArrayList<PlayerFriendship> allFriendships = new ArrayList<>();

//    @Expose
    private HashMap<Integer, Trade> AllTrades = new HashMap<>();
    private int numberOfAllGifts = 0;
    private final List<Dialog> allDialogs = new ArrayList<>(Arrays.asList(Dialog.values()));

    public GameModel(User currentUser, GameMap map) {
        this.currentUser = currentUser;
        this.map = map;
    }

    private HashMap<String, Item> AllPlants = new HashMap<>();

    public HashMap<String, Item> getAllPlants() {
        return AllPlants;
    }

    public void setAllPlants(HashMap<String, Item> allPlants) {
        AllPlants = allPlants;
    }

    private int turnCounter = 0;

    public int getTurnCounter() {
        return turnCounter;
    }

    public void increaseNumberOfGifts() {
        numberOfAllGifts++;
    }

    public void setTurnCounter(int turnCounter) {
        this.turnCounter = turnCounter;
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

    public void setAllFriendships(ArrayList<PlayerFriendship> allFriendships) {
        this.allFriendships = allFriendships;
    }

    public HashMap<Integer, Trade> getAllTrades() {
        return AllTrades;
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

    public void setNumberOfAllGifts(int numberOfAllGifts) {
        this.numberOfAllGifts = numberOfAllGifts;
    }

    public List<Dialog> getAllDialogs() {
        return allDialogs;
    }
}
