package com.StardewValley;

import com.StardewValley.Client.View.FirstMenu;
import com.StardewValley.Common.model.App;
import com.StardewValley.Common.model.ClientServer.ClientWork;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sun.tools.javac.Main;

import static com.StardewValley.Common.model.App.readfile;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class GameApp extends Game {
    private SpriteBatch batch;
    private static ClientWork client;
    private static String name1;
    private static String password;

    static {
        System.setProperty("java.net.preferIPv4Stack", "true");
        System.setProperty("kryonet.log", "DEBUG");
    }

    public GameApp(ClientWork client, String name, String pass) {
        name1 = name;
        password = pass;
        GameApp.client = client;
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

    public static synchronized ClientWork getClient() {
        return client;
    }
}
