package com.StardewValley.Client.View;

import com.StardewValley.Client.ClientController;
import com.StardewValley.Common.model.App;
import com.StardewValley.Common.model.Trade;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.ArrayList;

public class ShowTradesScreen implements Screen {

    private final Skin skin;
    private Stage stage;
    private Table tradesTable;
    private ArrayList<Trade> trades;

    public ShowTradesScreen(ArrayList<Trade> ts) {
        this.trades = ts != null ? ts : new ArrayList<>();
        this.skin = App.skin;
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Table root = new Table();
        root.setFillParent(true);
        stage.addActor(root);

        Label title = new Label("Trade List", skin);
        title.setAlignment(Align.center);

        TextButton backBtn = new TextButton("Back", skin);
        backBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                App.getGameApp().setScreen(App.currentGameGraphicView);
            }
        });

        tradesTable = new Table(skin);
        ScrollPane scrollPane = new ScrollPane(tradesTable, skin);
        scrollPane.setFadeScrollBars(false);

        root.add(title).pad(10).row();
        root.add(backBtn).pad(5).row();
        root.add(scrollPane).grow().pad(10);

        rebuildTradesTable();
    }

    private void rebuildTradesTable() {
        tradesTable.clearChildren();

        if (trades.isEmpty()) {
            tradesTable.add(new Label("No trades yet.", skin)).colspan(10).pad(10).expandX().fillX();
            return;
        }

        tradesTable.add(new Label("#", skin)).pad(5).expandX().fillX();
        tradesTable.add(new Label("Sender", skin)).pad(5).expandX().fillX();
        tradesTable.add(new Label("Receiver", skin)).pad(5).expandX().fillX();
        tradesTable.add(new Label("Item", skin)).pad(5).expandX().fillX();
        tradesTable.add(new Label("Qty", skin)).pad(5).expandX().fillX();
        tradesTable.add(new Label("Target Item", skin)).pad(5).expandX().fillX();
        tradesTable.add(new Label("Target Qty", skin)).pad(5).expandX().fillX();
        tradesTable.add(new Label("Price", skin)).pad(5).expandX().fillX();
        tradesTable.add(new Label("Accepted", skin)).pad(5).expandX().fillX();
        tradesTable.add(new Label("Action", skin)).pad(5).expandX().fillX();
        tradesTable.row();

        int index = 1;
        for (Trade t : trades) {
            tradesTable.add(new Label(String.valueOf(index), skin)).pad(5).expandX().fillX();
            tradesTable.add(new Label(safeStr(t.getSender()), skin)).pad(5).expandX().fillX();
            tradesTable.add(new Label(safeStr(t.getReciver()), skin)).pad(5).expandX().fillX();
            tradesTable.add(new Label(safeStr(t.getItem()), skin)).pad(5).expandX().fillX();
            tradesTable.add(new Label(String.valueOf(t.getAmount()), skin)).pad(5).expandX().fillX();
            tradesTable.add(new Label(safeStr(t.getTargetItem()), skin)).pad(5).expandX().fillX();
            tradesTable.add(new Label(String.valueOf(t.getTargetAmount()), skin)).pad(5).expandX().fillX();
            tradesTable.add(new Label(String.valueOf(t.getPrice()), skin)).pad(5).expandX().fillX();

            String acceptedStr = t.isAccepted() ? "Accepted" : "Pending";
            tradesTable.add(new Label(acceptedStr, skin)).pad(5).expandX().fillX();

            TextButton acceptButton = new TextButton("Accept", skin);
            if (!t.isAccepted()) {
                acceptButton.addListener(new ChangeListener() {
                    @Override
                    public void changed(ChangeEvent event, com.badlogic.gdx.scenes.scene2d.Actor actor) {
                        acceptTrade(t);
                    }
                });
                tradesTable.add(acceptButton).pad(5).expandX().fillX();
            } else {
                tradesTable.add(new Label("-", skin)).pad(5).expandX().fillX();
            }


            tradesTable.row();
            index++;
        }

        if (tradesTable.getParent() == null) {
            ScrollPane scrollPane = new ScrollPane(tradesTable, skin);
            scrollPane.setFillParent(true);
            stage.addActor(scrollPane);
        }
    }





    private void acceptTrade(Trade trade) {
        trade.setAccepted(true);
        ClientController.getInstance().sendTradeAcceptance(trade);
        rebuildTradesTable();
    }

    private static String safeStr(String s) {
        return s == null ? "-" : s;
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.08f, 0.09f, 0.11f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override public void resize(int width, int height) { stage.getViewport().update(width, height, true); }
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() { stage.dispose(); }
}
