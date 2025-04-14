package model;

public class Building {
    protected String name;
    protected int capacity;
    protected int cost;

    public Building(String name, int capacity, int cost) {
        this.name = name;
        this.capacity = capacity;
        this.cost = cost;
    }
    public boolean isFully() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}



