package com.StardewValley.View;

import com.StardewValley.Controller.FriendMenuController;
import com.StardewValley.enums.AssetManager;
import com.StardewValley.model.App;
import com.StardewValley.model.Friendship.Answer;
import com.StardewValley.model.Friendship.Gift;
import com.StardewValley.model.Friendship.Message;
import com.StardewValley.model.Friendship.PlayerFriendship;
import com.StardewValley.model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;

import java.util.ArrayList;

public class FriendMenuView implements Screen {
    private Stage stage;
    private  Image animationImage = new Image();
    private Skin skin;
    private User you;
    private User friend;
    private FriendMenuController controller;
    private TextButton backButton;
    private TextButton sendMessageButton;
    private TextField messageField;
    private TextButton acceptButton;
    private TextButton rejectButton;
    private TextButton sendFlowerButton;
    private TextButton hugButton;
    private TextButton rateButton;
    private TextField rateField;
    private TextButton sendMarriageRequestButton;
    private final Label ErrorLabel;
    private com.badlogic.gdx.utils.Timer.Task clearErrorTask;
    private final Label SuccessLabel;
    private com.badlogic.gdx.utils.Timer.Task clearErrorTask2;
    private Gift selectedGift;
    private Table chatTable;


    public FriendMenuView(User friend, FriendMenuController controller) {
        this.friend = friend;
        this.controller = controller;
        you= App.currentGameModel.currentUser;
        skin=App.skin;
        backButton = new TextButton("Back", skin);
        sendMessageButton = new TextButton("Send", skin);
        messageField = new TextField("", skin);
        acceptButton = new TextButton("Accept", skin);
        rejectButton = new TextButton("Reject", skin);
        sendFlowerButton = new TextButton("Send Flower", skin);
        hugButton = new TextButton("Hug", skin);
        rateButton = new TextButton("Rate", skin);
        rateField = new TextField("", skin);
        sendMarriageRequestButton = new TextButton("Send Marriage Request", skin);
        stage = new Stage();
        controller.setView(this);
        ErrorLabel = new Label("", skin);
        ErrorLabel.setColor(Color.RED);
        SuccessLabel = new Label("", skin);
        SuccessLabel.setColor(Color.GREEN);
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

        Label titleLabel = new Label(friend.getUsername(), skin);
        titleLabel.setFontScale(2f);
        rootTable.top().padTop(20);
        rootTable.add(titleLabel).colspan(5).center().padBottom(30);
        rootTable.row();

        Table leftMenu = createMenuBox("Gifts");
        Table middleMenu = createMenuBox("Actions");
        Table rightMenu = createMenuBox("Chat");


        Image verticalLine1 = new Image(createLineDrawable(2, 1, Color.GRAY));
        Image verticalLine2 = new Image(createLineDrawable(2, 1, Color.GRAY));


        rootTable.row().expand().fill();
        rootTable.add(leftMenu).expand().fill().pad(10);
        rootTable.add(verticalLine1).width(2).fillY().padTop(10).padBottom(10);
        rootTable.add(middleMenu).expand().fill().pad(10);
        rootTable.add(verticalLine2).width(2).fillY().padTop(10).padBottom(10);
        rootTable.add(rightMenu).expand().fill().pad(10);


        Image horizontalLine = new Image(createLineDrawable(1, 2, Color.GRAY));
        rootTable.row().colspan(5);
        rootTable.add(horizontalLine).height(2).fillX().padTop(20).padBottom(10);


        rootTable.row().colspan(5);
        rootTable.add(backButton).center().padBottom(20);
        rootTable.row();
        rootTable.add(ErrorLabel).colspan(5);
        rootTable.row();
        rootTable.add(SuccessLabel).colspan(5);
    }

    private Table createMenuBox(String title) {


        Table menu = new Table(skin);
        menu.top();

        Label label = new Label(title, skin);
        label.setFontScale(1.5f);
        menu.add(label).center().padTop(10).padBottom(20);
        menu.row();
        if (title.equals("Gifts")) {
            Table giftsTable = new Table(skin);
            giftsTable.top().left();

            ArrayList<Gift> gifts = you.getFriendsPlayer().get(friend).getGifts();
            if (gifts != null && !gifts.isEmpty()) {
                for (Gift gift : gifts) {
                    Table singleGiftTable = new Table(skin);
                    singleGiftTable.left();

                    Label infoLabel = new Label(gift.toString(), skin);
                    infoLabel.setAlignment(Align.left);

                    TextButton chooseButton = new TextButton("Select", skin);
                    chooseButton.addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            selectedGift = gift;
                            setSuccessMessage("You selected gift with id: " + selectedGift.getId());
                        }
                    });

                    singleGiftTable.add(infoLabel).expandX().left().pad(10);
                    if (gift.getSender().equals(friend)&&gift.getRate()==0) {
                        singleGiftTable.add(chooseButton).pad(10).width(100);
                    }
                    giftsTable.add(singleGiftTable).expandX().fillX().row();


                    giftsTable.add(new Image(createLineDrawable(1, 2, Color.LIGHT_GRAY)))
                        .colspan(2).expandX().fillX().padBottom(5).row();
                }
            } else {
                giftsTable.add(new Label("There is no Gift between you and " + friend.getUsername() + ".", skin)).pad(25);
            }

            ScrollPane scrollPane = new ScrollPane(giftsTable, skin);
            scrollPane.setFadeScrollBars(false);
            scrollPane.setScrollingDisabled(true, false);

            menu.add(scrollPane).expand().fill().pad(10).row();
            menu.add(rateField).center().row();
            menu.add(rateButton).center();
            menu.row();
        }


        else if (title.equals("Actions")) {
            Table actionTable = new Table(skin);
            actionTable.top();


            actionTable.add(hugButton).pad(10).width(180).height(60).center();
            actionTable.row();


            actionTable.add(sendFlowerButton).pad(10).width(180).height(60).center();
            actionTable.row();
            PlayerFriendship friendship=you.getFriendsPlayer().get(friend);

            if(friendship.getMarriageRequest()==null||friendship.getMarriageRequest().getMen().equals(you)){
                actionTable.add(sendMarriageRequestButton).pad(10).width(220).height(60).center();
                actionTable.row();
            } else if (friendship.getMarriageRequest().getWomen().equals(you)&&
                friendship.getMarriageRequest().getAnswer().equals(Answer.unanswered)) {
                Label label1 = new Label("Your friend wants to marry you :>", skin);
                Image ring = new Image(friendship.getMarriageRequest().getRing().getItemType().getTexture());

                actionTable.add(ring).pad(10).colspan(2).center().row();
                actionTable.add(label1).expandX().fillX().colspan(2).center().row();
                actionTable.add(rejectButton).pad(10).width(220).height(60).center();
                actionTable.add(acceptButton).pad(10).width(220).height(60).center().row();
            }



            animationImage.setVisible(false);
            actionTable.add(animationImage).expandY().fillY().padTop(20).row();


            ScrollPane scrollPane = new ScrollPane(actionTable, skin);
            scrollPane.setFadeScrollBars(false);
            scrollPane.setScrollingDisabled(true, false);
            menu.add(scrollPane).expand().fill().pad(10).row();

        }

        else {
            chatTable = new Table(skin);
            chatTable.top().left();

            refreshChat();

            ScrollPane scrollPane = new ScrollPane(chatTable, skin);
            scrollPane.setFadeScrollBars(false);
            scrollPane.setScrollingDisabled(true, false);
            scrollPane.layout();
            scrollPane.setScrollPercentY(1);

            menu.add(scrollPane).expand().fill().pad(10).row();

            Table inputTable = new Table();
            messageField.setMessageText("Type your message...");
            inputTable.add(messageField).width(300).padRight(10);
            inputTable.add(sendMessageButton).width(100);

            menu.add(inputTable).pad(10).center().row();

        }




        return menu;
    }
    public void refreshChat() {
        if (chatTable == null) return;

        chatTable.clear();

        ArrayList<Message> messages = you.getFriendsPlayer().get(friend).getConversation();

        for (Message message : messages) {
            Label msgLabel = new Label(message.text(), skin);
            msgLabel.setWrap(true);
            msgLabel.setAlignment(Align.left);

            if (message.sender().equals(you)) {
                msgLabel.setColor(Color.BLUE);
                msgLabel.setAlignment(Align.left);
                msgLabel.setWrap(true);
                chatTable.add(msgLabel).left().pad(10).width(400).row();
            } else {
                msgLabel.setColor(Color.WHITE);
                msgLabel.setAlignment(Align.right);
                msgLabel.setWrap(true);
                chatTable.add(msgLabel).right().pad(10).width(400).row();
            }


            chatTable.add(new Image(createLineDrawable(1, 1, Color.LIGHT_GRAY)))
                .colspan(2).expandX().fillX().padBottom(5).row();
        }
    }

    private TextureRegionDrawable createLineDrawable(int width, int height, Color color) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fill();
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return new TextureRegionDrawable(new TextureRegion(texture));
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
        SuccessLabel.setText(message);
        if (clearErrorTask2 != null) {
            clearErrorTask2.cancel();
        }
        clearErrorTask2 = new Timer.Task() {
            @Override
            public void run() {
                SuccessLabel.setText("");
            }
        };
        Timer.schedule(clearErrorTask2, 5);
    }
    @Override
    public void render(float v) {
        controller.handleButton();
        ScreenUtils.clear(0.2f, 0.2f, 0.25f, 1);
        stage.act(v);
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

    public User getYou() {
        return you;
    }

    public void setYou(User you) {
        this.you = you;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }

    public FriendMenuController getController() {
        return controller;
    }

    public void setController(FriendMenuController controller) {
        this.controller = controller;
    }

    public TextButton getBackButton() {
        return backButton;
    }

    public void setBackButton(TextButton backButton) {
        this.backButton = backButton;
    }

    public TextButton getSendMessageButton() {
        return sendMessageButton;
    }

    public void setSendMessageButton(TextButton sendMessageButton) {
        this.sendMessageButton = sendMessageButton;
    }

    public TextField getMessageField() {
        return messageField;
    }

    public void setMessageField(TextField messageField) {
        this.messageField = messageField;
    }

    public TextButton getAcceptButton() {
        return acceptButton;
    }

    public void setAcceptButton(TextButton acceptButton) {
        this.acceptButton = acceptButton;
    }

    public TextButton getRejectButton() {
        return rejectButton;
    }

    public void setRejectButton(TextButton rejectButton) {
        this.rejectButton = rejectButton;
    }

    public TextButton getSendFlowerButton() {
        return sendFlowerButton;
    }

    public void setSendFlowerButton(TextButton sendFlowerButton) {
        this.sendFlowerButton = sendFlowerButton;
    }

    public TextButton getHugButton() {
        return hugButton;
    }

    public void setHugButton(TextButton hugButton) {
        this.hugButton = hugButton;
    }

    public TextButton getRateButton() {
        return rateButton;
    }

    public void setRateButton(TextButton rateButton) {
        this.rateButton = rateButton;
    }

    public TextField getRateField() {
        return rateField;
    }

    public void setRateField(TextField rateField) {
        this.rateField = rateField;
    }

    public TextButton getSendMarriageRequestButton() {
        return sendMarriageRequestButton;
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

    public Label getSuccessLabel() {
        return SuccessLabel;
    }

    public Timer.Task getClearErrorTask2() {
        return clearErrorTask2;
    }

    public void setClearErrorTask2(Timer.Task clearErrorTask2) {
        this.clearErrorTask2 = clearErrorTask2;
    }

    public Gift getSelectedGift() {
        return selectedGift;
    }

    public void setSelectedGift(Gift selectedGift) {
        this.selectedGift = selectedGift;
    }

    public void setSendMarriageRequestButton(TextButton sendMarriageRequestButton) {
        this.sendMarriageRequestButton = sendMarriageRequestButton;
    }

    public Image getAnimationImage() {
        return animationImage;
    }

    public void setAnimationImage(Image animationImage) {
        this.animationImage = animationImage;
    }
}
