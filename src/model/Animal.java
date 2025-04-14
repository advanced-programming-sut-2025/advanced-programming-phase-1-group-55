package model;

public class Animal {
    private String name;
    private String type;
    private int friendshipPoints;
    private String producedItem;
    private String productQuality;
    private boolean isFedToday;
    private boolean isOutside;
    private boolean productCollected;
    private boolean isPettedToday;


    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
        this.friendshipPoints = 0;
        this.producedItem = null;
        this.productQuality = 0;
        this.isFedToday = false;
        this.isPettedToday = false;
        this.isOutside = false;
        this.productCollected = false;
    }
    public  void pet() {

    }
    public void feed() {

    }
    

}
