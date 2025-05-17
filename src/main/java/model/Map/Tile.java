package model.Map;

import model.Item.Item;
import model.User;

public class Tile {
    private Location location;
    private String mohtaviat;
    private TileTexture texture = null;
    private boolean walkable;
    private boolean isEmpty;
    private Item itemInThisTile;
    private User owner;
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }



    public Tile(Location location, String mohtaviat, boolean walkable, boolean isEmpty, TileTexture tileTexture) {
        this.location = location;
        this.mohtaviat = mohtaviat;
        this.walkable = walkable;
        this.isEmpty = isEmpty;
        this.texture = tileTexture;
    }


    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }


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

    public TileTexture getTexture() {
        return texture;
    }

    public void setTexture(TileTexture texture) {
        this.texture = texture;
    }

    public boolean isAccessible() {
        return walkable;
    }

    public void setAccessible(boolean accessible) {
        walkable = accessible;
    }

    public Item getItemInThisTile() {
        return itemInThisTile;
    }

    public void setItemInThisTile(Item item) {
        this.itemInThisTile = item;
    }

    public boolean isWalkable() {
        return walkable;
    }

    public void setWalkable(boolean walkable) {
        this.walkable = walkable;
    }
}
