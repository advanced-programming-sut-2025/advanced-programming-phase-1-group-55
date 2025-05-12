package model.Map;

public class place {
    private int height;
    private int width;
    private Location location;

    public place(int height, int width, Location location) {
        this.height = height;
        this.width = width;
        this.location = location;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Location getLocation() {
        return location;
    }


    public void setLocation(Location location) {
        this.location = place.this.location;
    }


}
