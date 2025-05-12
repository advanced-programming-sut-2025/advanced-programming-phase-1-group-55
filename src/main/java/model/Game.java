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


import java.util.List;

public class Game {
    public User currentUser;
    public HashMap<String, User> playersInGame = new HashMap<>();
    private GameMap map;

    public Game(User currentUser, HashMap<String, User> playersInGame, GameMap map) {
        this.currentUser = currentUser;
        this.playersInGame = playersInGame;
        this.map = map;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public HashMap<String, User> getPlayersInGame() {
        return playersInGame;
    }

    public void setPlayersInGame(HashMap<String, User> playersInGame) {
        this.playersInGame = playersInGame;
    }

    public GameMap getMap() {
        return map;
    }

    public void setMap(GameMap map) {
        this.map = map;
    }


}
