package com.StardewValley.Client.View;

import com.StardewValley.Server.Controller.ToolsMenuController;
import com.StardewValley.Common.model.App;
import com.StardewValley.Common.model.Tool.Tools;
import com.StardewValley.Common.model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Map;

public class ToolsMenuView implements Screen {
    private Stage stage;
    private Skin skin;
    private ToolsMenuController controller;
    private Table table;
    private TextButton backBtn;
    private TextButton confirmBtn;
    private Tools selectedTool;
    private User user;
    private Label successMessageLabel;
    private Timer.Task clearErrorTask2;
    private Tools chosenTool;
    private Image backgroundImage;

    public ToolsMenuView(ToolsMenuController controller, User user) {
        this.controller = controller;
        this.user = user;
        controller.setView(this);
        this.skin = App.skin;
        this.table = new Table();
        this.backBtn = new TextButton("Back", skin);
        this.confirmBtn = new TextButton("Confirm", skin);
        this.chosenTool = user.getBackPack().getCurrentTool();
    }

    @Override
    public void show() {
        if (stage == null) {
            stage = new Stage();
            Gdx.input.setInputProcessor(stage);

            Texture backgroundTexture = new Texture(Gdx.files.internal("background/vintage-textured-paper-background-vector.jpg"));
            backgroundImage = new Image(backgroundTexture);
            backgroundImage.setFillParent(true);
            stage.addActor(backgroundImage);
            stage.addActor(table);
        }

        table.clear();
        table.setFillParent(true);
        rebuildToolImages();
    }

    private void rebuildToolImages() {
        Map<String, Tools> availableTools = user.getBackPack() != null ? user.getBackPack().getAvailableTools() : null;
        if (availableTools == null || availableTools.isEmpty()) {
            System.out.println("No tools available");
            return;
        }

        table.clear();

        Label title = new Label("Select Your Tool", skin);
        table.add(title).colspan(availableTools.size()).padBottom(20).row();

        for (Tools tool : availableTools.values()) {
            Sprite toolSprite = new Sprite(tool.getSprite());

            if (tool.equals(chosenTool)) {
                toolSprite.setColor(0.8f, 1f, 0.8f, 1f);
                toolSprite.setScale(1.3f);
            } else {
                toolSprite.setColor(1f, 1f, 1f, 1f);
            }

            Image toolImage = new Image(new SpriteDrawable(toolSprite));
            toolImage.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    chosenTool = tool;
                    rebuildToolImages();
                }
            });

            table.add(toolImage).pad(10).width(64).height(64);
        }

        table.row();
        table.add(confirmBtn).colspan(availableTools.size()).padTop(20).row();
        table.add(backBtn).colspan(availableTools.size()).padTop(10);


    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        controller.handleButton(chosenTool);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        stage.dispose();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Skin getSkin() {
        return skin;
    }

    public void setSkin(Skin skin) {
        this.skin = skin;
    }

    public ToolsMenuController getController() {
        return controller;
    }

    public void setController(ToolsMenuController controller) {
        this.controller = controller;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public TextButton getBackBtn() {
        return backBtn;
    }

    public void setBackBtn(TextButton backBtn) {
        this.backBtn = backBtn;
    }

    public TextButton getConfirmBtn() {
        return confirmBtn;
    }

    public void setConfirmBtn(TextButton confirmBtn) {
        this.confirmBtn = confirmBtn;
    }

    public Tools getSelectedTool() {
        return selectedTool;
    }

    public void setSelectedTool(Tools selectedTool) {
        this.selectedTool = selectedTool;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Label getSuccessMessageLabel() {
        return successMessageLabel;
    }

    public void setSuccessMessageLabel(Label successMessageLabel) {
        this.successMessageLabel = successMessageLabel;
    }

    public Timer.Task getClearErrorTask2() {
        return clearErrorTask2;
    }

    public void setClearErrorTask2(Timer.Task clearErrorTask2) {
        this.clearErrorTask2 = clearErrorTask2;
    }

    public Tools getChosenTool() {
        return chosenTool;
    }

    public void setChosenTool(Tools chosenTool) {
        this.chosenTool = chosenTool;
    }

    public Image getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }
}
