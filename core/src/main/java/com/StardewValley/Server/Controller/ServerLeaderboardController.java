package com.StardewValley.Server.Controller;

import com.StardewValley.Common.enums.ScoreCriteria;
import com.StardewValley.Common.model.LeaderboardEntry;
import com.StardewValley.Common.model.LeaderboardUpdate;
import com.StardewValley.Server.connection.ClientConnectionController;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class ServerLeaderboardController {

    private final ClientConnectionController connectionController;
    private volatile ScoreCriteria currentCriteria = ScoreCriteria.WEALTH;

    private final ConcurrentMap<String, PlayerSnapshot> players = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private volatile boolean pendingBroadcast = false;

    public ServerLeaderboardController(ClientConnectionController connectionController) {
        this.connectionController = connectionController;
    }

    public void setCriteria(ScoreCriteria criteria) {
        this.currentCriteria = criteria;
        scheduleBroadcast();
    }

    public void onPlayerStateChanged(PlayerSnapshot snapshot) {
        players.put(snapshot.playerId(), snapshot);
        scheduleBroadcast();
    }

    private void scheduleBroadcast() {
        if (pendingBroadcast) return;
        pendingBroadcast = true;
        scheduler.schedule(() -> {
            try { broadcastNow(); }
            finally { pendingBroadcast = false; }
        }, 200, TimeUnit.MILLISECONDS); // debounce
    }

    private void broadcastNow() {
        List<LeaderboardEntry> ranked = buildLeaderboard(currentCriteria);
        LeaderboardUpdate update =
            new LeaderboardUpdate(currentCriteria, ranked, System.currentTimeMillis());
        connectionController.broadcastLeaderboard(update);
    }

    private List<LeaderboardEntry> buildLeaderboard(ScoreCriteria criteria) {
        Comparator<PlayerSnapshot> cmp = switch (criteria) {
            case QUESTS_COMPLETED -> Comparator.comparingInt(PlayerSnapshot::questsCompleted).reversed();
            case TOTAL_SKILL_LEVEL -> Comparator.comparingInt(PlayerSnapshot::totalSkillLevel).reversed();
            case WEALTH -> Comparator.comparingLong(PlayerSnapshot::wealth).reversed();
        };

        return players.values().stream()
            .sorted(cmp.thenComparing(PlayerSnapshot::playerName))
            .limit(100)
            .map(s -> new LeaderboardEntry(
                s.playerId(), s.playerName(), scoreOf(s, criteria)))
            .collect(Collectors.toList());
    }

    private long scoreOf(PlayerSnapshot s, ScoreCriteria c) {
        return switch (c) {
            case WEALTH -> s.wealth();
            case QUESTS_COMPLETED -> s.questsCompleted();
            case TOTAL_SKILL_LEVEL -> s.totalSkillLevel();
        };
    }






    // هسته‌ی وضعیت هر بازیکن که از منطق سرور پر می‌کنی
    public static record PlayerSnapshot(
        String playerId,
        String playerName,
        long wealth,
        int questsCompleted,
        int totalSkillLevel
    ) {}
}
