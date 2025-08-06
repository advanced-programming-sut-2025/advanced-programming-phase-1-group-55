package com.StardewValley.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import java.io.FileWriter;
import java.io.IOException;

public class SaveLoadUtil {

    public static void saveGame(Object gameModel, String filename) {
        Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .setPrettyPrinting()
            .create();

        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(gameModel, writer);
            System.out.println("Game saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to save game.");
        }
    }
}
