package com.StardewValley.Common.enums;

public enum SortBy {
    gold("gold"),skill("skill"),quest("quest");
    private final String name;
    SortBy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
