package com.StardewValley.View.newView;

import com.StardewValley.model.App;
import com.StardewValley.model.FarmingProdocts.AllCrops;
import com.StardewValley.model.FarmingProdocts.AllForagingCrops;
import com.StardewValley.model.FarmingProdocts.AllForagingTrees;
import com.StardewValley.model.FarmingProdocts.AllTrees;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class FarmingProductMenuView implements Screen {
    private final Stage stage;
    private final Skin skin = App.skin;
    private Table mainTable;
    private ScrollPane scrollPane;
    private enum Category { CROPS, FORAGING_CROPS, FORAGING_TREES, TREES }
    private Category currentCategory = Category.CROPS;

    public FarmingProductMenuView() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        mainTable = new Table(skin);
        mainTable.top().padTop(20);
        mainTable.defaults().expandX().fillX();

        scrollPane = new ScrollPane(mainTable, skin);
        scrollPane.setFillParent(true);
        scrollPane.setSmoothScrolling(true);
        scrollPane.setScrollingDisabled(true, false);
        scrollPane.setScrollY(0);
        scrollPane.layout();
        scrollPane.updateVisualScroll();

        stage.addActor(scrollPane);

        updateCategory(currentCategory);
    }

    private void updateCategory(Category category) {
        mainTable.clear();
        this.currentCategory = category;

        // دکمه‌های دسته‌بندی
        Table buttonRow = new Table(skin);
        buttonRow.add(createCategoryButton("All Crops", Category.CROPS)).pad(5);
        buttonRow.add(createCategoryButton("Foraging Crops", Category.FORAGING_CROPS)).pad(5);
        buttonRow.add(createCategoryButton("Foraging Trees", Category.FORAGING_TREES)).pad(5);
        buttonRow.add(createCategoryButton("Fruit Trees", Category.TREES)).pad(5);

        mainTable.add(buttonRow).colspan(4).center().padBottom(20).row();

        switch (category) {
            case CROPS -> addAllCrops();
            case FORAGING_CROPS -> addAllForagingCrops();
            case FORAGING_TREES -> addAllForagingTrees();
            case TREES -> addAllTrees();
        }

        mainTable.row();
        TextButton backBtn = new TextButton("Back", skin);
        backBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                App.gameApp.setScreen(App.currentGameGraphicView);
            }
        });
        mainTable.add(backBtn).colspan(4).center().padTop(30);
    }

    private TextButton createCategoryButton(String label, Category cat) {
        TextButton btn = new TextButton(label, skin);
        btn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                updateCategory(cat);
                scrollPane.setScrollY(0);
            }
        });
        return btn;
    }

    private void addAllCrops() {
        for (AllCrops crop : AllCrops.values()) {
            mainTable.row().pad(10);
            addItemRow(
                crop.getType().getDisplayName(),
                crop.getType().getTexture(),
                "Total harvest time: " + crop.getTotalHarvestTime(),
                "Sell price: " + crop.getBaseSellPrice()
            );
        }
    }

    private void addAllForagingCrops() {
        for (AllForagingCrops crop : AllForagingCrops.values()) {
            mainTable.row().pad(10);
            addItemRow(
                crop.getType().getDisplayName(),
                crop.getType().getTexture(),
                "Season: " + crop.getSeason(),
                "Sell price: " + crop.getBaseSellPrice()
            );
        }
    }

    private void addAllForagingTrees() {
        for (AllForagingTrees tree : AllForagingTrees.values()) {
            mainTable.row().pad(10);
            addItemRow(
                tree.getType().getDisplayName(),
                tree.getType().getTexture(),
                "Name: " + tree.getName(),
                "Season: " + tree.getSeason()
            );
        }
    }

    private void addAllTrees() {
        for (AllTrees tree : AllTrees.values()) {
            mainTable.row().pad(10);
            addItemRow(
                tree.getType().getDisplayName(),
                tree.getType().getTexture(),
                "Fruit: " + tree.getFruits().getType().getName(),
                "Total harvest time: " + tree.getTotalHarvestTime()
            );
        }
    }

    private void addItemRow(String name, Texture texture, String line1, String line2) {
        Table row = new Table(skin);

        Image image;
        if (texture != null) {
            try {
                image = new Image(new TextureRegionDrawable(new TextureRegion(texture)));
            } catch (Exception e) {
                image = new Image(); // fallback
            }
        } else {
            image = new Image();
        }
        image.setSize(48, 48);

        Label nameLabel = new Label(name, skin);
        Label desc1 = new Label(line1, skin);
        Label desc2 = new Label(line2, skin);

        Table textTable = new Table();
        textTable.add(nameLabel).left().row();
        textTable.add(desc1).left().row();
        textTable.add(desc2).left();

        row.add(image).width(64).height(64).padRight(10);
        row.add(textTable).left();

        mainTable.add(row).left().expandX().fillX().pad(5).colspan(4);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        stage.act(delta);
        stage.draw();
    }

    @Override public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() {
        stage.dispose();
    }
}
