package com.StardewValley.Server.Controller;

import com.StardewValley.Client.ClientData;
import com.StardewValley.Client.View.RadioMenuView;
import com.StardewValley.Common.model.App;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

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
                handlePlayingMusic();
            }
            if (view.getStopButton().isChecked()){
                view.getStopButton().setChecked(false);
            }if (view.getConnectButton().isChecked()){
                view.getConnectButton().setChecked(false);
            }
        }
    }
    public void handlePlayingMusic() {
        String selectedMusicName = view.getSelectedMusicName();

        if (selectedMusicName == null || !ClientData.getInstance().selfDetails.musics.containsKey(selectedMusicName)) {
            System.out.println("No music selected or invalid name.");
            return;
        }

        String filePath = ClientData.getInstance().selfDetails.musics.get(selectedMusicName);

        Music currentMusic = ClientData.getInstance().selfDetails.currentMusic;
        String currentMusicPath = ClientData.getInstance().selfDetails.currentMusicPath;


        if (currentMusic == null || currentMusicPath == null || !currentMusicPath.equals(filePath)) {


            if (currentMusic != null) {
                currentMusic.stop();
                currentMusic.dispose();
            }


            if (new java.io.File(filePath).exists()) {
                currentMusic = Gdx.audio.newMusic(Gdx.files.absolute(filePath));
            } else {
                currentMusic = Gdx.audio.newMusic(Gdx.files.internal(filePath));
            }

            currentMusic.setLooping(true);
            ClientData.getInstance().selfDetails.currentMusic = currentMusic;
            ClientData.getInstance().selfDetails.currentMusicPath = filePath;

            currentMusic.play();
            System.out.println("Playing music: " + selectedMusicName);
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
