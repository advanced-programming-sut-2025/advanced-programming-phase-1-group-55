package com.StardewValley.Client.View;

import com.StardewValley.Client.ClientController;
import com.StardewValley.Client.ClientData;
import com.StardewValley.Common.Lobby;
import com.StardewValley.Common.model.App;
import com.StardewValley.Server.Controller.MainGameController;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class InLobbyScreen implements Screen {

    private Stage stage;
    private Skin skin;
    private Table rootTable;
    private Table membersTable;
    private TextButton btnLeave;
    private TextButton btnStart;
    private TextButton btnRefresh;
    private SelectBox<Integer> mapSelector;
    private static boolean gameStarted = false;
    private Texture background;

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        skin = App.skin;
        background = new Texture("backgrounds/8.png");

        Lobby currentLobby = ClientData.getInstance().getLobby(ClientData.getInstance().lobbyCode);

        rootTable = new Table();
        rootTable.setFillParent(true);
        rootTable.pad(15);
        stage.addActor(rootTable);

        btnStart = new TextButton("Start Game", skin);
        btnLeave = new TextButton("Leave Lobby", skin);
        btnRefresh = new TextButton("Refresh", skin);

        mapSelector = new SelectBox<>(skin);
        mapSelector.setItems(1, 2, 3, 4);
        mapSelector.setSelected(1);

        btnStart.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ClientController.getInstance().startGame();
            }
        });

        btnLeave.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ClientController.getInstance().leaveLobby();
            }
        });

        btnRefresh.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ClientController.getInstance().refreshLobbies();
            }
        });
        TextButton btnLoadGame = new TextButton("Load Game", skin);
        btnLoadGame.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ClientController.getInstance().requestGameLoad();
            }
        });


        Table buttonTable = new Table();
        buttonTable.add(btnStart).pad(8).row();
        buttonTable.add(btnLeave).pad(8).row();
        buttonTable.add(btnRefresh).pad(8);
        buttonTable.add(btnLoadGame).pad(8).row();

        membersTable = new Table(skin);
        membersTable.defaults().pad(4);
        refreshMembers();

        rootTable.add(new Label(currentLobby.getName() + " (" + currentLobby.getCode() + ")", skin)).padBottom(5).row();
        rootTable.add(new Label("Lobby Members:", skin)).left().top().padBottom(8).row();
        rootTable.add(membersTable).left().top().expandY().row();
        rootTable.add(buttonTable).bottom().right();
    }

    private void refreshMembers() {
        membersTable.clear();
        Lobby lobby = ClientData.getInstance().getLobby(ClientData.getInstance().lobbyCode);
        if (lobby != null && lobby.getMembers() != null && !lobby.getMembers().isEmpty()) {
            for (String member : lobby.getMembers()) {
                Label label = new Label(member, skin);
                label.setAlignment(Align.left);
                membersTable.add(label).left().row();
            }
        } else {
            membersTable.add(new Label("No members in lobby", skin)).left().row();
        }
    }

    public static void setGameStarted(boolean started) {
        gameStarted = started;
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        stage.getBatch().end();

        stage.act(delta);
        stage.draw();
        refreshMembers();

        if (ClientData.getInstance().lobbyCode.isEmpty()) {
            App.gameApp.getScreen().dispose();
            App.gameApp.setScreen(new LobbyScreen());
        }

        if (gameStarted) {
            App.gameApp.setScreen(new MainGameGraphicView(new MainGameController(), App.currentGameModel.getMap()));
        }
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
        background.dispose();
    }
}
