package com.StardewValley.Client.View;

import com.StardewValley.Client.ClientController;
import com.StardewValley.Client.ClientData;
import com.StardewValley.Common.Lobby;
import com.StardewValley.Common.model.App;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class LobbyScreen implements Screen {
    private Stage stage;
    private Skin skin;

    private Table publicLobbiesTable;
    private Table foundLobbyTable;
    private Table onlinePlayersTable;

    private TextField lobbySearchField;
    private Label lobbySearchResultLabel;

    private float refreshTimer = 0;

    @Override
    public void show() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        skin = App.skin;
        publicLobbiesTable = new Table(skin);
        foundLobbyTable = new Table(skin);
        onlinePlayersTable = new Table(skin);

        initializeUI();
    }

    private void initializeUI() {
        Table leftPanel = new Table(skin);
        leftPanel.pad(5);
        leftPanel.add(new Label("Public Lobbies", skin)).left().row();
        leftPanel.add(new ScrollPane(publicLobbiesTable, skin)).expand().fill().row();

        TextButton newLobbyBtn = new TextButton("New Lobby", skin);
        newLobbyBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                openCreateLobbyDialog();

            }
        });
        leftPanel.add(newLobbyBtn).padTop(5);

        Table rightPanel = new Table(skin);
        rightPanel.pad(5);
        rightPanel.add(new Label("Find Lobby", skin)).left().row();

        lobbySearchField = new TextField("", skin);
        rightPanel.add(lobbySearchField).fillX().padTop(3).row();

        TextButton searchLobbyBtn = new TextButton("Search", skin);
        searchLobbyBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {

                searchForLobby();
            }
        });
        rightPanel.add(searchLobbyBtn).padTop(3).row();

        lobbySearchResultLabel = new Label("", skin);
        rightPanel.add(lobbySearchResultLabel).padTop(3).row();
        rightPanel.add(new ScrollPane(foundLobbyTable, skin)).expand().fill().padTop(5);

        Table bottomPanel = new Table(skin);
        bottomPanel.pad(5);
        bottomPanel.add(new Label("Online Players", skin)).left().row();
        bottomPanel.add(new ScrollPane(onlinePlayersTable, skin)).expandX().fillX();

        Table bottomButtons = new Table(skin);
        TextButton refreshBtn = new TextButton("Refresh", skin);
        refreshBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {

                ClientController.getInstance().refreshLobbies();
            }
        });

        TextButton exitBtn = new TextButton("Back", skin);
        exitBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                App.gameApp.setScreen(new MainMenuScreen());

            }
        });

        bottomButtons.add(refreshBtn).padRight(5);
        bottomButtons.add(exitBtn);

        Table root = new Table();
        root.setFillParent(true);
        root.pad(10);
        root.add(leftPanel).expand().fill().padRight(10);
        root.add(rightPanel).width(250).top();
        root.row();
        root.add(bottomPanel).colspan(2).expandX().fillX().padTop(10).row();
        root.add(bottomButtons).colspan(2).padTop(10);

        stage.addActor(root);
    }

    private void searchForLobby() {
        String code = lobbySearchField.getText().trim();
        Lobby lobby = ClientData.getInstance().getLobbyByName(code);
        if (lobby != null) {
            displayFoundLobby(lobby);
        } else {
            lobbySearchResultLabel.setText("Lobby not found");
            foundLobbyTable.clear();
        }
    }

    private void displayFoundLobby(Lobby lobby) {
        foundLobbyTable.clear();
        lobbySearchResultLabel.setText("Lobby Found!");
        foundLobbyTable.add(new Label("Name: " + lobby.getName(), skin)).left().pad(3).row();
        foundLobbyTable.add(new Label("Code: " + lobby.getCode(), skin)).left().pad(3).row();
        foundLobbyTable.add(new Label("Private: " + (lobby.isPrivate() ? "Yes" : "No"), skin)).pad(3).row();

        TextButton joinBtn = new TextButton("Join", skin);
        joinBtn.addListener(e -> {
            ClientController.getInstance().joinLobby(lobby.getCode());
            App.gameApp.setScreen(new InLobbyView());
            return true;
        });
        foundLobbyTable.add(joinBtn).pad(3);
    }

    private void openCreateLobbyDialog() {
        Dialog dialog = new Dialog("Create Lobby", skin);
        dialog.pad(10);

        TextField nameField = new TextField("", skin);
        nameField.setMessageText("Lobby name");
        TextField passwordField = new TextField("", skin);
        passwordField.setMessageText("Password");
        CheckBox visibleCheckBox = new CheckBox("Visible", skin);
        CheckBox privateCheckBox = new CheckBox("Private", skin);

        Table dialogTable = new Table(skin);
        dialogTable.pad(5).defaults().pad(3);
        dialogTable.add(new Label("Name:", skin)).left();
        dialogTable.add(nameField).width(180).row();
        dialogTable.add(new Label("Password:", skin)).left();
        dialogTable.add(passwordField).width(180).row();
        dialogTable.add(visibleCheckBox).colspan(2).left().row();
        dialogTable.add(privateCheckBox).colspan(2).left().row();

        dialog.getContentTable().add(dialogTable).row();

        TextButton createBtn = new TextButton("Create", skin);
        createBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                ClientController.getInstance().createLobby(
                    nameField.getText().trim(),
                    privateCheckBox.isChecked(),
                    passwordField.getText().trim(),
                    visibleCheckBox.isChecked()
                );
                App.gameApp.setScreen(new InLobbyView());
            }
        });

        TextButton cancelBtn = new TextButton("Cancel", skin);
        cancelBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                dialog.hide();

            }
        });

        dialog.button(createBtn);
        dialog.button(cancelBtn);
        dialog.show(stage);
    }

    private void buildPublicLobbies() {
        publicLobbiesTable.clear();
        for (Lobby lobby : ClientData.getInstance().lobbies) {
            if (!lobby.isVisible()) continue;

            Table row = new Table(skin);
            TextButton joinBtn = new TextButton("Join", skin);
            joinBtn.addListener(e -> {
                ClientController.getInstance().joinLobby(lobby.getCode());
                App.gameApp.setScreen(new InLobbyView());
                return true;
            });

            row.add(joinBtn).pad(2);
            row.add(new Label(lobby.getName() + " (" + lobby.getCode() + ")", skin)).left().padLeft(5);
            publicLobbiesTable.add(row).left().pad(2).row();
        }
    }

    private void buildOnlinePlayers() {
        onlinePlayersTable.clear();
        onlinePlayersTable.add(new Label("Username", skin)).pad(2);
        onlinePlayersTable.add(new Label("In Lobby?", skin)).pad(2);
        onlinePlayersTable.add(new Label("Lobby Code", skin)).pad(2);
        onlinePlayersTable.row();

        for (String username : ClientData.getInstance().onlineUsers) {
            String lobbyCode = "-";
            String inLobby = "No";
            for (Lobby lobby : ClientData.getInstance().lobbies) {
                if (lobby.getMembers().contains(username)) {
                    inLobby = "Yes";
                    lobbyCode = lobby.getCode();
                    break;
                }
            }
            onlinePlayersTable.add(new Label(username, skin)).pad(2);
            onlinePlayersTable.add(new Label(inLobby, skin)).pad(2);
            onlinePlayersTable.add(new Label(lobbyCode, skin)).pad(2);
            onlinePlayersTable.row();
        }
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        stage.act(delta);
        stage.draw();

        refreshTimer += delta;
        if (refreshTimer >= 1f) {
            buildPublicLobbies();
            buildOnlinePlayers();
            refreshTimer = 0;
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
    }
}
