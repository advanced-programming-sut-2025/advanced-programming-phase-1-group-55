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
                Music music = ClientData.getInstance().selfDetails.currentMusic;
                if (music != null) {
                    music.stop();
                    music.dispose();
                    ClientData.getInstance().selfDetails.setCurrentMusic(null);
                    ClientData.getInstance().selfDetails.setCurrentMusicPath(null);
                }
            }if (view.getConnectButton().isChecked()){
                view.getConnectButton().setChecked(false);
                handleConnectingToOtherPlayers();
            }
        }
    }
    public void handleConnectingToOtherPlayers() {

        if (view.getConnectTextField() == null) {
            view.setErrorMessage("connection field is missing!");
            return;
        }

        String otherUser = view.getConnectTextField().getText().trim();


        if (otherUser.isEmpty() ||
            ClientData.getInstance().gameDetails == null ||
            ClientData.getInstance().gameDetails.getPlayers() == null ||
            !ClientData.getInstance().gameDetails.getPlayers().containsKey(otherUser)) {
            view.setErrorMessage("please enter a valid username");
            return;
        }


        if (otherUser.equals(ClientData.getInstance().selfDetails.username)) {
            view.setErrorMessage("you can't connect to yourself!");
            return;
        }


        var targetPlayer = ClientData.getInstance().gameDetails.getPlayers().get(otherUser);
        if (targetPlayer == null) {
            view.setErrorMessage("target player data not found!");
            return;
        }

        String musicPath = targetPlayer.currentMusicPath;
        if (musicPath == null || musicPath.isEmpty()) {
            view.setErrorMessage("target player is not playing any music!");
            return;
        }


        Music music;
        if (new java.io.File(musicPath).exists()) {
            music = Gdx.audio.newMusic(Gdx.files.absolute(musicPath));
        } else {
            music = Gdx.audio.newMusic(Gdx.files.internal(musicPath));
        }

        music.setLooping(true);
        float position = targetPlayer.getMusicPosition();
        if (position > 0) {
            music.setPosition(position);
        }
        music.play();
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
