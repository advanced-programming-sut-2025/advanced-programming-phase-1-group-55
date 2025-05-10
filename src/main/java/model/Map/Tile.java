package model.Map;

import enums.TileType;
import model.ItemOfMap;

public class Tile {
    private Location location;
    private String mohtaviat;

    public Tile(Location location, String mohtaviat, boolean walkable, boolean isEmpty) {
        this.location = location;
        this.mohtaviat = mohtaviat;
        this.walkable = walkable;
        this.isEmpty = isEmpty;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    private TileType type;
    private boolean walkable;
    private boolean isEmpty;
    private ItemOfMap itemInThisTile;

    public String getMohtaviat() {
        return mohtaviat;
    }

    public void setMohtaviat(String mohtaviat) {
        this.mohtaviat = mohtaviat;
    }

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
        return walkable;
    }

    public void setAccessible(boolean accessible) {
        walkable = accessible;
    }

    public ItemOfMap getItemInThisTile() {
        return itemInThisTile;
    }

    public void setItemInThisTile(ItemOfMap itemInThisTile) {
        this.itemInThisTile = itemInThisTile;
    }
}
