package com.StardewValley.View.newView;

import com.StardewValley.Controller.PauseMenuController;
import com.StardewValley.View.oldView.ExitMenu;
import com.StardewValley.model.App;
import com.StardewValley.model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class PauseMenuView implements Screen {
    private Stage stage;
    public Table table;
    private final Skin skin = App.skin;
    private final PauseMenuController controller;
    private final User user;
    private TextButton ResumeButton;
    private TextButton SocialMenuButton;
    private TextButton MapMenuButton;
    private TextButton InventoryMenuButton;
    private TextButton toolsMenuButton;
    private TextButton skillsButton;
    private TextButton ExitButton;
    private TextButton recycleBinButton;
    private TextButton questsButton;
    private TextButton SaveButton;
    private final Label errorLabel;
    private Timer.Task clearErrorTask;
    private final Label SuccessMessageLabel;
    private Timer.Task clearErrorTask2;

    public PauseMenuView(PauseMenuController controller, User user) {
        this.controller = controller;
        this.table = new Table();
        this.controller.setView(this);
        this.user = user;


        ResumeButton = new TextButton("Resume Game", skin);
        SocialMenuButton = new TextButton("Social", skin);
        MapMenuButton = new TextButton("Map", skin);
        toolsMenuButton = new TextButton("Tools", skin);
        skillsButton = new TextButton("Skills", skin);
        ExitButton = new TextButton("Exit", skin);
        SaveButton = new TextButton("Save", skin);
        recycleBinButton = new TextButton("Inventory", skin);
        questsButton = new TextButton("Quests", skin);

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
        menuTable.defaults().width(400).height(80).pad(14);
        menuTable.add(ResumeButton).row();
        menuTable.add(SocialMenuButton).row();
        menuTable.add(questsButton).row();
        menuTable.add(MapMenuButton).row();
        menuTable.add(recycleBinButton).row();
        menuTable.add(toolsMenuButton).row();
        menuTable.add(skillsButton).row();
        menuTable.add(ExitButton).row();
        menuTable.add(SaveButton).row();
        menuTable.add(errorLabel).row();
        menuTable.add(SuccessMessageLabel).row();


        Table centerTable = new Table();
        centerTable.add(menuTable).top().left().padRight(50).padTop(40);
        rootTable.top().padTop(20);
        rootTable.add(centerTable).expand().center().row();
        ExitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });

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

    public Skin getSkin() {
        return skin;
    }

    public TextButton getResumeButton() {
        return ResumeButton;
    }

    public void setResumeButton(TextButton resumeButton) {
        ResumeButton = resumeButton;
    }

    public TextButton getSocialMenuButton() {
        return SocialMenuButton;
    }

    public void setSocialMenuButton(TextButton socialMenuButton) {
        SocialMenuButton = socialMenuButton;
    }

    public TextButton getMapMenuButton() {
        return MapMenuButton;
    }

    public void setMapMenuButton(TextButton mapMenuButton) {
        MapMenuButton = mapMenuButton;
    }

    public TextButton getInventoryMenuButton() {
        return InventoryMenuButton;
    }

    public void setInventoryMenuButton(TextButton inventoryMenuButton) {
        InventoryMenuButton = inventoryMenuButton;
    }

    public TextButton getToolsMenuButton() {
        return toolsMenuButton;
    }

    public void setToolsMenuButton(TextButton toolsMenuButton) {
        this.toolsMenuButton = toolsMenuButton;
    }

    public TextButton getSkillsButton() {
        return skillsButton;
    }

    public void setSkillsButton(TextButton skillsButton) {
        this.skillsButton = skillsButton;
    }

    public Label getErrorLabel() {
        return errorLabel;
    }

    public Timer.Task getClearErrorTask() {
        return clearErrorTask;
    }

    public void setClearErrorTask(Timer.Task clearErrorTask) {
        this.clearErrorTask = clearErrorTask;
    }

    public Label getSuccessMessageLabel() {
        return SuccessMessageLabel;
    }

    public Timer.Task getClearErrorTask2() {
        return clearErrorTask2;
    }

    public void setClearErrorTask2(Timer.Task clearErrorTask2) {
        this.clearErrorTask2 = clearErrorTask2;
    }

    public TextButton getExitButton() {
        return ExitButton;
    }

    public void setExitButton(TextButton exitButton) {
        ExitButton = exitButton;
    }

    public TextButton getSaveButton() {
        return SaveButton;
    }

    public void setSaveButton(TextButton saveButton) {
        SaveButton = saveButton;
    }

    public TextButton getRecycleBinButton() {
        return recycleBinButton;
    }

    public void setRecycleBinButton(TextButton recycleBinButton) {
        this.recycleBinButton = recycleBinButton;
    }

    public TextButton getQuestsButton() {
        return questsButton;
    }

    public void setQuestsButton(TextButton questsButton) {
        this.questsButton = questsButton;
    }
}
