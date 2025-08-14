package com.StardewValley.Common.model;

import com.StardewValley.Common.enums.ScoreCriteria;
import java.io.Serializable;
import java.util.List;

public class LeaderboardUpdate implements Serializable {
    private final ScoreCriteria criteria;
    private final List<LeaderboardEntry> entries;
    private final long serverTimestamp;

    public LeaderboardUpdate(ScoreCriteria criteria, List<LeaderboardEntry> entries, long serverTimestamp) {
        this.criteria = criteria;
        this.entries = entries;
        this.serverTimestamp = serverTimestamp;
    }
    public ScoreCriteria getCriteria() { return criteria; }
    public List<LeaderboardEntry> getEntries() { return entries; }
    public long getServerTimestamp() { return serverTimestamp; }
}
