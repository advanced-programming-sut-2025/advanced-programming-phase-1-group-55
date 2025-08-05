package com.StardewValley.View.newView;


import com.StardewValley.Controller.RegisterController;
import com.StardewValley.model.App;
import com.StardewValley.model.Result;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class RegisterScreen extends ScreenAdapter {
    private Stage stage;
    private Skin skin = App.skin;

    private TextField usernameField, passwordField, confirmPasswordField, nicknameField, emailField;
    private SelectBox<String> genderBox;
    private SelectBox<String> securityQuestionBox;
    private TextField securityAnswerField;
    private Label messageLabel;
    private TextButton randomPasswordButton;
    private RegisterController controller = new RegisterController();

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Texture bgTexture = new Texture(Gdx.files.internal("backgrounds/4.png"));
        Image image = new Image(bgTexture);
        image.setFillParent(true);
        stage.addActor(image);
        Table table = new Table(skin);
        table.setFillParent(true);
        table.defaults().pad(10);
        stage.addActor(table);




        usernameField = new TextField("", skin);
        passwordField = new TextField("", skin);
        confirmPasswordField = new TextField("", skin);
        nicknameField = new TextField("", skin);
        emailField = new TextField("", skin);
        securityQuestionBox = new SelectBox<>(skin);
        securityQuestionBox.setItems(
            "What was the name of your first-grade teacher?",
            "What was the first phone number you ever memorized?",
            "What is the name of your childhood best friend?"
        );
        randomPasswordButton = new TextButton("Random password", skin);

        randomPasswordButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                String randomPassword = controller.RandomPasswordGenerator();
                passwordField.setText(randomPassword);
                confirmPasswordField.setText(randomPassword);
            }
        });

        securityAnswerField = new TextField("", skin);
        genderBox = new SelectBox<>(skin);
        genderBox.setItems("male", "female");

        passwordField.setPasswordCharacter('*');
        passwordField.setPasswordMode(true);
        confirmPasswordField.setPasswordCharacter('*');
        confirmPasswordField.setPasswordMode(true);

        TextButton registerButton = new TextButton("Register", skin);
        TextButton backButton = new TextButton("Back to MainMenu", skin);
        messageLabel = new Label("", skin);

        registerButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                String username = usernameField.getText().trim();
                String password = passwordField.getText().trim();
                String confirm = confirmPasswordField.getText().trim();
                String nickname = nicknameField.getText().trim();
                String email = emailField.getText().trim();
                String gender = genderBox.getSelected();

                String selectedQuestion = securityQuestionBox.getSelected();
                String answer = securityAnswerField.getText().trim();
                Result result = controller.Register(username, password, confirm, nickname, email, gender, selectedQuestion, answer);
                messageLabel.setText(result.Message());
                if (result.IsSuccess()) {
                    App.getGameApp().setScreen(new MainMenuScreen());
                }
            }
        });

        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                App.getGameApp().setScreen(new FirstMenu());
            }
        });

        table.add("Username:").left();
        table.add(usernameField).width(300).row();


        table.add("Password:").left();
        table.add(passwordField).width(300).row();

        table.add("Confirm Password:").left();
        table.add(confirmPasswordField).width(300).row();
        table.add("random password").left();
        table.add(randomPasswordButton).width(300).row();


        table.add("Nickname:").left();
        table.add(nicknameField).width(300).row();
        table.add("Email:").left();
        table.add(emailField).width(300).row();
        table.add("Gender:").left();
        table.add(genderBox).width(300).row();
        table.add("Security Question:").left();
        table.add(securityQuestionBox).width(300).row();
        table.add("Your Answer:").left();
        table.add(securityAnswerField).width(300).row();

        table.add(registerButton).colspan(2).center().row();
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
