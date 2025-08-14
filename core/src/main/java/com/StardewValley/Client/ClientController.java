package com.StardewValley.Client;

import com.StardewValley.Client.View.InLobbyScreen;
import com.StardewValley.Client.View.LobbyScreen;
import com.StardewValley.Common.model.App;
import com.StardewValley.Common.ConnectionMessage;
import com.StardewValley.Common.Lobby;
import com.StardewValley.Common.model.Friendship.Message;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import static com.StardewValley.Common.Connection.TIMEOUT;

public class ClientController {
    private static ClientController instance;

    private ClientController() {
    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    private ServerConnection connection = null;
    private ClientData data = ClientData.getInstance();

    public void initConnection(String ip, int port, String serverIp, int serverPort) {
        try {
            Socket socket = new Socket(serverIp, serverPort);
            connection = new ServerConnection(socket, ip, port);
            connection.setOtherSideIP(serverIp);
            connection.setOtherSidePort(serverPort);
            data.connection = connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (connection != null && !connection.isAlive()) {
            connection.start();
        } else {
            throw new IllegalStateException("Tracker connection thread is already running or not set");
        }
    }

    public void informLogin(String username) {
        ConnectionMessage message = new ConnectionMessage(new HashMap<>() {{
            put("information", "inform_login");
            put("username", username);
        }}, ConnectionMessage.Type.inform);

        connection.sendMessage(message);
    }

    public void refreshLobbies() {
        ConnectionMessage request = new ConnectionMessage(new HashMap<>() {{
            put("command", "send_lobbies");
        }}, ConnectionMessage.Type.command);

        ConnectionMessage response = connection.sendAndWaitForResponse(request, TIMEOUT);

        if (response == null) {
            System.err.println("No response from server for send_lobbies.");
            return;
        }

        ArrayList<String> lobbiesJson = response.getFromBody("lobbies");
        if (lobbiesJson == null) {
            System.err.println("Invalid response: missing 'lobbies' field");
            return;
        }

        data.lobbies.clear();
        for (String json : lobbiesJson) {
            data.lobbies.add(ConnectionMessage.lobbyFromJson(json));
        }
        for (Lobby lobby : data.lobbies) {
            if (lobby.getCode().equals(data.lobbyCode)) {
                App.mainUser.setLobby(lobby);
            }
        }
    }


    public boolean createLobby(String name, boolean isPrivate, String password, boolean isVisible) {
        if (connection == null) {
            throw new IllegalStateException("No active server connection");
        }

        if (!isPrivate) password = "";
        String finalPassword = isPrivate ? password : "";

        ConnectionMessage request = new ConnectionMessage(new HashMap<>() {{
            put("command", "create_lobby");
            put("name", name);
            put("isPrivate", isPrivate);
            put("password", finalPassword);
            put("isVisible", isVisible);
        }}, ConnectionMessage.Type.command);

        ConnectionMessage response = connection.sendAndWaitForResponse(request, TIMEOUT);

        if (response == null) {
            System.err.println("No response from server for create_lobby.");
            return false;
        }

        if ("ok".equals(response.getFromBody("response"))) {
            data.lobbyCode = response.getFromBody("code");
            refreshLobbies();
            return true;
        }
        return false;
    }


    public String joinLobby(String code,String password) {
        ConnectionMessage request = new ConnectionMessage(new HashMap<>() {{
            put("command", "join_lobby");
            put("code", code);
            put("password", password);
        }}, ConnectionMessage.Type.command);

        ConnectionMessage response = connection.sendAndWaitForResponse(request, TIMEOUT);
        if (response.getFromBody("response").equals("ok")) {
            data.lobbyCode = code;
            refreshLobbies();
            App.gameApp.getScreen().dispose();
            App.gameApp.setScreen(new InLobbyScreen());
            return "joined successfully";
        } else {
            return response.getFromBody("error");
        }
    }

    public String leaveLobby() {
        String code = data.lobbyCode;
        ConnectionMessage request = new ConnectionMessage(new HashMap<>() {{
            put("command", "leave_lobby");
            put("code", code);
        }}, ConnectionMessage.Type.command);

        ConnectionMessage response = connection.sendAndWaitForResponse(request, TIMEOUT);
        if (response.getFromBody("response").equals("ok")) {
            data.lobbyCode = "";
            refreshLobbies();
            App.gameApp.setScreen(new LobbyScreen());
            return "leaved successfully";
        } else {
            return response.getFromBody("error");
        }
    }
    public void updateChat(Message message) {
        ConnectionMessage connectionMessage = new ConnectionMessage(new HashMap<>() {{
            put("command", "update_public_chat");
            put("text", message.getText());
            put("sender", message.getSender());
        }}, ConnectionMessage.Type.command);

        connection.sendMessage(connectionMessage);
    }

    public void startGame() {
        if (connection == null) {
            System.out.println( "failed: no active connection");
            return;
        }
        ConnectionMessage request=null;
       try{ request= new ConnectionMessage(new HashMap<>() {{
            put("command", "start_game");
        }}, ConnectionMessage.Type.command);}
       catch (Exception e) {
           System.out.println( "failed: " + e.getMessage());
           return ;
       }

        ConnectionMessage response = connection.sendAndWaitForResponse(request, TIMEOUT);
        if (response == null) {
            System.out.println( "failed: no response from server");
            return ;
        }
        if ("ok".equals(response.getFromBody("response"))) {
            System.out.println( "game started successfully");
        } else {
            System.out.println(Optional.ofNullable(response.getFromBody("error")));
        }
    }
}
