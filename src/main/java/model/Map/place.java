package model.Map;

public class place {
    private int height;
    private int width;
    private Location point;

    public place(int height, int width, Location point) {
        this.height = height;
        this.width = width;
        this.point = point;
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

    public Location getPoint() {
        return point;
    }

    public void setPoint(Location point) {
        this.point = point;
    }
}
