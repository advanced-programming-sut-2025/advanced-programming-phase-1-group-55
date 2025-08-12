package com.StardewValley;

import com.StardewValley.Client.ClientController;
import com.StardewValley.Client.View.FirstMenu;
import com.StardewValley.Common.model.App;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sun.tools.javac.Main;

import java.util.Scanner;

import static com.StardewValley.Common.model.App.readfile;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class GameApp extends Game {
    private SpriteBatch batch;

    public void handleConnection(int port) {

        try {

            String selfIp = "localhost";
            int selfPort = port;
            String serverIp = "localhost";
            int serverPort = 8080;
            ClientController.getInstance().initConnection(selfIp, selfPort, serverIp, serverPort);
        } catch (Exception e) {
            System.err.println("Could not start the server");
            e.printStackTrace();
        }


    }

    @Override
    public void create() {

        batch = new SpriteBatch();
        App.gameApp = this;
        readfile();
        setScreen(new FirstMenu());
    }


    @Override
    public void dispose() {
        batch.dispose();
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }
}
