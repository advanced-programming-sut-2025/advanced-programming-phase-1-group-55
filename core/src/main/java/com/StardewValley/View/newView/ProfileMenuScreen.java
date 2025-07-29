package com.StardewValley.View.newView;


import com.StardewValley.Controller.LoginMenuController;
import com.StardewValley.Controller.ProfileMenuController;
import com.StardewValley.Controller.RegisterController;
import com.StardewValley.model.App;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
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


public class ProfileMenuScreen implements Screen {
    private Stage stage;
    private Skin skin = App.skin;

    private ProfileMenuController controller;
    private RegisterController controller2;


    @Override
    public void show() {
        controller = new ProfileMenuController();
        controller2 = new RegisterController();
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        Texture bgTexture = new Texture(Gdx.files.internal("backgrounds/1.png"));
        Image image = new Image(bgTexture);
        image.setFillParent(true);
        stage.addActor(image);


        Table table = new Table();
        table.setFillParent(true);
        table.top().pad(20);
        stage.addActor(table);



        table.add(new Label("Profile Menu", skin, "default")).colspan(2).padBottom(20).row();

        TextField usernameField = new TextField("", skin);
        TextButton usernameBtn = new TextButton("Change Username", skin);
        table.add(usernameField).width(200).pad(5);
        table.add(usernameBtn).pad(5).row();

        TextField nicknameField = new TextField("", skin);
        TextButton nicknameBtn = new TextButton("Change Nickname", skin);
        table.add(nicknameField).width(200).pad(5);
        table.add(nicknameBtn).pad(5).row();

        TextField emailField = new TextField("", skin);
        TextButton emailBtn = new TextButton("Change Email", skin);
        table.add(emailField).width(200).pad(5);
        table.add(emailBtn).pad(5).row();

        TextField passwordField = new TextField("", skin);
        passwordField.setPasswordMode(true);
        passwordField.setPasswordCharacter('*');
        TextButton passwordBtn = new TextButton("Change Password", skin);
        table.add(passwordField).width(200).pad(5);
        table.add(passwordBtn).pad(5).row();

        TextButton infoBtn = new TextButton("Show User Info", skin);
        Label infoLabel = new Label("", skin);
        table.add(infoBtn).colspan(2).pad(10).row();
        table.add(infoLabel).colspan(2).pad(5).row();

        TextButton backBtn = new TextButton("Back to Main Menu", skin);
        table.add(backBtn).colspan(2).pad(20).row();

        usernameBtn.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                String result = controller.changeUsername(usernameField.getText()).Message();
                infoLabel.setText(result);
            }
        });

        nicknameBtn.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                String result = controller.changenickName(nicknameField.getText()).Message();
                infoLabel.setText(result);
            }
        });

        emailBtn.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                String result = controller.changeEmail(emailField.getText()).Message();
                infoLabel.setText(result);
            }
        });

        passwordBtn.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if (!controller2.isValidPassword(passwordField.getText())) {
                    infoLabel.setText("invalid password");
                } else {

                    infoLabel.setText("Password changed: " + passwordField.getText());
                }
            }
        });

        infoBtn.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                String result = controller.userInfo().Message();
                infoLabel.setText(result);
            }
        });

        backBtn.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                App.getGameApp().setScreen(new FirstMenu());
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.15f, 1);
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
