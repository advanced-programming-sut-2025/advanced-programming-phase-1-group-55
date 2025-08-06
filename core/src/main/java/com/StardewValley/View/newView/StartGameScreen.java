package com.StardewValley.View.newView;


import com.StardewValley.Controller.GameMenuController;
import com.StardewValley.Controller.MainGameController;
import com.StardewValley.model.App;

import com.StardewValley.model.GameModel;
import com.StardewValley.model.Item.CollisionRect;
import com.StardewValley.model.Map.Location;
import com.StardewValley.model.Result;
import com.StardewValley.model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.*;
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


public class StartGameScreen implements Screen {
    private Stage stage;
    private Skin skin = App.skin;

    private GameMenuController controller = new GameMenuController();

    private SelectBox<Integer> playerCountBox;
    private TextField username1Field, username2Field, username3Field;
    private SelectBox<String> map1Box, map2Box, map3Box;

    private Label resultLabel;

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Texture bgTexture = new Texture(Gdx.files.internal("backgrounds/5.png"));
        Image image = new Image(bgTexture);
        image.setFillParent(true);
        stage.addActor(image);

        Table table = new Table();
        table.setFillParent(true);
        table.pad(20);
        stage.addActor(table);

        table.add(new Label("Number of Players (1-3):", skin));
        playerCountBox = new SelectBox<>(skin);
        playerCountBox.setItems(1, 2, 3);
        table.add(playerCountBox).width(100).row();

        // Player 1
        table.add(new Label("Username 1:", skin));
        username1Field = new TextField("", skin);
        table.add(username1Field).width(250);
        map1Box = new SelectBox<>(skin);
        map1Box.setItems("Map1", "Map2");
        table.add(map1Box).width(200).row();

        // Player 2
        table.add(new Label("Username 2:", skin));
        username2Field = new TextField("", skin);
        table.add(username2Field).width(250);
        map2Box = new SelectBox<>(skin);
        map2Box.setItems("Map1", "Map2");
        table.add(map2Box).width(200).row();

        // Player 3
        table.add(new Label("Username 3:", skin));
        username3Field = new TextField("", skin);
        table.add(username3Field).width(250);
        map3Box = new SelectBox<>(skin);
        map3Box.setItems("Map1", "Map2");
        table.add(map3Box).width(200).row();

        resultLabel = new Label("", skin);
        table.add(resultLabel).colspan(3).pad(10).row();

        TextButton startButton = new TextButton("Start Game", skin);
        TextButton backButton = new TextButton("back", skin);
        table.add(startButton).colspan(3).padTop(20).row();
        table.add(backButton).colspan(3).padTop(20).row();

        playerCountBox.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                updateFieldsVisibility();
            }
        });

        updateFieldsVisibility();


        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String u1 = username1Field.getText().trim();
                String u2 = playerCountBox.getSelected() >= 2 ? username2Field.getText().trim() : null;
                String u3 = playerCountBox.getSelected() >= 3 ? username3Field.getText().trim() : null;

                String m1 = map1Box.getSelected();
                String m2 = playerCountBox.getSelected() >= 2 ? map2Box.getSelected() : null;
                String m3 = playerCountBox.getSelected() >= 3 ? map3Box.getSelected() : null;


                Result result = controller.newGame(u1, u2, u3, m1, m2, m3);
                if (result.IsSuccess()) {
                    App.getGameApp().setScreen(new MainGameGraphicView(new MainGameController(), App.currentGameModel.getMap()));
                } else {
                    resultLabel.setText(result.Message());
                }


            }
        });
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                App.getGameApp().setScreen(new MainMenuScreen());
            }
        });
    }

    private void updateFieldsVisibility() {
        int count = playerCountBox.getSelected();

        username1Field.setVisible(true);
        map1Box.setVisible(true);

        username2Field.setVisible(count >= 2);
        map2Box.setVisible(count >= 2);

        username3Field.setVisible(count == 3);
        map3Box.setVisible(count == 3);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.2f, 1);
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
