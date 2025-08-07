package com.StardewValley.View;

import com.StardewValley.Controller.RegisterController;
import com.StardewValley.model.App;
import com.StardewValley.model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import static com.StardewValley.model.App.AllUsers;

public class ForgetPasswordScreen extends ScreenAdapter {
    private Stage stage;
    private Skin skin=App.skin;


    private TextField usernameField, answerField, newPasswordField;
    private Label questionLabel, messageLabel;
    private TextButton checkButton, changePasswordButton, backButton;
    private RegisterController controller = new RegisterController();

    private User currentUser;

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Texture bgTexture = new Texture(Gdx.files.internal("backgrounds/2.png"));
        Image image = new Image(bgTexture);
        image.setFillParent(true);
        stage.addActor(image);
        Table table = new Table();
        table.setFillParent(true);
        table.defaults().pad(10);
        stage.addActor(table);

        Label title = new Label("Forget Password", skin);
        usernameField = new TextField("", skin);
        usernameField.setMessageText("Enter Username");

        questionLabel = new Label("", skin);
        answerField = new TextField("", skin);
        answerField.setMessageText("Answer");

        newPasswordField = new TextField("", skin);
        newPasswordField.setMessageText("New Password");
        newPasswordField.setPasswordCharacter('*');
        newPasswordField.setPasswordMode(true);
        newPasswordField.setVisible(false);

        messageLabel = new Label("", skin);

        checkButton = new TextButton("Check", skin);
        changePasswordButton = new TextButton("Change Password", skin);
        changePasswordButton.setVisible(false);

        backButton = new TextButton("Back", skin);
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                App.getGameApp().setScreen(new LoginScreen());
            }
        });

        checkButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                String username = usernameField.getText().trim();
                if (AllUsers.containsKey(username)) {
                    currentUser = AllUsers.get(username);
                    questionLabel.setText("Security Question: " + currentUser.getSecurityQuestion());
                    messageLabel.setText("");
                } else {
                    messageLabel.setText("User not found.");
                }
            }
        });

        changePasswordButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                String answer = answerField.getText().trim();
                String newPassword = newPasswordField.getText().trim();

                if (currentUser != null && currentUser.getAnswerOfSecurityQuestion().equalsIgnoreCase(answer)) {
                    if (!controller.isValidPassword(newPassword)) {
                        messageLabel.setText("password is invalid!");
                    } else {

                        currentUser.setPassword(controller.convertToSHA(newPassword));
                        messageLabel.setText("Password changed successfully.");
                    }
                } else {
                    messageLabel.setText("Wrong answer.");
                }
            }
        });

        answerField.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (!questionLabel.getText().equals("")) {
                    changePasswordButton.setVisible(true);
                    newPasswordField.setVisible(true);
                }
            }
        });

        table.add(title).colspan(2).center().row();
        table.add(usernameField).colspan(2).width(300).row();
        table.add(checkButton).colspan(2).center().row();
        table.add(questionLabel).colspan(2).row();
        table.add(answerField).colspan(2).width(300).row();
        table.add(newPasswordField).colspan(2).width(300).row();
        table.add(changePasswordButton).colspan(2).center().row();
        table.add(backButton).colspan(2).center().row();
        table.add(messageLabel).colspan(2).center();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.15f, 1);
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
