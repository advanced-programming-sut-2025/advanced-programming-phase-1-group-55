package model.Map;

public class Location {
    private int y;
    private int x;

    public Location(int y, int x) {
        this.y = y;
        this.x = x;
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
    public Location changeLocation(int dy,int dx){
        y+=dy;
        x+=dx;
        return new Location(y,x);
    }
    @Override
    public String toString() {
        return "Location{" +
                "y=" + y +
                ", x=" + x +
                '}';
    }
}
