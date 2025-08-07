package com.StardewValley.View;

import com.StardewValley.Controller.AnimalMenuController;
import com.StardewValley.Controller.BuyAnimalMenuController;
import com.StardewValley.model.App;
import com.StardewValley.model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class AnimalMenuView implements Screen {
    private Stage stage;
    private final Skin skin = App.skin;
    private final AnimalMenuController controller;
    private final User user;
    private TextButton buildBarnButton;
    private TextButton buildCoopButton;
    private TextButton buyAnimalButton;
    private final Label errorLabel;
    private TextButton backButton;

    public AnimalMenuView(AnimalMenuController controller, User user) {
        this.controller = controller;
        this.controller.setView(this);
        this.user = user;
        buildBarnButton = new TextButton("Build Barn", skin);
        buildCoopButton = new TextButton("Build Coop", skin);
        buyAnimalButton = new TextButton("Buy Animal", skin);
        errorLabel = new Label("", skin);
        errorLabel.setColor(Color.RED);
        errorLabel.setWrap(true);
        backButton = new TextButton("Back", skin);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        Texture bgTex = new Texture(Gdx.files.internal("background/vintage-textured-paper-background-vector.jpg"));
        Image bgImage = new Image(bgTex);
        bgImage.setFillParent(true);
        stage.addActor(bgImage);
        Table rootTable = new Table();
        rootTable.setFillParent(true);
        stage.addActor(rootTable);
        Table menuTable = new Table();
        menuTable.defaults().width(400).height(80).pad(14);

        menuTable.add(buildBarnButton).row();
        menuTable.add(buildCoopButton).row();
        menuTable.add(buyAnimalButton).row();
        menuTable.add(backButton).row();
        menuTable.add(errorLabel).row();
        rootTable.add(menuTable).center();

        buildBarnButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                controller.handleBuildRequest("Barn");
            }
        });

        buildCoopButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                controller.handleBuildRequest("Coop");
            }
        });

        buyAnimalButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                App.gameApp.setScreen(new BuyAnimalMenuView(
                    new BuyAnimalMenuController(user), user));
            }
        });

        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                App.gameApp.setScreen(App.currentGameGraphicView);
            }
        });
    }

    public void setErrorMessage(String message) {
        errorLabel.setText(message);
        errorLabel.clearActions();
        if (!message.isEmpty()) {
            errorLabel.addAction(Actions.sequence(
                Actions.delay(2),
                Actions.run(() -> errorLabel.setText(""))
            ));
        }
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));
        stage.draw();
    }

    @Override public void resize(int w, int h) { }
    @Override public void pause() { }
    @Override public void resume() { }
    @Override public void hide() { }
    @Override public void dispose() { stage.dispose(); }
}
