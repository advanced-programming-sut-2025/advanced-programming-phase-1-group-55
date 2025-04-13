package enums;

import model.Npc;
import model.Product;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public enum Store {
    Blacksmith(),
    ojaMart(),
    Generalstore(),
    CarpenterShop(),
    fishShop(),
    marnieRanch(),
    starDropSaloon();
    private final LocalTime openingTime;
    private final LocalTime closingTime;
    private Map<String, Product> productsOfStore=new HashMap<>();
    private final Npc owner;
    Store(Npc owner,LocalTime openingTime,LocalTime closingTime,Map<String,Product> productsOfStore){
        this.closingTime=closingTime;
        this.productsOfStore=productsOfStore;
        this.openingTime=openingTime;
        this.owner=owner;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public Map<String, Product> getProductsOfStore() {
        return productsOfStore;
    }

    public Npc getOwner() {
        return owner;
    }
}
