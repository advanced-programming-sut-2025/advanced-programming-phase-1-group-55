package com.StardewValley;

import com.StardewValley.View.FirstMenu;
import com.StardewValley.model.App;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.StardewValley.model.App.readfile;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class GameApp extends Game {
    private SpriteBatch batch;


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
