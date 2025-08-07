package com.StardewValley.View;

import com.StardewValley.Controller.CheatItemFinalMenuController;
import com.StardewValley.enums.AssetManager;
import com.StardewValley.model.App;
import com.StardewValley.model.Item.Item;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;

public class CheatItemFinalView implements Screen {
    private Skin skin;
    private Button backButton;
    private Button confirmButton;
    private CheatItemFinalMenuController controller;
    private Stage stage;
    private Item item;
    private final int[] quantity = {1};
    private CheatItemMenuView cheatItemView;
    private int totalPrice;
    private final Label ErrorLabel;
    private com.badlogic.gdx.utils.Timer.Task clearErrorTask;
    private final Label SuccessMessageLabel;
    private com.badlogic.gdx.utils.Timer.Task clearErrorTask2;

    public CheatItemFinalView( Item item, CheatItemMenuView cheatItemView,CheatItemFinalMenuController controller) {
        this.controller = controller;
        this.item = item;
        this.controller.setView(this);
        this.skin = App.skin;
        this.stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        this.cheatItemView = cheatItemView;

        this.backButton = new TextButton("Back", skin);
        this.confirmButton = new TextButton("Confirm", skin);
        ErrorLabel = new Label("", skin);
        ErrorLabel.setColor(Color.RED);
        SuccessMessageLabel = new Label("", skin);
        SuccessMessageLabel.setColor(Color.GREEN);
        totalPrice = item.getPrice();
    }

    @Override
    public void show() {
        Table rootTable = new Table();
        rootTable.setFillParent(true);
        rootTable.top().padTop(50);
        stage.addActor(rootTable);

        Texture itemImage=item.getItemType().getTexture();
        if (itemImage==null){
            itemImage = AssetManager.heart.getTexture();
        }
        if (itemImage != null) {
            Image image = new Image(itemImage);
            image.setScaling(Scaling.fit);
            rootTable.add(image).size(180, 180).colspan(2).padBottom(25).row();
        }

        Label nameLabel = new Label(item.getItemType().getDisplayName(), skin);
        nameLabel.setFontScale(1.4f);
        rootTable.add(nameLabel).colspan(2).padBottom(40).row();

        Label quantityTitleLabel = new Label("Quantity:", skin);
        quantityTitleLabel.setFontScale(1.1f);

        Label quantityLabel = new Label(String.valueOf(quantity[0]), skin);
        quantityLabel.setAlignment(Align.center);
        quantityLabel.setFontScale(1.2f);

        TextButton minusButton = new TextButton("<", skin);
        minusButton.setWidth(30);
        minusButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (quantity[0] > 1) {
                    quantity[0]--;
                    quantityLabel.setText(String.valueOf(quantity[0]));

                }
            }
        });

        TextButton plusButton = new TextButton(">", skin);
        plusButton.setWidth(30);
        plusButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                quantity[0]++;
                quantityLabel.setText(String.valueOf(quantity[0]));

            }
        });

        Table quantityTable = new Table();
        quantityTable.add(minusButton).width(10).height(40).padRight(50);
        quantityTable.add(quantityLabel).width(60);
        quantityTable.add(plusButton).width(10).height(40).padLeft(50);

        rootTable.add(quantityTitleLabel).padRight(90).padBottom(100);
        rootTable.add(quantityTable).padBottom(100).row();

        Table buttonTable = new Table();
        buttonTable.add(backButton).width(130).height(55).padRight(30);
        buttonTable.add(confirmButton).width(130).height(55);

        rootTable.add(buttonTable).colspan(2).padBottom(20).row();
        rootTable.add(ErrorLabel).colspan(2).center().row();
        rootTable.add(SuccessMessageLabel).colspan(2).center().row();
    }



    @Override
    public void render(float delta) {
        controller.handleButton();
        ScreenUtils.clear(0.2f, 0.2f, 0.25f, 1);
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

    public Skin getSkin() {
        return skin;
    }

    public void setSkin(Skin skin) {
        this.skin = skin;
    }

    public Button getBackButton() {
        return backButton;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }

    public Button getConfirmButton() {
        return confirmButton;
    }

    public void setConfirmButton(Button confirmButton) {
        this.confirmButton = confirmButton;
    }

    public CheatItemFinalMenuController getController() {
        return controller;
    }

    public void setController(CheatItemFinalMenuController controller) {
        this.controller = controller;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity[0];
    }

    public CheatItemMenuView getCheatItemView() {
        return cheatItemView;
    }

    public void setCheatItemView(CheatItemMenuView cheatItemView) {
        this.cheatItemView = cheatItemView;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Label getErrorLabel() {
        return ErrorLabel;
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
}
