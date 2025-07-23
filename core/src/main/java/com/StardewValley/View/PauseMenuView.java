package com.StardewValley.View;

import com.StardewValley.Controller.PauseMenuController;
import com.StardewValley.enums.AssetManager;
import com.StardewValley.model.App;
import com.StardewValley.model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class PauseMenuView implements Screen {
    private Stage stage;
    public Table table;
   private final Skin skin= App.getSkin();
    private final PauseMenuController controller;
    private final User user;
    private TextButton ResumeButton ;
    private TextButton SocialMenuButton ;
    private TextButton MapMenuButton ;
    private TextButton InventoryMenuButton ;
    private TextButton toolsMenuButton ;
    private TextButton skillsButton;
    private final Label errorLabel;
    private Timer.Task clearErrorTask;
    private final Label SuccessMessageLabel;
    private Timer.Task clearErrorTask2;
    public PauseMenuView(PauseMenuController controller,User user) {
        this.controller = controller;
        this.table = new Table();
        this.controller.setView(this);
        this.user = user;


        ResumeButton = new TextButton("Resume Game", skin);
        SocialMenuButton = new TextButton("Social", skin);
        MapMenuButton = new TextButton("Map", skin);
        InventoryMenuButton = new TextButton("Inventory", skin);
        toolsMenuButton = new TextButton("Tools", skin);
        skillsButton= new TextButton("Skills", skin);

        errorLabel = new Label("", skin);
        errorLabel.setColor(Color.RED);
        errorLabel.setWrap(true);
        SuccessMessageLabel = new Label("", skin);
        SuccessMessageLabel.setColor(Color.GREEN);
        SuccessMessageLabel.setWrap(true);
    }
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);


        Texture backgroundTexture = new Texture(Gdx.files.internal("background/vintage-textured-paper-background-vector.jpg"));
        Image backgroundImage = new Image(backgroundTexture);
        backgroundImage.setFillParent(true);
        stage.addActor(backgroundImage);

        Table rootTable = new Table();
        rootTable.setFillParent(true);
        stage.addActor(rootTable);

        Table menuTable = new Table();
        menuTable.defaults().width(500).height(90).pad(14);
        menuTable.add(ResumeButton).row();
        menuTable.add(SocialMenuButton).row();
        menuTable.add(InventoryMenuButton).row();
        menuTable.add(toolsMenuButton).row();
        menuTable.add(skillsButton).row();
        menuTable.add(errorLabel).row();
        menuTable.add(SuccessMessageLabel).row();


        Table centerTable = new Table();
        centerTable.add(menuTable).top().left().padRight(50);
        rootTable.top().padTop(20);
        rootTable.add(centerTable).expand().center().row();
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0, 0, 0, 1);
        App.gameApp.getBatch().begin();
        App.gameApp.getBatch().end();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
        controller.handleButtonPressed();
    }
    public void setErrorMessage(String error) {
        errorLabel.setText(error);

        errorLabel.clearActions();

        if (!error.isEmpty()) {
            errorLabel.addAction(Actions.sequence(
                Actions.delay(2),
                Actions.run(() -> {
                    errorLabel.setText("");
                    System.out.println("ERROR CLEARED via Action!");
                })
            ));
        }
    }
    public void setSuccessMessage(String message) {
        SuccessMessageLabel.setText(message);
        if (clearErrorTask2 != null) {
            clearErrorTask2.cancel();
        }
        clearErrorTask2 = new Timer.Task() {
            @Override
            public void run() {
                SuccessMessageLabel.setText("");
            }
        };
        Timer.schedule(clearErrorTask2, 5);
    }

    @Override
    public void resize(int i, int i1) {

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
        if (clearErrorTask != null) clearErrorTask.cancel();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }


    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public PauseMenuController getController() {
        return controller;
    }

    public User getUser() {
        return user;
    }


}
