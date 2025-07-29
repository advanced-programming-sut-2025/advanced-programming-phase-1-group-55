package com.StardewValley.View.newView;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.StardewValley.Controller.GameMenuController;
import com.StardewValley.Controller.MainGameController;
import com.StardewValley.model.App;

import com.StardewValley.model.Result;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
public class MapSelectionScreen implements Screen {

    private Stage stage;
    private Skin skin;

    private TextField[] playerFields = new TextField[4];
    private SelectBox<String>[] mapBoxes = new SelectBox[4];
    private String[] mapOptions = {"Map1", "Map2"};



    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        skin = App.skin;

        Table table = new Table();
        table.setFillParent(true);
        table.defaults().pad(10);
        stage.addActor(table);

        for (int i = 0; i < 4; i++) {
            final int index = i;
            Label playerLabel = new Label("Player " + (i + 1) + " Username:", skin);
            playerFields[i] = new TextField("", skin);
            mapBoxes[i] = new SelectBox<>(skin);
            mapBoxes[i].setItems(mapOptions);

            table.add(playerLabel).left();
            table.add(playerFields[i]).width(200);
            table.add(mapBoxes[i]).width(100);
            table.row();
        }

        TextButton startButton = new TextButton("Start Game", skin);
        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                handleStartGame();
            }
        });

        table.add(startButton).colspan(3).center();
    }

    private void handleStartGame() {
        for (int i = 0; i < 4; i++) {
            String username = playerFields[i].getText().trim();
            String selectedMap = mapBoxes[i].getSelected();

            if (!username.isEmpty()) {
                System.out.println("Player " + (i + 1) + ": " + username + " -> " + selectedMap);

            }
        }


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override public void resize(int width, int height) { stage.getViewport().update(width, height, true); }
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() { stage.dispose(); skin.dispose(); }
}
