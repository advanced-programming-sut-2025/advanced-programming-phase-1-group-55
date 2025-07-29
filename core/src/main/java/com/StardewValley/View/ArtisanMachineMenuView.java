package com.StardewValley.View;

import com.StardewValley.Controller.ArtisanMachineMenuController;
import com.StardewValley.model.App;
import com.StardewValley.model.Artisan.ArtisanMachine;
import com.StardewValley.model.Map.GameMap;
import com.StardewValley.model.User;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class ArtisanMachineMenuView implements Screen {
    private Stage stage;
    private User player;
    private GameMap map;
    private ArtisanMachine artisanMachine;
    private ArtisanMachineMenuController controller;
    private Skin skin;
    private TextButton backButton;
    private TextButton endProgressButton;
    private TextButton startProgressButton;
    private TextButton cancelButton;
    private TextButton collectButton;
    private final Label ErrorLabel;
    private com.badlogic.gdx.utils.Timer.Task clearErrorTask;
    private final Label SuccessMessageLabel;
    private com.badlogic.gdx.utils.Timer.Task clearErrorTask2;

    public ArtisanMachineMenuView(User player, GameMap map, ArtisanMachine artisanMachine, ArtisanMachineMenuController controller) {
        this.player = player;
        this.map = map;
        this.artisanMachine = artisanMachine;
        this.controller = controller;
        ErrorLabel = new Label("", skin);
        ErrorLabel.setColor(Color.RED);
        SuccessMessageLabel = new Label("", skin);
        SuccessMessageLabel.setColor(Color.GREEN);
        collectButton = new TextButton("Collect", skin);
        backButton = new TextButton("Back", skin);
        cancelButton = new TextButton("Cancel", skin);
        startProgressButton = new TextButton("Start", skin);
        skin= App.getSkin();
        stage = new Stage();
        controller.setView(this);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {

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

    }
}
