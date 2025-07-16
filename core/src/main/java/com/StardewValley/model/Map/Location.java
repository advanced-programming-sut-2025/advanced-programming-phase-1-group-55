package com.StardewValley.model.Map;

public class Location {
    private int y;
    private int x;

    public Location(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public boolean isBetween(Location location, int width, int height) {
        return y < location.getY() + width && y > location.getY() && x < location.getX() + height && x > location.getX();
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Location changeLocation(int dy, int dx) {
        y += dy;
        x += dx;
        return new Location(y, x);
    }
    public Location getAdjacent(String direction) {
        int dx = 0, dy = 0;

        switch (direction.toLowerCase()) {
            case "up": dy = -1; break;
            case "down": dy = 1; break;
            case "left": dx = -1; break;
            case "right": dx = 1; break;
            case "upleft": dx = -1; dy = -1; break;
            case "upright": dx = 1; dy = -1; break;
            case "downleft": dx = -1; dy = 1; break;
            case "downright": dx = 1; dy = 1; break;
            default:
                throw new IllegalArgumentException("Invalid direction: " + direction);
        }

        return new Location(this.y + dy, this.x + dx);
    }
    @Override
    public String toString() {
        return "Location { " +
                " x = " + x +
                " , y = " + y +
                " }";
    }
}
