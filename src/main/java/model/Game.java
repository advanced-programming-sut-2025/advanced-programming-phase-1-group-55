package model;

import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;
import enums.*;


import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.*;


import com.google.gson.GsonBuilder;

import enums.Menu;
import model.Map.GameMap;
import model.Map.Tile;

import static model.GameTime.*;


import java.util.List;

public class Game {
    public User currentUser;
    public ArrayList<User> playersInGame = new ArrayList<>();
    private GameMap map;

    public Game(User currentUser, ArrayList<User> playersInGame, GameMap map) {
        this.currentUser = currentUser;
        this.playersInGame = playersInGame;
        this.map = map;
    }

    private int turnCounter = 0;

    public int getTurnCounter() {
        return turnCounter;
    }

    public void setTurnCounter(int turnCounter) {
        this.turnCounter = turnCounter;
    }

    public void nextTurn() {
        currentUser = playersInGame.get((++turnCounter) % playersInGame.size());
        System.out.println("player " + turnCounter % playersInGame.size() + " : " + currentUser.getUsername());

        if ((turnCounter) % playersInGame.size() == 0) {
            increaseHour(1);
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


    public Tile getTileFromDirection(String direction) {
        User user = App.currentGame.currentUser;
        int currentX = user.getLocation().getX();
        int currentY = user.getLocation().getY();

        int dx = 0;
        int dy = 0;

        direction = direction.toLowerCase();

        switch (direction) {
            case "up":
                dy = 1;
                break;
            case "down":
                dy = -1;
                break;
            case "left":
                dx = -1;
                break;
            case "right":
                dx = 1;
                break;
            case "up-left":
                dx = -1;
                dy = 1;
                break;
            case "up-right":
                dx = 1;
                dy = 1;
                break;
            case "down-left":
                dx = -1;
                dy = -1;
                break;
            case "down-right":
                dx = 1;
                dy = -1;
                break;
            default:
                return null;
        }

        int newX = currentX + dx;
        int newY = currentY + dy;

        return App.currentGame.getMap().tiles[newX][newY];
    }


}
