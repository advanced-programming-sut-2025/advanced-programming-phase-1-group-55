package com.StardewValley.Server.connection;

import com.StardewValley.Client.ClientData;
import com.StardewValley.Client.ServerConnection;
import com.StardewValley.Common.ConnectionMessage;
import com.StardewValley.Common.GameDetails;
import com.StardewValley.Common.Lobby;
import com.StardewValley.Common.PlayerDetails;
import com.StardewValley.Common.model.App;
import com.StardewValley.Common.model.Chat.Emoji;
import com.StardewValley.Common.model.Chat.Message;

import com.StardewValley.Common.model.Trade;
import com.StardewValley.Common.model.User;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class ClientConnectionController {
    private ClientConnection connection;

    public ClientConnectionController(ClientConnection connection) {
        this.connection = connection;
    }

    public void updateEmoji(ConnectionMessage message) {
        Emoji emoji = ConnectionMessage.emojiFromJson(message.getFromBody("json"));
        PlayerDetails playerDetails = connection.getGame().getPlayers().get(message.getFromBody("sender"));
        playerDetails.emoji = emoji;
        String json = ConnectionMessage.emojiToJson(emoji);
        ConnectionMessage update = new ConnectionMessage(new HashMap<>() {{
            put("update", "update_emoji");
            put("json", json);
            put("sender", message.getFromBody("sender"));
        }}, ConnectionMessage.Type.update);
        for (ClientConnection connection : ServerMain.getConnections()) {
            if (connection.isAlive()) {
                connection.sendMessage(update);
            }
        }

    }

    public void updatePublicChat(ConnectionMessage message) {
        Message messageToUpdate = new Message(message.getFromBody("text"), message.getFromBody("sender"));
        messageToUpdate.setText(messageToUpdate.getSender() + ": " + messageToUpdate.getText());
        connection.getGame().getPublicGameChat().add(messageToUpdate);

        sendUpdatedChatToAll(messageToUpdate);
    }

    public void handleTradeRequest(ConnectionMessage message) {
        String tradeJson = message.getFromBody("trade");

        Trade trade = ConnectionMessage.tradeFromJson(tradeJson);

        connection.getGame().getTrades().add(trade);

        ConnectionMessage notifyReceiver = new ConnectionMessage(new HashMap<>() {{
            put("information", "receive_trade_request");
            put("trade", tradeJson);
        }}, ConnectionMessage.Type.inform);

        for (ClientConnection connection : ServerMain.getConnections()) {
            System.err.println("username:: " + connection.getUsername());
            if (connection.isAlive()) {
                connection.sendMessage(notifyReceiver);
            }
        }
    }

    public void handleTradeAcceptance(ConnectionMessage message) {
        String tradeJson = message.getFromBody("trade");
        Trade acceptedTrade = ConnectionMessage.tradeFromJson(tradeJson);

        for (Trade t : connection.getGame().getTrades()) {
            if (t.getId() == acceptedTrade.getId()) {
                t.setAccepted(true);
                break;
            }
        }

        ConnectionMessage notifySenderAndReceiver = new ConnectionMessage(new HashMap<>() {{
            put("information", "trade_accepted");
            put("trade", tradeJson);
        }}, ConnectionMessage.Type.inform);

        for (ClientConnection connection : ServerMain.getConnections()) {
            if (connection.isAlive()) {
                connection.sendMessage(notifySenderAndReceiver);
            }
        }

    }

    public void handleSaveGameRequest() {


        GameDetails gameToSave = connection.getGame();
        if (gameToSave == null) {
            System.err.println("game null ");
            return;
        }

        try {
            String json = ConnectionMessage.gameDetailsToJson(gameToSave);

            Path savePath = Path.of("saved_games", "game.json");

            Files.createDirectories(savePath.getParent());

            Files.writeString(savePath, json);

            System.out.println("Game " + gameToSave.getGameId() + " saved successfully.");

            ConnectionMessage notifyClients = new ConnectionMessage(new HashMap<>() {{
                put("information", "game_saved");
                put("gameId", gameToSave.getGameId());
            }}, ConnectionMessage.Type.inform);

            for (ClientConnection conn : ServerMain.getConnections()) {
                if (conn.isAlive()) {
                    conn.sendMessage(notifyClients);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void sendUpdatedChatToAll(Message message) {
        String json = ConnectionMessage.messageToJson(message);
        ConnectionMessage update = new ConnectionMessage(new HashMap<>() {{
            put("update", "update_chat");
            put("json", json);
        }}, ConnectionMessage.Type.update);

        for (ClientConnection connection : ServerMain.getConnections()) {
            if (connection.isAlive()) {
                connection.sendMessage(update);
            }
        }
    }

    public void getUser(ConnectionMessage message) {
        String username = message.getFromBody("username");
        User user = App.getAllUsers().get(username);
        ConnectionMessage response;
        if (user == null) {
            response = new ConnectionMessage(new HashMap<>() {{
                put("response", "not_found");
            }}, ConnectionMessage.Type.response);
        } else {
            response = new ConnectionMessage(new HashMap<>() {{
                put("response", "ok");
                put("user", ConnectionMessage.userToJson(user));
            }}, ConnectionMessage.Type.response);
        }

        connection.sendMessage(response);
    }

    public void informLogin(ConnectionMessage message) {
        String username = message.getFromBody("username");
        System.out.println(username);
        System.out.println("12345678");
        connection.setUsername(username);
    }

    public void informLogout(ConnectionMessage message) {
        connection.setUsername("");
    }

    public void sendLobbies(ConnectionMessage message) {
        ArrayList<String> lobbiesJson = new ArrayList<>();
        for (Lobby lobby : ServerMain.getLobbies()) {
            lobbiesJson.add(ConnectionMessage.lobbyToJson(lobby));
        }
        ConnectionMessage response = new ConnectionMessage(new HashMap<>() {{
            put("response", "ok");
            put("lobbies", lobbiesJson);
        }}, ConnectionMessage.Type.response);

        connection.sendMessage(response);
    }

    public void createLobby(ConnectionMessage message) {
        String name = message.getFromBody("name");
        Boolean isPrivate = message.getFromBody("isPrivate");
        String password = message.getFromBody("password");
        Boolean isVisible = message.getFromBody("isVisible");

        ConnectionMessage response;
        for (Lobby lobby : ServerMain.getLobbies()) {
            if (lobby.getName().equals(name)) {
                response = new ConnectionMessage(new HashMap<>() {{
                    put("response", "not_available_name");
                }}, ConnectionMessage.Type.response);

                connection.sendMessage(response);
                return;
            }
        }
        Lobby lobby = new Lobby(name, connection.getUsername(), isPrivate, password, isVisible);
        ServerMain.addLobby(lobby);
        connection.setLobbyCode(lobby.getCode());

        response = new ConnectionMessage(new HashMap<>() {{
            put("response", "ok");
            put("code", lobby.getCode());
        }}, ConnectionMessage.Type.response);

        connection.sendMessage(response);
    }

    public void joinLobby(ConnectionMessage message) {
        String code = message.getFromBody("code");
        String password = message.getFromBody("password");
        String username = connection.getUsername();
        String error = "";
        Lobby lobby = ServerMain.getLobbyByCode(code);
        if (!connection.getLobbyCode().isEmpty()) {
            error = "you are already in a lobby";
        } else if (lobby == null) {
            error = "lobby not found";
        } else if (lobby.getMembers().size() >= 4) {
            error = "lobby is already full";
        } else if (lobby.isPrivate() && !lobby.getPassword().equals(password)) {
            error = "passwords do not match";
        }

        ConnectionMessage response;
        if (error.isEmpty()) {
            lobby.addMember(username);
            connection.setLobbyCode(code);
            response = new ConnectionMessage(new HashMap<>() {{
                put("response", "ok");
            }}, ConnectionMessage.Type.response);
        } else {
            String finalError = error;
            response = new ConnectionMessage(new HashMap<>() {{
                put("response", "error");
                put("error", finalError);
            }}, ConnectionMessage.Type.response);

        }

        connection.sendMessage(response);
    }

    public void leaveLobby(ConnectionMessage message) {
        String code = connection.getLobbyCode();
        String username = connection.getUsername();
        String error = "";
        Lobby lobby = ServerMain.getLobbyByCode(code);
        if (code.isEmpty()) {
            error = "you are not in a lobby";
        }

        ConnectionMessage response;
        if (error.isEmpty()) {
            lobby.removeMember(username);
            connection.setLobbyCode("");
            response = new ConnectionMessage(new HashMap<>() {{
                put("response", "ok");
            }}, ConnectionMessage.Type.response);
        } else {
            String finalError = error;
            response = new ConnectionMessage(new HashMap<>() {{
                put("response", "error");
                put("error", finalError);
            }}, ConnectionMessage.Type.response);
        }

        connection.sendMessage(response);

    }

    public void informLobbyTermination() {
        ConnectionMessage message = new ConnectionMessage(new HashMap<>() {{
            put("information", "lobby_termination");
        }}, ConnectionMessage.Type.inform);

        connection.sendMessage(message);

        connection.setLobbyCode("");
    }

    public void startGame(ConnectionMessage message) {
        String error = "";
        String code = connection.getLobbyCode();
        Lobby lobby = ServerMain.getLobbyByCode(connection.getLobbyCode());
        if (code.isEmpty() || lobby == null) {
            error = "you are not in a lobby";
        } else if (!lobby.getAdminUsername().equals(connection.getUsername())) {
            error = "you are not the admin of the lobby";
        } else if (lobby.getMembers().size() <= 1) {
            error = "there must be at least two members";
        }

        ConnectionMessage response;
        if (!error.isEmpty()) {
            String finalError = error;
            response = new ConnectionMessage(new HashMap<>() {{
                put("response", "error");
                put("error", finalError);
            }}, ConnectionMessage.Type.response);

            connection.sendMessage(response);
            return;
        } else {
            response = new ConnectionMessage(new HashMap<>() {{
                put("response", "ok");
            }}, ConnectionMessage.Type.response);

            connection.sendMessage(response);
        }

        GameDetails gameDetails = new GameDetails(lobby.getMembers(), lobby.getAdminUsername());
        ServerMain.addGame(gameDetails);
        String json = ConnectionMessage.gameDetailsToJson(gameDetails);

        System.out.println(lobby.getMembers());
        ArrayList<ClientConnection> connections = new ArrayList<>();
        ArrayList<String> avatarPaths = new ArrayList<>();
        for (String member : lobby.getMembers()) {
            ClientConnection connection = ServerMain.getConnectionByUsername(member);
            connections.add(connection);
            ConnectionMessage information = new ConnectionMessage(new HashMap<>() {{
                put("information", "start_game");
                put("game_details", json);
                put("usernames", lobby.getMembers());
                put("avatar_paths", avatarPaths);
            }}, ConnectionMessage.Type.inform);

            connection.sendMessage(information);
            connection.setInGame(true);
            connection.setGame(gameDetails);
        }

        gameDetails.setConnections(connections);
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(() -> {
            if (connection.getGame().isRunning()) {
                connection.getGame().sendGameDetails();
            } else {
                scheduler.shutdown();
            }
        }, 2000, 4, TimeUnit.MILLISECONDS);
    }

    public void handleLoadGameRequest() {
        try {
            Path savePath = Path.of("saved_games", "game.json");
            if (!Files.exists(savePath)) {
                System.err.println("No saved game found.");
                ConnectionMessage notifyClients = new ConnectionMessage(new HashMap<>() {{
                    put("information", "load_failed");
                    put("reason", "No saved game found");
                }}, ConnectionMessage.Type.inform);
                connection.sendMessage(notifyClients);
                return;
            }

            String json = Files.readString(savePath);
            GameDetails loadedGame = ConnectionMessage.gameDetailsFromJson(json);
            connection.setGame(loadedGame);

            for (String member : loadedGame.getPlayers().keySet()) {
                ClientConnection conn = ServerMain.getConnectionByUsername(member);
                if (conn != null) {
                    conn.setGame(loadedGame);
                    conn.setInGame(true);
                }
            }

            System.out.println("Game " + loadedGame.getGameId() + " loaded successfully.");

            ConnectionMessage notifyClients = new ConnectionMessage(new HashMap<>() {{
                put("information", "game_loaded");
                put("gameId", loadedGame.getGameId());
                put("game_details", json);
            }}, ConnectionMessage.Type.inform);

            for (ClientConnection conn : ServerMain.getConnections()) {
                if (conn.isAlive()) {
                    conn.sendMessage(notifyClients);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void updateSelf(ConnectionMessage message) {
        String json = message.getFromBody("json");
        PlayerDetails newSelf = ConnectionMessage.playerDetailsFromJson(json);
        newSelf.username = connection.getUsername();
        String username = newSelf.username;
        GameDetails game = connection.getGame();
        if (game.isRunning()) {
            game.putPlayerByUsername(username, newSelf);
        }
    }

    public void getLastUser() {
        User user = App.getCurrentGameModel().getPlayersInGame().get(1);
        ConnectionMessage response;
        if (user == null) {
            response = new ConnectionMessage(new HashMap<>() {{
                put("response", "not_found");
            }}, ConnectionMessage.Type.response);
        } else {
            response = new ConnectionMessage(new HashMap<>() {{
                put("response", "ok");
                put("user", ConnectionMessage.userToJson(user));
            }}, ConnectionMessage.Type.response);
        }
        connection.sendMessage(response);
    }

}



