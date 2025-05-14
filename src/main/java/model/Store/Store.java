package model.Store;


import model.Item.Item;
import model.NPC.Npc;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Store {
    private final LocalTime openingTime;
    private final LocalTime closingTime;
    private Map<String, Product> productsOfStore=new HashMap<>();
    private final Npc owner;
    private final String DisplayName;


    public Store(LocalTime openingTime, LocalTime closingTime, Map<String,
            Product> productsOfStore, Npc owner, String displayName) {
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.productsOfStore = productsOfStore;
        this.owner = owner;
        DisplayName = displayName;
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

    public void setProductsOfStore(Map<String, Product> productsOfStore) {
        this.productsOfStore = productsOfStore;
    }

    public Npc getOwner() {
        return owner;
    }

    public String getDisplayName() {
        return DisplayName;
    }

}
