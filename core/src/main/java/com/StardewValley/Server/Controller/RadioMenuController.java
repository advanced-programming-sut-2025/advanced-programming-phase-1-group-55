package com.StardewValley.Server.Controller;

import com.StardewValley.Client.ClientData;
import com.StardewValley.Client.View.RadioMenuView;
import com.StardewValley.Common.model.App;

public class RadioMenuController {
    private RadioMenuView view;

    public void setView(RadioMenuView view) {
        this.view = view;
    }
    public void handleButton(){
        if (view!=null){
            if (view.getBackButton().isChecked()){
                view.getBackButton().setChecked(false);
                App.gameApp.setScreen(App.currentGameGraphicView);
            }
            if (view.getChooseFileButton().isChecked()){
                view.getChooseFileButton().setChecked(false);
                handleChoosingMusic();
                view.show();
            }
            if (view.getPlayButton().isChecked()){
                view.getPlayButton().setChecked(false);
            }
            if (view.getStopButton().isChecked()){
                view.getStopButton().setChecked(false);
            }if (view.getConnectButton().isChecked()){
                view.getConnectButton().setChecked(false);
            }
        }
    }
    public void handleChoosingMusic() {
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();

        javax.swing.filechooser.FileNameExtensionFilter filter =
            new javax.swing.filechooser.FileNameExtensionFilter("Audio Files", "mp3", "wav");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        if (result == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            String fileName = selectedFile.getName();
            ClientData.getInstance().selfDetails.musics.put(fileName, selectedFile.getAbsolutePath());
        }
    }

}
