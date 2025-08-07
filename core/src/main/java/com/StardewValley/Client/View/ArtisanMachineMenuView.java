package com.StardewValley.Client.View;

import com.StardewValley.Server.Controller.ArtisanMachineMenuController;
import com.StardewValley.Common.enums.AssetManager;
import com.StardewValley.Common.model.App;
import com.StardewValley.Common.model.Artisan.ArtisanMachine;
import com.StardewValley.Common.model.Artisan.ArtisanStatus;
import com.StardewValley.Common.model.Item.Item;
import com.StardewValley.Common.model.Map.GameMap;
import com.StardewValley.Common.model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.Map;

public class ArtisanMachineMenuView implements Screen {
    private final Stage stage;
    private final User player;
    private final GameMap map;
    private final ArtisanMachine artisanMachine;
    private final ArtisanMachineMenuController controller;
    private final Skin skin;
    private final TextButton backButton;
    private final TextButton endProgressButton;
    private final TextButton startProgressButton;
    private final TextButton cancelButton;
    private final TextButton collectButton;
    private final SelectBox<Item> selectBox;
    private final Label ErrorLabel;
    private com.badlogic.gdx.utils.Timer.Task clearErrorTask;
    private final Label SuccessMessageLabel;
    private com.badlogic.gdx.utils.Timer.Task clearErrorTask2;
    private ProgressBar energyBar;

    public ArtisanMachineMenuView(User player, GameMap map, ArtisanMachine artisanMachine, ArtisanMachineMenuController controller) {
        //todo artisan kaamel ok shod , faghat handle kardn navar pishraft moonde
        this.player = player;
        this.map = map;
        this.artisanMachine = artisanMachine;
        this.controller = controller;
        this.skin = App.skin;
        this.stage = new Stage(new ScreenViewport());
        this.selectBox = new SelectBox<>(skin);

        this.ErrorLabel = new Label("", skin);
        ErrorLabel.setColor(Color.RED);

        this.SuccessMessageLabel = new Label("", skin);
        SuccessMessageLabel.setColor(Color.GREEN);

        this.backButton = new TextButton("Back", skin);
        this.startProgressButton = new TextButton("Start", skin);
        this.cancelButton = new TextButton("Cancel", skin);
        this.endProgressButton = new TextButton("End Progress", skin);
        this.collectButton = new TextButton("Collect", skin);

        controller.setView(this);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        Texture backgroundTexture = AssetManager.ArtisanBackground.getTexture();
        Image backgroundImage = new Image(backgroundTexture);
        backgroundImage.setFillParent(true);
        stage.addActor(backgroundImage);
        Table root = new Table();
        root.setFillParent(true);
        stage.addActor(root);
        Label title = new Label(artisanMachine.getArtisanType().name()+" Machine Menu", skin);
        root.add(title).center().padTop(20).padBottom(100);
        root.row();


        ProgressBar.ProgressBarStyle progressBarStyle = new ProgressBar.ProgressBarStyle();

        Pixmap bgPixmap = new Pixmap(200, 20, Pixmap.Format.RGBA8888);
        bgPixmap.setColor(Color.DARK_GRAY);
        bgPixmap.fill();
        progressBarStyle.background = new TextureRegionDrawable(new Texture(bgPixmap));

        Pixmap knobPixmap = new Pixmap(1, 20, Pixmap.Format.RGBA8888);
        knobPixmap.setColor(Color.GREEN);
        knobPixmap.fill();
        progressBarStyle.knobBefore = new TextureRegionDrawable(new Texture(knobPixmap));

        energyBar = new ProgressBar(0f, artisanMachine.getArtisanType().getProcessTime(), 1f, false, progressBarStyle);
        energyBar.setValue(50f);
        root.add(energyBar).width(200).padBottom(200).center().row();


        Texture machineTexture = artisanMachine.getArtisanType().getTexture();
        if (machineTexture != null) {
            Image machineImage = new Image(machineTexture);
            machineImage.setScale(3f);
            root.add(machineImage).padBottom(100).center().padRight(60).row();
        } else {
            Label noImage = new Label("No Image Available", skin);
            root.add(noImage).padBottom(50).center().row();
        }


        if (artisanMachine.getStatus().equals(ArtisanStatus.off)) {
            Label selectLabel = new Label("Choose an item to start", skin);
            root.add(selectLabel).padTop(10).center().row();

            Map<String, Item> inventoryItems = player.getBackPack().getInventory();
            selectBox.setItems(inventoryItems.values().toArray(new Item[0]));
            root.add(selectBox).width(250).padBottom(20).center().row();
        }


        Table buttonRow = new Table();
        buttonRow.add(backButton).pad(5);

        switch (artisanMachine.getStatus()) {
            case ArtisanStatus.off:
                buttonRow.add(startProgressButton).pad(5);
                break;
            case ArtisanStatus.working:
                buttonRow.add(cancelButton).pad(5);
                buttonRow.add(endProgressButton).pad(5);
                break;
            case ArtisanStatus.ready:
                buttonRow.add(collectButton).pad(5);
                break;
        }


        root.add(buttonRow).bottom().padBottom(30).padTop(50).row();


        root.add(ErrorLabel).padTop(10).center().row();
        root.add(SuccessMessageLabel).padTop(5).center().row();
    }


    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        controller.handleButton();
        stage.act(delta);
        stage.draw();
    }
    public void setErrorMessage(String message) {
        ErrorLabel.setText(message);
        if (clearErrorTask != null) {
            clearErrorTask.cancel();
        }
        clearErrorTask = new Timer.Task() {
            @Override
            public void run() {
                ErrorLabel.setText("");
            }
        };
        Timer.schedule(clearErrorTask, 5);
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
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

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

    public Item getSelectedItem() {
        return selectBox.getSelected();
    }

    public Stage getStage() {
        return stage;
    }

    public User getPlayer() {
        return player;
    }

    public GameMap getMap() {
        return map;
    }

    public ArtisanMachine getArtisanMachine() {
        return artisanMachine;
    }

    public ArtisanMachineMenuController getController() {
        return controller;
    }

    public Skin getSkin() {
        return skin;
    }

    public TextButton getBackButton() {
        return backButton;
    }

    public TextButton getEndProgressButton() {
        return endProgressButton;
    }

    public TextButton getStartProgressButton() {
        return startProgressButton;
    }

    public TextButton getCancelButton() {
        return cancelButton;
    }

    public TextButton getCollectButton() {
        return collectButton;
    }

    public SelectBox<Item> getSelectBox() {
        return selectBox;
    }

    public ProgressBar getEnergyBar() {
        return energyBar;
    }

    public void setEnergyBar(ProgressBar energyBar) {
        this.energyBar = energyBar;
    }
}
