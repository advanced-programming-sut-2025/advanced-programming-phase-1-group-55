package com.StardewValley.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import com.StardewValley.model.Friendship.PlayerFriendship;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.Map.GameMap;
import com.StardewValley.model.Map.Tile;
import com.StardewValley.model.NPC.Dialog;

import static com.StardewValley.model.GameTime.*;

public class GameModel implements Serializable {
    private static final long serialVersionUID = 1L;

    public User currentUser;
    public ArrayList<User> playersInGame = new ArrayList<>();
    public GameMap map;
    public ArrayList<PlayerFriendship> allFriendships = new ArrayList<>();
    public HashMap<Integer, Trade> allTrades = new HashMap<>();
    public HashMap<String, Item> allPlants = new HashMap<>();
    public int numberOfAllGifts = 0;
    public int turnCounter = 0;
    public final List<Dialog> allDialogs = new ArrayList<>(Arrays.asList(Dialog.values()));

    public GameModel(User currentUser, GameMap map) {
        this.currentUser = currentUser;
        this.map = map;
    }


    public void saveToFile(Path path) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path))) {
            out.writeObject(this);
        }
    }

    public static GameModel loadFromFile(Path path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))) {
            return (GameModel) in.readObject();
        }
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
        return allTrades;
    }

    public void setAllTrades(HashMap<Integer, Trade> allTrades) {
        this.allTrades = allTrades;
    }

    public void addToAllTrade(Trade trade) {
        allTrades.put(trade.getId(), trade);
    }

    public HashMap<String, Item> getAllPlants() {
        return allPlants;
    }

    public void setAllPlants(HashMap<String, Item> allPlants) {
        this.allPlants = allPlants;
    }

    public int getNumberOfAllGifts() {
        return numberOfAllGifts;
    }

    public void setNumberOfAllGifts(int numberOfAllGifts) {
        this.numberOfAllGifts = numberOfAllGifts;
    }

    public void increaseNumberOfGifts() {
        numberOfAllGifts++;
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    public void setTurnCounter(int turnCounter) {
        this.turnCounter = turnCounter;
    }

    public List<Dialog> getAllDialogs() {
        return allDialogs;
    }


//    public void nextTurn() {
//        currentUser = playersInGame.get((++turnCounter) % playersInGame.size());
//
//        if (currentUser.isFainted()) {
//            nextTurn();
//            return;
//        }
//
//        System.out.println("Player " + (turnCounter % playersInGame.size()) + " : " + currentUser.getUsername());
//
//        if ((turnCounter) % playersInGame.size() == 0) {
//            increaseHour(1);
//        }
//    }

//
//    public Tile getTileFromDirection(String direction) {
//        int currentX = currentUser.getLocation().getX();
//        int currentY = currentUser.getLocation().getY();
//
//        int dx = 0;
//        int dy = 0;
//
//        switch (direction.toLowerCase()) {
//            case "up" -> dy = 1;
//            case "down" -> dy = -1;
//            case "left" -> dx = -1;
//            case "right" -> dx = 1;
//            case "up-left" -> { dx = -1; dy = 1; }
//            case "up-right" -> { dx = 1; dy = 1; }
//            case "down-left" -> { dx = -1; dy = -1; }
//            case "down-right" -> { dx = 1; dy = -1; }
//            default -> { return null; }
//        }
//
//        int newX = currentX + dx;
//        int newY = currentY + dy;
//
//        return map.tiles[newX][newY];
//    }
}
