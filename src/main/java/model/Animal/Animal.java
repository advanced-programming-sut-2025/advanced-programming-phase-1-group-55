package model.Animal;

import model.Item.Item;
import model.Map.Tile;

import java.util.ArrayList;
import java.util.Random;

public class Animal extends Item {
    private String name;
    private FarmAnimalType animalType;
    private int friendship = 0;
    private boolean isFed = false;
    private boolean isIn = true;
    private boolean isPet = false;
    private final ArrayList<Item> products;
    private Tile tile = null;
    private boolean hasProduct = false;
    private boolean secondProduct = false;
    private double quality = 0;

    public Animal(String name, FarmAnimalType animalType)
    {
        this.itemType = animalType.getType();
        this.name = name;
        this.animalType = animalType;
        this.price = animalType.getPrice();
        this.isFed = false;
        this.isIn = true;
        this.isPet = false;
        this.products = (ArrayList<Item>) animalType.getProduct();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FarmAnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(FarmAnimalType animalType) {
        this.animalType = animalType;
    }

    public int getFriendship() {
        return friendship;
    }

    public boolean isFed() {
        return isFed;
    }

    public void setFed(boolean fed) {
        isFed = fed;
    }

    public boolean isIn() {
        return isIn;
    }

    public void setIn(boolean in) {
        isIn = in;
    }

    public boolean isPet() {
        return isPet;
    }

    public void setPet(boolean pet) {
        isPet = pet;
    }

    public ArrayList<Item> getProducts() {
        return products;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public boolean isHasProduct() {
        return hasProduct;
    }

    public void setHasProduct(boolean hasProduct) {
        this.hasProduct = hasProduct;
    }

    public boolean isSecondProduct() {
        return secondProduct;
    }

    public void setSecondProduct(boolean secondProduct) {
        this.secondProduct = secondProduct;
    }


    public void setQuality(double quality) {
        this.quality = quality;
    }

    public void increaseFriendship(int amount)
    {
        this.friendship += amount;
        if(friendship >= 1000) friendship = 1000;
    }
    public void decreaseFriendship(int amount) {
        this.friendship -= amount;
    }
    public void feed() {
        if (!isFed) {
            increaseFriendship(8);
            isFed = true;
        }
    }
    public void pet() {
        if (!isPet) {
            increaseFriendship(15);
            isPet = true;
        }
    }

    public void setFriendship(int friendship) {
        this.friendship = Math.min(friendship, 1000);
    }
    public void checkAndReset()
    {
        if(!isFed)
        {
            decreaseFriendship(20);
        }

        if(!isIn)
        {
            decreaseFriendship(20);
        }

        if(!isPet)
        {
            decreaseFriendship(10 - getFriendship() / 200);
        }

        hasProduct = isFed;

        isFed = false;
        isPet = false;
        isIn = true;

        secondProduct = false;

        if (friendship > 100)
        {
            Random rand = new Random();
            if ((friendship + (rand.nextInt(3) / 3.0 + 1)) / 1500 >= 1)
            {
                secondProduct = true;
            }
        }
    }
    public void goOut()
    {
        isIn = false;
        isFed = true;
        increaseFriendship(8);
    }
    public Item getProduct()
    {
        Item product = products.get(0);
        if (secondProduct && products.size() > 1)
        {
            product = products.get(1);
        }

        return product;
    }
    public void calculateProductPrice(Item product)
    {
        quality = getQuality();

        if(quality <= 0.5)
        {
            product.setPrice(price);
        } else if(quality > 0.5 && quality <= 0.7) {
            product.setPrice((int) (price * 1.25));
        } else if(quality > 0.7 && quality <= 0.9) {
            product.setPrice((int) (price * 1.5));
        } else {
            product.setPrice((int) (price * 2.0));
        }
    }
    public double getQuality()
    {
        Random rand = new Random();
        return ((double) friendship / 1000) * (0.5 + 0.5 * rand.nextDouble());
    }
    public int getPrice()
    {
        return (int) (animalType.getPrice() * (((double) friendship / 1000) + 0.3));
    }
}
