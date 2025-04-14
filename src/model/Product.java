package model;

public class Product {
    private  String name;
    private int productsLeft;
    private  double price;
    private  int todaySale=0;
    private  int level=0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductsLeft() {
        return productsLeft;
    }

    public void setProductsLeft(int productsLeft) {
        this.productsLeft = productsLeft;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTodaySale() {
        return todaySale;
    }

    public void setTodaySale(int todaySale) {
        this.todaySale = todaySale;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public void upgradeProduct(){
        level++;
    }
}
