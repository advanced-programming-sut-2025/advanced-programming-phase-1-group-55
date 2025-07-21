package com.StardewValley;

import com.StardewValley.Controller.MainGameController;
import com.StardewValley.View.newView.MainGameGraphicView;
import com.StardewValley.View.newView.MainMenuScreen;
import com.StardewValley.model.App;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class GameApp extends Game {
    private SpriteBatch batch;


    @Override
    public void create() {
        batch = new SpriteBatch();
        App.gameApp = this;
        Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
        setScreen(new MainMenuScreen());
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
