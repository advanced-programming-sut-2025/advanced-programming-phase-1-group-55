package com.StardewValley.Client.View;
import com.StardewValley.Common.enums.AssetManager;
import com.StardewValley.Common.enums.SkillType;
import com.StardewValley.Common.model.App;
import com.StardewValley.Common.model.Skill;
import com.StardewValley.Common.model.User;
import com.StardewValley.Server.Controller.PauseMenuController;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;






public class SkillsMenuView implements Screen {

    private final User user;
    private final Skin skin;
    private Stage stage;
    private Table table;
    private TextButton backBtn;

    public SkillsMenuView(User user) {
        this.user = user;
        this.skin = App.skin;
    }

    @Override
    public void show() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        table = new Table();
        table.setFillParent(true);
        ScrollPane scrollPane = new ScrollPane(table, skin);
        scrollPane.setFillParent(true);
        stage.addActor(scrollPane);
        backBtn = new TextButton("Back", skin);
        Label title = new Label("Your Skills", skin);
        table.add(title).colspan(2).padBottom(20).row();

        for (SkillType skillType : SkillType.values()) {
            if (skillType == SkillType.Max_Energy) continue;
            Sprite iconSprite;
            try {
                iconSprite = AssetManager.valueOf(skillType.name().toUpperCase()).getSprite();
            } catch (Exception e) {
                iconSprite = AssetManager.gear.getSprite();
            }
            Image icon = new Image(new SpriteDrawable(iconSprite));
            String tooltipText = SkillType.skillDescriptions.getOrDefault(
                skillType,
                "No description available."
            );
            Tooltip<Label> tooltip = new Tooltip<>(new Label(tooltipText, skin));
            tooltip.setInstant(true);
            tooltip.setAlways(true);
            Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
            pixmap.setColor(1f, 1f, 1f, 0.8f);
            pixmap.fill();
            Texture texture = new Texture(pixmap);
            Drawable background = new TextureRegionDrawable(new TextureRegion(texture));
            tooltip.getContainer().pad(10).background(background).top();






            icon.addListener(tooltip);
            stage.addActor(tooltip.getContainer());
            Skill skill = switch (skillType) {
                case Farming -> user.getFarmingSkill();
                case Mining -> user.getMiningSkill();
                case Fishing -> user.getFishingSkill();
                case Foraging -> user.getForagingSkill();
                default -> null;
            };
            int level = (skill != null) ? skill.getLevel() : 0;
            assert skill != null;
            Label skillLabel = new Label(skillType.name() + " - Level: " + level+"\n- Point: "+skill.getPoints(), skin);
            table.add(icon).pad(10).width(64).height(64);
            table.add(skillLabel).pad(10).left().row();
        }
        table.row();
        table.add(backBtn).colspan(2).padTop(20);
        backBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                App.gameApp.setScreen(new PauseMenuView(new PauseMenuController(), user));
            }
        });
    }
    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        stage.act(delta);
        stage.draw();
    }
    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() {
        stage.dispose();
    }
}
