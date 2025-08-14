package com.StardewValley.Client;

import com.StardewValley.Common.model.LeaderboardUpdate;
import com.StardewValley.Common.model.LeaderboardEntry;
import com.StardewValley.Client.View.LeaderboardView;

import java.util.ArrayList;
import java.util.List;

public class ClientLeaderboardController {

    private static final ClientLeaderboardController instance = new ClientLeaderboardController();
    private final List<LeaderboardEntry> currentEntries = new ArrayList<>();
    private LeaderboardUpdate lastUpdate;
    private LeaderboardView view;

    private ClientLeaderboardController() {}

    public static ClientLeaderboardController getInstance() {
        return instance;
    }

    public void onLeaderboardUpdate(LeaderboardUpdate update) {
        this.lastUpdate = update;
        this.currentEntries.clear();
        this.currentEntries.addAll(update.getEntries());

        if (view != null) {
            view.refresh(update);
        }
    }

    public List<LeaderboardEntry> getCurrentEntries() {
        return new ArrayList<>(currentEntries);
    }

    public LeaderboardUpdate getLastUpdate() {
        return lastUpdate;
    }

    public void attachView(LeaderboardView view) {
        this.view = view;
        if (lastUpdate != null) {
            view.refresh(lastUpdate);
        }
    }

    public void detachView() {
        this.view = null;
    }
}
