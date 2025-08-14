package com.StardewValley.Client;

import com.StardewValley.Client.View.MainGameGraphicView;
import com.StardewValley.Common.*;
import com.StardewValley.Common.model.App;

import com.StardewValley.Common.model.Result;
import com.StardewValley.Common.model.User;
import com.StardewValley.Server.Controller.GameMenuController;
import com.StardewValley.Server.Controller.MainGameController;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ServerConnectionController {
    private static ServerConnectionController instance;
    private ServerConnection connection;
    private ClientData data = ClientData.getInstance();
    private GameMenuController controller = new GameMenuController();

    private ServerConnectionController() {
    }

    public static ServerConnectionController getInstance() {
        if (instance == null) {
            instance = new ServerConnectionController();
        }
        return instance;
    }

    public ConnectionMessage status() {
        ConnectionMessage message = new ConnectionMessage(new HashMap<>() {{
            put("command", "status");
            put("response", "ok");
            put("client_ip", connection.getIp());
            put("client_port", connection.getPort());
        }}, ConnectionMessage.Type.response);

        return message;
    }

    public void lobbyTerminated(ConnectionMessage message) {
        data.lobbyCode = "";
    }

    public void gameStarted(ConnectionMessage message) {
        System.out.println("start game ");
        GameDetails game = ConnectionMessage.gameDetailsFromJson(message.getFromBody("game_details"));
        System.out.println((String) message.getFromBody("game_details"));
        ArrayList<String> usernames = message.getFromBody("usernames");
        data.selfDetails = new PlayerDetails(App.mainUser.getUsername());
        data.gameDetails = game;
        data.isInGame = true;
        String otherUsername="";
        for (String x : usernames) {
            if (App.mainUser.getUsername().equals(x)) {
                continue;
            } else {
                otherUsername = x;
            }
        }
        Result result = controller.newGame(otherUsername, null, null, "Map1", "Map1", "Map1");
        if (result.IsSuccess()) {
            Gdx.app.postRunnable(() -> {
                App.getGameApp().setScreen(
                    new MainGameGraphicView(
                        new MainGameController(),
                        App.currentGameModel.getMap()
                    )
                );
            });
        } else {
            System.err.println(result.Message());
        }

        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(() -> {
            if (data.isInGame) {
                data.updateAndSendSelf();
            } else {
                scheduler.shutdown();
            }
        }, 3, 1, TimeUnit.SECONDS);

    }

    public void updateOnlineUsers(ConnectionMessage message) {
        data.onlineUsers = message.getFromBody("online_users");

    }

    public void setConnection(ServerConnection connection) {
        this.connection = connection;
    }

    public void updateGame(ConnectionMessage message) {
        GameDetails oldGame = data.gameDetails;
        GameDetails newGame = ConnectionMessage.gameDetailsFromJson(message.getFromBody("json"));
        newGame.setPublicGameChat(oldGame.getPublicGameChat());
        for (String member : oldGame.getPlayers().keySet()) {
            Reaction oldReaction = oldGame.getPlayerByUsername(member).reaction;
            if (oldReaction == null) {
                oldReaction = new Reaction("");
            }
            Reaction newReaction = newGame.getPlayerByUsername(member).reaction;
            if (newReaction == null) {
                newReaction = new Reaction("");
            }
            if (!oldReaction.text.equals(newReaction.text) && !newReaction.text.isEmpty()) {
                newReaction.time = System.currentTimeMillis();
            }
        }
        data.gameDetails = newGame;
    }

    public void updateStoreItems(ConnectionMessage message) {
        String store = message.getFromBody("store");
        String item = message.getFromBody("item");
        int count = message.getIntFromBody("count");

//        TODO: reduce the quantity of the item from the store
    }

    private String sourceOfMusic = "";

    public void setSourceOfMusic(String sourceOfMusic) {
        this.sourceOfMusic = sourceOfMusic;
    }

    public void saveMusicFile(ConnectionMessage message) {
        String name = message.getFromBody("filename");
        String sourcePath = "temp_receives/" + name;
        File source = new File(sourcePath);
        String targetDirPath = "received_musics/" + "  music sasi mankan";
        File targetDir = new File(targetDirPath);
        if (!targetDir.exists()) targetDir.mkdirs();
        if (!source.exists()) {
            System.err.println("Error: File (" + name + ") does not exist");
            return;
        }

        try {
            Path sourceFile = source.toPath();
            Path targetFile = targetDir.toPath().resolve(sourceOfMusic + "~" + source.getName());

            Files.move(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
            File file = targetFile.toFile();

            if (data.currentMusic != null && data.currentMusic.isPlaying()) {
                data.currentMusic.pause();
            }

            try {
                FileHandle handle = Gdx.files.absolute(file.getAbsolutePath());
                data.currentMusic = Gdx.audio.newMusic(handle);
                data.currentMusic.play();
            } catch (Exception e) {
                System.err.println("Error playing music: " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
