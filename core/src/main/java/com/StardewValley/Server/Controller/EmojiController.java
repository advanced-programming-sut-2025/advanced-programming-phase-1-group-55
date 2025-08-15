package com.StardewValley.Server.Controller;

import com.StardewValley.Client.View.ChangeDefaultEmojiMenu;
import com.StardewValley.Client.View.EmojiMenuView;
import com.StardewValley.Common.model.App;

public class EmojiController {
    EmojiMenuView emojiMenuView;
    ChangeDefaultEmojiMenu changeDefaultEmojiMenu;
    public void handleButton(){
        if (emojiMenuView != null) {
            if (emojiMenuView.getBackBtn().isChecked()){
                emojiMenuView.getBackBtn().setChecked(false);
                App.gameApp.setScreen(App.currentGameGraphicView);
            } else if (emojiMenuView.getSendBtn().isChecked()) {
                emojiMenuView.getSendBtn().setChecked(false);
                handleSendingEmoji();
            } else if (emojiMenuView.getChangeBtn().isChecked()) {
                emojiMenuView.getChangeBtn().setChecked(false);
                App.gameApp.setScreen(new ChangeDefaultEmojiMenu(emojiMenuView.getSelectedEmoji()));
            }
        }
        if (changeDefaultEmojiMenu != null) {
            if (changeDefaultEmojiMenu.getBackBtn().isChecked()) {
                changeDefaultEmojiMenu.getBackBtn().setChecked(false);
                App.gameApp.setScreen(new EmojiMenuView());
            } else if (changeDefaultEmojiMenu.getChangeBtn().isChecked()) {
                changeDefaultEmojiMenu.getChangeBtn().setChecked(false);
                handleChangingEmoji();
            }
        }
    }
    public void handleSendingEmoji(){

    }
    public void handleChangingEmoji(){

    }
    public EmojiMenuView getEmojiMenuView() {
        return emojiMenuView;
    }

    public void setEmojiMenuView(EmojiMenuView emojiMenuView) {
        this.emojiMenuView = emojiMenuView;
    }

    public ChangeDefaultEmojiMenu getChangeDefaultEmojiMenu() {
        return changeDefaultEmojiMenu;
    }

    public void setChangeDefaultEmojiMenu(ChangeDefaultEmojiMenu changeDefaultEmojiMenu) {
        this.changeDefaultEmojiMenu = changeDefaultEmojiMenu;
    }
}
