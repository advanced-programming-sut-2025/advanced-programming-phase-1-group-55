package com.StardewValley.Common.model.Friendship;

public enum Answer {
    accept("accepted"),
    reject("rejected"),
    unanswered("unanswered");

    private final String displayName;

    Answer(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
