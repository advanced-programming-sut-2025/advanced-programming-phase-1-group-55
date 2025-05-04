package model.Animal;

public enum AnimalType {

    Chicken("chicken", 800, "egg", 50, "big egg", 95);


    private final String name;
    private final int buyPrice;
    private final String firstProduct;
    private final int firstProductPrice;
    private final String secondProduct;
    private final int seconfProductPrice;

    AnimalType(String name, int buyPrice, String firstProduct, int firstProductPrice, String secondProduct, int seconfProductPrice) {
        this.name = name;
        this.buyPrice = buyPrice;
        this.firstProduct = firstProduct;
        this.firstProductPrice = firstProductPrice;
        this.secondProduct = secondProduct;
        this.seconfProductPrice = seconfProductPrice;
    }

    public String getName() {
        return name;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public String getFirstProduct() {
        return firstProduct;
    }

    public int getFirstProductPrice() {
        return firstProductPrice;
    }

    public String getSecondProduct() {
        return secondProduct;
    }

    public int getSeconfProductPrice() {
        return seconfProductPrice;
    }
}
