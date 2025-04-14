package model;

public class Product {
    private  String type;
    private boolean isRare;
    private int quality;

    public Product(String type, boolean isRare, int quality) {
        this.type = type;
        this.isRare = isRare;
        this.quality = quality;
    }
}
