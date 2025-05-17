package model.Store;


import model.Item.Item;
import model.NPC.Npc;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Store {
    private final int openingTime;
    private final int closingTime;
    private Map<String, Product> productsOfStore=new HashMap<>();
    private final String DisplayName;


    public Store(int openingTime, int closingTime, Map<String,
            Product> productsOfStore, String displayName) {
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.productsOfStore = productsOfStore;
        DisplayName = displayName;
    }

    public int getOpeningTime() {
        return openingTime;
    }

    public int getClosingTime() {
        return closingTime;
    }

    public Map<String, Product> getProductsOfStore() {
        return productsOfStore;
    }

    public void setProductsOfStore(Map<String, Product> productsOfStore) {
        this.productsOfStore = productsOfStore;
    }



    public String getDisplayName() {
        return DisplayName;
    }

}
