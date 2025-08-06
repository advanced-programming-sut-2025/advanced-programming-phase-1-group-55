package com.StardewValley;

import com.StardewValley.View.oldView.AppView;
import com.StardewValley.model.GameModel;
import com.StardewValley.model.Map.GameMap;
import com.StardewValley.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User();
            GameMap map = new GameMap();

            GameModel gameModel = new GameModel(user, map);


            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String filename = "game_save.json";


            try (FileWriter writer = new FileWriter(filename)) {
                gson.toJson(gameModel, writer);
            }


            try (Reader reader = Files.newBufferedReader(Paths.get(filename))) {
                GameModel loadedGameModel = gson.fromJson(reader, GameModel.class);
                System.out.println("Game loaded! Current User: " + loadedGameModel.getCurrentUser());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

