package com.StardewValley.Common;

import com.StardewValley.Common.model.Chat.Emoji;
import com.StardewValley.Common.model.Chat.Message;
import com.StardewValley.Common.model.Trade;
import com.StardewValley.Common.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;


public class ConnectionMessage {
    private static final GsonBuilder gsonBuilder = new GsonBuilder();
    private static final Gson gson;

    static {
        gsonBuilder.setPrettyPrinting();
        gson = gsonBuilder.create();
    }


    public static synchronized String tradeToJson(Trade trade) {
        return gson.toJson(trade);
    }

    public static synchronized Trade tradeFromJson(String json) {
        return gson.fromJson(json, Trade.class);
    }


    public static synchronized String messageToJson(Message message) {
        return gson.toJson(message);
    }

    public static synchronized Message messageFromJson(String json) {
        return gson.fromJson(json, Message.class);
    }

    public String toJson() {
        return gson.toJson(this);
    }

    public synchronized static ConnectionMessage fromJson(String json) {
        return gson.fromJson(json, ConnectionMessage.class);
    }

    public static synchronized String userToJson(User user) {
        return gson.toJson(user);
    }


    public static synchronized String lobbyToJson(Lobby lobby) {
        return gson.toJson(lobby);
    }

    public static synchronized Lobby lobbyFromJson(String json) {
        return gson.fromJson(json, Lobby.class);
    }
    public static synchronized String emojiToJson(Emoji emoji) {
        return gson.toJson(emoji);
    }

    public static synchronized Emoji emojiFromJson(String json) {
        return gson.fromJson(json, Emoji.class);
    }

    public static synchronized String gameDetailsToJson(GameDetails gameDetails) {
        return gson.toJson(gameDetails);
    }

    public static synchronized GameDetails gameDetailsFromJson(String json) {
        return gson.fromJson(json, GameDetails.class);
    }

    public static synchronized String playerDetailsToJson(PlayerDetails playerDetails) {
        return gson.toJson(playerDetails);
    }

    public static synchronized PlayerDetails playerDetailsFromJson(String json) {
        return gson.fromJson(json, PlayerDetails.class);
    }

    private Type type;
    private HashMap<String, Object> body;


    public ConnectionMessage(HashMap<String, Object> body, Type type) {
        this.body = body;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public <T> T getFromBody(String fieldName) {
        return (T) body.get(fieldName);
    }

    public int getIntFromBody(String fieldName) {
        return (int) ((double) ((Double) body.get(fieldName)));
    }

    public long getLongFromBody(String fieldName) {
        return ((Number) body.get(fieldName)).longValue();
    }

    public HashMap<String, Object> getBody() {
        return body;
    }

    public enum Type {
        command,
        response,
        inform,
        update,
    }


}
