package com.StardewValley.Client.View;

import com.StardewValley.Client.ClientController;
import com.StardewValley.Common.model.App;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.StardewValley.Common.model.Item.Item;
import com.StardewValley.Common.model.Trade;
import com.StardewValley.Common.model.User;

import java.util.List;

public class TradeMenuScreen extends ScreenAdapter {

    private Stage stage;
    private Skin skin;
    private User currentUser;
    private List<User> allPlayers;
    private List<Item> inventory;

    public TradeMenuScreen(User currentUser, List<User> allPlayers, List<Item> inventory) {
        this.currentUser = currentUser;
        this.allPlayers = allPlayers;
        this.inventory = inventory;
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        skin = App.skin;

        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        Label playerLabel = new Label("Select a player:", skin);
        Array<String> playerNames = new Array<>();
        for (User u : allPlayers) {
            if (u.getUsername().equals(App.mainUser.getUsername())) {
                continue;
            }
            if (u != null && u.getUsername() != null) {
                playerNames.add(u.getUsername());
            }
        }
        SelectBox<String> playerBox = new SelectBox<>(skin);
        if (playerNames.size > 0) {
            playerBox.setItems(playerNames.toArray(String[]::new));
            playerBox.setSelected(playerNames.first());
        }

        Label itemLabel = new Label("Select your item:", skin);
        Array<String> myItemNames = new Array<>();
        for (Item i : inventory) {
            if (i != null && i.getItemType() != null && i.getItemType().getDisplayName() != null) {
                myItemNames.add(i.getItemType().getDisplayName());
            }
        }
        SelectBox<String> itemBox = new SelectBox<>(skin);
        if (myItemNames.size > 0) {
            itemBox.setItems(myItemNames.toArray(String[]::new));
            itemBox.setSelected(myItemNames.first());
        }

        Label amountLabel = new Label("Amount:", skin);
        TextField amountField = new TextField("1", skin);

        Label targetItemLabel = new Label("Target item:", skin);
        Array<String> targetItemNames = new Array<>();
        for (Item i : inventory) {
            if (i != null && i.getItemType() != null && i.getItemType().getDisplayName() != null) {
                targetItemNames.add(i.getItemType().getDisplayName());
            }
        }
        SelectBox<String> targetItemBox = new SelectBox<>(skin);
        if (targetItemNames.size > 0) {
            targetItemBox.setItems(targetItemNames.toArray(String[]::new));
            targetItemBox.setSelected(targetItemNames.first());
        }

        Label targetAmountLabel = new Label("Target amount:", skin);
        TextField targetAmountField = new TextField("1", skin);

        TextButton sendButton = new TextButton("Send Trade Request", skin);
        sendButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, com.badlogic.gdx.scenes.scene2d.Actor actor) {
                if (playerBox.getSelected() == null || itemBox.getSelected() == null || targetItemBox.getSelected() == null)
                    return;

                User receiver = allPlayers.get(playerBox.getSelectedIndex());
                Item myItem = inventory.get(itemBox.getSelectedIndex());
                int amount = Integer.parseInt(amountField.getText());
                Item targetItem = inventory.get(targetItemBox.getSelectedIndex());
                int targetAmount = Integer.parseInt(targetAmountField.getText());

                Trade trade = new Trade(
                    currentUser.getUsername(),
                    receiver.getUsername(),
                    myItem.getItemType().getDisplayName(),
                    "item_for_item",
                    amount,
                    0,
                    targetItem.getItemType().getDisplayName(),
                    targetAmount,
                    generateTradeId()
                );

                ClientController.getInstance().sendTradeRequest(trade);


                ((com.badlogic.gdx.Game) Gdx.app.getApplicationListener()).setScreen(App.currentGameGraphicView);
                dispose();
            }
        });

        table.add(playerLabel).left();
        table.add(playerBox).row();
        table.add(itemLabel).left();
        table.add(itemBox).row();
        table.add(amountLabel).left();
        table.add(amountField).row();
        table.add(targetItemLabel).left();
        table.add(targetItemBox).row();
        table.add(targetAmountLabel).left();
        table.add(targetAmountField).row();
        table.add(sendButton).colspan(2).padTop(20f);
    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    private int generateTradeId() {
        int a = 1;
        return (a++);
    }


}
