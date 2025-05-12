package model.FarmingProdocts;

import model.Map.Location;

public class ForagingSeed {
    private AllForagingSeeds type;
    private Location location;

    public ForagingSeed( Location location,AllForagingSeeds type) {
        this.type = type;
        this.location = location;
    }

    public AllForagingSeeds getType() {
        return type;
    }

    public void setType(AllForagingSeeds type) {
        this.type = type;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
