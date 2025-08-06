package com.StardewValley.View.newView;

import com.StardewValley.Controller.MainGameController;
import com.StardewValley.model.App;
import com.StardewValley.model.GameModel;
import com.StardewValley.model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.InputMultiplexer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FirstMenu extends ScreenAdapter {
    private Stage stage;
    private Skin skin = App.skin;

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(stage);
        Texture bgTexture = new Texture(Gdx.files.internal("backgrounds/rpg-stardew-valley-logo-71h23ye38y48aaiq.jpg"));
        Image background = new Image(bgTexture);
        background.setFillParent(true);
        stage.addActor(background);


        Table table = new Table();
        table.setFillParent(true);
        table.bottom();
        stage.addActor(table);


        TextButton registerBtn = new TextButton("Register", skin);
        TextButton loginBtn = new TextButton("Login", skin);
        TextButton exitBtn = new TextButton("Exit", skin);
        TextButton loadButton = new TextButton("Load Game", skin);
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


        registerBtn.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {

                App.getGameApp().setScreen(new RegisterScreen());
            }
        });

        loginBtn.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                App.getGameApp().setScreen(new LoginScreen());
            }
        });

        exitBtn.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });
        multiplexer.addProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                if (keycode == Input.Keys.G) {
                    App.mainUser = App.getAllUsers().get("arshia");
                    App.getGameApp().setScreen(new MainMenuScreen());
                }
                return true;
            }
        });


        Gdx.input.setInputProcessor(multiplexer);

        table.add(registerBtn).size(400, 100).padBottom(20).row();
        table.add(loginBtn).size(400, 100).padBottom(20).row();
        table.add(exitBtn).size(400, 100).row();
        table.add(loadButton).size(400, 100);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}
