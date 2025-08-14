package com.StardewValley.Common.model;

import java.io.Serializable;

public class LeaderboardEntry implements Serializable {
    private final String playerId;
    private final String playerName;
    private final long score;

    public LeaderboardEntry(String playerId, String playerName, long score) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.score = score;
    }
    public String getPlayerId() { return playerId; }
    public String getPlayerName() { return playerName; }
    public long getScore() { return score; }
}
