package com.StardewValley.Common.model.FarmingProdocts;

import com.StardewValley.Common.model.Map.Location;

public class ForagingTree {
    private AllForagingTrees foragingTreeType;
    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public AllForagingTrees getForagingTreeType() {
        return foragingTreeType;
    }

    public void setForagingTreeType(AllForagingTrees foragingTreeType) {
        this.foragingTreeType = foragingTreeType;
    }

    @Override
    public String toString() {
        return "Crop{" +
                "name='" + foragingTreeType.getName() + '\'' +
                ", season=" + foragingTreeType.getSeason() +
                '}';
    }
}
