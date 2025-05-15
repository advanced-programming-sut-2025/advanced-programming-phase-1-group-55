package model.Animal;

public class Animal {
    private String name;
    private AnimalType type;
    private int friendshipPoints;
    private String producedItem;
    private int productQuality;
    private boolean isFedToday;
    private boolean isOutside;
    private boolean productCollected;
    private boolean isPettedToday;

    public Cage getCage() {
        return cage;
    }

    public void setCage(Cage cage) {
        this.cage = cage;
    }

    public boolean isPettedToday() {
        return isPettedToday;
    }

    public void setPettedToday(boolean pettedToday) {
        isPettedToday = pettedToday;
    }

    public boolean isProductCollected() {
        return productCollected;
    }

    public void setProductCollected(boolean productCollected) {
        this.productCollected = productCollected;
    }

    public boolean isOutside() {
        return isOutside;
    }

    public void setOutside(boolean outside) {
        isOutside = outside;
    }

    public boolean isFedToday() {
        return isFedToday;
    }

    public void setFedToday(boolean fedToday) {
        isFedToday = fedToday;
    }

    public int getProductQuality() {
        return productQuality;
    }

    public void setProductQuality(int productQuality) {
        this.productQuality = productQuality;
    }

    public String getProducedItem() {
        return producedItem;
    }

    public void setProducedItem(String producedItem) {
        this.producedItem = producedItem;
    }

    public int getFriendshipPoints() {
        return friendshipPoints;
    }

    public void setFriendshipPoints(int friendshipPoints) {
        this.friendshipPoints = friendshipPoints;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private  Cage cage;

    public Animal(String name, AnimalType type) {
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
