package com.StardewValley.Client.View;


import com.StardewValley.Common.model.App;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.StardewValley.Common.GameDetails;
import com.StardewValley.Common.model.Trade;

import java.util.ArrayList;
import java.util.List;

public class ShowTradesScreen implements Screen {

    private final Skin skin;
    private Stage stage;

    private Table root;
    private Table tradesTable;
    private ScrollPane scrollPane;
    private ArrayList<Trade> trades;

    public ShowTradesScreen(ArrayList<Trade> ts) {
        this.trades = ts;
        this.skin = App.skin;
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        root = new Table();
        root.setFillParent(true);
        root.defaults().pad(6);
        stage.addActor(root);

        Label title = new Label("Trade List", skin);
        title.setAlignment(Align.center);

        TextButton refreshBtn = new TextButton("Refresh", skin);
        TextButton backBtn = new TextButton("Back", skin);

        refreshBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                rebuildTradesTable();
            }
        });
        backBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                App.getGameApp().setScreen(App.currentGameGraphicView);
            }
        });

        Table header = new Table(skin);
        header.defaults().pad(4).left();
        header.add(new Label("#", skin)).width(40);
        header.add(new Label("Sender", skin)).growX().minWidth(120);
        header.add(new Label("Receiver", skin)).growX().minWidth(120);
        header.add(new Label("Item", skin)).growX().minWidth(140);
        header.add(new Label("Qty", skin)).width(60);
        header.add(new Label("Price", skin)).width(80);
        header.add(new Label("Time", skin)).minWidth(140);

        tradesTable = new Table(skin);
        tradesTable.defaults().pad(4).left();

        scrollPane = new ScrollPane(tradesTable, skin);
        scrollPane.setFadeScrollBars(false);
        scrollPane.setScrollingDisabled(true, false);

        root.add(title).colspan(2).growX().padTop(8f);
        root.row();

        Table controls = new Table();
        controls.add(refreshBtn).left();
        controls.add().expandX();
        controls.add(backBtn).right();
        root.add(controls).colspan(2).growX();
        root.row();

        root.add(header).colspan(2).growX();
        root.row();

        root.add(scrollPane).colspan(2).grow().minHeight(200);

        rebuildTradesTable();
    }

    private void rebuildTradesTable() {
        tradesTable.clearChildren();


        if (trades.isEmpty()) {
            Label empty = new Label("No trades yet.", skin);
            empty.setAlignment(Align.center);
            tradesTable.add(empty).colspan(7).growX().pad(12);
            return;
        }

        int index = 1;
        for (Trade t : trades) {
            addTradeRow(index++, t);
        }
        tradesTable.pack();
        scrollPane.layout();
    }

    private void addTradeRow(int index, Trade t) {
        String sender = safeStr(getOr(() -> t.getSender(), "N/A"));
        String receiver = safeStr(getOr(() -> t.getReciver(), "N/A"));
        String item = safeStr(getOr(() -> t.getItem(), "Unknown"));
        String qty = String.valueOf(getOrInt(() -> t.getAmount(), 0));
        String targetItem = safeStr(getOr(() -> t.getTargetItem(), "Unknown"));
        String qty2 = String.valueOf(getOrInt(() -> t.getTargetAmount(), 0));


        Table row = new Table(skin);
        row.defaults().pad(4).left();

        row.add(new Label(String.valueOf(index), skin)).width(40);
        row.add(new Label(sender, skin)).growX().minWidth(120);
        row.add(new Label(receiver, skin)).growX().minWidth(120);
        row.add(new Label(item, skin)).growX().minWidth(140);
        row.add(new Label(qty, skin)).width(60).right();
        row.add(new Label(targetItem, skin)).width(80).right();
        row.add(new Label(qty2, skin)).minWidth(140);

        // TextButton details = new TextButton("Details", skin);
        // details.addListener(new ClickListener() {
        //     @Override public void clicked(InputEvent event, float x, float y) {
        //         showTradeDialog(t);
        //     }
        // });
        // row.add(details).padLeft(8);

        tradesTable.add(row).growX();
        tradesTable.row();

        Image sep = new Image(skin.newDrawable("white", 1, 1, 1, 0.1f));
        tradesTable.add(sep).colspan(7).height(1).growX();
        tradesTable.row();
    }

    private boolean hasPrice(Trade t) {
        try {
            t.getPrice();
            return true;
        } catch (Throwable e) {
            return false;
        }
    }


    private static List<Trade> safeTrades(ArrayList<Trade> list) {
        return list == null ? new ArrayList<>() : list;
    }

    private static String safeStr(String s) {
        return s == null ? "" : s;
    }

    private interface SupplierX<T> {
        T get() throws Exception;
    }

    private static <T> T getOr(SupplierX<T> s, T def) {
        try {
            return s.get();
        } catch (Throwable e) {
            return def;
        }
    }

    private static int getOrInt(SupplierX<Integer> s, int def) {
        try {
            return s.get();
        } catch (Throwable e) {
            return def;
        }
    }

//    private void showTradeDialog(Trade t) {
//        Dialog dlg = new Dialog("Trade Details", skin);
//        StringBuilder sb = new StringBuilder();
//        sb.append("Sender: ").append(getOr(() -> t.getSenderUsername(), "N/A")).append('\n');
//        sb.append("Receiver: ").append(getOr(() -> t.getReceiverUsername(), "N/A")).append('\n');
//        sb.append("Item: ").append(getOr(() -> t.getItemName(), "Unknown")).append('\n');
//        sb.append("Quantity: ").append(getOrInt(() -> t.getQuantity(), 0)).append('\n');
//        if (hasPrice(t)) sb.append("Price: ").append(getOrInt(() -> t.getPrice(), 0)).append('\n');
//        if (hasTime(t)) sb.append("Time: ").append(getOr(() -> t.getTimestamp().toString(), "-")).append('\n');
//
//        dlg.getContentTable().add(new Label(sb.toString(), skin)).pad(10);
//        dlg.button("OK");
//        dlg.show(stage);
//    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.08f, 0.09f, 0.11f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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
    }
}
