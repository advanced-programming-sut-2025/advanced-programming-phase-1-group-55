package com.StardewValley.View.newView;


import com.StardewValley.Controller.MainGameController;
import com.StardewValley.model.GameModel;
import com.badlogic.gdx.Screen;
import com.StardewValley.Controller.LoginMenuController;
import com.StardewValley.model.App;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainMenuScreen implements Screen {

    private Stage stage;
    private Skin skin = App.skin;


    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Texture bgTexture = new Texture(Gdx.files.internal("backgrounds/3.png"));
        Image image = new Image(bgTexture);
        image.setFillParent(true);
        stage.addActor(image);
        Table table = new Table();
        table.setFillParent(true);
        table.center();
        stage.addActor(table);

        Label title = new Label("Main Menu", skin);
        TextButton profileBtn = new TextButton("Profile Menu", skin);
//        TextButton avatarBtn = new TextButton("Avatar Menu", skin);
        TextButton gameBtn = new TextButton("PreGame Menu", skin);
        TextButton logoutBtn = new TextButton("Logout", skin);
        TextButton loadButton = new TextButton("Load Game", skin);

        Label username = new Label("", skin);
        username.setText("Username : " + App.mainUser.getUsername());


        Texture avatarTexture = new Texture(App.mainUser.getAvatarPath());
        Image avatarImage = new Image(avatarTexture);

        avatarImage.setSize(250, 150);


        Table avatarTable = new Table();
        avatarTable.top().left();
        avatarTable.setFillParent(true);
        avatarTable.add(avatarImage).size(250, 150).pad(10);
        stage.addActor(avatarTable);

        Table usernameLabel = new Table();
        usernameLabel.top().right();
        usernameLabel.setFillParent(true);
        usernameLabel.add(username).pad(10);
        stage.addActor(usernameLabel);


        table.add(title).padBottom(40).row();
        table.add(gameBtn).pad(10).row();
//        table.add(avatarBtn).pad(10).row();
        table.add(profileBtn).pad(10).row();
        table.add(logoutBtn).pad(10).row();
        table.add(loadButton).pad(10).row();
        loadButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                try {
                    Path savePath = Paths.get("saves", "game_save.json");

                    if (!Files.exists(savePath)) {
                        System.out.println("No saved game found!");
                        return;
                    }

                    Gson gson = new GsonBuilder()
                        .excludeFieldsWithoutExposeAnnotation()
                        .setPrettyPrinting()
                        .create();

                    try (Reader reader = Files.newBufferedReader(savePath)) {
                        GameModel loadedGame = gson.fromJson(reader, GameModel.class);

                        if (loadedGame.getMap() != null) {
//                            loadedGame.getMap().loadGraphics();
                        }

                        App.setCurrentGameModel(loadedGame);

                        App.getGameApp().setScreen(
                            new MainGameGraphicView(
                                new MainGameController(),
                                loadedGame.getMap()
                            )
                        );

                        System.out.println("Game loaded successfully!");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
//                    resultLabel.setText("Error loading saved game!");
                }
            }
        });
        profileBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                App.getGameApp().setScreen(new ProfileMenuScreen());
            }
        });


        gameBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                App.getGameApp().setScreen(new StartGameScreen());
            }
        });

        logoutBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                App.getGameApp().setScreen(new FirstMenu());
            }
        });
    }

    @Override
    public void render(float delta) {
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
