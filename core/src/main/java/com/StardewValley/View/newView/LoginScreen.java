package com.StardewValley.View.newView;

import com.StardewValley.Controller.LoginMenuController;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class LoginScreen extends ScreenAdapter {
    private Stage stage;
    private Skin skin;
    private LoginMenuController controller;

    public LoginScreen() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        controller = new LoginMenuController();

        skin = new Skin(Gdx.files.internal("skin/golden-ui-skin.json"));

        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        Label titleLabel = new Label("Login Menu", skin);
        TextField usernameField = new TextField("", skin);
        usernameField.setMessageText("Username");

        TextField passwordField = new TextField("", skin);
        passwordField.setPasswordCharacter('*');
        passwordField.setPasswordMode(true);
        passwordField.setMessageText("Password");

        CheckBox stayLoggedIn = new CheckBox("Stay Logged In", skin);

        TextButton loginButton = new TextButton("Login", skin);
        TextButton forgetButton = new TextButton("Forget Password", skin);
        Label resultLabel = new Label("", skin);

        loginButton.addListener(event -> {
            if (event.toString().equals("touchDown")) {
                String username = usernameField.getText().trim();
                String password = passwordField.getText().trim();
                String stay = stayLoggedIn.isChecked() ? "yes" : "no";
                String result = controller.login(username, password, stay).Message();
                resultLabel.setText(result);
            }
            return true;
        });

        forgetButton.addListener(event -> {
            if (event.toString().equals("touchDown")) {
                String username = usernameField.getText().trim();
                String result = controller.forgetPassword(username).Message();
                resultLabel.setText(result);
            }
            return true;
        });

        table.add(titleLabel).colspan(2).padBottom(20).row();
        table.add(usernameField).colspan(2).width(300).padBottom(10).row();
        table.add(passwordField).colspan(2).width(300).padBottom(10).row();
        table.add(stayLoggedIn).colspan(2).padBottom(10).row();
        table.add(loginButton).padRight(10);
        table.add(forgetButton).padLeft(10).row();
        table.add(resultLabel).colspan(2).padTop(20);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.15f, 1);
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
