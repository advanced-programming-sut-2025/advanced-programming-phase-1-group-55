package com.StardewValley.Client.View;

import com.StardewValley.Client.ClientData;
import com.StardewValley.Common.model.App;
import com.StardewValley.Server.Controller.RadioMenuController;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.HashMap;

public class RadioMenuView implements Screen {
    private Stage stage;
    private final Label ErrorLabel;
    private com.badlogic.gdx.utils.Timer.Task clearErrorTask;
    private HashMap<String, String> musicList;
    private List<String> musicListUI;
    private TextButton backButton, chooseFileButton, playButton, stopButton, connectButton;
    private Skin skin;
    private RadioMenuController controller;
    private String selectedMusicName;
    private TextField connectTextField;

    public RadioMenuView() {
        skin = App.skin;
        controller = new RadioMenuController();
        controller.setView(this);
        ErrorLabel = new Label("", skin);
        ErrorLabel.setColor(Color.RED);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        musicList = ClientData.getInstance().selfDetails.musics;

        musicListUI = new List<>(skin);
        musicListUI.setItems(musicList.keySet().toArray(new String[0]));

        musicListUI.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, com.badlogic.gdx.scenes.scene2d.Actor actor) {
                selectedMusicName = musicListUI.getSelected();
                System.out.println("Selected music: " + selectedMusicName);
            }
        });

        ScrollPane scrollPane = new ScrollPane(musicListUI, skin);

        backButton = new TextButton("Back", skin);
        chooseFileButton = new TextButton("Choose File", skin);
        playButton = new TextButton("Play", skin);
        stopButton = new TextButton("Stop", skin);
        connectButton = new TextButton("Connect to Other Player", skin);


        connectTextField = new TextField("", skin);
        connectTextField.setMessageText("Enter player name or ID");

        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        table.add(scrollPane).expand().fill().colspan(5).row();

        table.add(backButton).expandX().pad(5);
        table.add(chooseFileButton).expandX().pad(5);
        table.add(playButton).expandX().pad(5);
        table.add(stopButton).expandX().pad(5);
        table.add(connectButton).expandX().pad(5);
        table.row();


        table.add().expandX();
        table.add().expandX();
        table.add().expandX();
        table.add().expandX();
        table.add(connectTextField).expandX().pad(5);
        table.row();

        table.add(ErrorLabel).colspan(5);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
        controller.handleButton();
    }
    public void setErrorMessage(String message) {
        ErrorLabel.setText(message);
        if (clearErrorTask != null) {
            clearErrorTask.cancel();
        }
        clearErrorTask = new Timer.Task() {
            @Override
            public void run() {
                ErrorLabel.setText("");
            }
        };
        Timer.schedule(clearErrorTask, 5);
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

    public Stage getStage() {
        return stage;
    }

    public List<String> getMusicListUI() {
        return musicListUI;
    }

    public TextButton getBackButton() {
        return backButton;
    }

    public TextButton getChooseFileButton() {
        return chooseFileButton;
    }

    public TextButton getPlayButton() {
        return playButton;
    }

    public TextButton getStopButton() {
        return stopButton;
    }

    public TextButton getConnectButton() {
        return connectButton;
    }

    public String getSelectedMusicName() {
        return selectedMusicName;
    }
}
