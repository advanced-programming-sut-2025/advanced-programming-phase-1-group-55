package model;

import enums.RockType;
import model.Map.Location;

public class Rock {
    private Location location;
    private RockType rockType;

    public Rock(Location location, RockType rockType) {
        this.location = location;
        this.rockType = rockType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public RockType getRockType() {
        return rockType;
    }

    public void setRockType(RockType rockType) {
        this.rockType = rockType;
    }
}
