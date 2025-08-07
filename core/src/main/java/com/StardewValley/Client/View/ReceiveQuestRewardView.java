package com.StardewValley.Client.View;

import com.StardewValley.Common.enums.AssetManager;
import com.StardewValley.Common.model.App;
import com.StardewValley.Common.model.Map.GameMap;
import com.StardewValley.Common.model.NPC.Quest;
import com.StardewValley.Common.model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class ReceiveQuestRewardView implements Screen {
    private Stage stage;
    private Skin skin;
    private User user;
    private Quest quest;
    private NpcMenuView npcMenuView;
    private GameMap map;
    private final Button backButton;

    public ReceiveQuestRewardView(User user, Quest quest, NpcMenuView npcMenuView, GameMap map) {
        this.user = user;
        this.quest = quest;
        this.npcMenuView = npcMenuView;
        this.map = map;
        stage = new Stage(new ScreenViewport());
        skin= App.skin;
        backButton=new TextButton("Collect Rewards", skin);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        Texture backgroundTexture = AssetManager.PinkBackground.getTexture();
        Image backgroundImage = new Image(backgroundTexture);
        backgroundImage.setFillParent(true);
        stage.addActor(backgroundImage);

        Table table = new Table();
        table.setFillParent(true);
        table.top().padTop(80);

        String text = "You successfully completed the quest!\n\n\nyour rewards: "
            + quest.getReward().getAmount() + " "
            + quest.getReward().getItem().getDisplayName()+"\n\n";

        Label titleLabel = new Label(text, skin);
        titleLabel.setColor(Color.CYAN);
        titleLabel.setFontScale(2f);
        titleLabel.setAlignment(Align.center);

        table.add(titleLabel).colspan(2).center().padBottom(40);
        table.row();
        table.add(backButton).colspan(2).center().padTop(80).width(250).height(70);

        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                App.gameApp.setScreen(npcMenuView);
            }
        });

        stage.addActor(table);


        Image centerStar = new Image(AssetManager.Gift.getTexture());
        centerStar.setSize(128, 128);
        centerStar.setOrigin(Align.center);
        centerStar.setPosition(Gdx.graphics.getWidth() / 2f - 64, 100);
        centerStar.getColor().a = 0;

        centerStar.addAction(Actions.sequence(
            Actions.fadeIn(4f),
            Actions.scaleBy(0.5f, 0.5f, 0.5f),
            Actions.fadeOut(1000f)
        ));
        stage.addActor(centerStar);


        Image leftStar = new Image(AssetManager.Balloon.getTexture());
        leftStar.setSize(64, 64);
        leftStar.setPosition(100, 50);
        leftStar.getColor().a = 0;
        leftStar.addAction(Actions.sequence(
            Actions.fadeIn(0.7f),
            Actions.sequence(
                Actions.moveBy(30, 130, 0.3f),
                Actions.moveBy(-30, 130, 0.3f),
                Actions.moveBy(30, 130, 0.3f),
                Actions.moveBy(-30, 130, 0.3f),
                Actions.moveBy(0, 130, 0.3f)
            ),
            Actions.fadeOut(2f)
        ));
        stage.addActor(leftStar);


        Image rightStar = new Image(AssetManager.Balloon.getTexture());
        rightStar.setSize(64, 64);
        rightStar.setPosition(Gdx.graphics.getWidth() - 164, 50);
        rightStar.getColor().a = 0;
        rightStar.addAction(Actions.sequence(
            Actions.fadeIn(0.7f),
            Actions.sequence(
                Actions.moveBy(-30, 130, 0.3f),
                Actions.moveBy(30, 130, 0.3f),
                Actions.moveBy(-30, 130, 0.3f),
                Actions.moveBy(30, 130, 0.3f),
                Actions.moveBy(0, 130, 0.3f)
            ),
            Actions.fadeOut(2f)
        ));
        stage.addActor(rightStar);
    }


    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        stage.act(Math.min(delta, 1 / 30f));
        stage.draw();
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    public NpcMenuView getNpcMenuView() {
        return npcMenuView;
    }

    public void setNpcMenuView(NpcMenuView npcMenuView) {
        this.npcMenuView = npcMenuView;
    }

    public GameMap getMap() {
        return map;
    }

    public void setMap(GameMap map) {
        this.map = map;
    }
}
