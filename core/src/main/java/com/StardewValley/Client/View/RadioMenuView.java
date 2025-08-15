package com.StardewValley.Client.View;

import com.StardewValley.Common.model.App;
import com.StardewValley.Server.Controller.RadioMenuController;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class RadioMenuView implements Screen {
    private Stage stage;
    private List<String> musicList;
    private TextButton backButton, chooseFileButton, playButton, stopButton, connectButton;
    private Skin skin;
    private RadioMenuController controller;

    public RadioMenuView() {
       skin= App.skin;
       controller = new RadioMenuController();
       controller.setView(this);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);



        musicList = new List<>(skin);
        musicList.setItems("Song1.mp3", "Song2.mp3", "Song3.mp3");
        ScrollPane scrollPane = new ScrollPane(musicList, skin);


        backButton = new TextButton("Back", skin);
        chooseFileButton = new TextButton("Choose File", skin);
        playButton = new TextButton("Play", skin);
        stopButton = new TextButton("Stop", skin);
        connectButton = new TextButton("Connect to Other Player", skin);


        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        table.add(scrollPane).expand().fill().colspan(5).row();

        table.add(backButton).expandX().pad(5);
        table.add(chooseFileButton).expandX().pad(5);
        table.add(playButton).expandX().pad(5);
        table.add(stopButton).expandX().pad(5);
        table.add(connectButton).expandX().pad(5);
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
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}
