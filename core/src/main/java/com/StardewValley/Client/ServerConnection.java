package com.StardewValley.Client;

import com.StardewValley.Common.Connection;
import com.StardewValley.Common.ConnectionMessage;
import com.StardewValley.Common.PlayerDetails;
import com.StardewValley.Common.model.Chat.Emoji;
import com.StardewValley.Common.model.Chat.Message;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServerConnection extends Connection {
    private String ip;
    private int port;
    private ServerConnectionController controller = ServerConnectionController.getInstance();

    private AtomicBoolean exitFlag = new AtomicBoolean(false);

    protected ServerConnection(Socket socket, String ip, int port) throws IOException {
        super(socket);
        this.port = port;
        this.ip = ip;
        controller.setConnection(this);
    }

    @Override
    public boolean initialHandshake() {
        try {
            readFrame();
            sendMessage(controller.status());

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    protected synchronized boolean handleMessage(ConnectionMessage message) {
        String command = (String) message.getFromBody("command");
        if (message.getType().equals(ConnectionMessage.Type.command)) {
            if (command.equals("status")) {
                sendMessage(controller.status());
                return true;
            }
            if (command.equals("file_meta")) {
                super.startFileReceiving(message);
                return true;
            }
            if (command.equals("player_request")) {
                controller.handlePlayerRequest(message);
                return true;
            }


        } else if (message.getType().equals(ConnectionMessage.Type.inform)) {
            if (message.getFromBody("information").equals("lobby_termination")) {
                controller.lobbyTerminated(message);
                return true;
            }
            if (message.getFromBody("information").equals("start_game")) {
                controller.gameStarted(message);
                return true;
            }
            if (message.getFromBody("information").equals("online_users")) {
                controller.updateOnlineUsers(message);
                return true;
            }
        }
        if (message.getType().equals(ConnectionMessage.Type.update)) {
            String updateType = message.getFromBody("update");

            if (updateType.equals("update_game")) {
                controller.updateGame(message);
                return true;
            }

            if (updateType.equals("update_chat")) {
                String jsonString =message.getFromBody("json");
                Message message1 = ConnectionMessage.messageFromJson(jsonString);
                ClientData.getInstance().gameDetails.getPublicGameChat().add(message1);

                return true;
            }
            if (updateType.equals("update_emoji")) {
                String jsonString =message.getFromBody("json");
                Emoji emoji=ConnectionMessage.emojiFromJson(jsonString);
                String sender = message.getFromBody("sender");
                for (PlayerDetails playerDetails:ClientData.getInstance().gameDetails.getPlayers().values()){
                    if (playerDetails.getUsername().equals(sender)&& !sender.equals(ClientData.getInstance().selfDetails.username)){
                        playerDetails.setEmoji(emoji);
                    }
                }
            }
        }

        return false;

    }

    @Override
    public void end() {
        exitFlag.set(true);
        super.end();
    }

    public boolean isEnded() {
        return exitFlag.get();
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public ServerConnectionController getController() {
        return controller;
    }
}
