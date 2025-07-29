package com.StardewValley.View.newView;

import com.StardewValley.model.App;
import com.StardewValley.model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class FirstMenu extends ScreenAdapter {
    private Stage stage;
    private Skin skin = App.skin;

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
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
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                if (keycode == Input.Keys.G) {
                    App.mainUser = App.getAllUsers().get("asdas");
                    App.getGameApp().setScreen(new MainMenuScreen());

                }
                if (keycode == Input.Keys.A) {
                    App.mainUser = App.getAllUsers().get("asdas");
                    App.getGameApp().setScreen(new MapSelectionScreen());

                }
                return true;
            }
        });

        table.add(registerBtn).size(400, 100).padBottom(20).row();
        table.add(loginBtn).size(400, 100).padBottom(20).row();
        table.add(exitBtn).size(400, 100);

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
