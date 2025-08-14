package com.StardewValley.Common;

import com.StardewValley.Common.model.Friendship.Message;
import com.StardewValley.Server.connection.ClientConnection;

import java.util.ArrayList;
import java.util.HashMap;

public class GameDetails {
    private static int availableId = 0;

    private String adminUsername;
    private HashMap<String, PlayerDetails> players;
    private transient ArrayList<ClientConnection> connections;
    private int gameId;
    private boolean isRunning;
    private  transient ArrayList<Message> publicGameChat=new ArrayList<>();

    public GameDetails(ArrayList<String> usernames, String adminUsername) {
        players = new HashMap<>();
        for (String username : usernames) {
            players.put(username, new PlayerDetails(username));
        }
        this.adminUsername = adminUsername;
        this.gameId = availableId++;
        this.isRunning = true;
    }

    public GameDetails() {}

    public void sendGameDetails() {
        String json = ConnectionMessage.gameDetailsToJson(this);
        ConnectionMessage update = new ConnectionMessage(new HashMap<>() {{
            put("update", "update_game");
            put("json", json);
            put("game_code", gameId);
        }}, ConnectionMessage.Type.update);
        for(ClientConnection connection : connections) {
            if(connection.isAlive()) {
                connection.sendMessage(update);
            }
        }
    }

    public PlayerDetails getPlayerByUsername(String username) {
        return players.get(username);
    }

    public void putPlayerByUsername(String username, PlayerDetails player) {
        players.put(username, player);
    }

    public HashMap<String, PlayerDetails> getPlayers() {
        return players;
    }

    public int getGameId() {
        return gameId;
    }

    public ArrayList<ClientConnection> getConnections() {
        return connections;
    }

    public void setConnections(ArrayList<ClientConnection> connections) {
        this.connections = connections;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public ArrayList<Message> getPublicGameChat() {
        return publicGameChat;
    }

    public void setPublicGameChat(ArrayList<Message> publicGameChat) {
        this.publicGameChat = publicGameChat;
    }
}
