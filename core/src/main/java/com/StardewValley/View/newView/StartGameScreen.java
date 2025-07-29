package com.StardewValley.View.newView;


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


public class StartGameScreen implements Screen {
    private Stage stage;
    private Skin skin = App.skin;

    private GameMenuController controller = new GameMenuController();

    private SelectBox<Integer> playerCountBox;
    private TextField username1Field, username2Field, username3Field;
    private Label resultLabel;

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);
        table.pad(20);
        stage.addActor(table);

        table.add(new Label("Start New Game", skin, "title")).colspan(2).padBottom(20).row();

        table.add(new Label("Number of Players (1-3):", skin));
        playerCountBox = new SelectBox<>(skin);
        playerCountBox.setItems(1, 2, 3);
        table.add(playerCountBox).width(100).row();

        table.add(new Label("Username 1:", skin));
        username1Field = new TextField("", skin);
        table.add(username1Field).width(200).row();

        table.add(new Label("Username 2:", skin));
        username2Field = new TextField("", skin);
        table.add(username2Field).width(200).row();

        table.add(new Label("Username 3:", skin));
        username3Field = new TextField("", skin);
        table.add(username3Field).width(200).row();

        resultLabel = new Label("", skin);
        table.add(resultLabel).colspan(2).pad(10).row();

        TextButton startButton = new TextButton("Start Game", skin);
        table.add(startButton).colspan(2).padTop(20).row();

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

                Result result = controller.newGame(u1, u2, u3);
                resultLabel.setText(result.Message());

                if (result.IsSuccess()) {
                    App.getGameApp().setScreen(new MainGameGraphicView(new MainGameController()));
                }
            }
        });
    }

    private void updateFieldsVisibility() {
        int count = playerCountBox.getSelected();
        username1Field.setVisible(true);
        username2Field.setVisible(count >= 2);
        username3Field.setVisible(count == 3);
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
