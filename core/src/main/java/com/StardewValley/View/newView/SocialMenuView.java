package com.StardewValley.View.newView;

import com.StardewValley.enums.AssetManager;
import com.StardewValley.model.App;
import com.StardewValley.model.Friendship.NpcFriendship;
import com.StardewValley.model.Friendship.PlayerFriendship;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.NPC.Quest;
import com.StardewValley.model.NPC.QuestStatus;
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

import java.util.Map;

public class SocialMenuView implements Screen {
    private Item selectedItem;
    private User user;
    private Stage stage;
    private Skin skin;
    private TextButton backButton;
    private TextButton sendGiftButton;
    private User selectedFriend;
    private final Label ErrorLabel;
    private com.badlogic.gdx.utils.Timer.Task clearErrorTask;

    public SocialMenuView(User user) {
        this.user = user;
        stage = new Stage();
        skin= App.skin;
        backButton = new TextButton("Back", skin);
        sendGiftButton = new TextButton("Send Gift", skin);
        ErrorLabel = new Label("", skin);
        ErrorLabel.setColor(Color.RED);
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

    Label titleLabel = new Label("Social Menu", skin);
        titleLabel.setFontScale(2f);
        rootTable.top().padTop(20);
        rootTable.add(titleLabel).colspan(5).center().padBottom(30);
        rootTable.row();

    Table leftMenu = createMenuBox("Friendship");
    Table rightMenu = createMenuBox("Send Gifts");


    Image verticalLine1 = new Image(createLineDrawable(2, 1, Color.GRAY));


        rootTable.row().expand().fill();
        rootTable.add(leftMenu).expand().fill().pad(10);
        rootTable.add(verticalLine1).width(2).fillY().padTop(10).padBottom(10);
        rootTable.add(rightMenu).expand().fill().pad(10);


    Image horizontalLine = new Image(createLineDrawable(1, 2, Color.GRAY));
        rootTable.row().colspan(5);
        rootTable.add(horizontalLine).height(2).fillX().padTop(20).padBottom(10);


        rootTable.row().colspan(5);
        rootTable.add(backButton).center().padBottom(20);
}

private Table createMenuBox(String title) {


    Table menu = new Table(skin);
    menu.top();

    Label label = new Label(title, skin);
    label.setFontScale(1.5f);
    menu.add(label).center().padTop(10).padBottom(20);
    menu.row();
    if (title.equals("Friendship")) {
        Table friendshipTable = new Table(skin);
        friendshipTable.top().left();

        Map<User, PlayerFriendship> friendships = user.getFriendsPlayer();
        if (friendships != null && !friendships.isEmpty()) {
            for (PlayerFriendship friendship : friendships.values()) {
               Label informationOfFriendship =new Label(friendship.toString(), skin);
               friendshipTable.add(informationOfFriendship).expandX().fillX().pad(10);
               friendshipTable.row();
            }
        } else {
            friendshipTable.add(new Label("There is no friendship.", skin)).pad(25);
        }

        ScrollPane scrollPane = new ScrollPane(friendshipTable, skin);
        scrollPane.setFadeScrollBars(false);
        scrollPane.setScrollingDisabled(true, false);

        menu.add(scrollPane).expand().fill().pad(10).row();
    }
 else if (title.equals("Send Gifts")) {
        Table itemTable = new Table(skin);
        int columnCount = 3;
        int i = 0;

        Map<String, Item> inventory = user.getBackPack().getInventory();
        final TextButton[] selectedButton = {null};

        for (Map.Entry<String, Item> entry : inventory.entrySet()) {
            Item item = entry.getValue();
            TextButton itemButton = new TextButton(
                item.getItemType().getDisplayName() +
                    "\nPrice: " + item.getPrice() +
                    "\nQuantity: " + item.getNumber(), skin);
            itemButton.getLabel().setFontScale(0.65f);
            itemButton.pad(10);

            itemButton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (selectedButton[0] != null) {
                        selectedButton[0].setColor(Color.WHITE);
                    }
                    selectedButton[0] = itemButton;
                    selectedItem=item;
                    itemButton.setColor(Color.LIME);
                }
            });

            itemTable.add(itemButton).pad(5).width(150).height(100);
            itemTable.row();

            i++;
            if (i % columnCount == 0) itemTable.row();
        }

        ScrollPane scrollPane = new ScrollPane(itemTable, skin);
        scrollPane.setScrollingDisabled(true, false);
        scrollPane.setFadeScrollBars(false);
        menu.add(scrollPane).expand().fill().pad(10);
        menu.row();
        menu.add(sendGiftButton).pad(5).width(150).height(100);
    }
        menu.add(ErrorLabel).colspan(2).center().row();
    return menu;
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
//        controller.handleButton();
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
    public Item getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public TextButton getBackButton() {
        return backButton;
    }

    public void setBackButton(TextButton backButton) {
        this.backButton = backButton;
    }

    public TextButton getSendGiftButton() {
        return sendGiftButton;
    }

    public void setSendGiftButton(TextButton sendGiftButton) {
        this.sendGiftButton = sendGiftButton;
    }

    public User getSelectedFriend() {
        return selectedFriend;
    }

    public void setSelectedFriend(User selectedFriend) {
        this.selectedFriend = selectedFriend;
    }
}
