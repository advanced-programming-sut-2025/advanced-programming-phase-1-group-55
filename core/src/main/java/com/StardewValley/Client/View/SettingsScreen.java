package com.StardewValley.Client.View;


import com.StardewValley.Client.ClientController;
import com.StardewValley.Client.ClientData;
import com.StardewValley.Common.model.User;
import com.StardewValley.Common.model.App;
import com.StardewValley.Server.connection.ServerMain;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.List;

public class SettingsScreen implements Screen {

    private Stage stage;
    private Table table;
    private PauseMenuView pauseMenuView;

    SettingsScreen(PauseMenuView p) {
        pauseMenuView = p;
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        Texture bgTexture = new Texture(Gdx.files.internal("backgrounds/7.png"));
        Image bg = new Image(bgTexture);
        bg.setFillParent(true);
        stage.addActor(bg);

        table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        Label title = new Label("Settings", App.skin);
        table.add(title).colspan(3).padBottom(20).row();

        List<User> players = App.getCurrentGameModel().getPlayersInGame();
        for (User player : players) {
            Label nameLabel = new Label(player.getUsername(), App.skin);
            TextButton kickButton = new TextButton("Kick", App.skin);

            kickButton.addListener(new ClickListener() {
                @Override
                public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {

                    System.out.println("Kicked: " + player.getUsername());
                }
            });

            table.add(nameLabel).padRight(20).left();
            table.add(kickButton).width(180);
            table.row().pad(5, 0, 5, 0);
        }
        TextButton backButton = new TextButton("back", App.skin);
        TextButton saveButton = new TextButton("Save", App.skin);
        TextButton exitButton = new TextButton("Exit", App.skin);

        saveButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                ClientController.getInstance().requestGameSave();
            }
        });

        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                ClientController.getInstance().requestGameSave();
                Gdx.app.exit();


            }
        });
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                App.getGameApp().setScreen(new PauseMenuView(pauseMenuView.getController(), pauseMenuView.getUser()));

            }
        });

        table.row().padTop(20);
        table.add(saveButton).colspan(1).width(120).padRight(10);
        table.add(exitButton).colspan(1).width(120);
        table.add(backButton).colspan(1).width(120);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
