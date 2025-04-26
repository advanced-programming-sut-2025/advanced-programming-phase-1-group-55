package model;

import enums.TileType;

public class Tile {
    private Location location;
    private TileType type;
    private  boolean isAccessible;
    private ItemOfMap itemInThisTile;
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public TileType getType() {
        return type;
    }

    public void setType(TileType type) {
        this.type = type;
    }

    public boolean isAccessible() {
        return isAccessible;
    }

    public void setAccessible(boolean accessible) {
        isAccessible = accessible;
    }

    public ItemOfMap getItemInThisTile() {
        return itemInThisTile;
    }

    public void setItemInThisTile(ItemOfMap itemInThisTile) {
        this.itemInThisTile = itemInThisTile;
    }
}
