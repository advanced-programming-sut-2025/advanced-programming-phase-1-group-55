package com.StardewValley.Client.View;

import com.StardewValley.Common.enums.AssetManager;
import com.StardewValley.Common.model.App;
import com.StardewValley.Common.model.Friendship.Message;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public class ChatMenuView implements Screen {
    private Stage stage;
    private Skin skin;
    private ArrayList<Message> messages;
    private TextButton backButton;
    private TextButton sendButton;
    private TextField textField;

    private Table messageTable;
    private ScrollPane scrollPane;

    public ChatMenuView(ArrayList<Message> messages) {
        this.messages = messages;
        stage = new Stage();
        skin = App.skin;
        backButton = new TextButton("Back", skin);
        sendButton = new TextButton("Send", skin);
        textField = new TextField("", skin);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        Texture backgroundTexture = AssetManager.PinkBackground.getTexture();
        Image backgroundImage = new Image(backgroundTexture);
        backgroundImage.setFillParent(true);
        stage.addActor(backgroundImage);

        Table rootTable = new Table();
        rootTable.setFillParent(true);
        stage.addActor(rootTable);

        Label titleLabel = new Label("Public Chat", skin);
        titleLabel.setFontScale(2f);
        rootTable.top().padTop(20);
        rootTable.add(titleLabel).colspan(5).center().padBottom(30);
        rootTable.row();

        // بخش پیام‌ها
        messageTable = new Table(skin);
        messageTable.top().left();

        scrollPane = new ScrollPane(messageTable, skin);
        scrollPane.setFadeScrollBars(false);
        scrollPane.setScrollingDisabled(true, false);

        rootTable.add(scrollPane).expand().fill().pad(10).row();


        Table inputTable = new Table();
        textField.setMessageText("Type your message...");
        inputTable.add(textField).width(300).padRight(10);
        inputTable.add(sendButton).width(100);

        rootTable.add(inputTable).pad(10).center().row();


        for (Message msg : messages) {
            addMessageToUI(msg);
        }
        scrollToBottom();
    }


    public void addMessage(Message message) {
        messages.add(message);
        addMessageToUI(message);
        scrollToBottom();
    }

    private void addMessageToUI(Message message) {
        Label msgLabel = new Label(message.text(), skin);
        msgLabel.setWrap(true);

        if (message.sender().equals(App.mainUser)) {
            msgLabel.setColor(Color.BLUE);
            msgLabel.setAlignment(Align.left);
            messageTable.add(msgLabel).left().pad(10).width(400).row();
        } else {
            msgLabel.setColor(Color.WHITE);
            if (message.text().contains("@"+App.mainUser.getUsername())) {
                msgLabel.setColor(Color.YELLOW);
            }
            msgLabel.setAlignment(Align.right);
            messageTable.add(msgLabel).right().pad(10).width(400).row();
        }

        messageTable.add(new Image(createLineDrawable(1, 1, Color.LIGHT_GRAY)))
            .colspan(2).expandX().fillX().padBottom(5).row();
    }

    private void scrollToBottom() {
        Gdx.app.postRunnable(() -> scrollPane.setScrollPercentY(1));
    }

    private TextureRegionDrawable createLineDrawable(int width, int height, Color color) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fill();
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return new TextureRegionDrawable(new TextureRegion(texture));
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0, 0, 0, 1);
        stage.act(v);
        stage.draw();
    }

    @Override
    public void resize(int i, int i1) {}

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
}
